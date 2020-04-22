/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (36.12%)
 * Likes:    466
 * Dislikes: 0
 * Total Accepted:    46.3K
 * Total Submissions: 122.3K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        // dp[i] 以nums[i]结尾的最大乘积
        // int[][] dp = new int[nums.length][2];
        // dp[0][0] = nums[0];
        // dp[0][1] = 1; // 1表示当前元素在连续子序列中，0表示不在
        // for (int i = 1; i < dp.length; i++) {
        //     // dp[i] = Math.max(dp[i-1], dp[i-1]*nums[i]);
        //     if(dp[i-1][1] == 1){
        //         if(dp[i-1][0] <= dp[i-1][0]*nums[i]){
        //             dp[i][0] = dp[i-1][0] * nums[i];
        //             dp[i][1] = 1;
        //         }else{
        //             dp[i][0] = dp[i-1][0];
        //             dp[i][1] = 0;
        //         }
        //     }else{
        //         dp[i][0] = Math.max(dp[i-1][0], nums[i]);
        //         dp[i][1] = 0; 
        //     }
        // }
        // // dp[0] 2 dp[1] 6 dp[2] 6 dp[3] 
        // return dp[dp.length-1][0];

        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] dpMax = new int[n];
        dpMax[0] = nums[0];
        int[] dpMin = new int[n];
        dpMin[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(dpMin[i-1]*nums[i], Math.max(dpMax[i-1]*nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i-1]*nums[i], Math.min(dpMax[i-1]*nums[i], nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }
}
// @lc code=end

