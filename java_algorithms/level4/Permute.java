import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Permute<T> implements Permutations<T>{
	public static void main(String[] args){
		Permute<String> perm = new Permute<String>();
		List<String> test = new LinkedList<String>();
		test.add("trung");
		test.add("trong");
		test.add("dinh");
		Collection<List<String>> result = perm.permute(test);
		log( result.size() );
		for( List<String> l : result ){
			print( l );
		}
	}
	
	static <T> void print( List<T> list){
		StringBuilder strBuilder = new StringBuilder();
		for( T t : list){
			strBuilder.append( t.toString() + " -> " );
		}
		log( strBuilder.toString() );
	}
	public Collection<List<T>> permute( List<T> values ){
		Collection<List<T>> result = new LinkedList<List<T>>();
		if( values == null){
			return result;
		}
		if( values.size() <= 1){
			result.add(values);
		}
		else{
			for(int i = 0; i < values.size(); i++){
				T selected = values.get(i);
				for( List<T> remaining : permute( truncate(values, i) ) ){
					result.add( combine( selected, remaining ));
				} // end for loop
			} 
		}
		return result;
		}// end of permute()
	List<T> truncate( List<T> input, int indexToRemove){
		List<T> result = new LinkedList<T>();
		result.addAll( input.subList(0,indexToRemove));
		result.addAll( input.subList(indexToRemove+1, input.size()));
		return result;
	} // end of truncate()
	
	List<T> combine(T item, List<T> list){
		List<T> result = new LinkedList<T>();
		result.add(item);
		result.addAll(list);
		return result;
	} // end of combine()

	static void log(Object msg){
		System.out.println( msg.toString() );
	}
} // end of class

interface Permutations<T> {
	
	 Collection<List<T>> permute( List<T> values );

} // end of interface
