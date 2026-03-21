# Next Greater Element I

The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

https://leetcode.com/problems/next-greater-element-i/description/

# Topics

- Array
- Hash Table
- Stack
- Monotonic Stack

# My own sol using hashmap

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums2[n - 1], -1);

        for(int i=n-2; i>=0; i--) {
            if(nums2[i+1] > nums2[i]) {
                map.put(nums2[i], nums2[i+1]);
            } else {
                int j;
                for(j=i+1; j<n; j++) {
                    if(map.get(nums2[j]) > nums2[i]) {
                        break;
                    }
                }
                if(j != n)
                map.put(nums2[i], map.get(nums2[j]));
                else
                map.put(nums2[i], -1);
            }
        }

        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
```

# Sol using monotonic decreasing stack

https://www.youtube.com/watch?v=mJWQjJpEMa4

```java
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=nums2.length-1; i>=0; i--) {
            int nge = -1;
            while(!st.isEmpty()) {
                int topElement = st.peek();
                if(topElement > nums2[i]) {
                    nge = topElement;
                    break;
                }
                st.pop();
            }
            st.push(nums2[i]);
            map.put(nums2[i], nge);
        }

        for(int i=0; i<nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
```