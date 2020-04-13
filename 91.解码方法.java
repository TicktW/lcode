import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.28%)
 * Likes:    299
 * Dislikes: 0
 * Total Accepted:    34.3K
 * Total Submissions: 147.8K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        HashMap<Integer, Integer> mem = new HashMap<>();
        // return getAns1(s, 0, mem);
        return getAns1(s);

    }

    private int getAns1(String s, int start){
        // 递归的方式
        if(start == s.length()){
            return 1;
        }

        if(s.charAt(start) == '0'){
            return 0;
        }

        int ans1 = getAns1(s, start+1);
        int ans2 = 0;

        if(start < s.length()-1){
            int ten = (s.charAt(start) - '0')*10;
            int one = (s.charAt(start+1) - '0');
            if(ten + one <= 26){
               ans2 = getAns1(s, start+2);
            } 
        }


        return ans1 + ans2;

    }


    private int getAns1(String s, int start, HashMap<Integer, Integer> mem){
        // 递归的方式, 加mem
        if(start == s.length()){
            return 1;
        }

        if(s.charAt(start) == '0'){
            return 0;
        }

        int m = mem.getOrDefault(start, -1);
        if(m != -1) return m;

        int ans1 = getAns1(s, start+1);
        int ans2 = 0;

        if(start < s.length()-1){
            int ten = (s.charAt(start) - '0')*10;
            int one = (s.charAt(start+1) - '0');
            if(ten + one <= 26){
               ans2 = getAns1(s, start+2);
            } 
        }


        return ans1 + ans2;

    }


    private int getAns1(String s){
        // 动态规划不优化空间
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;

        if(s.charAt(s.length()-1)!= '0'){
            dp[s.length()-1] = 1;
        }

        for (int i = s.length()-2; i >=0 ; i--) {
            if(s.charAt(i) == '0'){
                continue;
            }

            int ans1 = dp[i+1];

            int ans2 = 0;
            int ten = (s.charAt(i) - '0')*10;
            int one = s.charAt(i+1) - '0';
            if(ten + one <= 26){
                ans2 =  dp[i+2];
            }

            dp[i] = ans1 + ans2;
        }

        return dp[0];

    }
}
// @lc code=end

