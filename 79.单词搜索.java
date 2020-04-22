/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 *
 * https://leetcode-cn.com/problems/word-search/description/
 *
 * algorithms
 * Medium (39.46%)
 * Likes:    388
 * Dislikes: 0
 * Total Accepted:    52.4K
 * Total Submissions: 127.2K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 
 * 
 * 示例:
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 
 * 
 */

// @lc code=start
class Solution {
    private boolean flag = false;
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        // i,j board索引， k 字符串索引
        if(k == word.length() || flag){
            return flag = true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)){
            return false;
        }
        
        char c = board[i][j];
        board[i][j] = '.';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i-1, j, k+1) ||
                      dfs(board, word, i, j+1, k+1) || dfs(board, word, i, j-1, k+1);
        board[i][j] = c;

        return res;
    }
}
// @lc code=end

