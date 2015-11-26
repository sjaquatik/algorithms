import java.util.Stack;

public class BraceMatching{

	public static boolean isMatch(String s){
	
		Stack<Character> st = new Stack<Character>();

		for(int i = 0; i < s.length(); i++)
		{
			if( s.charAt(i) == '('){
				st.push( '(' );
			}
			else if( s.charAt(i) == ')'){
				if( st.isEmpty()){
					return false;
				}
				st.pop();
			}
		}
	
		return st.isEmpty();
	}


	public static void main(String[] args){
		String test = "((abc)))";
		log( test + " has matching bracket? : " + BraceMatching.isMatch(test));	
	}

	public static void log(Object msg){
		System.out.println( msg.toString());
	}

}
