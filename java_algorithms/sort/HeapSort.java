public class HeapSort {
	public static void main(String[] ags){
		int[] test = new int[]{16,4,10,14,7,9,3,2,8,1};
		int middleIndex = test.length/2 - 1;
		for(int i = middleIndex ; i > -1; i--){
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
		int left = 2*i+1;
		int right = 2*i+2;
		if( left > array.length -1 || right > array.length -1){
			log("Left or right index is greater than: " + (array.length -1));
			return;
		}
		int maxChild = Math.max( array[left], array[right]);
		if( array[ i ] < maxChild){
			//if left
			if( maxChild == array[left]){
				log("Left child index: " + left + " value: " + array[left]);
				swap(array, i, left);
				maxHeapify(array, left);
			}
			else{
				log("Right child index: " + right + " value: " + array[right]);
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
