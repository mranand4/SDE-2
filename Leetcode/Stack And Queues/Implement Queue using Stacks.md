# Implement Queue using Stacks

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

https://leetcode.com/problems/implement-queue-using-stacks/description/

# Topics

- Stack
- Queue

# Solution with minimum shifts

```java
import java.util.Stack;

class MyQueue {

    private Stack newestStack;
    private Stack oldestStack;

    public MyQueue() {
        newestStack = new Stack<Integer>();
        oldestStack = new Stack<Integer>();
    }

    private void shift() {
        if(oldestStack.isEmpty()) {
            while(!newestStack.isEmpty()) {
                oldestStack.push(newestStack.pop());
            }
        }
    }
    
    public void push(int x) {
        newestStack.push(x);
    }
    
    public int pop() {
        if(newestStack.isEmpty()) return (int) oldestStack.pop();
        shift();
        return (int) oldestStack.pop();
    }
    
    public int peek() {
        shift();
        return (int) oldestStack.peek();
    }
    
    public boolean empty() {
        return oldestStack.isEmpty() && newestStack.isEmpty();
    }
}
```

# Notes

- This sol was referred to from ctci book, naive solution will require shifting the stack for every pop/peek op.