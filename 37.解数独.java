import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 *
 * https://leetcode-cn.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (58.10%)
 * Likes:    391
 * Dislikes: 0
 * Total Accepted:    25.5K
 * Total Submissions: 41.8K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 
 * 一个数独的解法需遵循如下规则：
 * 
 * 
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 
 * 空白格用 '.' 表示。
 * 
 * 
 * 
 * 一个数独。
 * 
 * 
 * 
 * 答案被标成红色。
 * 
 * Note:
 * 
 * 
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * 
 * 
 */

// @lc code=start
class Solution {
    Set<Integer>[] rowSets = new HashSet[9];
    Set<Integer>[] colSets = new HashSet[9];
    Set<Integer>[] boxSets = new HashSet[9];

    Solution(){
        for (int i = 0; i < 9; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            boxSets[i] = new HashSet<>();
        }
    }

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int boxIndex = (i/3)*3 + j/3;
                int num = (int)(board[i][j]-'0');

                rowSets[i].add(num);
                colSets[j].add(num);
                boxSets[boxIndex].add(num);
                
            }
        }
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        // 返回条件
        if(j == board[0].length && i == board.length-1){
            return true;
        }

        // 索引处理
        if(j == board[0].length){
            j = 0;
            i++;
        }

        char c = board[i][j];
        int boxIndex = (i/3)*3 + j/3;

        if(c == '.'){
            for (int k = 1; k <= 9; k++) {
                if(rowSets[i].contains(k) || colSets[j].contains(k) || boxSets[boxIndex].contains(k)) 
                    continue;

                board[i][j] = (char)(k+'0');
                rowSets[i].add(k);
                colSets[j].add(k);
                boxSets[boxIndex].add(k);
                if(backtrack(board, i, j+1) == true){
                    return true;
                }
                board[i][j] = '.';
                rowSets[i].remove(k);
                colSets[j].remove(k);
                boxSets[boxIndex].remove(k);
            }
            return false;

        }else{
            return backtrack(board, i, j+1);
        }
    }
}
// @lc code=end

