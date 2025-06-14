class Solution {
    public int minMaxDifference(int num) {
         String numStr = String.valueOf(num); // Convert the integer to a string for manipulation
        int minVal = Integer.parseInt(numStr.replace(numStr.charAt(0), '0')); // Replace first digit with '0' to get the minimum value
        // Iterate over the characters in the string
        for (char digit : numStr.toCharArray()) {
            if (digit != '9') {
                // Replace the current digit with '9' to get the maximum value and return the difference
                return Integer.parseInt(numStr.replace(digit, '9')) - minVal;
            }
        }
        // If all digits are '9', return the difference between the original number and minVal
        return num - minVal;
    }
}