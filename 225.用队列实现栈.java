import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 *
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (61.41%)
 * Likes:    113
 * Dislikes: 0
 * Total Accepted:    28.6K
 * Total Submissions: 46K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * 使用队列实现栈的下列操作：
 * 
 * 
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 
 * 
 * 注意:
 * 
 * 
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty
 * 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * 
 * 
 */

// @lc code=start
/**
 * 假设连个队列q1，q2，一个做入队列，一个做出队列。q1提供入栈，w2tigong弹栈。

 入栈时，只需入队列q1即可。

弹栈时，需考虑两种情况。

1. q1 只有一个元素，出队即可。

2. q1 不只一个元素，此时弹栈的数据应该为位于队尾的元素，也就是最后进入的元素。我们需要把q1 元素依次出队，保存到q2中，其中q1 的最后一个元素不入q2，直接输出。然后将队列q2 的元素再入队q1.
 */
class MyStack {
    private Deque<Integer> q1, q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        q1.offer(x);
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return q1.pop(); 
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peekFirst();
        
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

