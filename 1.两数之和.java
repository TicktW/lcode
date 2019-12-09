import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start

class Solution {
    public int[] twoSum(final int[] nums, final int target) {
       HashMap<Integer, Integer> hm = new HashMap<>();
       int[] res = new int[2];

       for (int i = 0; i < nums.length; i++) {
           hm.put(nums[i], i);
       }
       for (int i = 0; i < nums.length; i++) {
           if(hm.containsKey(target-nums[i])){
            int k = hm.get(target-nums[i]);
            if (i == k) {
                continue;
            }
            res[0] = i;
            res[1] = k;
            return res;
           }            
       }
       return res;
    }
}
// @lc code=end

