package javaProblemAnalyze.randomBasicConcept;

public class Recursion {
    // A Java program to demonstrate
// working of recursion


        static void printFun(int test)
        {
            if (test < 1) {
            }

            else {
                System.out.printf("%d ", test);

                // Statement 2
                printFun(test - 1);

                System.out.printf(" %d after", test);
            }
        }

        public static void main(String[] args)
        {
            int test = 3;
            printFun(test);
        }


}
