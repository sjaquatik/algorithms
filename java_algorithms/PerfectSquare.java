public class PerfectSquare{
	// print perfect square upt to n
	public void perfectSquare(int n){
	int base = 1;
	while (base * base <= n){
	System.out.print( base * base + "->");
	base += 1;
		}
	System.out.println();
	}
	
	public static void main(String[] args){
		PerfectSquare ps = new PerfectSquare();
		ps.perfectSquare(100);
	}
}

