import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 *
 * https://leetcode-cn.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (41.18%)
 * Likes:    146
 * Dislikes: 0
 * Total Accepted:    21.9K
 * Total Submissions: 51.5K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 
 * 示例1:
 * 
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 
 * 示例 4:
 * 
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * 
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] strs = str.split(" ");
        char[] pats = pattern.toCharArray();

        if(strs.length != pats.length) return false;

        for (int i = 0; i < pats.length; i++) {
            char p = pats[i];
            String s = strs[i];

            if(map.containsKey(p)){
                if(!s.equals(map.get(p))) return false;
            }else{
                if(map.containsValue(s)) return false;
                map.put(p, s);
            }
        }
        return true;

    }
}
// @lc code=end

