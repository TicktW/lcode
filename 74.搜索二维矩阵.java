/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (36.45%)
 * Likes:    169
 * Dislikes: 0
 * Total Accepted:    40K
 * Total Submissions: 106.1K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 将二维数组从逻辑上转化为一维的数组
        // 对于 mat(m*n) mat[i][j] 来说 转化为一维数组是 n*j + i;
        if(matrix.length == 0 || matrix[0].length == 0) return false;  

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m*n - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            int num = matrix[mid/n][mid%n];
            if(num > target){
                right = mid - 1;
            }else if(num < target){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

