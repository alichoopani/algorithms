import java.util.Scanner;

class PrintTriangle
{

    public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("insert width: ");
	    Integer width = sc.nextInt();
	    triangle(width, 1);

    }

    static void printTriangle(int num) {
        if (num == 0)
            return;
        System.out.print("* ");
        printTriangle(num - 1);
    }

    static void triangle(int n, int i) {
        if (n == 0)
            return;
        printTriangle(i);
        System.out.println();
        triangle(n - 1, i + 1);
    }
}

