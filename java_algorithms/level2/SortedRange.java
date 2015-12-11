public class SortedRange{

	public static void main(String[] args){
		char[] test = new char[3];
		test[0] = 'c';
		test[1] = 'f';
		test[2] = 'k';
		char c = 'e';
		log("Element greater than " + c + " is " + findChar(test, c));	
		
	}

	public static void log(Object msg){
		System.out.println(msg.toString());
	}
	public static char findChar(char[] st, char key){
		
		int length = st.length;
		
		return st[ findInsPoint(st, 0, length-1, key) % length];
	
	}

	public static int findInsPoint(char[] st, int begin, int end, char key){
	
		if( end < begin){
			return begin;
		}
		else{
			int mid = begin + (end - begin) / 2;

			if ( key > st[mid]){
				begin = mid + 1;
				return findInsPoint(st, begin, end, key);
			}
			else if( key < st[mid]){
				end = mid - 1;
				return findInsPoint(st, begin, end, key);
			}
			else{
				return mid + 1;
			}

		}
		
	}

}
