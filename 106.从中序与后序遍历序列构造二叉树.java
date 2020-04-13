import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (65.36%)
 * Likes:    183
 * Dislikes: 0
 * Total Accepted:    30.9K
 * Total Submissions: 45.6K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    private int [] inorder;
    private int [] postorder;
    private HashMap<Integer, Integer> inIndexs;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        HashMap<Integer, Integer> inIndexs = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndexs.put(inorder[i], i);
        }
        this.inIndexs = inIndexs;
        return build(0, inorder.length-1, 0, postorder.length - 1);

    }

    private TreeNode build(int inStart, int inEnd, int posStart, int posEnd){
        if(posStart > posEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[posEnd]);
        int inIndex = inIndexs.get(root.val);
        // int rightLen = inEnd - inIndex + 1;
        int leftLen = inIndex - inStart + 1;
        root.left = build(inStart, inIndex - 1, posStart, posStart + leftLen - 2);
        root.right = build(inIndex+1, inEnd, posStart + leftLen - 1 , posEnd-1);
        
        return root;
    }
}
// @lc code=end

