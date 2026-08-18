import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Maps each number to its next greater element
        Map<Integer, Integer> map = new HashMap<>();

        // Monotonic decreasing stack
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {

            // num is the next greater element for all smaller elements
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        // Elements remaining in the stack have no greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build answer for nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}