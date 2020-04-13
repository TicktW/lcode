import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 *
 * https://leetcode-cn.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (36.42%)
 * Likes:    366
 * Dislikes: 0
 * Total Accepted:    42.7K
 * Total Submissions: 113.5K
 * Testcase Example:  '[1,2,5]\n11'1
 *
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 示例 1:
 * 
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3 
 * 解释: 11 = 5 + 5 + 1
 * 
 * 示例 2:
 * 
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * 
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] = 1 + min(dp[i-con[j]])
        if(coins.length == 0) return 0;

        int[] dp = new int[amount+1];
        // -1 标记此时最优无结果
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j] >= 0 && dp[i-coins[j]] != -1){
                    if(dp[i] == -1 || dp[i] > dp[i-coins[j]]){
                        dp[i] = dp[i-coins[j]] + 1;
                    }
                }
            }
        }

        return dp[amount];

    }
}
// @lc code=end

