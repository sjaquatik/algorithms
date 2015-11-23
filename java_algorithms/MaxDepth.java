public class MaxDepth{
	
	public int maxDepth(Node root){
		
		if(root == null){
			return 0;
		}
		
		else
		{
			return 1 + Math.max( maxDepth(root.getLeft()), maxDepth(root.getRight()));
		}
		
	}
	
}

class NodeImpl implements Node {
		
		public Node getLeft(){
			return null;
		}
	
		public Node getRight(){
			return null;
		}

	}

interface Node {
	public Node getLeft();
	public Node getRight();
}
