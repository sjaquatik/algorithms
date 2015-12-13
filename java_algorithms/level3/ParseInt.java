public class ParseInt{

	public static void main(String[] args){

		log(ParseInt.parseInt("-2147483648"));
		// 2147483647
	}
		
	static void log(Object msg){
		System.out.println(msg.toString());
	}

	public static int parseInt(String s){
		if ( s == null || s.length() <= 0){
			throw new NumberFormatException("Not a number");
		}
		int result = 0;
		int walker = 0;
		boolean isNegative = false;
		if(s.charAt(0) == '-'){
			if(s.length() <= 1){
				throw new NumberFormatException("Not a number");
			}
			isNegative = true;
			walker++;
		}

		while(walker < s.length()){
			char c = s.charAt(walker++);
			if( c < '0' || c > '9'){
				throw new NumberFormatException("Not a number");
			}
			log("Result: " + result + " Index: " + walker);
			//result = result * 10 - (int)(c - '0');
			result = result * 10;
			result += c - '0';
	
		} // end while loop
		if(isNegative){
			result = -result;
		}
		return result;
	}


} // end class

