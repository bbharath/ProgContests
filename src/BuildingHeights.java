import java.util.Arrays;
//SRM 624 Div 1 250
//Passed System Tests
public class BuildingHeights
{
	public int minimum(int[] heights)
	{
		int ret = 0;
		int N = heights.length;
		Arrays.sort(heights);
		int[] costs = new int[N+1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[1] = 0;
		for(int i=0;i<N;++i) {
			int additionalFloors = 0;
			for(int j=i, M=1; j>=0; --j, ++M) {
				additionalFloors += (heights[i]-heights[j]);
				costs[M] = Math.min(costs[M], additionalFloors);
			}
		}
		for(int i=1;i<=N;++i)
			ret = ret ^ costs[i];
		return ret;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		BuildingHeights obj;
		int answer;
		obj = new BuildingHeights();
		long startTime = System.currentTimeMillis();
		answer = obj.minimum(p0);
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
		
		int[] p0;
		int p1;
		
		// ----- test 0 -----
		p0 = new int[]{1,5,4,3,8};
		p1 = 22;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{1,2,3};
		p1 = 2;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{3,4,1,6,8,1};
		p1 = 21;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{990,20,2359,1667,51,2455,1659,1093,2015,205,656,752,1760,1594,857,2033,1868,1932,2408,1518,91,2220,1696,1552,933,143,1888,1261,2298,1975,929,2139,1994,2139,158,896,2093,1816,841,459,2020,1496,63,131,589,919,1015,1308,350,922,326,1792,641,2021,843,425,1015,231,1685,2165,1057,1465,655,550,1103,812,297,2048,1479,1137,6,2350,1484,1420,1332,925,2338,1198,2232,1539,2119,57,830,1611,929,525,888};
		p1 = 56068;
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
