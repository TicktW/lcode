import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 *
 * https://leetcode-cn.com/problems/single-number/description/
 *
 * algorithms
 * Easy (64.31%)
 * Likes:    1171
 * Dislikes: 0
 * Total Accepted:    178.4K
 * Total Submissions: 268.4K
 * Testcase Example:  '[2,2,1]'
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 
 * 说明：
 * 
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 
 * 示例 1:
 * 
 * 输入: [2,2,1]
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 0) return -1;
        Set<Integer> oneSet = new HashSet<>();
        Set<Integer> twoSet = new HashSet<>();
        for (Integer num: nums) {
            if(!oneSet.contains(num)){
                oneSet.add(num);
                continue;
            } else{
                oneSet.remove(num);
                twoSet.add(num);
            }
        }

        int res = 0;
        for (Integer num : oneSet) {
            res = num;
        }
        return res;


    }
}
// @lc code=end

