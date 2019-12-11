/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int pop;
        int res = 0;

        while (x != 0) {
            pop = x % 10;
            x /= 10;


            // java int is limit by 32 bit
            // judge before res * 10 + pop

            if(res > Integer.MAX_VALUE/10 || 
            (res == Integer.MAX_VALUE/10 && pop > (Integer.MAX_VALUE%10))) return 0;

            if(res < Integer.MIN_VALUE/10 ||
            (res == Integer.MIN_VALUE/10 && pop < (Integer.MIN_VALUE%10))) return 0;
            res =  res*10 + pop;
        }
        return res;
    }
}
// @lc code=end

