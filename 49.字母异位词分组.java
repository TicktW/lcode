import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (59.50%)
 * Likes:    328
 * Dislikes: 0
 * Total Accepted:    67.5K
 * Total Submissions: 110.2K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 将数组元素放进哈希表去重
        // new HashMap key-> sorted string -> val string lists
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            map.getOrDefault(key, new ArrayList<>()).add(string); TODO 此处用getordefault 不行
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(string);
        }
        // forall hashmap item val, put into res
        List<List<String>> res = new ArrayList<>();
        for (List<String> valList : map.values()) {
            res.add(valList);
        }
        return res;
    }
}
// @lc code=end

