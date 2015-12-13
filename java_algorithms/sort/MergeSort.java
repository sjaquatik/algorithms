public class MergeSort{

	public static void main(String[] args){
		int[] test = new int[]{3,2,1,88,-3,1, 1, 0, 99, -9, 1,3,88,-2,5};
		int[] sorted = mergeSort(test, 0, test.length-1);
		printArray(sorted);
	}
	
	static void printArray(int[] a){
		StringBuilder strBuilder = new StringBuilder();
		for(int i : a){
			strBuilder.append( i + " ");
		}
		log( strBuilder.toString());
	}

	static int[] mergeSort(int[] array, int start, int end){
		
		// base case 
		if( (end - start) == 0){
			return new int[]{ array[start] };
		}
	
		// sort left, sort right then merge
		else{
			int middle = start + (end - start) / 2;
			int[] left = mergeSort(array, start, middle);
			int[] right = mergeSort( array, middle+1, end);
			return merge( left, right);			
	
		}
	}

	static int[] merge(int[] left, int[] right){
		int[] result = new int[ left.length + right.length ];
		int leftPointer = 0;
		int rightPointer = 0;
		int index = 0;
		while( leftPointer < left.length && rightPointer < right.length ){
			// if left greater than right
			if( left[leftPointer] > right[rightPointer]){
				result[index] = right[rightPointer];
				rightPointer++;
			}
			else{
				result[index] = left[leftPointer];
				leftPointer++;
			}
			index++;
		}// end while loop
		if( leftPointer < left.length){
			for(int i = leftPointer; i < left.length; i++){
				result[index++] = left[i];
			}
		}
		if( rightPointer < right.length ){
			for(int i = rightPointer; i < right.length; i++){
				result[index++] = right[i];
			}
		}
		return result;
	}

	static void log(Object msg){
		System.out.println( msg.toString() );
	}

}

