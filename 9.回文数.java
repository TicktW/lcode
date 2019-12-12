/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int oldX = x;
        int palX = 0;
        while (x > 0) {
            int pop = x % 10;
            x /= 10;
            palX = palX*10 + pop;
        }
        if(oldX == palX) return true;
        return false;
    }
}
// @lc code=end

