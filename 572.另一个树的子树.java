/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一个树的子树
 *
 * https://leetcode-cn.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (42.12%)
 * Likes:    181
 * Dislikes: 0
 * Total Accepted:    17.8K
 * Total Submissions: 40.2K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s
 * 也可以看做它自身的一棵子树。
 * 
 * 示例 1:
 * 给定的树 s:
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 给定的树 t：
 * 
 * 
 * ⁠  4 
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * 
 * 示例 2:
 * 给定的树 s：
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 * 
 * 
 * 给定的树 t：
 * 
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 返回 false。
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
    private boolean res = false;
    private TreeNode tRoot;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        this.tRoot = t;
        dfs(s);
        return res;
    }

    private void dfs(TreeNode s, TreeNode t) {
        /* 尝试用一个dfs 同时遍历两个树， 最后的问题是难以确定dfs的最后一个节点*/
        if(s == null) return;

        if(s.val == t.val){
            res = true;
            dfs(s.left, t.left);
            dfs(s.right, t.right);
        }else{
            
            if(s.val == tRoot.val){
                res = true;
                dfs(s, tRoot);
            }else{
                res = false;
                dfs(s.left, tRoot);
                dfs(s.right, tRoot);
            }
        }


    }

    private void dfs(TreeNode s) {
        if(s == null) return;
        if(eqTree(s, tRoot) == true) this.res = true; 
        dfs(s.left);
        dfs(s.right);
    }

    private boolean eqTree(TreeNode s, TreeNode t) {
        if(s == null && t == null){
            return true;
        }else if( s != null && t != null){
            if(s.val != t.val) return false;
            return eqTree(s.left, t.left) && eqTree(s.right, t.right);
        }else{
            return false;
        }
        
    }
}
// @lc code=end

