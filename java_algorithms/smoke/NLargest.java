import java.util.Collections;
import java.util.List;
import java.util.Arrays;
public class NLargest{

	public static int nLargest(int n, List<Integer> input) throws IllegalArgumentException{
		if ( input == null || input.size() == 0) {
			throw new IllegalArgumentException("List cannot be blank");
		}
		else if ( n > input.size() ){
			throw new IllegalArgumentException("Too few number in the list");
		}
		else{
			Collections.sort(input);
			return input.get(input.size() - n);
		}
		
	}
	public static void main(String[] args){
		List<Integer> testList = Arrays.asList(1,2,3,4,5);
		int n = 1;
		System.out.println("The " + n + "th largest element in " + testList.toString() + " is " + NLargest.nLargest(n,testList) );
	}
}
