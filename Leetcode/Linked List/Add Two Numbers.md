# Add Two Numbers

https://leetcode.com/problems/add-two-numbers/description/

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

# My answer

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode frst = l1;
        ListNode scnd = l2;
        ListNode ans = new ListNode();
        ListNode ansp = ans;
        int carry = 0;

        while(frst != null && scnd != null) {
            int sum = frst.val + scnd.val + carry;
            if(sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode nxt = new ListNode(sum);
            ansp.next = nxt;
            ansp = nxt;
            frst = frst.next;
            scnd = scnd.next;
        }

        while(frst != null) {
            int sum = frst.val + carry;
            if(sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode nxt = new ListNode(sum);
            ansp.next = nxt;
            ansp = nxt;
            frst = frst.next;
        }

        while(scnd != null) {
            int sum = scnd.val + carry;
            if(sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode nxt = new ListNode(sum);
            ansp.next = nxt;
            ansp = nxt;
            scnd = scnd.next;
        }

        if(carry == 1) ansp.next = new ListNode(1);

        return ans.next;
    }
}

# Notes

- My answer is already optimized.