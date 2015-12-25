import java.util.Collection;
import java.util.List;
import java.util.LinkedList;

public class PermuteList {
	
	public static void main(String[] args){
		
		List<String> inputList = new LinkedList<String>();
		inputList.add("Trung");
		inputList.add("Trong");
		inputList.add("Dinh");
		inputList.add("Mit");
		inputList.add("Miu Miu");
		
		Collection<List<String>> result = new LinkedList<List<String>>();
		List<String> prefix = new LinkedList<String>();
		
		permute(prefix, inputList, result);

		for(List<String> l : result ){
			print( l );
		}
	}
	
	static void print( List<String> list){
		StringBuilder strBuilder = new StringBuilder();
		for( String str : list ){
			strBuilder.append( str + " -> " );	
		}
		log( strBuilder.toString() );
	}
	
	static void log(Object msg){
		System.out.println( msg.toString() );
	}
	
	static void permute( List<String> prefix, List<String> remaining, Collection<List<String>> result){
	
	if( remaining.size() == 0 ){
		result.add(prefix);
	}
	
	else{
		for(int i = 0 ; i < remaining.size(); i++){
			List<String> combined = combine( prefix, remaining.get(i));
			List<String> snipped = snip( remaining, i);
			permute( combined, snipped, result);
		} // end for loop	
	
	}
	
	} // end of permute()
	
	static List<String> combine( List<String> prefix, String item){
		List<String> result = new LinkedList<String>();
		result.addAll(prefix);
		result.add(item);
		return result;
	} // end of combine()

	static List<String> snip( List<String> input, int indexToSnip ){
		List<String> result = new LinkedList<String>();
		result.addAll( input.subList(0, indexToSnip));
		result.addAll( input.subList(indexToSnip+1, input.size()));
		return result;
	}

}
