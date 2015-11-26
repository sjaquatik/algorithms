public class Dec2Bin{
	// print out a binary string given an integer input
	public static String dec2Binary(int input){
		
	if (input == 0){
		return "0";
	}
	
	int maxLength = findIndex(input);

	log("Max length: " + maxLength+"");

	char[] chArray = new char[ maxLength + 1 ];

	for(int i = 0; i<maxLength+1; i++){
		chArray[i] = '0';
	}

	chArray[maxLength] = '1';

	int remainder = input - (int)Math.pow(2, maxLength);
	while(remainder >0){
		log("Remainder is: " , ""+remainder);
		maxLength = findIndex(remainder);
		chArray[maxLength] = '1';
		remainder = remainder - (int)Math.pow(2, maxLength);
	} 
	log("Remainder is: " , ""+remainder);
	StringBuilder strBuilder  = new StringBuilder();
	for( char c:chArray){
		strBuilder.append(c);
		}
	return strBuilder.reverse().toString();	
	
	}
	

	static int findIndex(int input){
	
		int base = 1;

		while ( Math.pow(2,base) <= input){
			base += 1;
		}
	return base-1;
	}

	public static void main(String[] args){
		log(dec2Binary(38));
	}

	static void log(String... msg){
		StringBuilder strBuilder = new StringBuilder();
		for(String str:msg){
		strBuilder.append(str);
		}
		System.out.println(strBuilder.toString());
	}
	
}
