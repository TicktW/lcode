/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        // divide into groups
        // group num is rownum*2 - 2
        // 0
        // 1 len-1
        // 2 len-2

        if(numRows <= 1) return s;
        int appendRow = 0;
        String appendStr = "";
        int groupLen = numRows * 2 - 2;

        int i = 0;
        while (appendRow < numRows) {
            while (i < s.length()) {               
                int groupIndex = i % groupLen;
                int groupStart = i - groupIndex;
                if ( groupIndex == 0 || groupIndex == numRows-1) {
                    appendStr += s.charAt(i);    
                }else{
                    appendStr += s.charAt(i);
                    if(groupStart+groupLen-groupIndex < s.length()) appendStr += s.charAt(groupStart+groupLen-groupIndex);
                }
                i += groupLen;               
            }           
            i = appendRow + 1;
            appendRow += 1;
        }
        return appendStr;
    }
}
// @lc code=end
