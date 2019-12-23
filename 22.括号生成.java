import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, "", n);
        return res;
    }


    private void dfs(int left, int right, String tmp, int n) {
        // for a str len = k
        // add new char 
        // if left == n and right == n, res add
        if(left == n && right == n){
            res.add(tmp);
            return;
        }
        // if left < n , str tmp can add (
        if(left < n){
            dfs(left+1, right,  tmp + "(", n);
        }
        // if left > right and right < n , add )
        if(right < left && right < n){
            dfs(left, right+1, tmp+")", n);
        }else{
            return;
        }
    }
}
// @lc code=end

