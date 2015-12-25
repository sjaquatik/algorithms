import java.util.List;
import java.util.LinkedList;
public class CharPerm{

	public static void main(String[] args){
		String input = "abc";
		List<String> result = new LinkedList<String>();
		permute("", input, result);
		printList( result );
	}

	static <T> void printList(List<T> input){
		StringBuilder strBuilder = new StringBuilder();
		for(T t : input){
			strBuilder.append( t.toString() + " --> " );
		}

		System.out.println( strBuilder.toString() );
	}
	public static void permute(String prefix, String input, List<String> result){
		log("Prefix: " + prefix + " input " + input)
		int length = input.length();

		if(length == 0 ){
			result.add(prefix);
		}
		else{
			for(int i = 0; i < length; i++){
				permute(prefix + input.charAt(i), input.substring(0,i) + input.substring(i+1, length), result);	
			}
		}
		
	}

	static void log(Object msg){
		System.out.println(msg.toString());
	}
	

}
