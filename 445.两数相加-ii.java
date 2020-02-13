import java.util.Stack;

/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1, l2 中的值push到栈中
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // pop栈中元素，并计算和
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        // 构造新链表
        int carry = 0;
        ListNode dummpy = new ListNode(0);
        while(!s1.isEmpty() || !s2.isEmpty() || carry > 0)
        {
            int s1Val,s2Val;
            if(s1.isEmpty()){
                s1Val = 0;
            }else{
                s1Val = s1.pop();
            }

            if(s2.isEmpty()){
                s2Val = 0;
            }else{
                s2Val = s2.pop();
            }

            int sum = s1Val + s2Val + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode newNode = new ListNode(sum);
            newNode.next = dummpy.next;
            dummpy.next = newNode;

        }

        return dummpy.next;
    }
}
// @lc code=end

