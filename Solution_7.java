package leetcode.java;

/**
 * @author Chaos Wong
 * @version 1.0
 * @date 2020/2/28 17:35
 */
public class Solution_7 {
	public int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			//由于答题模板中限定输入为int，而题文中为限制，故在本题中不判断最后位亦可
			if( rev > Integer.MAX_VALUE/10 ){ return 0;}
			//if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)){ return 0; }
			if(rev < Integer.MIN_VALUE/10 ){ return 0;}
			//if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)){ return 0; }
			rev = rev * 10 + pop;
		}
		return rev;
	}
}
