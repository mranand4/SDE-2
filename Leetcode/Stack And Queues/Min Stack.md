# Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

https://leetcode.com/problems/min-stack/description/

# Topics

- Stack

# Solution using two stacks(referred from CTCI)

```java
import java.util.Stack;

class MinStack {

    Stack<Integer> primaryStack;
    Stack<Integer> minStack;

    public MinStack() {
        primaryStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        primaryStack.push(val);

        if(minStack.isEmpty()) {
            minStack.push(val);
        } else {
            if(val < minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }
    }
    
    public void pop() {
        if(!primaryStack.isEmpty()) {
            primaryStack.pop();
            minStack.pop();
        }
    }
    
    public int top() {
        return primaryStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
```

# Solution using nodes (also referred from ctci)

```java
class MinStack {

    class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }

    private Node head;

    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if(head == null) {
            head = new Node(val, val);
        } else {
            Node node = new Node(val , Math.min(val, head.min));
            node.next = head;
            head = node;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
```

# Notes

- We can also implement max stack by reversing the conditions ...