import java.math.BigInteger;

//Passed System Tests
//SRM 616 Div 1 250
public class WakingUp
{
	public int maxSleepiness(int[] period, int[] start, int[] volume, int D)
	{
		BigInteger lcm = BigInteger.ONE;
		
		for(int p : period) {
			BigInteger P = new BigInteger(""+p);
			BigInteger gcd = lcm.gcd(P);			
			lcm = lcm.multiply(P).divide(gcd);
		}
		int T = lcm.intValue();
		int sleep = 0;
		int N = period.length;
		int min = 0;
		for(int t=1;t<=T;++t) {
			sleep += D;
			for(int i=0;i<N;++i) {
				if(t>=start[i] && ( (t-start[i])%period[i]) == 0) {
					sleep-=volume[i];
				}				
			}
			min = Math.min(min, sleep);
		}
		
		if(sleep<0)
			return -1;
		else
			return -min;
		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int[] p2, int p3, boolean hasAnswer, int p4) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}" + "," + p3);
		System.out.println("]");
		WakingUp obj;
		int answer;
		obj = new WakingUp();
		long startTime = System.currentTimeMillis();
		answer = obj.maxSleepiness(p0, p1, p2, p3);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p4);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p4;
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
		
		int[] p0;
		int[] p1;
		int[] p2;
		int p3;
		int p4;
		
		// ----- test 0 -----
		p0 = new int[]{2,3};
		p1 = new int[]{1,2};
		p2 = new int[]{3,4};
		p3 = 3;
		p4 = 2;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{1};
		p1 = new int[]{1};
		p2 = new int[]{17};
		p3 = 17;
		p4 = 0;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{1};
		p1 = new int[]{1};
		p2 = new int[]{23};
		p3 = 17;
		p4 = -1;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{9,2,5,5,7};
		p1 = new int[]{6,1,4,1,6};
		p2 = new int[]{71,66,7,34,6};
		p3 = 50;
		p4 = 78;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{5,6,5,3,8,3,4};
		p1 = new int[]{1,1,3,2,6,3,3};
		p2 = new int[]{42,85,10,86,21,78,38};
		p3 = 88;
		p4 = -1;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
	    p0 = new int[] {6, 3, 8, 3, 9, 9, 10, 9, 4, 2, 1, 2, 9, 4, 9, 8, 10, 8, 3, 10, 5, 10, 4, 6, 3, 1};
	    p1 = new int[]  {2, 1, 1, 1, 4, 8, 3, 3, 3, 2, 1, 2, 2, 1, 6, 8, 3, 6, 3, 8, 1, 9, 1, 6, 3, 1};
	    p2 = new int[] {11, 7, 15, 27, 11, 6, 13, 26, 28, 21, 11, 9, 11, 18, 9, 10, 14, 6, 2, 10, 20, 19, 29, 14, 14, 11};
	    p3 = 97;
	    p4 = -1;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, true, p4) && all_right;

		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
