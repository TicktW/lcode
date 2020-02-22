import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 *
 * https://leetcode-cn.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (26.70%)
 * Likes:    154
 * Dislikes: 0
 * Total Accepted:    10.6K
 * Total Submissions: 38K
 * Testcase Example:  '"1432219"\n3'
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 
 * 注意:
 * 
 * 
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 
 * 
 * 示例 1 :
 * 
 * 
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 
 * 
 * 示例 2 :
 * 
 * 
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 
 * 
 * 示例 3 :
 * 
 * 
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        // 贪心移除i位置前的元素
        // 若i前的元素值大，则出栈
        for (char digit : num.toCharArray()) {
            while(stack.size()>0 && k>0 && stack.peekLast() > digit){
                stack.removeLast();
                k-=1;
            }
            stack.addLast(digit);
        }

        // 若k未用完，则此时为逆序，从尾到头删除k个
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }

        // 将stack转化为字符串
        StringBuilder res = new StringBuilder();
        boolean startZero = true;
        for (Character character : stack) {
            if(character == '0' && startZero == true) continue;
            startZero = false;
            res.append(character);
        }

        // 若为空串，则返回0
        if(res.length() == 0) return "0";
        return res.toString();

        
    }
}
// @lc code=end

