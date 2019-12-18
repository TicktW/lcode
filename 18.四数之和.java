import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
// -2,-1,0,0,1,2
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 4)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                for (int l = j + 1, r = nums.length - 1; l < r;) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        List<Integer> targetRes = new ArrayList<Integer>();
                        targetRes.add(nums[i]);
                        targetRes.add(nums[j]);
                        targetRes.add(nums[l]);
                        targetRes.add(nums[r]);
                        res.add(targetRes);

                        while (l < r && nums[r - 1] == nums[r]) {
                            r--;
                        }
                        while (l < r && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        r--;
                        l++;
                    } else if (sum > target) {
                        while (l < r && nums[r - 1] == nums[r]) {
                            r--;
                        }
                        r--;
                    } else {
                        while (l < r && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        l++;
                    }
                }

            }
        }
        return res;
    }

}
// @lc code=end
