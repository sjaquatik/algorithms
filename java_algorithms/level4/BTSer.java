import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
public class BTSer{

	private Node root;
	
	public BTSer(Node root){
		this.root = root;
	}
	
	public Node getRoot(){
		return this.root;
	}
	
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
		BTSer bt = new BTSer(one);
		try{
			writeBT( bt, "serialized.txt");
		}catch(IOException ioe){
			System.out.println( ioe.getMessage());
		}
		try{
		BTSer btDesr = readBT("serialized.txt");
		printTree(btDesr);
		} catch(IOException ioe){
			System.out.println( ioe.getMessage());
		}
		
	}// end of main method
	
	static void printTree( BTSer tree){
		log(printTree(tree.getRoot()));

	}
	static String printTree(Node n){
		if( n != null){
			return n.data + printTree( n.left ) + printTree( n.right);
		}
		else{
			return "";
		}
		
	}
	
	public static void writeBT( BTSer bt, String fileName) throws IOException{
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		if( null != bt){
			writeBT( bt.getRoot(), writer);
		}
		writer.flush();
		writer.close();
	}
	private static void writeBT(Node node, Writer writer) throws IOException{ 
		if(null == node){
			writer.append("# ");
		}else{
			writer.append( String.valueOf( node.data + " "));
			writeBT(node.left, writer);
			writeBT(node.right, writer);
		}
	}// end of writeBT
	
	public static BTSer readBT( String fileName) throws IOException{
		Scanner reader = new Scanner(new File(fileName));
		BTSer bt = null;
		reader.useDelimiter(" ");
		return new BTSer(buildBT(reader));
	}
	private static Node buildBT(Scanner reader) throws IOException{
		if(reader.hasNext()){
			String data = reader.next();
			log("Data is " + data);
			if(data.equals("#")){
				return null;
			}
			try{
				int dataInt = Integer.valueOf(data);
				Node n = new Node(Integer.valueOf(dataInt), buildBT(reader), buildBT(reader));		
				return n;
			}catch(NumberFormatException nfe){
				log("Exception: " + nfe.getMessage());
			}
		}
		return null;
	}
	static void log(Object msg){
		System.out.println(msg.toString());
	}
	public static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data, Node l, Node r){
			this.data = data;
			this.left = l;
			this.right = r;
		}
		
	} // end of class Node
}
