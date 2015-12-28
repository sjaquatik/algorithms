public class ReverseBT {

	public static void main(String[] args){
		
		TreeNode two = new TreeNode( null, null, 2);
		TreeNode three = new TreeNode( null, null, 3);
		TreeNode one = new TreeNode( two, three, 1);
		TreeNode root = reverse(two, one, three);
		log( inOrderPrint(root ));
	}

	static void log(Object msg){
		System.out.println( msg.toString() );
	}
	
	static String inOrderPrint(TreeNode node){
		if( node == null ){
			return "";
		}
		else{
			return inOrderPrint( node.left ) + " " + node.data + " " + inOrderPrint( node.right );
		}
	}

	/**
		node - current Node
		top - node's parent
		right - node's right sibling
	*/ 
	static TreeNode reverse( TreeNode node, TreeNode top, TreeNode right){
		top.left = null;
		top.right = null;
		TreeNode originLeft = node.left;
		TreeNode originRight = node.right;
		node.left = right;
		node.right = top;
	 	if( originLeft == null || originRight == null){
			return node;
		}
		else{
			return reverse( originLeft, node, originRight);
		}
	}
}

class TreeNode {
		TreeNode left;
		TreeNode right;
		int data;
	public TreeNode( TreeNode left, TreeNode right, int data){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
