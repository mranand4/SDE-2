# Next Greater Element II

Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

# Topics

- Array
- Stack
- Monotonic Stack

# My own sol using monotonic decreasing stack

```java
import java.util.Set;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int greatestElementIdx = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > nums[greatestElementIdx]) {
                greatestElementIdx = i;
            }
        }

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        ans[greatestElementIdx] = -1;
        st.push(nums[greatestElementIdx]);
        int idx = greatestElementIdx - 1;

        while(idx != greatestElementIdx) {

            // circling back to last element
            if(idx < 0) {
                idx = nums.length - 1;
                continue;
            }

            int nge = -1;
            while(!st.isEmpty()) {
                int topElement = st.peek();
                if(topElement > nums[idx]) {
                    nge = topElement;
                    break;
                }
                st.pop();
            }
            st.push(nums[idx]);
            ans[idx] = nge;
            idx--;
        }

        return ans;
    }
}
```

- Start backwards from the greatest element, next greater element of the greatest element will always be -1. This was the key for solution this question. In the NGE 1 ques, we start at the end as that element will not have any next greater element, here we have to start with the greatest element.
- Circle back to last element after processing element at index 0.