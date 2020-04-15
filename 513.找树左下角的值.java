import java.util.Deque;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

import org.omg.CORBA.IRObject;

/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
 *
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (67.01%)
 * Likes:    76
 * Dislikes: 0
 * Total Accepted:    12.1K
 * Total Submissions: 17.6K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * 输出:
 * 1
 * 
 * 
 * 
 * 
 * 示例 2: 
 * 
 * 
 * 输入:
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   5   6
 * ⁠      /
 * ⁠     7
 * 
 * 输出:
 * 7
 * 
 * 
 * 
 * 
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
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
    public int findBottomLeftValue(TreeNode root) {

         Deque<TreeNode> q = new LinkedList<>();
         q.addLast(root);
         TreeNode firstNode = root;

         while (!q.isEmpty()) {
             int qLen = q.size();
             for (int i = 0; i < qLen; i++) {
                 TreeNode node = q.pollFirst();
                 if(i == 0) firstNode = node;
                 if(node.left != null) q.add(node.left);
                 if(node.right != null) q.add(node.right);
             }
             
         }
         return firstNode.val;
    }
}
// @lc code=end

