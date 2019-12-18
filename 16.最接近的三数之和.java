import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
// -1,2,1,-4
// -4,-1,1,2
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // len(nums) <= 3 -> return sum
        if(nums.length <= 3) 
            return this.sum(nums);
        Arrays.sort(nums);
        // len(nums)  > 3 -> store sum, compare target;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            for (int l=i+1, r=nums.length-1; l<r;) {
                int curSum = nums[i] + nums[l] + nums[r];
                res = (Math.abs(curSum-target) < Math.abs(res-target))? curSum:res;
                if(curSum > target) r--;
                if(curSum < target) l++;
                if(curSum == target) return target;
            }
        }
        return res;
    }

    // private int sum(int[] nums) {
    //     int res = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         res += nums[0];
    //     }
    //     return res;
    // }

    
    private int sum(int... nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }
}
// @lc code=end

