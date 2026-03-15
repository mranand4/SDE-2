# Implement Stack using Queues

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

https://leetcode.com/problems/implement-stack-using-queues/description/

# Topics

- Stack
- Queue

# Sol using two queues

```java
import java.util.Queue;
import java.util.LinkedList;

class MyStack {

    private Queue<Integer> primaryQueue;
    private Queue<Integer> secondaryQueue;

    public MyStack() {
        primaryQueue = new LinkedList<Integer>();
        secondaryQueue = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        secondaryQueue.offer(x);
        while(!primaryQueue.isEmpty()) {
            secondaryQueue.offer(primaryQueue.poll());
        }
        Queue<Integer> o = secondaryQueue;
        secondaryQueue = primaryQueue;
        primaryQueue = o;
    }
    
    public int pop() {
        return primaryQueue.poll();
    }
    
    public int top() {
        return primaryQueue.peek();
    }
    
    public boolean empty() {
        return primaryQueue.isEmpty();
    }
}
```

# Sol using just one queue

```java
class MyStack {

    private Queue<Integer> queue;
    private Queue<Integer> queue2;

    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        queue.offer(x);
        for(int i=0; i<queue.size() - 1; i++)
            queue.offer(queue.poll());
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
```
# Notes

- https://www.geeksforgeeks.org/dsa/implement-stack-using-queue/
- https://leetcode.com/problems/implement-stack-using-queues/solutions/62516/concise-1-queue-java-c-python-by-stefanp-kygm/