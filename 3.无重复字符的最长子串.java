/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] indexs = new int[256];
        int ans = 0;
        
        for(int i=0, j=0; j<s.length(); j++){
            i = Math.max(indexs[s.charAt(j)], i);
            ans = Math.max(j-i+1, ans);
            indexs[s.charAt(j)] = j+1;
        }
        return ans;
    }
}
// @lc code=end

