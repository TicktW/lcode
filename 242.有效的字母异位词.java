import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (57.12%)
 * Likes:    183
 * Dislikes: 0
 * Total Accepted:    92.7K
 * Total Submissions: 155.8K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        // add s elem into map
        for (Character character : s.toCharArray()) {
            if(map.containsKey(character)){
                map.put(character, map.get(character)+1);
            }else{
                map.put(character, 1);
            }
        }
        // use t consume char
        for (Character character : t.toCharArray()) {
            if(!map.containsKey(character)) return false;
            int val = map.get(character);
            if(val == 1){
                map.remove(character);
            }else{
                map.put(character, val-1);
            }
        }

        return map.size() == 0;
    }
}
// @lc code=end

