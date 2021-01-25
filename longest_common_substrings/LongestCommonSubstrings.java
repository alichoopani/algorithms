import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;
import java.util.List;

public class LongestCommonSubstrings
{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("insert first string: ");
		String in1 = sc.nextLine();
		System.out.print("insert first string: ");
		String in2 = sc.nextLine();
		System.out.println("the answer is: " + getLongestSubscriptions(in1, in2));
	}

	/**
	 * get two string and return list of longest subscriptions between strings
	 * @return List<String>
	 */
	private static List<String> getLongestSubscriptions(String in1, String in2) {
		String longerString = in1.length() > in2.length() ? in1 : in2;
		String shorterString = in1.length() > in2.length() ? in2 : in1;
		List<String> out = new ArrayList<>(); 
		for(int i = 0; i < shorterString.length(); i++)
			for (int j = i + 1; j < shorterString.length() + 1; j++) {
				String tmp = shorterString.substring(i, j);
				if (containString(tmp, longerString))
				       if (out.size() == 0)
						out.add(tmp);
				       else if(out.get(0).length() == tmp.length())		
					       out.add(tmp);
				       else if(out.get(0).length() < tmp.length()) {
					       out.clear();
					       out.add(tmp);
				       }
			}
		return out;
	}

	/**
	 * get tow string and check first string exist in second string or not
	 * @return boolean
	 */
	private static boolean containString(String str1, String str2) {
		for (int i = 0; i < str2.length() - str1.length() + 1; i++)
			if (str2.substring(i, i + str1.length()).equals(str1))
				return true;
		return false;
	}
}
