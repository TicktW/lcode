import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.Node;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node curr = head;
        // Node -> newNode(copy from Node)
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head;

        while (curr != null) {
            if(curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;
        while(curr != null){
            curr.next = curr.next.next;
            if(newCurr.next != null){
                newCurr.next = newCurr.next.next;
            }
            curr = curr.next;
            newCurr = newCurr.next;

        }

        return newHead;


    }
}
// @lc code=end

