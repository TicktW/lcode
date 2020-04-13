import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (59.91%)
 * Likes:    438
 * Dislikes: 0
 * Total Accepted:    101.1K
 * Total Submissions: 164.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 
 * 
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> treeQ = new LinkedList<>();
        treeQ.add(root);
        int level = 0;

        while (!treeQ.isEmpty()){
            res.add(new ArrayList<Integer>());

            int qsize = treeQ.size();
            for (int i = 0; i < qsize; i++) {
                TreeNode node = treeQ.remove();
                res.get(level).add(node.val);
                if(node.left != null){
                    treeQ.add(node.left);
                }
                if(node.right != null){ 
                    treeQ.add(node.right);
                 }
                
            }
            level += 1; 
        } 
        return res; 
    }
}


// @lc code=end 