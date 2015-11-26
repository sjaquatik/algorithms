public class ReverseString{

	public static String reverseString( String s){
		
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(s);
		return strBuilder.reverse().toString();
		
	}
	public static void main(String[] args){
		String test = "hello";
		System.out.println(reverseString(test));
	}
}
