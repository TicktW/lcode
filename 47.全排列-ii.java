import java.nio.charset.UnmappableCharacterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (55.79%)
 * Likes:    226
 * Dislikes: 0
 * Total Accepted:    39K
 * Total Submissions: 68.5K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(0, nums, path, used);
        return result;
        
    }

    private void dfs(int idx, int[] nums, List<Integer> path, boolean[] used){
        if(idx == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < used.length; i++) {
            if(used[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && used[i-1] == false){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(idx+1, nums, path, used);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end

