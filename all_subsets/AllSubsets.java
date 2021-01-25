import java.util.List;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AllSubsets
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
		printAllSubsetsOfList(list);
	}

	private static void printAllSubsetsOfList(List<Integer> list) {
		List<Integer> binary = new ArrayList<>(Collections.nCopies(list.size() + 1, 0));
		while(binary.get(0) == 0) {
			binary = binaryCount(binary);
			System.out.print("{");
			for (int i = list.size(); i > 0; i--)
				if (binary.get(i) == 1)
					System.out.print(list.get(i - 1));
			System.out.println("}");
		}

	}

	private static List<Integer> binaryCount(List<Integer> list) {
		for (int i = list.size() - 1; i >= 0; i--)
			if (list.get(i) == 0) {
				for (int j = i; j <= list.size() - 1; j++)
					list.set(j, 0);
				list.set(i, 1);
				break;
			}
		return list;
       	}
}
