import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
public class LongestIncreasingSub{
	
	public static void findLongestIncreasingSub(List<Integer> input){
		int size = input.size();
		int[] ls = new int[size];	
		int max = 1;
		for(int i = 0; i < size; i++){
			ls[i] = 1;
		}


		for(int i = 1; i < input.size(); i++){
			for(int j = 0; j < i; j++){
				if( input.get(j) < input.get(i)){		
					ls[i] = Math.max(ls[i], ls[j]+1);
					if( ls[i] > max){
						max = ls[i];
					}
				}	
			}
		}// end outer for loop
		
		log("LIS: " + max);

		for( int i = 0; i < size; i++){
			log(i + "->" + ls[i]);
		}
		
	}
	
	public static void main(String[] args){
		List<Integer> input = Arrays.asList(3,4,-1,0,6,2,3);
		findLongestIncreasingSub(input);
	}

	public static void log(Object msg){
		System.out.println(msg.toString());
		}

}
