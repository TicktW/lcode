/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        /*
        if s == p, then
        s[1] == p[1]
        and 
        s other == p other
        */
        if(p.isEmpty()) return s.isEmpty();
        boolean firstMatch = (!s.isEmpty()) && ((s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        
        if(p.length()>1 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        }else{
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }

    }
}
// @lc code=end

