import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (71.35%)
 * Likes:    215
 * Dislikes: 0
 * Total Accepted:    34.2K
 * Total Submissions: 47.1K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
class Solution {

    private List<Integer> items = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generate(1, n, k, items, result);
        return result;
        
    }

    private void generate(int i, int n, int k, List<Integer> items, List<List<Integer>> result){
        if(items.size() == k){
            result.add(new ArrayList<>(items));
            return;
        }
        if(items.size() > k || i > n){
            return;
        }
        
        items.add(i);
        generate(i+1, n, k, items, result);

        items.remove(items.size()-1);
        generate(i+1, n, k, items, result);
    }
}
// @lc code=end

