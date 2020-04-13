import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (52.74%)
 * Likes:    144
 * Dislikes: 0
 * Total Accepted:    30.7K
 * Total Submissions: 57.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回锯齿形层次遍历如下：
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while (!q.isEmpty()) {
            res.add(new ArrayList<>());

            int qLen = q.size();

            for (int i = 0; i < qLen; i++) {
                TreeNode node;
                if(level % 2 == 0){
                    node = q.pollLast();
                }else{
                    node = q.pollFirst();
                }
                

                res.get(level).add(node.val);

                if (node.left != null){
                    if((level % 2) == 1){
                        q.offerLast(node.left);
                    }else{
                        q.offerFirst(node.left);
                    }
                }
                if (node.right != null){
                    if((level % 2) == 1){
                        q.offerLast(node.right);
                    }else{
                        q.offerFirst(node.right);
                    }
                }
                    
            }
            level += 1;

        }
        return res;
    }
}
// @lc code=end
