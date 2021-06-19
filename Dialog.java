import java.util.Scanner;

public class Dialog {

    private final int ENDE = 0;
    private final int ANONYM = 1;
    private final int LAMBDA = 2;

    private final int SQUARE = 1;
    private final int FACULTY = 2;
    private final int EXPONENT = 3;
    private final int FIBONACCI = 4;

    Scanner input = new Scanner(System.in);

    /**
     * This Method checks the all input numbers.
     * @param from start the operation numbers / class numbers
     * @param to end the operation numbers / class numbers
     * @return the input
     */
    private int getValidNumbe(int from, int to) {
        int temp = 0;
        while (true) {
            try {
                temp = input.nextInt();
                if (temp >= from && temp <= to) {
                    return temp;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("invalid input number");
                System.out.println("Please enter an invalid number again:");
                input.nextLine();
                continue;
            }
        }
    }

    /**
     * This is the operation funktion
     * @param Anonym if the choosen class is (true)Anonym or (false)Lambda .
     */
    private void executeOperations(boolean Anonym) {

        // print operations menu
        System.out.println("choose operation: " + "\n" +
                SQUARE + " :Square" + "  " + FACULTY + " : Faculty" + "  " + EXPONENT + " :Exponent" + "  " +
                FIBONACCI + " :Fibonacci  " + ENDE + " :Main Menu" );

        // get choice number
        int choice = getValidNumbe(0, 4);
        if (choice == ENDE) return;
        // get first and seonde numbers (i and j) for the operations as described in the exercise sheet
        System.out.println("Enter first number: ");
        int firstNumber = getValidNumbe(Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Enter second number: ");
        int secondNumber = getValidNumbe(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (secondNumber < firstNumber ){
            System.out.println("there is nothing to calculate because first number "+firstNumber +" is smaller " +
                    "than second number "+secondNumber);
            return;
        }
        switch (choice) {
            case SQUARE:
                if (Anonym) {
                    ApplyPrint.squareAnonym(firstNumber, secondNumber);
                } else {
                    ApplyPrint.squareLambda(firstNumber, secondNumber);
                }
                break;
            case FACULTY:
                if (Anonym) {
                    ApplyPrint.facAnonym(firstNumber, secondNumber);
                } else {
                    ApplyPrint.facLambda(firstNumber, secondNumber);
                }
                Fakultat tlfaku = new Fakultat();
                ApplyPrint.applyAndPrint(firstNumber, secondNumber, tlfaku);
                
                Fakultat.Nested nestfaku = new Fakultat.Nested();
                ApplyPrint.applyAndPrint(firstNumber, secondNumber, nestfaku);
                
                break;
            case EXPONENT:
                if (Anonym) {
                    ApplyPrint.exponAnonym(firstNumber, secondNumber);
                } else {
                    ApplyPrint.expoLambda(firstNumber, secondNumber);
                }
                break;
            case FIBONACCI:
                if (Anonym) {
                    ApplyPrint.fibonacciAnonym(firstNumber, secondNumber);
                } else {
                    ApplyPrint.fibonacciLambda(firstNumber, secondNumber);
                }
                break;
            case ENDE:
                                          
                return;
            default:
                System.out.println("somthing went wrong");
        }

    }


    public void Start() {
        int funktion = -1;
        while (true) {
            System.out.printf("Choose class of operation:\n%d:Anonyme  %d:Lambda %d:Exit%n", ANONYM , LAMBDA , ENDE);
            funktion = getValidNumbe(0, 2);
            switch (funktion) {
                case ENDE:
                 Conditionate lambdaXsquare = x -> x * x;
                ApplyPrint.applyAndPrint(1, 10,
                                         lambdaXsquare.conditionateInput(ApplyPrint.even)
                                     );
                                     
                Conditionate  lambdaFaku = x -> {
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
                                               };
                 ApplyPrint.applyAndPrint(1, 10,
                                         lambdaFaku.conditionateOutput(ApplyPrint.odd)
                                     ); 
                    return;
                case ANONYM:
                    executeOperations(true);
                    break;
                case LAMBDA:
                    executeOperations(false);
                    break;
                default:
                    System.out.println("invalid");
            }
        }
    }

    public static void main(String[] args) {
        new Dialog().Start();

    }
}
