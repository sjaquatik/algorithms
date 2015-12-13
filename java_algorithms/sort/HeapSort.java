public class HeapSort {
	public static void main(String[] ags){
		int[] test = new int[]{1,2,3,4,5};
		for(int i = test.length/2 ; i >0; i--){
			maxHeapify(test, i);
		}
		StringBuilder strBuilder = new StringBuilder();
		for(int i = 0; i < test.length; i++){
			strBuilder.append( test[i]);
			strBuilder.append(" ");
		}
		System.out.println(strBuilder.toString());
	}
	
	public static void maxHeapify(int[] array, int i){
		int left = 2*i;
		int right = 2*i + 1;
		log("left: " + left + " right: " + right);
		if( left >= array.length || right >= array.length){
			return;
		}
	
		int maxChild = Math.max( array[left], array[right]);
		
		if( array[ i ] < maxChild){
			//if left
			if( maxChild == array[left]){
				swap(array, i, left);
				maxHeapify(array, left);
			}
			else{
				swap(array,i, right);
				maxHeapify(array, right);
			}
			
		}
	}	
	static void log(Object msg){
	System.out.println(msg.toString());
	}
	public static void swap(int[] array, int index1, int index2){
			int temp = array[index1];
			array[index1] = array[index2];
			array[index2] = temp;
		}
}
