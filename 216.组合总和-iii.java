import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 *
 * https://leetcode-cn.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (69.18%)
 * Likes:    104
 * Dislikes: 0
 * Total Accepted:    18.6K
 * Total Submissions: 26.3K
 * Testcase Example:  '3\n7'
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 
 * 说明：
 * 
 * 
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 
 * 
 * 示例 2:
 * 
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */

// @lc code=start
class Solution {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return res;

    }

    private void dfs(int k, int n, int start) {
        if(k <0 || n < 0) return;
        if(k == 0 && n == 0){
            if(path.isEmpty()) return;
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(k-1, n-i, ++start);
            path.remove(path.size()-1);
        }
        
    }
}
// @lc code=end

