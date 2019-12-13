/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int maxArea = 0;

        while (l < r) {
            maxArea = Math.max((r-l)*Math.min(height[l], height[r]), maxArea);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
// @lc code=end

