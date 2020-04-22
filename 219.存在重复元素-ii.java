import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 *
 * https://leetcode-cn.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (36.68%)
 * Likes:    159
 * Dislikes: 0
 * Total Accepted:    42K
 * Total Submissions: 109.5K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的
 * 绝对值 至多为 k。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 
 * 示例 3:
 * 
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(seen.containsKey(nums[i])){
                // seen.put(nums[i], seen.get(nums[i])+1);
                int index = seen.get(nums[i]);
                if(Math.abs(i-index) <= k){
                    return true;
                }else{
                    seen.put(nums[i], i);
                }
            }else{
                seen.put(nums[i], i);
            }
        }
        return false;

    }
}
// @lc code=end

