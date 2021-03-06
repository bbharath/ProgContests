import java.util.Arrays;
//Passed System Tests
//SRM 608 Div 1 300
public class MysticAndCandies
{
	public int minBoxes(int C, int X, int[] low, int[] high)
	{
		Arrays.sort(low);
		Arrays.sort(high);
		int N=low.length;
		int H = 0;
		for(int i=0;i<N;++i) {			
			H+=high[i];
		}
		
		int a=0, b=0;
		for(int i=N-1, ret=0; i>=0; --i) {
			++ret;
			a+=low[i];
			if(a>=X)
				return ret;
			b+=high[i];
			if(C-H+b>=X)
				return ret; 
		}
		return low.length;
				
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int[] p2, int[] p3, boolean hasAnswer, int p4) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p3.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p3[i]);
		}
		System.out.print("}");
		System.out.println("]");
		MysticAndCandies obj;
		int answer;
		obj = new MysticAndCandies();
		long startTime = System.currentTimeMillis();
		answer = obj.minBoxes(p0, p1, p2, p3);
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
		
		int p0;
		int p1;
		int[] p2;
		int[] p3;
		int p4;
		
		// ----- test 0 -----
		p0 = 15;
		p1 = 12;
		p2 = new int[]{1,2,3,4,5};
		p3 = new int[]{1,2,3,4,5};
		p4 = 3;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 60;
		p1 = 8;
		p2 = new int[]{5,2,3};
		p3 = new int[]{49,48,47};
		p4 = 2;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 58;
		p1 = 30;
		p2 = new int[]{3,9,12,6,15};
		p3 = new int[]{8,12,20,8,15};
		p4 = 2;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 207581165;
		p1 = 172146543;
		p2 = new int[]{4725448,2753824,6019698,4199708,4070001,3589497,5358499,3637585,5393667,2837466,2747807,2918199,3638042,5199002,3072044,3858909,3762101,3657754,3218704,3888861,3195689,4768935,3137633,4124272,4125056,6087486,3632970,3620489,2748765,5917493,3958996,3335021,3517186,5543440,2951006,3403270,3299481,3093204,4092331};
		p3 = new int[]{5702812,6805664,6823687,5337687,4286533,4999849,6567411,4563235,6618139,6260135,6249469,3821449,5963157,6385012,4255959,5786920,6112817,4103918,6371537,4231698,3409172,6806782,5623563,4511221,6407338,6491490,5209517,6076093,6530132,6111464,5833839,6253088,5595160,6236805,5772388,5285713,5617002,4650978,5234740};
		p4 = 31;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 43873566;
		p1 = 32789748;
		p2 = new int[]{2053198,2175819,4260803,1542497,1418952,5000015,1381849,2462882,6466891,1827580,6943641,5775477};
		p3 = new int[]{2827461,3726335,5410505,4781355,4925909,5621160,7325774,5025476,7876037,8072075,6979462,6647628};
		p4 = 7;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
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
