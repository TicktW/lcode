import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=508 lang=java
 *
 * [508] 出现次数最多的子树元素和
 *
 * https://leetcode-cn.com/problems/most-frequent-subtree-sum/description/
 *
 * algorithms
 * Medium (59.35%)
 * Likes:    62
 * Dislikes: 0
 * Total Accepted:    4.6K
 * Total Submissions: 7.4K
 * Testcase Example:  '[5,2,-3]'
 *
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * 
 * 
 * 
 * 示例 1：
 * 输入:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -3
 * 
 * 
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 * 
 * 示例 2：
 * 输入：
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -5
 * 
 * 
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 * 
 * 
 * 
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // private List<Integer> res = new LinkedList<>();
    private Map<Integer, Integer> map = new HashMap<>();
    // private int curTimes;
    private int maxTimes = 0;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        dfs(root);
        return map.entrySet().stream().filter(entry -> entry.getValue().equals(maxTimes)).mapToInt(Map.Entry::getKey).toArray();

    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        int sum = left + right + root.val;
        int freq = map.getOrDefault(sum, 0) + 1;
        map.put(sum, freq);
        maxTimes =  freq > maxTimes? freq : maxTimes;

        return sum;
        
    }
}
// @lc code=end

