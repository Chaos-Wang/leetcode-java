package leetcode.java;

/**
 * @author Chaos Wong
 * @version 1.0
 * @date 2020/2/19 16:23
 */


public class Solution_4 {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double res = -1;

		//若两个数组有一个为空，返回另一个的中位数
		if( nums1.length == 0){ res = findMedian( nums2 ); }
		else if(nums2.length == 0){ res = findMedian( nums1 ); }
		//若两个数组中位数相等，则这返回公共中位数
		else if( findMedian( nums1 ) == findMedian( nums2 )){ res = findMedian( nums1 ); }
		//一般情况，使用二分法、分治法解决，保证题目时间复杂度要求
		else {

			//size总长度，用于计算数组一分割符移动时，数组二分割符应移动多少
			int size1 = nums1.length,size2 = nums2.length,size = size1 + size2;

			if ( size1 > size2 ) {
				//由于算法中遍历数组一后可得到结果，故当数组一为二者中比较短的那个，可以获得更低时间复杂度
				return findMedianSortedArrays( nums2, nums1 );
			}

			//初始化区间
			//这里将separator1（分割位置）定位在数组1的中间（若为偶数个，则为较大的那一侧）
			int left = 0, right = size1,separator1 = size1 / 2;
			//简化特殊情况所需变量：两数组中有一个数组所有元素大于另一个数组
			int H1 = nums1[0],E1 = nums1[size1-1],H2 = nums2[0],E2 = nums2[size2-1];

			while ( separator1 <= size1 ) {
				if(H1>E2){
					//nums1[]所有值都大于nums2[]
					separator1 = 0;
				}
				else if(H2>E1){
					//nums2[]所有值都大于nums1[]
					separator1 = size1;
				}else {
					//将left，right视为新的区间，使用二分法得到分割位置
					separator1 = (right - left) / 2 + left;
				}
				int separator2 = (size / 2) - separator1;
				double L1 = (separator1 == 0) ? Integer.MIN_VALUE : nums1[ separator1 - 1 ];
				double R1 = (separator1 == size1) ? Integer.MAX_VALUE : nums1[ separator1 ];
				double L2 = (separator2 == 0) ? Integer.MIN_VALUE : nums2[ separator2 - 1 ];
				double R2 = (separator2 == size2) ? Integer.MAX_VALUE : nums2[ separator2 ];
				//若L1>R2，当separator1向左移，数组1较多的数会被分配到右边。
				if ( L1 > R2 ) {
					right = separator1 - 1;
				}
				//若L2 > R1，当separator1向右移，数组1较多的数被分配到左边。
				else if ( L2 > R1 ) {
					left = separator1 + 1;
				}
				//当L1<=R2 L2<=R1，当前separator1和separator2的位置就是中位数了
				else {
					//若两个数组中元素数量为偶数，则中位数是两个中位数的平均值
					if ( size % 2 == 0 ) {
						L1 = L1 > L2 ? L1 : L2;
						R1 = R1 > R2 ? R2 : R1;
						res = (L1 + R1) / 2;
						return res;
					}
					//若两个数组中元素的数量为奇数，则中位数是当前位置的右值
					else {
						res = R1 > R2 ? R2 : R1;
						return res;
					}
				}
			}
		}
			return res;
	}
	public static double findMedian( int[] nums ){
		double res;
		int size =nums.length;
		if( size == 1 ){ return nums[0];}
		int mid = size / 2;
		if ( size %  2 == 0 )
		{
			res =  ((double)(nums[mid] + nums[mid - 1]) / 2);
		}
		else {
			res = nums[ mid ];
		}
		return res;
	}
}
