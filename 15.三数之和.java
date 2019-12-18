import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
// -4,-1,-1,0,1,2
// -1,0,0,0,0,1
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> li = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;

            for (int l = i + 1, r = nums.length - 1; l < r;) {
                int tsum = nums[i] + nums[l] + nums[r];
                if (tsum > 0) {
                    r--;
                } else if (tsum < 0) {
                    l++;
                } else {
                    List<Integer> cnums = new ArrayList<>();
                    cnums.add(nums[i]);
                    cnums.add(nums[l]);
                    cnums.add(nums[r]);
                    li.add(cnums);
                    // if(nums[i+1] == nums[i]){
                    //     int tail = nums.length;
                    //     while(--tail > i+1){
                    //         if(nums[i]*2 + nums[tail] == 0) break;
                    //     }
                    // }
                    // if(nums[r] == nums[r-1] && r-1 > l) continue;
                    // if(nums[l] == nums[++l]) continue;
                    while (l<r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while (l<r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    l++;
                    r--;
                }

            }
        }

        return li;
    }
}
// @lc code=end
