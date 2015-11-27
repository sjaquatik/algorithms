import java.util.List;
import java.util.ArrayList;
public class BFSQueue {

	static class Tree{
		Node root;
		public Tree(Node r){
			this.root = r;
		}
		public void setRoot(Node r){
			this.root = r;
		}
		public void printTree(){
			// master list of Node
			List<List<Node>> listNode = new ArrayList<List<Node>>();	
			List<Node> tmp = new ArrayList<Node>();
			tmp.add(this.root);
			listNode.add(tmp);
			while(true){
				int currentLevel = listNode.size() - 1;
				List<Node> currentList= listNode.get(currentLevel);
				tmp = new ArrayList<Node>();
				for(Node n: currentList){
					if (n.getLeft() != null){
						tmp.add(n.getLeft());
					}
					if(n.getRight() != null){
						tmp.add(n.getRight());
					}
				} // end for loop
				if(tmp.size() == 0){
					break;
				}
				else{
				listNode.add(tmp);
				}
			}

			for(int i = 0; i <listNode.size(); i++){
				List<Node> currList = listNode.get(i);
				StringBuilder builder = new StringBuilder();
				for(Node n: currList){
					builder.append(n.getData());
				}
				if( i % 2 != 0){
				log(builder.reverse().toString());
				}
				else{
					log( builder.toString());
				}
			}
			
		}
		
		public void log(Object msg){	
			System.out.println(msg.toString());
		}
	}

	  static class Node{

		private int data;
		private Node left;
		private Node right;
	
		private Node(int data, Node l, Node r) {
			this.data = data;
			this.left = l;
			this.right = r;
		}
		public int getData(){ return this.data; }
		public Node getLeft(){ return this.left; }
		public Node getRight(){ return this.right; }
	} // end of Node class

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
		Tree tree = new Tree(one);
		tree.printTree();

	}

}
