import java.util.Arrays;
import java.util.List;
public class MaxSum{

	static int maxSum( List<Integer> input){
		int maxSum = Integer.MIN_VALUE;
		int runningSum = 0;

		for(int i : input){
			runningSum +=i;
			if( runningSum > maxSum ) { maxSum = runningSum; }
			if(runningSum < 0) { runningSum = 0;  }
					
		}
		
		return maxSum;
	} // end of method

	static void log(Object msg){
		System.out.println(msg.toString());
	}
	
	public static void main(String[] args){
		List<Integer> test = Arrays.asList(-1,-2,-3,4);
		int maxSum = MaxSum.maxSum(test);
		log(maxSum);
	}

}
