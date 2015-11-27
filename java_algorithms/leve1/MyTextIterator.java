import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class MyTextIterator implements Iterable<String>
{
	private String fn;

	public MyTextIterator(String fn){
		
		this.fn = fn;
			
	}
	
	@Override
	public Iterator<String> iterator(){
		return new MyIterator(this.fn);
	}
	
	public static void main(String[] args)
	{
		String fileName = "/Users/trung.dinh/Desktop/Trung/problems/github/algorithms/java_algorithms/leve1/test.txt";
		MyTextIterator myTxtClass = new MyTextIterator(fileName);

		Iterator<String> strIterator = myTxtClass.iterator();
		while(strIterator.hasNext()){
			System.out.println(strIterator.next());
		}
	}
}

class MyIterator implements Iterator<String>{

		private BufferedReader buffReader;
		
		public MyIterator(String fn){
			
			try{
				buffReader = new BufferedReader( new FileReader(fn));
			
			}catch(FileNotFoundException fnfe){
				log("File " + fn + " not found");
				buffReader = null;
			}catch (Exception e){
				log("Other exception: " + e.getMessage() + " while trying to open " + fn);	
				buffReader = null;
			}
		}

		public void log(Object msg){
			System.out.println(msg.toString());
		}
		
		@Override
		public boolean hasNext(){
			if(buffReader == null){
				return false;
			}
			try{
				buffReader.mark(1);
				int nextChar = buffReader.read();
				buffReader.reset();
				return nextChar != -1;
			}catch(Exception e){
				log(e.getMessage());
				this.close();
				return false;
			}
			
		}
	
		@Override
		public String next(){
			String nextLine = "";
			try{
			 nextLine = buffReader.readLine();
			 return nextLine;
			}catch(IOException ioe){
				log("IO Exception while reading file");
				this.close();
			}
			return "";
		}
			
		@Override		
		public void remove(){
		throw new UnsupportedOperationException();
		}

		public void close(){
			try{
				buffReader.close();
			}catch(Exception e){
				log(e.getMessage() + " while trying to close buffer reader");
			}
			finally{
				buffReader = null;
			}
		}	
}

