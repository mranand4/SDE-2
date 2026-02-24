# Replace Elements with Greatest Element on Right Side

Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.

# Topics

- Array

# My own sol

```java
class Solution {
    public int[] replaceElements(int[] arr) {

        int n = arr.length;
        int lastGreatest = arr[n - 1];
        int nextNum = arr[n - 1];
        for(int i=n - 2; i>=0; i--) {
            int currNum = arr[i];
            int replacement = lastGreatest > nextNum ? lastGreatest : nextNum;
            arr[i] = replacement;
            lastGreatest = replacement;
            nextNum = currNum;
        }
        arr[n - 1] = -1;
        return arr;
        
    }
}
```

# Notes

- Key insight is that element at index i will either be the greater of the curr greatest element and the element in the next immediate cell.
- We have to traverse from end, maintain last greatest element and also the the original value of last replaced element.
- At the end we can replace the last element with -1.
- It's an in-place solution.