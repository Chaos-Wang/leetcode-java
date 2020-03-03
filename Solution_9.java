package leetcode.java;

/**
 * @author Chaos Wong
 * @version 1.0
 * @date 2020/3/2 23:10
 */

public class Solution_9 {
	public boolean IsPalindrome(int x) {
		//负数不会是回文数，且除0外，若最后一位是0，则不是回文数
		if(x < 0 || (x % 10 == 0 && x != 0)) { return false; }

		int revertedNumber = 0;
		while(x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + x % 10;
			x /= 10;
		}
		//奇数条件下与偶数条件下
		return x == revertedNumber || x == revertedNumber/10;
	}
}
