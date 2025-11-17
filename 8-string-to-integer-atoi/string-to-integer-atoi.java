class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        if (len == 0) return 0;

        int index = 0;

        // Step 1: Skip leading spaces
        while (index < len && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2: Check sign
        boolean isNegative = false;
        if (index < len) {
            if (s.charAt(index) == '-') {
                isNegative = true;
                index++;
            } else if (s.charAt(index) == '+') {
                index++;
            }
        }

        // Step 3: Process digits
        int result = 0;

        while (index < len && isDigit(s.charAt(index))) {

            int digit = s.charAt(index) - '0';

            // Step 4: Check overflow
            if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {

                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            // Step 5: Add digit
            result = result * 10 + digit;
            index++;
        }

        return isNegative ? -result : result;
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
