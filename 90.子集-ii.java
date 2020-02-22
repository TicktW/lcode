import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 *
 * https://leetcode-cn.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (57.81%)
 * Likes:    163
 * Dislikes: 0
 * Total Accepted:    22.3K
 * Total Submissions: 37.7K
 * Testcase Example:  '[1,2,2]'
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: [1,2,2]
 * 输出:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 */

// @lc code=start
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> items = new ArrayList<>();
        Arrays.sort(nums);
        addNum(0, nums, items, result);
        return result;
        
    }

    private void addNum(int i, int[] nums, List<Integer> items, List<List<Integer>> result){
        if(i >= nums.length){
            result.add(new ArrayList<>(items));
            return;
        }
        
        items.add(nums[i]);
        addNum(i+1, nums, items, result);

        items.remove(items.size()-1);

        if(items.size() > 0 && items.get(items.size()-1) == nums[i]){
            return;
        }
        addNum(i+1, nums, items, result);
    }
}
// @lc code=end

