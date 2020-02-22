import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (72.91%)
 * Likes:    537
 * Dislikes: 0
 * Total Accepted:    78.9K
 * Total Submissions: 106.5K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(0, nums, path, used);
        return result;
        
    }

    private void dfs(int idx, int[] nums, List<Integer> path, boolean[] used){
        if(idx == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if(used[i] == true) continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(idx+1, nums, path, used);

            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end

