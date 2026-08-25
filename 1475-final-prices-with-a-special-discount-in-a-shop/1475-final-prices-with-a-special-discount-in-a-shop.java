import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = prices.clone();

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // Remove prices that are greater than current price
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            // Top is the first smaller or equal price
            if (!stack.isEmpty()) {
                answer[i] = prices[i] - stack.peek();
            }

            // Add current price for future elements
            stack.push(prices[i]);
        }

        return answer;
    }
}