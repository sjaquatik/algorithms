import java.util.Collections;
public class MaxSum {
	public static void maxSubArray(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];
 
		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
		}	
 		
		for( int i: sum){
		System.out.println ( i );
		}
		
	}
	
	public static void main(String[] args){
		int[] arr = new int[8];
		arr[0] = -2;
		arr[1] = -3;
		arr[2] = 4;
		arr[3] = -1;
		arr[4] = -2;
		arr[5] = 1;
		arr[6] = 5;
		arr[7] = -3;
		maxSubArray(arr);

	}
}
