import java.util.List;
import java.util.LinkedList;
public class WordPerm{
	public static void main(String[] args){
		String test = "merry Christmas Minh";
		String[] testArray = test.split(" ");
		List<String> result = new LinkedList<String>();
		permute("", testArray, result);
		print(result);
			
	}

	static <T> void print(List<T> input){
		StringBuilder strBuilder = new StringBuilder();
		for( T t : input ){
			strBuilder.append( t.toString());
		}
		System.out.println( strBuilder.toString() );
	}
	static void permute(String prefix, String[] input, List<String> result){
		int len = input.length;
		
		if(len == 0){
			result.add( prefix );
		} else {
			for(int i = 0 ; i < len; i++){
				permute(prefix + input[i] + " ", concatArray( getSubarray(0, i, input), getSubarray(i+1, len, input)), result);
			}//end for loop
		}
	}

	static String[] getSubarray( int start, int end, String[] orig){
		List<String> result = new LinkedList<String>();
		if( end == start ){
			return new String[0];
		} else {

			for(int i = start; i < end; i++){
				result.add( orig[i] );	
			}
		}

		String[] strArr = new String[ result.size() ];
		strArr = result.toArray( strArr );

		return strArr;
	
	}

	static String[] concatArray(String[] a1, String[] a2){
		
		String[] result = new String[ a1.length + a2.length ];
		
		int i = 0;
		
		for( String b : a1 ) {
			result[ i++ ] = b; 
		}		
	
		for( String b : a2 ){
			result[ i++ ] = b;
		}

		return result;
	}
} // end of WordPerm class
