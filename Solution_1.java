package leetcode.java;

import java.util.Map;
import java.util.HashMap;

/**
 * @author Chaos Wong
 * @version 1.0
 * @date 2020/2/13 16:43
 */
public class Solution_1 {


  public static int[] twoSum_force(int[] nums, int target) {
    for(int i = 0 ; i != nums.length ; i++){
      for( int j = i ; j != nums.length ; j++){
        if( nums[i] + nums[j] == target && i!=j) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{0,0};
  }
  public static int[] twoSum_Hash1(int[] nums, int target) {
      Map<Integer,Integer> numsMap = new HashMap<Integer,Integer>(nums.length);
      for( int i = 0 ; i != nums.length ; i++){
        numsMap.put(nums[i],i);
      }
      for( int i = 0 ; i != nums.length ; i++){

        Integer index = numsMap.get(target - nums[i]);

        if( index!=null && i != index.intValue() ){
          return new int[]{i,index};
        }
      }
      return null;
  }
  public static int[] twoSum_Hash2(int[] nums, int target) {
    Map<Integer,Integer> numsMap = new HashMap<Integer,Integer>(nums.length);

    for( int i = 0 ; i != nums.length ; i++){

      Integer index = numsMap.get(target - nums[i]);

      if( index != null){
        return new int[]{i,index};
      }
        numsMap.put(nums[i], i);
    }
    return null;
  }
}
