/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        Boolean flag = false;
        if( (dividend >0 && divisor >0) || (dividend <0 && divisor<0) )
           flag = true;
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int predivsor = divisor;
        int res = 1;
        while(divisor > dividend){
            int preres = 0;
            if(divisor < dividend-divisor){                
                dividend = dividend - divisor;
                divisor = predivsor;
                preres = res;
                res = 1;
            }
            divisor += divisor;
            res = preres + res + res;
        }
        return flag == true ? res : -res;
        
    }
}
// @lc code=end
