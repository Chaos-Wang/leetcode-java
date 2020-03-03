package leetcode.java;

/**
 * @author Chaos Wong
 * @version 1.0
 * @date 2020/3/3 11:50
 */

class Solution_10_1{
	public static void merge ( int[] A, int m, int[] B, int n ) {
		if ( n == 0 ) {
			return;
		}
		if ( m == 0 ) {
			for( int i = 0 ; i != B.length ; ++i){
				A[i] = B[i];
			}
			return;
		}

		int A_MAX = A[ m - 1 ], A_MIN = A[ 0 ];
		int B_MAX = B[ n - 1 ], B_MIN = A[ 0 ];

		if ( A_MIN > B_MAX ) {
			for ( int i = A.length - 1; i >= n; --i ) {
				A[ i ] = A[ i - n ];
			}
			for ( int j = 0; j != n; ++j ) {
				A[ j ] = B[ j ];
			}
		}
		else if ( A_MAX < B_MIN ) {
			for ( int j = n - 1; j != -1; --j ) {
				A[ m + j ] = B[ j ];
			}
		}
		else {
			//index为当前数字比较的起点，end为当前最后一个无序数索引
			//从后往前遍历A、B，一次性得到结果的索引
			int index = m - 1, end = A.length - 1;
			for ( int i = n - 1; i != -1; --i ) {
				int tmp = B[ i ];
				//使用count记录某一个B中的数字从index开始，到他的最终位置所需要经过的A中的数字的个数
				int count = 0;
				while ( index >= count && tmp <= A[ index - count ] ) {
					count++;
				}
				int idx = end;
				if ( count != 0 ) {
					//移动A中的数字
					int num = count;
					while ( num != 0 ) {
						A[ idx ] = A[ idx - (end - index) ];
						--idx;
						--num;
					}
				}

				//填充B中的数字到A中对应位置
				A[ idx ] = B[ i ];
				end -= count + 1;
				index = ( idx - 1 >= index-count ) ? index - count : idx - 1 ;
			}

		}

	}
}