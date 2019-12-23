/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        haystack = "hello";
        needle = "ll";
        int[] next = this.getnext(needle);
        int i=0, j=0;

        while(i < haystack.length() && j < needle.length()){
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == needle.length()){
            return i-j;
        }else{
            return -1;
        }
    }

    private int[] getnext(String needle) {
        //abab
        // abab

        int[] next = new int[needle.length()];
        if(needle.length() == 0) 
            return next;
        next[0] = -1;
        int i=0, j=-1;
        while(i < needle.length()-1){
            if(j == -1 || needle.charAt(i) == needle.charAt(j)){
                ++i;
                ++j;
                next[i] = j;
            }else{
                j = next[j];
            }
        }
        return next;       
    }
}
// @lc code=end

