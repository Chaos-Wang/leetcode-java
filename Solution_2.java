package leetcode.java;

/**
 * @author Chaos Wong
 * @version 1.0
 * @date 2020/2/15 10:47
 */
public class Solution_2 {
  //模拟加法
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode result = new ListNode(0);
    ListNode current=result;
    int carry = 0;

    while( l1 != null || l2 != null){

      int num1 = (l1!=null) ? l1.val : 0;
      int num2 = (l2!=null) ? l2.val : 0;
      int sum = num1 + num2 + carry;

      carry = sum/10;
      sum %= 10;
      current.next = new ListNode( sum );
      current = current.next;

      if(l1!=null){ l1 = l1.next;}
      if(l2!=null){ l2 = l2.next;}

    }

    if (carry == 1) { current.next = new ListNode(carry); }

    return result.next;
  }
  //先加后进位法（草率的命名） 递归
  public ListNode addTwoNumbers1(ListNode l1, ListNode l2){

    if( l2!=null || (l1!=null&&l1.val>9) ) {

      l1 = (l1 == null) ? new ListNode(0) : l1;
      l2 = (l2 == null) ? new ListNode(0) : l2;

      l1.val += l2 == null ? 0 : l2.val;

      if (l1.val > 9) {

        l1.val %= 10;
        if (l1.next != null) {

          l1.next.val++;
        } else {

          l1.next = new ListNode(1);
        }
      }

      l1.next = addTwoNumbers1(l1.next, l2.next);
    }
      return l1;
  }


}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}