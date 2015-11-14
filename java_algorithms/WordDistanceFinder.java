import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
public class WordDistanceFinder{

	// Map of String to index position of the word in the list
	private Map<String,ArrayList<Integer>> wordMap;
	
	public WordDistanceFinder(List<String> word){
		initWordMap(word);	
	}
	public int distance(String str1, String str2){
	
		// simple case 
		if( !wordMap.containsKey(str1) || !wordMap.containsKey(str2)){
			return 0;
		}
	
		else if ( wordMap.get(str1).size() == 1 && wordMap.get(str2).size() == 1){
			return Math.abs( wordMap.get(str1).get(0) - wordMap.get(str2).get(0));
		}
		// one of the word is duplicate
		else{
			
			// get first list
			List<Integer> firstList = wordMap.get(str1);
			// get second list
			List<Integer> secondList = wordMap.get(str2);

		
		}
	
		return 0;
	}

	public int findMinGapRecur( int key, int low, int high, List<Integer> list){
		// base case
		if( high - low == 0){
			return 0;
		}
		else if( list.size() == 1){
			return Math.abs( key - list.get(0));
		}
		else if ( list.size() == 2){
			return Math.min( key - list.get(0), key - list.get(1));
		}
		// recursive step
		else{
			int middle = list.size() / 2;
			System.out.println("Middle is: " + middle);
			// the key is less than middle of list
			if( key < list.get(middle)){
				return findMinGapRecur(key, low, middle, list);
			}
			// the key is more than the middle of list
			else{
				return findMinGapRecur(key, middle+1, high, list);	
			}		
		}

	}

	private void initWordMap(List<String> inputList){
		wordMap = new HashMap<String,ArrayList<Integer>>();
		for(int i = 0; i < inputList.size(); i++){
			String key = inputList.get(i);
			// if the  map does not have the String 
			if( !wordMap.containsKey( inputList.get(i))){
				ArrayList<Integer> tmpList = new ArrayList<Integer>();
				tmpList.add(i);
				wordMap.put(inputList.get(i), tmpList);
			}
			// the map contains the key
			else{
				// Get the current List
				ArrayList<Integer> currentList = wordMap.get( inputList.get(i));
				// Add the current index to the List
				currentList.add(i);
				// update the wordMap with this list
				wordMap.put ( key, currentList);
			} 
		} // end of while loop
	}

	public void printWordMap(){
		System.out.print(wordMap.toString());
	}

	public static void main(String[] argvs){
		List<String> testList = Arrays.asList("the","quick","brown","fox","quick");
		WordDistanceFinder finder = new WordDistanceFinder(testList);
		//finder.printWordMap();
		//System.out.println(finder.distance("the","fox"));
		List<Integer> testList2 = Arrays.asList(1,4,7,11);
		int closest = finder.findMinGapRecur(10,0,testList2.size(),testList2);
		System.out.println(closest);
	}
}
