/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (33.53%)
 * Likes:    265
 * Dislikes: 0
 * Total Accepted:    52.9K
 * Total Submissions: 155.8K
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 
 * 
 * 示例 3:
 * 
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 说明:
 * 
 * 
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        // ans1
        return ans2(x, n);
    }

    // 暴力算法，将x连乘n次,注意n<0时的情况
    public double ans1(double x, int n) {
        // 补码中负数比正数多一个
        long N = n;
        if(n < 0){
            x = 1/x;
            N = -n;
        }
        double ans = 1;
        for (int i = 0; i < N; i++) {
            ans = ans*x;
        }
        return ans;
    }

    public double ans2(double x, int n) {
        long N = n;
        if(n < 0){
            x = 1/x;
            N = -n;
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        double half = fastPow(x, n/2);
        if(n % 2 == 0){
            return half * half;
        }else{
            return half * half * x;
        }
    }
}
// @lc code=end

