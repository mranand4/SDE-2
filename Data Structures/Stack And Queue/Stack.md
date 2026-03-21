# Monotonic Stacks

A monotonic stack is a special type of stack data structure where elements are kept in either increasing or decreasing order.

## Types of Monotonic Stack:

Monotonic Stacks can be broadly classified into two types:

- Monotonic Increasing Stack: Elements inside the stack are always in increasing order(from bottom to top) e.g. 1->5->7 (where 7 is top, 1 is bottom).
- Monotonic Decreasing Stack: Elements inside the stack are always in decreasing order(from bottom to top) e.g. 7->5->1 (where 1 is top, 7 is bottom).

## Code for monotonic decreasing stack

```java
void monotomicDecreasing() {
        Stack<Integer> primary = new Stack<>();
        Stack<Integer> secondary = new Stack<>();

        int[] nums = {1, 4, 7, 0, -2, -5, 10, 5, 6, -3};

        for(int i : nums) {
            System.out.println("Adding " + i + " to monotonic decreasing stack.");

            if(primary.isEmpty()) {
                primary.push(i);
                System.out.println("Stack after this operation " + primary);
                continue;
            }
            
            // if to be inserted element is lesser than top element
            // then just insert it as it's guaranteed to be smallest
            if(i < primary.peek()) {
                primary.push(i);
                System.out.println("Stack after this operation " + primary);
                continue;
            }
            
            // if not, pop out all the elements which are smaller than
            // the to be inserted element, insert the element and add popped elements
            // back (lifo is respected in case of inserted element has duplicate)
            while(!primary.isEmpty() && primary.peek() < i) {
                secondary.add(primary.pop());
            }
            primary.add(i);
            while(!secondary.isEmpty()) {
                primary.add(secondary.pop());
            }

            System.out.println("Stack after this operation " + primary);
        }
    }
```