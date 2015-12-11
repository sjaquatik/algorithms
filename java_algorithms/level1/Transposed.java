import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
public class Transposed{

	public static void main(String[] args) {
	
	List<Integer> test = Arrays.asList(6,7,1,2,3,4,5);
	// find 6
	int key = 2;
	log(" Is " + key + " in the list? " + isInList(key, test));	
	}

	// Given a transposed list, identify the index of the list where the transposed list
	// [ 6 7 1 2 3 5] -> return 1
	public static int findTransposedBorder( List<Integer> inputList){
	
	int lastIndex = inputList.size() - 1;
	int firstVal = inputList.get(0);
	int slope = inputList.get(lastIndex) - firstVal;
	while( slope < 0 && lastIndex > 0){
		lastIndex -= 1;
		 slope = inputList.get(lastIndex) - firstVal;
	}
		return lastIndex;
		
	}// end method

	public static boolean isInList( int key, List<Integer> input){
		int indexOfTranspose = findTransposedBorder(input);
		// normal sorted list
		if(indexOfTranspose == input.size() - 1)
		{
			return binarySearch( key,input, 0, input.size() - 1);
		} 
		else {
			// look on the bigger part
			if( key >= input.get(0)){
				log("Looking at bigger half of list");
				return binarySearch( key,input, 0, indexOfTranspose);
			}
			// look on the smaller part of the list
			else{
				log("looking at smaller part of list from index " + (indexOfTranspose+1) + " to " + (input.size()-1));
				return binarySearch(key,input, indexOfTranspose+1, input.size()-1);
			}
		}
	} // end of isInList()
	public static boolean binarySearch(int key, List<Integer> input, int lowIndex, int highIndex){
		if (input == null){
			return false;
		}
		else if( lowIndex == highIndex ){
			log("lowIndex : " + lowIndex + " input.get(lowIndex) : " + input.get(lowIndex));
			return input.get(lowIndex) == key;
		}else{
			int middle = (highIndex + lowIndex ) / 2;
			log("Middle index: " + middle);
			
			if(key > input.get(middle)){
				// look at higher half
				return binarySearch(key, input, middle+1, highIndex);
			}
				// look at lower half
			else{
				return binarySearch(key, input, lowIndex, middle);
			}
		}
	}

	public static void log(Object msg){
		System.out.println(msg.toString());
	}

}
