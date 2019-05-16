public class CompareFunction {

    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 27;
        String compareResult = compare(num1, num2);  // pass variables to be compared 
        System.out.print(compareResult);

    }

    public static String compare(int var1, int var2) {

        String result;
        if (var1 > var2) {
            result = var1 + " is larger than " + var2;
        } else if (var1 == var2) {
            result = "Both numbers are equal";
        } else {
            result = var2 + " is larger than " + var1;
        }
        return result;
    }
}


