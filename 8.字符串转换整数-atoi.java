/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        boolean positive = true;
        boolean numStart = false;
        boolean numEnd = false;

        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(numStart == true && (c > '9' || c < '0')) break;

            // char before num should be one of space, -,

            if (c == ' ') {
                if(numStart == false) continue;
                if(i+1 <str.length() && (str.charAt(i+1) <= '9' && str.charAt(i+1) >= '0' )){
                    return 0;
                }                
            } else if (c == '-') {
                if(numStart == true) return 0;
                positive = false;
                numStart = true;
                continue;
            }else if (c == '+') {
                if(numStart == true) return 0;
                positive = true;
                numStart = true;
                continue;
            } else if (c <= '9' && c >= '0') {
                numStart = true;
                int intc = (positive == true) ? (int) (c - '0') : -(int) (c - '0');

                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE/10 && intc > Integer.MAX_VALUE % 10))
                    return Integer.MAX_VALUE;

                if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE/10 && intc < Integer.MIN_VALUE % 10))
                    return Integer.MIN_VALUE;

                num = num * 10 + intc;
            } else {
                break;
            }

            // if(numStart == true && (c == '+' || c == '-')) continue;

            // if(numStart == true && c == ' ') break;


        }
        return num;

    }
}
// @lc code=end
