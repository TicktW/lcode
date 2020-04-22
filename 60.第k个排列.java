import java.util.LinkedList;
import java.util.List;

import javax.swing.border.EtchedBorder;

/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 *
 * https://leetcode-cn.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (47.41%)
 * Likes:    222
 * Dislikes: 0
 * Total Accepted:    30.2K
 * Total Submissions: 62.2K
 * Testcase Example:  '3\n3'
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 
 * 
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 
 * 
 * 示例 1:
 * 
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 
 * 
 * 示例 2:
 * 
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 
 * 
 */

// @lc code=start
class Solution {
    private int[] facs;
    public String getPermutation(int n, int k) {
        // 对于任意给定的n,k要确认第一个字符
        // 对于n!个数来说，可以分为n组，每组首字母相等,每组的元素(n-1)!个
        // 那么首字母为 k / (n-1)!
        int[] facs = new int[n+1];
        facs[0] = 1;
        for (int i = 1; i < facs.length; i++) {
            facs[i] = facs[i-1] * i;
        }
        this.facs = facs;


        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            nums.add(i);
        }


        return getRes(nums, k);
    }

    private String getRes(List<Integer> nums, int k){
        if(nums.size() == 0) return "";
        if(k == 0){
            StringBuilder sb = new StringBuilder();
            for (int i = (nums.size()-1); i >= 0; i--) {
                sb.append(String.valueOf(nums.get(i)));
            }
            return sb.toString();
        }

        int n = nums.size();
        // get fist
        int res = (int)Math.ceil((double)k / (double)facs[n-1]);
        k = k % facs[n-1];
        // k = k - res * facs[n-1];
        res = nums.remove(res-1);
        // get new k
        return String.valueOf(res) + getRes(nums, k);
        
    }

    public static void main(String[] args) {
        new Solution().getPermutation(3, 3);
    }
}
// @lc code=end

 