import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(){{
            put("I", 1);
            put("IV", 4);
            put("V", 5);
            put("IX", 9);
            put("X", 10);
            put("XL", 40);
            put("L", 50);
            put("XC", 90);
            put("C", 100);
            put("CD", 400);
            put("D", 500);
            put("CM", 900);
            put("M", 1000);
        }};
        int res = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     if(i<s.length()-1 &&( s.charAt(i) == 'I' || s.charAt(i) == 'X' || s.charAt(i) == 'C')){
        //         if (s.charAt(i+1) == 'V' || s.charAt(i+1) == '' ) {
        //            res += map.get(String.valueOf(new char[]{s.charAt(i), s.charAt(i+1)}));
        //            i++;
        //         }else{
        //            res += map.get(String.valueOf(s.charAt(i)));
        //         }
        //     }
        // }

        for (int i = 0; i < s.length(); i++) {
            if(i<s.length()-1){
                switch (s.substring(i, i+2)) {
                    case "IV":
                    case "IX":
                    case "XL":
                    case "XC":
                    case "CD":
                    case "CM":
                        res += map.get(String.valueOf(new char[]{s.charAt(i), s.charAt(i+1)}));
                        i++;
                        continue;
                }
                res += map.get(String.valueOf(s.charAt(i)));
            }else{
                res += map.get(String.valueOf(s.charAt(i)));
            }
        }
        return res;
    }
}
// @lc code=end
