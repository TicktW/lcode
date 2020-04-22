import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (64.49%)
 * Likes:    267
 * Dislikes: 0
 * Total Accepted:    28.7K
 * Total Submissions: 42.9K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回 s 所有可能的分割方案。
 * 
 * 示例:
 * 
 * 输入: "aab"
 * 输出:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        if(s == null || s.length() == 0) return ans;
        dfs(s, 0, new LinkedList<>(), ans);
        return ans;
    }

    private void dfs(String s, int pos, List<String> cur, List<List<String>> ans){
        if(pos == s.length()){
            ans.add(new LinkedList<>(cur));
        }
        for (int i = pos+1; i <= s.length(); i++) {
            String subStr = s.substring(pos, i);
            if(isPalindrome(subStr)){
                cur.add(subStr);
                dfs(s, i, cur, ans);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        for (int i = 0, j = s.length()-1; i<j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

