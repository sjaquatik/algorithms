import java.util.List;
import java.util.Arrays;
public class ReverseWord{

	public static void main(String[] args){
		String test = "was an American college football player and coach";
		System.out.print( reverseWord(test));
	}

	static String reverseWord(String str){
	
		List<String> tokenStringList = Arrays.asList(str.split(" "));
		StringBuilder strBuilder = new StringBuilder();

		for(int i = tokenStringList.size() - 1; i > 0 ; i--){
			strBuilder.append( tokenStringList.get(i) + " ");	
		}

		strBuilder.append( tokenStringList.get(0));
		
		return strBuilder.toString();
	
	}

}
