//Passed System Tests
//SRM 619 Div 1 250
//I thought this was easy - but I took more than an 1 hour to get it right
public class SplitStoneGame
{
	public String winOrLose(int[] number)
	{
		final String lose = "LOSE";
		final String win = "WIN";
		int N = number.length;
		
		if(N<=2) {
			return lose;
		} else {
			boolean[][][] answers = new boolean[N+1][N+1][N+1];
			
			for(int total=0;total<=N;++total) {
				for(int possible=0;possible<=total;++possible) {
					int notPossible = total - possible;
					if(possible>=1 && possible-1+notPossible>=2) {						
						int group1 = possible-1;
						int group2 = notPossible;
						
						boolean b1=true, b2 = true, b3 = true;
						if(group1>=2) {
							//add both to possibles group
							b1 = answers[total-1][group1][group2]; 
						}
						if(group1>=1 && group2>=1) {
							//add 1 to possible and 1 to notPossible;
							b2 = answers[total-1][group1+1][group2-1];
						}
						if(group2>=2) {
							//add both to notPossibles group
							b3 = answers[total-1][group1+2][group2-2];
						}
						
						if(!b1 || !b2 || !b3) {
							answers[total][possible][notPossible] = true;
						} else {
							answers[total][possible][notPossible] = false;
						}							
						
					} else {
						answers[total][possible][notPossible] = false;
					}						
				}					
			}
			
			
			int p1 = 0, p2 = 0;
			for(int i=0;i<N;++i) {
				if(number[i]>1) {
					++p1;
				} else {
					++p2;
				}
			}			
			return answers[N][p1][p2] ? win: lose;
		}
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		SplitStoneGame obj;
		String answer;
		obj = new SplitStoneGame();
		long startTime = System.currentTimeMillis();
		answer = obj.winOrLose(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p1 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p1);
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
		String p1;
		
		// ----- test 0 -----
		p0 = new int[]{1,1,1};
		p1 = "LOSE";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{2,2};
		p1 = "LOSE";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{1,1,2};
		p1 = "WIN";
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{1,2,3,4,3,2,2,4,3,1,4,4,1,2,4,4,1,4,3,1,4,2,1};
		p1 = "WIN";
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{1,1,1,1,1,1,1,1,1,1,2,1,1,1,3,1,9,1,3,1,1,1,1,1};
		p1 = "LOSE";
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		p0 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
		p1 = "LOSE";
		all_right = KawigiEdit_RunTest(5, p0, true, p1) && all_right;
		
		
		p0 = new int[]{1, 1, 1, 1, 2, 1, 8, 2, 8, 1, 5, 20, 1, 1, 1, 1, 27, 1, 1, 1};
		p1 = "LOSE";
		all_right = KawigiEdit_RunTest(6, p0, true, p1) && all_right;
		
		p0 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		p1 = "LOSE";
		all_right = KawigiEdit_RunTest(7, p0, true, p1) && all_right;
		
		p0 = new int[]{2, 2, 2, 1};
		p1 = "LOSE";
		all_right = KawigiEdit_RunTest(8, p0, true, p1) && all_right;
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!