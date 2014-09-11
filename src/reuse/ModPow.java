package reuse;

import java.math.BigInteger;

public class ModPow {
	
	/**
	 * return (x^y)%mod
	 * @param x
	 * @param y
	 * @param mod
	 * @return
	 */
	public static long modPow(long x, long y, long mod) {
		x%=mod;
		long log2 = 1;
		int pow2 = 0;
		while(log2<=y) {
			log2*=2;
			++pow2;			
		}
		long[] modPows = new long[pow2];
		modPows[0] = x;
		for(int i=1;i<pow2;++i) {
			modPows[i] = modPows[i-1] * modPows[i-1];
			modPows[i] %= mod;
		}
		
		String binaryStr = Long.toString(y, 2);
		
		long ans = 1L;
		
		for(int i=binaryStr.length()-1,j=0;i>=0;i--, j++) {
			int ch = binaryStr.charAt(i)-'0';
			if(ch==1) {
				ans *=modPows[j];
				ans%=mod;
			}
		}
		ans%=mod;
		return ans;
	}

	public static void main(String[] args) {

		long X = 22312313;
		long Y = 2131231;
		long mod = 10000007;
		System.out.println(modPow(X, Y, mod));
		BigInteger x = new BigInteger(""+X);
		BigInteger y = new BigInteger(""+Y);
		BigInteger m = new BigInteger(""+mod);
		System.out.println(x.modPow(y, m));

	}

}
