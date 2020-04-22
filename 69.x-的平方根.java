/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (37.23%)
 * Likes:    349
 * Dislikes: 0
 * Total Accepted:    118.6K
 * Total Submissions: 315K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;

        int low = 2;
        int high = x/2;

        while (low <= high) {
            int mid = (low + high)/2;
            long pow = (long)mid*mid;
            if(pow == x){
                return mid;
            }else if(pow > x){
                high = mid - 1;
            }else if(pow < x){
                low = mid + 1;
            }
            // [0,8] [0, 3] [2,3] []
        }
        return high;
    }
}
// @lc code=end

