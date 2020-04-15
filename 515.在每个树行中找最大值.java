import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
 *
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (56.61%)
 * Likes:    60
 * Dislikes: 0
 * Total Accepted:    9.4K
 * Total Submissions: 15.9K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * 您需要在二叉树的每一行中找到最大的值。
 * 
 * 示例：
 * 
 * 
 * 输入: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      / \   \  
 * ⁠     5   3   9 
 * 
 * 输出: [1, 3, 9]
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int qLen = q.size();
            int maxVal = q.peekFirst().val;
            for (int i = 0; i < qLen; i++) {
                TreeNode node = q.pollFirst();
                maxVal = node.val > maxVal ? node.val : maxVal;
                if(node.left != null) q.addLast(node.left);
                if(node.right != null) q.addLast(node.right);
            }
            res.add(maxVal);
        }
        return res;
        
    }
}
// @lc code=end

