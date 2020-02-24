import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 *
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (62.09%)
 * Likes:    135
 * Dislikes: 0
 * Total Accepted:    18K
 * Total Submissions: 28.4K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 示例:
 * 
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        Map<Integer, Integer> indexMap = new HashMap<>();
        //遍历树
        // 遍历时记录层次信息
        // pop时将信息记录
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<Integer> depth = new LinkedList<>();
        queue.add(root);
        depth.add(0);
        
        while (! queue.isEmpty()) {
            TreeNode node = queue.pop();
            int dep = depth.pop();

            indexMap.put(dep, node.val);

            if(node.left != null){
                queue.add(node.left);
                depth.add(dep+1);
            }
            if(node.right != null){
                queue.add(node.right);
                depth.add(dep+1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (Integer val: indexMap.values()) {
            res.add(val);
        }

        return res;


    }
}
// @lc code=end

