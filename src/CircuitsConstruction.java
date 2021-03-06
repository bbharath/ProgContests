import java.util.Arrays;
import java.util.Stack;

//SRM 628 Div 1 500
//Passed System Tests
public class CircuitsConstruction
{
	private int find(String circuit) {
		int ret = 0;
		Stack<Integer> s = new Stack<Integer>();
		for(int i=circuit.length()-1;i>=0;--i) {
			char ch = circuit.charAt(i);
			if(ch=='X')
				s.push(1);
			else if(ch=='A'){
				int sum = s.pop() + s.pop();
				s.push(sum);
			} else {
				int max = Math.max(s.pop(), s.pop());
				s.push(max);
			}
		}
		ret = s.pop();
		return ret;
	}
	public int maximizeResistance(String circuit, int[] conductors)
	{
		int sum = find(circuit);
		Arrays.sort(conductors);
		int ret = 0;
		for(int i=conductors.length-1, taken=0;i>=0 && taken<sum;++taken, --i) {
			ret+=conductors[i];
		}
		return ret;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, int[] p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}");
		System.out.println("]");
		CircuitsConstruction obj;
		int answer;
		obj = new CircuitsConstruction();
		long startTime = System.currentTimeMillis();
		answer = obj.maximizeResistance(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p2;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}
	public static void main(String[] args) {
		boolean all_right;
		all_right = true;
		
		String p0;
		int[] p1;
		int p2;
		
		// ----- test 0 -----
		p0 = "BXBXX";
		p1 = new int[]{8,2,3};
		p2 = 8;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "AAXXAXAXX";
		p1 = new int[]{1,1,2,8,10};
		p2 = 22;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "AXBXX";
		p1 = new int[]{8,2,3};
		p2 = 11;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "BAAXBXXBXAXXBBAXXBXXAAXXX";
		p1 = new int[]{17,7,21,102,56,72,88,15,9,192,16,8,30};
		p2 = 454;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
