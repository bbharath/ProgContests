package reuse;

import java.util.Arrays;

/*
 * RangeCountTree - a tree that implements range queries. Also known as a BinaryIndexedTree
 * Insert and Delete are O(N);
 * Takes space (2*X+1 where X = 2^y where y is smallest number : such that X = 2^y >=N)
 */
public class RangeCountTree {
	int[] counts;
	int N;
	public RangeCountTree(int inp) {
		int p = 1;
		while (p<=inp) {
			p*=2;
		}
		this.N=p;
		this.counts = new int[2*p+1];
		Arrays.fill(counts, 0);
	}
	private void go(int index, boolean inc, int val, int low, int high) {
		if(index>=counts.length)
			return;
		
		//System.err.println("Changing index at index: "+index+" "+low+" "+high);
		if(inc) 
			++counts[index];
		else 
			--counts[index];
		
		int mid = (low+high)/2;
		if(0<=val && val<=mid) {
			go(2*index+1, inc, val, low, mid);
		} else {
			go(2*index+2, inc, val, mid+1, high);
		}
	}
	public void insert(int X) {
		go(0, true, X, 0, N-1);		
	}
	public void delete(int X) {
		go(0, false, X, 0, N-1);
	}
	private int getCount(int index, int L, int H, int lower, int upper) {
		if(L==lower && H==upper)
			return counts[index];
		else {
			int mid = (L+H)/2;
			int ret = 0;
			if(upper<=mid) {
				ret = getCount(index*2+1, L, mid, lower, upper);
			}
			else if(lower>mid) {
				ret = getCount(index*2+2, mid+1, H, lower, upper);
			} else {
				ret += getCount(index*2+1, L, mid, lower, mid);
				ret += getCount(index*2+2, mid+1, H, mid+1, upper);
			}			
			return ret;
		}
	}
			
	public int getCount(int X) {		
		return getCount(0, 0, N-1, 0, X);
	}
	public int getCount(int low, int high) {
		return getCount(0,0, N-1, low, high);
	}
	public static void main(String[] args) {
		RangeCountTree ct = new RangeCountTree(1000);
		for(int i=1;i<=50;++i)
			ct.insert(i);
		System.out.println(ct.getCount(48, 75));
	}
}
