public class FindRange{

	public static void main(String[] args){
		int[] test = new int[] {1,3,3};
		printArray(findRange(test,3));
	}

	static void printArray(int[] a){
		StringBuilder strBuilder = new StringBuilder();
		for(int i : a){
			strBuilder.append(i + " -> ");
		}
		System.out.println(strBuilder.toString());
	}
	
	public static int[] findRange( int[] input, int elem){
		
		int rightIndex = binarySearch( input, 0, input.length - 1, elem);
		int leftIndex = binarySearch(input, 0, input.length - 1, elem -1 );
		
		if( rightIndex == -1 || input[ rightIndex] != elem){
			return new int[]{-1, -1};
		}
		
		return new int[]{ leftIndex+1, rightIndex};	
	
	}

	static int binarySearch(int[] input, int left, int right, int key){
		while( right - left > 1){
			if( input[left] > key ) return -1 ;	
			if( input[right] <= key) return right;
			int mid = left + ( right - left ) / 2;
			if( input[mid] <= key ){
				left = mid;
			}
			else{
				right = mid;
			}
		}// end while loop
		return left;
	}

}
