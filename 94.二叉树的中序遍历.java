import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (69.08%)
 * Likes:    386
 * Dislikes: 0
 * Total Accepted:    100.6K
 * Total Submissions: 143.7K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 输出: [1,3,2]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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
    public List<Integer> inorderTraversal(TreeNode root) {
        // 非递归方案
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();



        // 递归方案
        // helper(root, res);
        // return res;
    }

    // private void helper(TreeNode node, List<Integer> res) {
    //     if (node != null) {
    //         if(node.left != null){
    //             helper(node.left, res);
    //         }
    //         res.add(node.val);
    //         if(node.right != null){
    //             helper(node.right, res);
    //         }
    //     }
    // }
}
// @lc code=end

