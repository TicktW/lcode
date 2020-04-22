import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (44.98%)
 * Likes:    243
 * Dislikes: 0
 * Total Accepted:    37.3K
 * Total Submissions: 80.2K
 * Testcase Example:  '"25525511135"'
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 示例:
 * 
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new LinkedList<>();
        if(s == "") return ans;
        dfs(s, 0, new LinkedList<>(), ans);
        return ans;

    }

    private void dfs(String s, int pos, List<String> cur, List<String> ans){
        if(cur.size() == 4 && pos == s.length()){
            ans.add(String.join(".", cur));
            return;
        }
        if(cur.size() > 4){
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if(pos + i > s.length()) break;
            String seg = s.substring(pos, pos+i);
            if(seg.startsWith("0") && seg.length() > 1 || i == 3 && Integer.parseInt(seg) > 255){
                continue;
            }
            cur.add(seg);
            dfs(s, pos + i, cur, ans);
            cur.remove(cur.size()-1);
        }
    }
}
// @lc code=end

