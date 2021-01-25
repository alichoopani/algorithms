import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AllSubsetsRecursive
{

	public static void main(String... args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("insert count of numbers: ");
		Integer count = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= count; i++) {
			System.out.format("insert %sth number: ", i);
			list.add(sc.nextInt());
		}	
		allSubsetsRecursive(list, 0, "");
	}


	public static void allSubsetsRecursive(List<Integer> list, Integer index, String current) {
		if (index == list.size()) {
			System.out.println("{" + current + "}");
			return;
		}
		allSubsetsRecursive(list, index + 1, current);
		current += list.get(index);	
		allSubsetsRecursive(list, index + 1, current);
	}
}
