public class Main {
    /*
     * 1 Testing
     * 2 Normal
     */
    public static int PRINT_MODE = 1;

    public static int SUITES_RUN = 0;
    public static int SUITES_PASSED = 0;
    public static int TESTS_RUN = 0;
    public static int TESTS_PASSED = 0;

    public static void main(String[] args) {

        //Testing for constructors and toString
        RecursiveArray rA1 = new RecursiveArray("1,2,3");
        assertEquals(rA1.toString(), "[1,2,3]");
        RecursiveArray rA2 = new RecursiveArray();
        assertEquals(rA2.toString(), "Empty Array");
        RecursiveArray rA3 = new RecursiveArray("1,1,1,1,1,1,1");
        assertEquals(rA3.toString(), "[1,1,1,1,1,1,1]");

        //testing append and prepend
        RecursiveArray arr1 = new RecursiveArray("1,2,3");
        arr1.append(4);
        assertEquals(arr1.toString(), "[1,2,3,4]");
        RecursiveArray arr2 = new RecursiveArray("1,2,3");
        arr2.prepend(5);
        assertEquals(arr2.toString(), "[5,1,2,3]");

        //testing contains
        RecursiveArray array1 = new RecursiveArray("1,2,3");
        assertEquals(array1.contains(1), true);
        RecursiveArray array2 = new RecursiveArray("1,2,3");
        assertEquals(array2.contains(4), false);

        //test for ascending and descending
        RecursiveArray r1 = new RecursiveArray("1,2,3");
        assertEquals(r1.isAscending(), true);
        RecursiveArray r2 = new RecursiveArray("3,2,1");
        assertEquals(r2.isAscending(), false);

        RecursiveArray r3 = new RecursiveArray("3,2,1");
        assertEquals(r3.isDescending(), true);
        RecursiveArray r4 = new RecursiveArray("1,2,3");
        assertEquals(r4.isDescending(), false);

        //testing for sort ascending and sort descending
        RecursiveArray a1 = new RecursiveArray("1,5,6,3,2,9,7");
        a1.sortAscending();
        assertEquals(a1.toString(), "[1,2,3,5,6,7,9]");

        RecursiveArray a3 = new RecursiveArray("1,2,3,6,8,9");
        a3.sortDescending();
        assertEquals(a3.toString(), "[9,8,6,3,2,1]");


        
        endSuite();
    }

    public static void startSuite(String name) {
        switch (PRINT_MODE) {
            case 1:
                SUITES_RUN++;
                System.out.println("===================\nStarting: " + name + "\n===================");
                break;
        }
    }

    public static void endSuite() {
        switch (PRINT_MODE) {
            case 1:
                if (TESTS_RUN == TESTS_PASSED) {
                    SUITES_PASSED++;
                    System.out.println("All Tests Passed " + "\n===================");
                } else {
                    System.out.println("Tests Failed: " + (TESTS_RUN - TESTS_PASSED)
                            + "\n===================" );
                }
                TESTS_RUN = 0;
                TESTS_PASSED = 0;
                break;
        }
    }

    public static <T> void assertEquals(T actual, T expected) {
        switch (PRINT_MODE) {
            case 1:
                TESTS_RUN++;
                if (actual.equals(expected)) {
                    TESTS_PASSED++;
                    System.out.println("Test " + TESTS_RUN + " Passed ");
                } else {
                    System.out.println("Test " + TESTS_RUN + " Failed: Expected " + expected + " but got "
                            + actual );
                }
                break;
            case 2:
                System.out.println(actual);
                break;
        }
    }

    public static void assertEquals(String actual, String expected) {
        switch (PRINT_MODE) {
            case 1:
                TESTS_RUN++;
                if (actual.equals(expected)) {
                    TESTS_PASSED++;
                    System.out.println("Test " + TESTS_RUN + " Passed ");
                } else {
                    System.out.println("Test " + TESTS_RUN + " Failed: Expected ");
                    boolean wrong = false;
                    for (int i = 0; i < expected.length(); i++) {
                        if (i < actual.length() && actual.charAt(i) == expected.charAt(i)) {
                            if (wrong) {
                                //System.out.print(ANSI_RESET);
                                wrong = false;
                            }
                        } else if (!wrong) {
                            //System.out.print(ANSI_RED);
                            wrong = true;
                        }
                        System.out.print(expected.charAt(i));
                    }
                    System.out.print(" but got ");
                    wrong = false;
                    for (int i = 0; i < actual.length(); i++) {
                        if (i < expected.length() && actual.charAt(i) == expected.charAt(i)) {
                            if (wrong) {
                                //System.out.print(ANSI_RESET);
                                wrong = false;
                            }
                        } else if (!wrong) {
                            //System.out.print(ANSI_RED);
                            wrong = true;
                        }
                        System.out.print(actual.charAt(i));
                    }
                    //System.err.println(ANSI_RESET);
                }
                break;
            case 2:
                System.out.println(actual);
                break;
        }
    }

    public static void endAll() {
        switch (PRINT_MODE) {
            case 1:
                if (SUITES_RUN == SUITES_PASSED) {
                    System.out.println(
                             "\n\n===================\n" + "All Suites Passed " + SUITES_PASSED + "/"
                                    + SUITES_RUN + "\n===================");
                } else {
                    System.out.println("===================\n" + "Some Suites Failed: " + SUITES_PASSED + "/"
                            + SUITES_RUN + "\n===================");
                }
                break;
        }
    }
}