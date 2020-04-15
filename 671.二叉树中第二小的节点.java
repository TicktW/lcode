/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
 *
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/description/
 *
 * algorithms
 * Easy (44.67%)
 * Likes:    69
 * Dislikes: 0
 * Total Accepted:    9.7K
 * Total Submissions: 21.1K
 * Testcase Example:  '[2,2,5,null,null,5,7]'
 *
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或
 * 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 * 
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 
 * ⁠   2
 * ⁠  / \
 * ⁠ 2   5
 * ⁠    / \
 * ⁠   5   7
 * 
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 
 * ⁠   2
 * ⁠  / \
 * ⁠ 2   2
 * 
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        return helper(root, root.val);
        
    }
    
    private int helper(TreeNode root, int rootVal) {
        if(root.val != rootVal){
            return root.val;
        }
        if(root.left == null){
            return -1;
        }
        int left = helper(root.left, rootVal);
        int right = helper(root.right, rootVal);

        if(left == -1) return right;
        if(right == -1) return left;

        return Math.min(left, right);

        
    }
}
// @lc code=end

