package leetcode.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Chaos Wong
 * @version 1.0
 * @date 2020/2/17 11:36
 */
public class Solution_3 {

  //HashSet实现滑动窗口、发现重复start+1
  public static int lengthOfLongestSubstring(String s) {
    int lengthOfString =s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0, startIndex = 0,length = 0;
    int index = startIndex + length;
    if(s.equals("")){ return 0; }
    do {
      if (!set.contains(s.charAt(index))) {
        set.add(s.charAt( startIndex + (length++) ) );
        ans = Math.max(ans, length);
      } else {
        length--;
        set.remove(s.charAt(startIndex++));
      }
      index = startIndex + length;
    } while(index < lengthOfString);
    return ans;
  }

  //HashMap实现滑动窗口，发现重复start置为重复元素上一次被发现的位置+1
  public static int lengthOfLongestSubstring2(String s) {
    int n = s.length(), ans = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int end = 0, start = 0; end < n; end++) {
      char tmp = s.charAt(end);
      if (map.containsKey(tmp)) {
        start = Math.max(map.get(tmp), start);
      }
      ans = Math.max(ans, end - start + 1);
      map.put(s.charAt(end), end + 1);
    }
    return ans;
  }

  //与HashMap同理，将HashMap建立的高速K-V存取转化为了通过indexOf获取
  public static int lengthOfLongestSubstring3(String s) {
    int current = 0, start = 0, length = 0, result = 0;
    while (current < s.length()) {
      int tmp = s.indexOf(s.charAt(current),start);
      if (tmp < current) {
        if (length > result) {
          result = length;
        }
        if (result >= s.length() - tmp - 1) {
          return result;
        }
        start = tmp + 1;
        length = current - start;
      }
      length++;
      current++;
    }
    return length;
  }

}