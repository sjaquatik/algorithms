public class PalinSub {
	
	public static void main(String[] args){
		//String test = "ABBAST";	
		String test = "AABCDEBAZ";
		System.out.println("Longest Palindromic subsequence: " + maxLenPalindrome(test));
	}

	public static int maxLenPalindrome( String str){
		char[] values = str.toCharArray();
		int result = 1;
		int arrayLen = values.length;
		int LPSLen = arrayLen + 1;
		
		// Lookup table 
		int[][] LPS = new int[LPSLen][LPSLen];	
		for(int i = 0; i < LPSLen; i++){
			LPS[i][i] = 1;
		}

		for(int strLen = 2 ; strLen <= arrayLen; strLen++){
			for(int i = 0; i < LPSLen-strLen; i++){
				int j = strLen + i - 1;
				log("strLen: " + strLen  + " i: " + i + " j: " + j);
				if(values[i] == values[j] && strLen==2){
					LPS[i][j] = 2;
				}
				else if( values[i] == values[j]){
					LPS[i][j] = 2 + LPS[i+1][j-1];
				}
				else {
					LPS[i][j] = Math.max( LPS[i][j-1], LPS[i+1][j]);
				}
			}
		}// end outer loop
		
		printArray(LPS);

		return LPS[0][arrayLen-1];
	}

	static void printArray(int[][] array){
		StringBuilder strBuilder = new StringBuilder();
		int len = array.length;
	
		for(int i = 0; i < len; i++){

			for(int j = 0; j < len; j++){
				strBuilder.append( array[i][j] + " ");
			}
			
			strBuilder.append("\n");
		}
		System.out.println(strBuilder.toString());
	}

	static void log(Object msg){
		System.out.println(msg.toString());
	}
}
