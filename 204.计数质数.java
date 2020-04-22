import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 *
 * https://leetcode-cn.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (31.22%)
 * Likes:    331
 * Dislikes: 0
 * Total Accepted:    53.1K
 * Total Submissions: 159.2K
 * Testcase Example:  '10'
 *
 * 统计所有小于非负整数 n 的质数的数量。
 * 
 * 示例:
 * 
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);

        for (int i = 2; i < n; i++) {
            if(!isPrim[i]) continue;
            for (int j = 2*i; j < n; j+=i){
                isPrim[j] = false;
            }
        }

        int count = 0;
        // TODO 指数从2开始统计
        for (int i = 2; i < isPrim.length; i++) {
            if(isPrim[i]) count++;
        }
        return count;
    }
}
// @lc code=end

