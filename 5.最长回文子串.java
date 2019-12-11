/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {

        // "" return 
        if(s.length()==0) return "";

        // eg for palindrome str
        // aba
        // abba

        // expand from every char and space

        int start, end;
        start = 0;
        end = 0;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            int l,r;
            // odd
            for(l=i-1, r=i+1; l>=0 && r< s.length(); l--, r++){
                if(s.charAt(l) == s.charAt(r)){
                    if((r-l) <= (end-start)) continue;
                    start = l;
                    end = r;
                }else{
                    break;
                }
            }
            // even
            for(l=i, r=i+1; l>=0 && r< s.length(); l--, r++){
                if(s.charAt(l) == s.charAt(r)){
                    if((r-l) <= (end-start)) continue;
                    start = l;
                    end = r;
                }else{
                    break;
                }
            }
        }

        return s.substring(start, end+1);
    }
}
// @lc code=end

