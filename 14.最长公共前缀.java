/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // StringBuilder ans = new StringBuilder();
        if(strs.length == 0) return "";

        String comm = strs[0];
        // int pre = 0;
        for (int i = 1; i < strs.length; i++) {
            int j;
            for (j = 0; j < Math.min(strs[i].length(), comm.length()); j++) {
                if (strs[i].charAt(j) != comm.charAt(j))
                    break;
            }
            comm = comm.substring(0, j);
            
        }
        // for (int i = 0; i < strs.length - 1; i++) {
        //     int j;
        //     for (j = 0; j < Math.min(strs[i].length(), strs[i + 1].length()); j++) {
        //         if (strs[i].charAt(j) != strs[i + 1].charAt(j))
        //             break;
        //     }
        //     pre = pre >= j ? pre : j;
        // }
        // return strs[0].substring(0, pre);
        return comm;
    }
}
// @lc code=end
