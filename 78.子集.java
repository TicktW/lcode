import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (75.56%)
 * Likes:    466
 * Dislikes: 0
 * Total Accepted:    60K
 * Total Submissions: 78.6K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {

    private List<Integer> items = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(items);
        generate(0, nums, items, result);

        return result;
    }

    private void generate(int i, int[] nums, List<Integer> items, List<List<Integer>> result){
        if(i >= nums.length){
            return;
        }
        items.add(nums[i]);

        result.add(new ArrayList<>(items));
        generate(i+1, nums, items, result);

        items.remove(items.size()-1);
        generate(i+1, nums, items, result);
    }

}
// @lc code=end

