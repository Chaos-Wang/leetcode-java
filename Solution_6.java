package leetcode.java;

import javax.swing.text.IconView;

/**
 * @author Chaos Wong
 * @version 1.0
 * @date 2020/2/28 15:25
 */

public class Solution_6 {
	public static String convert(String s, int numRows) {
		int len = s.length();
		//短字符串或只有一行，返回原字符串
		if( len <= numRows || numRows == 1 ){ return s;}

		StringBuilder[] z = new StringBuilder[numRows];
		boolean flag = true;

		for( int i = 0, j=0 ; i != len ; ++i ){

			if( i < numRows ){ z[j] = new StringBuilder(); }
			if( z[j] != null ){ z[j].append( s.charAt( i ) ); }


			if( j == numRows - 1 ){ flag = false; }
			else if( j == 0) { flag = true; }
			if(flag){j++;}
			else{j--;}
		}

		StringBuilder res = new StringBuilder();
		for ( StringBuilder tmp : z ) {

			res.append( tmp );
		}

		return res.toString();

	}
}