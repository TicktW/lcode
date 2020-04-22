import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 *
 * https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/description/
 *
 * algorithms
 * Medium (40.83%)
 * Likes:    113
 * Dislikes: 0
 * Total Accepted:    9.8K
 * Total Submissions: 22.3K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * 设计一个支持以下两种操作的数据结构：
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * 
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * 
 * 示例:
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * 
 * 说明:
 * 
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * 
 */

// @lc code=start
class WordDictionary {

    class TrieNode {
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if(cur.children[word.charAt(i) - 'a'] == null){
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.children[word.charAt(i) - 'a'];

            if(i == word.length() -1){
                cur.isEnd = true;
            }
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return realSearch(word, 0, root);
    }

    private boolean realSearch(String word, int pos, TrieNode root){
        if(pos == word.length()){
            return root.isEnd;
        }
        if(word.charAt(pos) == '.'){
            for (TrieNode node : root.children) {
                if(node != null && realSearch(word, pos+1, node)) return true;
            }
            return false;
        }else{
            if(root.children[word.charAt(pos)-'a'] != null){
                return realSearch(word, pos + 1, root.children[word.charAt(pos)-'a']);
            }else{
                return false;
            }
        }
    }

}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

// 暴力破解会超时，用trie树解决
// class WordDictionary {
//     private List<String> strs;

//     /** Initialize your data structure here. */
//     public WordDictionary() {
//         this.strs = new LinkedList<>();
//     }
    
//     /** Adds a word into the data structure. */
//     public void addWord(String word) {
//         if (word != null) {
//             this.strs.add(word);
//         }
//     }
    
//     /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
//     public boolean search(String word) {
//         for (String string : strs) {
//             if(compare(string, 0, word)){
//                 return true;
//             }
//         }
//         return false;
//     }

//     private boolean compare(String string, int pos, String word){
//         if(pos == string.length()){
//             return false;
//         }

//         int wLen = word.length();
//         if(pos + wLen -1 != string.length()-1){
//             return false;
//         }
//         for (int i = 0; i < wLen; i++) {
//             if(word.charAt(i) == '.') continue;
//             if(word.charAt(i) != string.charAt(pos+i)){
//                 // return compare(string, pos+1, word);
//                 return false;
//             }
//         }
//         return true;
//     }
// }
// @lc code=end

