import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 *
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (54.69%)
 * Likes:    98
 * Dislikes: 0
 * Total Accepted:    12.1K
 * Total Submissions: 21.4K
 * Testcase Example:  '[1,null,3,2]'
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   /
 * ⁠  2
 * 
 * 输出：
 * 1
 * 
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * 相同
 * 
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
    private TreeNode pre = null;
    private int minVal = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minVal;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(pre != null){
            minVal = Math.min(Math.abs(root.val - pre.val), minVal); 
        }
        pre = root;
        inorder(root.right);
    }
}
// @lc code=end

