import java.util.Scanner;


class PrintDiamond
{

    public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("insert width: ");
	    Integer width = sc.nextInt();
	    diamond(width, 1);
    }

    static void diamond(int n, int i) {
        if (i == n + 1)
            return;
        printDiamond(n, i, 1);
        System.out.println();
        diamond(n, i + 1);
    }

    public static void printDiamond(int n, int i, int j) {
        if (j == n + 1)
            return;
        int x = (int) Math.ceil(n / 2.0);
        if (j <= Math.abs(x - i) || j >= x + i || (i > x && j > 3 * x - i - 1 ))
            System.out.print("  ");
        else
            System.out.print("* ");
        printDiamond(n, i, ++j);
    }
}
