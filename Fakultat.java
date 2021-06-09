/**
*
* @author (Mofadhal Al-Manari und Leen Alkhadraa)
* @version (09.06.2021)
* 
*/
	
  

public class Fakultat implements MyFunction {
	
	    /**
	     * Top level Klasse zum Berechnen die Fakultät einer Zahl
	     */
	    public int apply(int i){
	        if(i == 0){
	            return 1;
	        }if (i < 0 ){
	            throw new IllegalArgumentException("False input");
	        }
	        return i * apply(i - 1);
	    }
	    
	    /**
	     * 
	     *Static Nested Klasse zum Berechnen die Fakultät einer Zahl
	     */
	    public static class Nested implements MyFunction {
	        public int apply(int i){
	            if(i == 0){
	                return 1;
	            }if (i < 0 ){
	                throw new IllegalArgumentException("False input");
	            }
	            return i * apply(i - 1);
	        }
	    }

	}

