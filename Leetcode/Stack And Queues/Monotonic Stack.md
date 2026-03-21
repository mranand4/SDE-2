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