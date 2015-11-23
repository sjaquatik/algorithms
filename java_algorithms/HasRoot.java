public class HasRoot{

	public static boolean hasRoot(int n){
	int base = 1;
	while( base <= n/2){
		if ( n == base*base){
			return true;
		}
		base += 1;
	}
	return false;
	}

	public static void main(String[] args){
		for(int i = 0; i <= 49; i++){
			System.out.println("Does: " + i + " has root? " + HasRoot.hasRoot(i));
		}
	}

}
