import java.util.HashMap;
import java.util.Stack;

import javafx.scene.chart.Axis.TickMark;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    private HashMap<Character, Character> mapping;

    // create map
    public Solution() {
        this.mapping = new HashMap<>();
        this.mapping.put(')', '(');
        this.mapping.put('}', '{');
        this.mapping.put(']', '[');
    }

    public boolean isValid(String s) {
        // create stack
        Stack<Character> stack = new Stack<>();
        // for element in s, if s is left character push to stack
        // i if s is right character, stack pop and judge
        for (int i = 0; i < s.length(); i++) {
            if (this.mapping.containsKey(s.charAt(i))) {
                if (stack.isEmpty())
                    return false;
                if (this.mapping.get(s.charAt(i)) != stack.pop())
                    return false;

            } else {
                stack.push(s.charAt(i));
            }

        }

        // TODO
        if (!stack.isEmpty())
            return false;

        return true;
    }
}
// @lc code=end
