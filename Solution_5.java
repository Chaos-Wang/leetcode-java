package leetcode.java;

/**
 * @author Chaos Wong
 * @version 1.0
 * @date 2020/2/27 11:08
 */
public class Solution_5 {
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1){
			return "";
		}
		char[] sArray = s.toCharArray();
		int start=0, end = 0;
		double separator = 0.5;

		for( separator = 0.5 ; separator < sArray.length ; separator+=0.5 ){

			int length = expandSeparator( sArray , (int)separator,(int)(separator+0.5) );
			if( length > end - start){

				start = (int)separator - (length - 1) / 2;
				end = (int)separator + length / 2;
			}

		}
		return s.substring(start, end + 1);

	}

	private int expandSeparator(char[] s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length && s[L] == s[R]) {
			L--;
			R++;
		}
		return R - L - 1;
	}

}