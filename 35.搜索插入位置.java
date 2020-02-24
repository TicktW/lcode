import java.lang.annotation.Target;
import java.nio.channels.MulticastChannel;

/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 *
 * https://leetcode-cn.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (44.65%)
 * Likes:    436
 * Dislikes: 0
 * Total Accepted:    120.6K
 * Total Submissions: 266.7K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 
 * 
 * 示例 3:
 * 
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 
 * 
 * 示例 4:
 * 
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 
 * 
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        return binSearch(nums, 0, nums.length-1, target);

    }

    private int binSearch(int[] nums, int left, int right, int target){
        if(right < left){
            return -1;
        }
        int mid = (left + right)/2;

        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            if(mid == nums.length-1 || target < nums[mid+1]){
                return mid+1;
            }
            return binSearch(nums, mid + 1, right, target); 
        }else{
            if(mid == 0 || target > nums[mid-1]){
                return mid;
            }
            return binSearch(nums, left, mid - 1, target); 
        }
    }
}
// @lc code=end

