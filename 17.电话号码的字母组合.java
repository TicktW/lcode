import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        String[] letterMap = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> res = new ArrayList<>();
        res.add("");

        for (int i = 0; i < digits.length(); i++) {
            int num = Integer.valueOf(digits.substring(i, i+1));
            String letters = letterMap[num];
            int rsize = res.size();
            for (int j2 = 0; j2 < rsize; j2++) {
                String temp = res.remove(0);
                for (int j = 0; j < letters.length(); j++) {
                    res.add(temp + letters.charAt(j));
                }
            }
        }
        return res;
    }
}
// @lc code=end
