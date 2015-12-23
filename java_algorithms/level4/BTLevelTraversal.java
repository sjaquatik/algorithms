import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
public class BTLevelTraversal{
	
	public static void main(String[] args){
		Node nine = new Node(9,null,null);
                Node six = new Node(6, null,null);
                Node eight = new Node(8,null,null);
                Node two = new Node(2,nine,six);
                Node four = new Node(4,null,eight);
                Node seven = new Node(7,null,null);
                Node three = new Node(3,two,four);
                Node five = new Node(5,null,seven);
                Node one = new Node(1, three, five);
		printByLevel(one);	
	
	
	} // end of main

	public static void printByLevel( Node root){
	
		List<List<Node>> listOfNode = getListOfNode( root );
		for(List<Node> l : listOfNode){
			printCurrLevel( l );
		}
	}
	public static void printCurrLevel( List<Node> listOfNode){
		StringBuilder strBuilder = new StringBuilder();
		for(Node n : listOfNode){
			strBuilder.append( n.data + " ");
		}// end for loop
		strBuilder.append("\n==============");
		System.out.println( strBuilder.toString());

	}
	
	public static List<List<Node>> getListOfNode( Node root ){
		
		List<List<Node>> returnList = new ArrayList<List<Node>>();
		if( root == null ) {
			return returnList;
		}	

		List<Node> tmp = new LinkedList<Node>();
		tmp.add(root);
		returnList.add(tmp);
		
		while(true){	
			int currentLevel = returnList.size() - 1;
			tmp = new LinkedList<Node>();
			for(Node n : returnList.get(currentLevel)){
				if( n.getLeft() != null ){
					tmp.add( n.getLeft() );
				}
				if( n.getRight() != null ){
					tmp.add( n.getRight() );
				}
				
			}// end for loop
			if(tmp.size() == 0){
				break;
			}
			else{
				returnList.add(tmp);
			}
		}//end while
		return returnList;
	}

	public static class Node{
	 	int data;
		Node left;
		Node right;
		public Node( int data, Node l, Node r){
			this.data = data;
			this.left = l;
			this.right = r;
		}
		public Node getLeft(){
			return this.left;
		}
		public Node getRight(){
			return this.right;
		}
	} // end of class Node

} // end BTLevelTraversal class
