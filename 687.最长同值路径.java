/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
 *
 * https://leetcode-cn.com/problems/longest-univalue-path/description/
 *
 * algorithms
 * Easy (37.72%)
 * Likes:    238
 * Dislikes: 0
 * Total Accepted:    14.5K
 * Total Submissions: 36.6K
 * Testcase Example:  '[5,4,5,1,1,5]'
 *
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * 
 * 示例 1:
 * 
 * 输入:
 * 
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         1   1   5
 * 
 * 
 * 输出:
 * 
 * 
 * 2
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 
 * 
 * ⁠             1
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         4   4   5
 * 
 * 
 * 输出:
 * 
 * 
 * 2
 * 
 * 
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
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
    private int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        int aLeft = 0, aRight = 0;
        if(root.left != null && root.left.val == root.val){
            aLeft += left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            aRight += right + 1;
        }
        ans = Math.max(ans, aLeft + aRight);

        return Math.max(aLeft, aRight);
    }
}
// @lc code=end

