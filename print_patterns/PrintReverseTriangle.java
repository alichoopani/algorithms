import java.util.Scanner;

class PrintReverseTriangle
{

    public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("insert width: ");
	Integer width = sc.nextInt();
        reverseTriangle(width);
    }

    static void printTriangle(int num, String c) {
        if (num == 0)
            return;
        System.out.print (c);
        printTriangle(num - 1, c);
    }

    static void reverseTriangle(int n) {
        if (n == 0)
            return;
        printTriangle(n, "* ");
        System.out.println();
        reverseTriangle(n - 1);
    }

}

