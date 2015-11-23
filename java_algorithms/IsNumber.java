public class IsNumber{
	public static boolean inNumber(String input){
	
		try{
			Double.parseDouble(input);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	static boolean isNumberLong(String input){
		if( input == null || input.length() == 0){
			return false;
		}

		char[] inputAsCharArray = input.toCharArray();
		
		boolean dotSeen = false;
		boolean negSeen = false;

		for ( char c : inputAsCharArray){
			
			if( c == '-' && input.length() == 1){
				return false;
			}
			else if( c == '.' && input.length() == 1){
				return false;
			}
			else if( c == '-' && input.indexOf(c) != 0){
				log("We see - in the wrong position");
				return false;
			}
		 
			else if( c == '-' && input.indexOf(c) == 0){
				log("We see a negative sign in the correct postion, set the seenNeg boolean flag to true");
				negSeen = true;
			}
			else if( c == '-' && negSeen ){
				log("We see another -, but another - sign was seen");
				return false;
			}
			else if(c == '.' && c == input.charAt(input.length() -1)){
				log("The . is at the end");
				return false;
			}
			else if( c == '.' && !dotSeen ){
				dotSeen = true;
			}
			else if(c == '.' && dotSeen){
				log("We see too many . sign");
				return false;
			}
			else if( c < 48 || c > 57){
				log(" Character: " + c + " is not a valid digit");
				return false;
			}	
	
		}
		return true;
	}
	
	public static void log(String message){
		System.out.println(message);
	}

	public static void main(String[] args){
		System.out.println("Is " + getTest() + " a number? " + isNumberLong( getTest() ) );
	}
	
	private static String getTest(){
		return ".-";
	}
}
