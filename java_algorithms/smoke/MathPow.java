public class MathPow{

	public static double pow( double a, int b){
		
		double pow = 1;

		int iter = b < 0 ? Math.abs(b) : b;

		while( iter > 0){
			pow *= a;
			iter -= 1;
		}

		return b > 0 ? pow : 1.0 / pow;

	}

	public static void main(String[] args){
		double a = 0;
		int b = 0;
		log( a + "  power of " + b + "  is: " + MathPow.pow(a,b));
	
	}

	public static void log(Object s){
		System.out.println(s.toString());
	}

}
