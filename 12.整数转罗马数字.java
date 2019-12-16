/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        // create hashmap
        String[] values = {"I", "IV", "V", "IX", "X", "XL","L", "XC" , "C", "CD", "D", "CM", "M"};
        int[] keys = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        for (int i = keys.length-1; i >= 0; i--){
            int pop = num/keys[i];
            while (pop-- > 0) {
                ans.append(values[i]);
            }
            num = num % keys[i];
        }
        return ans.toString();
    }
}
// @lc code=end

