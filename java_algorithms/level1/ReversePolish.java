import java.util.Stack;
import java.util.List;
import java.util.LinkedList;
import java.util.EmptyStackException;
public class ReversePolish{
	public static void main(String[] args){
		log("Result: " + rpn(getTest()));
	}
	private static List<String> getTest(){
		List<String> test = new LinkedList<String>();
		/*
		test.add("5");
		test.add("80");
		test.add("40");
		test.add("/");
		test.add("+");
		*/	
		test.add("0");
		test.add("0");
		test.add("/");
		return test;
	}
	private static void log(Object msg){
		System.out.println(msg.toString());
	}
	public static double rpn(List<String> inputList){
		if(inputList == null || inputList.size() == 0){
			throw new IllegalArgumentException();
		}
		Stack<Double> stack = new Stack<Double>();
		for( String st: inputList){
			if( isOp( st) ){
				log(st + " is an operation");
				try{
					double v1 = stack.pop();
					double v2 = stack.pop();
					stack.push( performMath( v1, v2, OP.getOp(st) ));
				}catch(EmptyStackException ese){
					throw new IllegalArgumentException("Emtpy stack");
				}catch(Exception e){
					throw new IllegalArgumentException(e.getMessage());
				}
			}
			else{
				log("Pushing " + st + " onto the stack");
				stack.push( parseDouble(st));
			}
		}	
		return stack.pop();
	}
	private static boolean isOp( String value){
	
	OP[] allOps = OP.values();

	for(OP o : allOps){
		if (value.equals(o.getString())){
			return true;
		}
	}
	return false;
	}
	private static double parseDouble( String value ) throws IllegalArgumentException {
		try{
			return Double.parseDouble(value);
		}catch(NumberFormatException nfe){
			throw new IllegalArgumentException();
		}
	}

	private static double performMath(double v1, double v2, OP op) throws IllegalArgumentException, ArithmeticException{
		switch(op){
			case ADD:
				return v1 + v2;
			case SUBSTRACT:
				return v2 - v1;
			case MULTIPLY:
				return v2 * v1;
			case DIV:
				if( v1 == 0){
					throw new ArithmeticException("Divide by zero");
				}
				else{
					return v2 / v1;
				}
			default:
				throw new IllegalArgumentException("Operation not supported");
		}
	}
} // end class

enum OP {

	ADD("+"), SUBSTRACT("-"), MULTIPLY("*"), DIV("/");

	OP(String v){
		this.rawString = v;
	}

	private final String rawString;
	
	public String getString(){
		return rawString;
	}
	
	public static OP getOp(String st){
		switch (st){
			case "+":
				return ADD;
			case "-":
				return SUBSTRACT;
			case "*":
				return MULTIPLY;
			case "/":
				return DIV;
			default:
				throw new IllegalArgumentException(); 
		}
	}
}
