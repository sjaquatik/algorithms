public class StringReplace{
	public static void main(String[] args){
	
		log( replaceRec( "hello goodbye hello", "oo", "ttt"));	
	
	}

	/**
		Replace all instances of 'find' in orig with rep
	*/
	static String replaceRec(String orig, String find, String rep){

		if( orig == null || orig.length() == 0){
			return orig;
		}

		else{
			int foundIndex = orig.indexOf( find );
			if( foundIndex < 0){
				return orig;
			}
			else{
				StringBuilder strBuilder = new StringBuilder();
				strBuilder.append( orig.substring(0, foundIndex));
				strBuilder.append(rep);
				strBuilder.append( orig.substring(foundIndex+find.length())); 
				return replaceRec( strBuilder.toString(), find, rep);
			}
		}
	}

	static void log(Object msg){
		System.out.println(msg.toString());
	}
}
