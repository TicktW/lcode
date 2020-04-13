/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (62.96%)
 * Likes:    217
 * Dislikes: 0
 * Total Accepted:    26.9K
 * Total Submissions: 41.2K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start
class Trie {

    private Trie[] childrens;
    private final int R = 26;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        childrens = new Trie[R];
    }

    private boolean containsKey(char ch) {
        return childrens[ch-'a'] != null;
    }

    private Trie getNode(char ch){
        return childrens[ch-'a'];
    }

    private void putNode(char ch, Trie node) {
        childrens[ch - 'a'] = node;
    }


    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            // 字符存在则继续向下
            if(curr.containsKey(word.charAt(i))){
                curr = curr.getNode(word.charAt(i));
            }else{
            // 字符不在，创建节点
                Trie newNode = new Trie();
                curr.putNode(word.charAt(i), newNode);
                curr = newNode;
            }
        }
        curr.setEnd();
    }

    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            // 字符存在则继续向下
            if(curr.containsKey(word.charAt(i))){
                curr = curr.getNode(word.charAt(i));
            }else{
            // 字符不在，创建节点
                return false;
            }
        }
        return curr.isEnd();

    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (int i = 0; i < prefix.length(); i++) {
            // 字符存在则继续向下
            if(curr.containsKey(prefix.charAt(i))){
                curr = curr.getNode(prefix.charAt(i));
            }else{
            // 字符不在，创建节点
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

