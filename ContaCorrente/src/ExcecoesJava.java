public class ExcecoesJava {
    public static void main(String[] args) {
        // 1. NullPointerException (não verificada)
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }

        // 2. ArithmeticException (não verificada)
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }

        // 3. ArrayIndexOutOfBoundsException (não verificada)
        try {
            int[] arr = new int[5];
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // 4. NumberFormatException (não verificada)
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }

        // 5. ClassCastException (não verificada)
        try {
            Object obj = Integer.valueOf(100);
            String str = (String) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }

        // 6. IOException (verificada)
        try {
            java.io.File file = new java.io.File("arquivo_inexistente.txt");
            java.io.FileReader fr = new java.io.FileReader(file);
        } catch (java.io.IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // 7. OutOfMemoryError (erro, não exceção)
        try {
            long[] hugeArray = new long[Integer.MAX_VALUE];
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemoryError: " + e.getMessage());
        }
    }
}