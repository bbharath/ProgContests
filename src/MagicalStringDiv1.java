//SRM 609 Div 1 250
//Passed System Tests
public class MagicalStringDiv1
{
	public int getLongest(String S)
	{
		int N = S.length();
		
		int removed = N, ret = 0;
		
		for(int K=1;K<50;++K) {
			int r = 2*K;
			if(r>N)
				continue;
			
			int removedNow = 0;
			int greater = 0 , lesser = 0;
			for(int i=0;i<N;++i) {
				char ch = S.charAt(i);
				if(greater<K) {
					if(ch=='>') {
						++greater;
					} else {
						++removedNow;
					}
				} else if(lesser<K) {
					if(ch=='<') {
						++lesser;
					} else {
						++removedNow;
					}
				} else {
					++removedNow;
				}
			}
			if(greater==K && lesser==K) {
				if(removedNow<removed) {
					removed = removedNow;
					ret = r;
				}
			}
		}
		
		return ret;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
		System.out.println("]");
		MagicalStringDiv1 obj;
		int answer;
		obj = new MagicalStringDiv1();
		long startTime = System.currentTimeMillis();
		answer = obj.getLongest(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p1;
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
		int p1;
		
		// ----- test 0 -----
		p0 = "<><><<>";
		p1 = 4;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = ">>><<<";
		p1 = 6;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "<<<>>>";
		p1 = 0;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "<<<<><>>><>>><>><>><>>><<<<>><>>>>><<>>>>><><<<<>>";
		p1 = 24;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
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
