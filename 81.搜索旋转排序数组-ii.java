/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (34.58%)
 * Likes:    77
 * Dislikes: 0
 * Total Accepted:    14.3K
 * Total Submissions: 41.2K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * 
 * 示例 1:
 * 
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 
 * 进阶:
 * 
 * 
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;

        int left = 0;
        int right = nums.length - 1;
        // [0, 4] 
        
        while (left <= right) {
            int startNum = nums[left];
            int midIndex = left + (right - left)/2;
            if(target == nums[midIndex]){
                return true;
            }
            if(nums[midIndex] > startNum){
                if(target < nums[midIndex] && target >= startNum){
                    right = midIndex - 1;
                }else{
                    left = midIndex + 1;
                }

            }else if(nums[midIndex] < startNum){
                if(target > nums[midIndex] && target < startNum){
                    left = midIndex + 1;
                }else{
                    right = midIndex - 1;
                }

            }else{
                left += 1;
            }
        }

        return false;
    }
}
// @lc code=end

