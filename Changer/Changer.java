import java.util.ArrayList;
import java.util.HashMap;

public class Rozmieniacz {
	
	 // 1, 2, 5, 10, 20, 50, 100, 200, 500
	static ArrayList<Integer> nominals = new ArrayList<Integer>();
	static HashMap<Integer, Integer> change = new HashMap<Integer, Integer>();
	
	static int idx = 8;
	
	//	-------------------------------------
	//	Filling up the list with all nominals
	//	-------------------------------------
	static void add_nominals( ArrayList<Integer> nom ) {
		
		nom.add( 1   );
		nom.add( 2   );
		nom.add( 5   );
		nom.add( 10  );
		nom.add( 20  );
		nom.add( 50  );
		nom.add( 100 );
		nom.add( 200 );
		nom.add( 500 );
	}
	
	//	-----------------------------------
	//	Recursive greedy exchange algorithm
	//	-----------------------------------
	static void exchange( int value, int index ) {
		
		if( value <= 0 )
			return;
		else {
			//	--------------------------------
			//	If this integer is lesser than 1
			//		it means that the nominal is
			//		too big to be exchanged
			//	--------------------------------
			int div = value/nominals.get(index);
			
			//	-----------------------
			//	Trying to exchange with
			//		lower nominal
			//	-----------------------
			if( div <= 0 ) {
				exchange( value, index-1 );
				return;
			}
			else {
				while( div >= 1 ) {
					
					int temp;
					if( change.get( nominals.get(index) ) == null )
						temp = 0;
					else
						temp = change.get( nominals.get(index) );
					
					change.put( nominals.get(index), temp+1 );
					value -= nominals.get(index);
					div = value/nominals.get(index);
				}
				
				exchange( value, index-1 );
			}
		}
	}
	
	public static void main( String[] args ) {
		
		add_nominals( nominals );
		
		//	---------------------------------------------------
		//	Set this value to whatever you want to be exchanged
		//	---------------------------------------------------
		int value = 239;
		
		exchange( value, idx );
		
		for( Integer key : change.keySet() )
			System.out.println( "Nominal = " + key.toString() + "     Quantity = " + change.get(key).toString() );
	}
}
