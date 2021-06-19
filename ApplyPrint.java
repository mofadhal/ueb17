import java.util.function.IntPredicate;
/**
*
* @author (Mofadhal Al-Manari und Leen Alkhadraa)
* @version (09.06.2021)
*
*/

public class ApplyPrint {

    /**
     * diese Methode soll die übergebene Funktion auf alle Zahlen zwischen i und j anwenden
     */
    public static void applyAndPrint(int i, int j, MyFunction f) {
        for (; i <= j; i++) {
            //int temp = f.apply(i);
            System.out.print(f.apply(i) + "  ");
        }
        System.out.println();
    }

    //-------------------------Anonyme--------------------------------

    /**
     * Anonyme Klasse, die die Quadratzahl für i berechnet
     */
    public static void squareAnonym(int i, int j) {
        System.out.print("Square anonym : ");
        
        
        MyFunction nanonXSquare =  new MyFunction() {
            @Override
            public int apply(int i) {
                return i * i;
            }
        };
        
        applyAndPrint(i, j, nanonXSquare);
    }


    /**
     * Anonyme Klasse, die die Fakultät einer Zahl berechnet
     */
    public static void facAnonym(int i, int j) {
        System.out.print("Faculty anonym : ");
        applyAndPrint(i, j, new MyFunction() {
            @Override
            public int apply(int i) {
                if (i < 0)
                    throw new IllegalArgumentException("fac for negative is not defined");
                int result = 1;
                for (; i >= 1; i--) {
                    result *= i;
                }
                return result;
            }
        });
    }

    /**
     * Anonyme Klasse, die i^(i+1) berechnet
     */
    public static void exponAnonym(int i, int j) {
        System.out.print("Exponent anonym :");
        applyAndPrint(i, j, new MyFunction() {
            @Override
            public int apply(int i) {
                return (int) Math.pow(i, i + 1);
            }
        });
    }

    /**
     * Anonyme Klasse, die die Fibonaccifolge berechnet
     */
    public static void fibonacciAnonym(int i, int j) {
        System.out.print("Fibonacci anonym :");
        applyAndPrint(i, j, new MyFunction() {
            @Override
            public int apply(int i) {
                int x = 0, y = 1, z = 1;
                for (int a = 0; a < i; a++) {
                    x = y;
                    y = z;
                    z = x + y;
                }
                return x;
            }
        });
    }
/*
 * public static long fib(int n) {
   if(n == 0) {
     return 0;
   } else if (n == 1) {
     return 1;
   } else {
      return fib(n-1) + fib(n-2); //der rekursive Aufruf
   }
}
 */

    //---------------------------Lambda----------------------------

    /**
     * Lambda Ausdrück, die die Quadratzahl für i berechnet
     */
    public static void squareLambda(int i, int j) {
        System.out.print("Square lambda : ");
        MyFunction lambdaXsquare = x -> x * x;
        
        applyAndPrint(i, j, lambdaXsquare);
        //applyAndPrint(i, j, x -> x * x);
    }

    /**
     * Lambda Ausdrück, die die Fakultät einer Zahl berechnet
     */
    public static void facLambda(int i, int j) {
        System.out.print("Faculty lambda : ");
        applyAndPrint(i, j, x -> {
            if (x < 0) {
                throw new IllegalArgumentException("fac for negative is not defined");
            }
            int result = 1;
            if (x == 0) {
                return 1;
            }
            for (int a = x; a >= 1; a--) {
                result *= a;
            }
            return result;
        });
    }

    /**
     * Lambda Ausdrück, die die Fakultät einer Zahl berechnet
     */
    public static void expoLambda(int i, int j) {
        System.out.print("Exponent lambda : ");
        applyAndPrint(i, j, (x -> (int) Math.pow(x, x + 1)));
    }

    /**
     * Lambda Ausdrück, die die Fibonaccifolge berechnet
     */
    public static void fibonacciLambda(int i, int j) {
        System.out.print("Fibonacci lambda :");
        applyAndPrint(i, j, s -> {
            int x = 0, y = 1, z = 1;
            for (int a = 0; a < s; a++) {
                x = y;
                y = z;
                z = x + y;
            }
            return x;
        });

    }


    /**
     * Prädikat zum Überprüfen, ob ein gegebener Integer Wert ungerade ist
     */
    public static IntPredicate odd = new IntPredicate() {
        public boolean test(int x) {
            return !(x % 2 == 0);
        }
    };
    /**
     * Prädikat als Lambda Ausdruck zum Überprüfen, ob ein gegebener Integer Wert gerade ist
     */
    public static IntPredicate even = x -> (x % 2 == 0);

}
   

