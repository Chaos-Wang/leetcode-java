package leetcode.java;

/**
 * @author Chaos Wong
 * @version 1.0
 * @date 2020/3/1 14:44
 */

//在第七题基础上添加字符串处理即可
public class Solution_8 {

	public int myAtoi(String str) {
		int len = str.length();

		// 去除空格
		int index = 0;
		while (index < len) {
			if (str.charAt(index) != ' ') {
				break;
			}
			index++;
		}

		if (index == len) {
			return 0;
		}

		// 第 1 个字符如果是符号，判断合法性，并记录正负
		int sign = 1;
		char firstChar = str.charAt(index);
		if (firstChar == '+') {
			index++;
		} else if (firstChar == '-') {
			index++;
			sign = -1;
		}

		int res = 0;
		while (index < len) {
			char currChar = str.charAt(index);
			// 判断合法性
			if (!Character.isDigit( currChar )) {
				break;
			}

			// 环境只能存储 32 位大小的有符号整数，需要提前判断乘以10后是否越界
			if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
				return Integer.MAX_VALUE;
			}
			if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
				return Integer.MIN_VALUE;
			}

			res = res * 10 + sign * (currChar - '0');
			index++;
		}

		return res;
	}

}
