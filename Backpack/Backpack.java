import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Backpack {

    //	--------------------
    //	Size of the backpack
    //	--------------------
    static int max_capacity = 24;

    //	----------------------------------------
    //	Item object that is kept in the backpack
    //	----------------------------------------
    class Item {

        private int weight;
        private int value;
        private double proportion;

        Item( int a, int b ) {

            weight = a;
            value  = b;
            proportion = b/a;
        }

        //	-------
        //	Getters
        //	-------
        int getWeight() { return weight; }
        int getValue()  { return value;  }

        double getProportion()  { return proportion;  }
    }

    //	-----------------------------------------
    //	For the needs of the greedy algorithm,
    //		finding the item with best proportion
    //	-----------------------------------------
    static Item findItemWithBestProportion( List<Item> items, Backpack b ) {

        Item temp = b.new Item( 1, 0 );

        for( Item i : items ) {

            if( temp.getProportion() < i.getProportion() )
                temp = i;
        }

        return temp;
    }

    //	--------------------------------------------------
    //	For the needs of the greedy algorithm,
    //		finding the item with best value ¯\_(ツ)_/¯
    //	----------------------------------------------
    static int getBestValue( List<Item> items ) {

        int bestValue = 0;
        for( Item i : items )
            bestValue += i.getValue();

        return bestValue;
    }

    public static void main( String[] argv ) {

        Backpack backpack = new Backpack();

        //	---------------------------
        //	Reading data from .txt file
        //	---------------------------
        String path = System.getProperty("user.dir")+"\\src\\data1.txt";
        File file = new File( path );
        List<Item> items = new ArrayList<Item>();

        try {
            Scanner scanner = new Scanner( file );

            while( scanner.hasNext() ) {

                int weight = scanner.nextInt();
                int value = scanner.nextInt();

                Item item = backpack.new Item( weight, value );

                items.add( item );
            }

            scanner.close();
        } catch (Exception e) {}
		
		/*
		for( Item i : items )
			System.out.println( "Weight: " + i.getWeight() + "	Value: " + i.getValue() );
		*/

        List<Item> bestItems = new ArrayList<Item>();
        int current_capacity = 0;

        while( !items.isEmpty() ) {

            //	Finding best item ...
            Item bestItem = findItemWithBestProportion( items, backpack );

            //	Checking if there's enough space left ...
            if( current_capacity+bestItem.getWeight() <= max_capacity ) {

                bestItems.add( bestItem );
                current_capacity += bestItem.getWeight();

                items.remove( bestItem );
            }
            else {
                items.remove( bestItem );
            }
        }

        System.out.println( "Best Value: " + getBestValue( bestItems ) );

        for( Item i : bestItems )
            System.out.println( "Weight: " + i.getWeight() + "	Value: " + i.getValue() );
    }
}
