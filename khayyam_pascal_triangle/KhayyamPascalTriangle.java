import java.util.Scanner;

public class KhayyamPascalTriangle
{

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("insert number: ");
		Integer input = sc.nextInt();
		printZhayam(input);
	}

	private static void printZhayam(Integer i) {
		for (int j = 1; j <= i; j++) {
			for (int k = 1; k <= j; k++) 
				System.out.print(getZhayam(k, j) + " ");
			System.out.println();
		}
	}

	private static Integer getZhayam(Integer i, Integer j) {
		return (i == 1 || i == j) ? 1 : getZhayam(i - 1, j - 1) + getZhayam(i, j - 1);
	}
}
