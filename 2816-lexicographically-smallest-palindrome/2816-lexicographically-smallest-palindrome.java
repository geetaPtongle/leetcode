class Solution {
    // Approch 1st
    // Time Complexity (TC):
    // Time Complexity: O(n)

    // We iterate through half of the string (i from 0 to n / 2) since we are checking pairs of characters (charArray[i] and charArray[j]).

    // Each operation inside the loop (comparison and assignment) takes constant time O(1).

    // Therefore, the total time complexity is proportional to the length of the string n, so it's O(n).

    // Space Complexity (SC):
    // Space Complexity: O(n)

    // We convert the string s into a char[] array (charArray), which requires O(n) space.

    // The final result is created using new String(charArray), which also uses space proportional to the size of the array.

    // Therefore, the space complexity is O(n), where n is the length of the string.

    // Summary:
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public String makeSmallestPalindrome1(String s) {
        int i = 0, j = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                char smallest = (charArray[i] < charArray[j]) ? charArray[i] : charArray[j];
                charArray[i] = smallest;
                charArray[j] = smallest;
            }
            i++;
            j--;
        }
        return new String(charArray);
    }

    //Approch 2nd
    // Time Complexity (TC):
    // Time Complexity: O(n)

    // The for loop runs n / 2 times, where n is the length of the string.

    // Each operation inside the loop, including checking the characters (charAt()), comparing them, and setting the characters (setCharAt()), takes constant time O(1).

    // Therefore, the time complexity is proportional to the length of the string n, so it's O(n).

    // Space Complexity (SC):
    // Space Complexity: O(n)

    // The StringBuilder requires O(n) space to store the characters of the string, which is of the same size as the input string.

    // No additional space is used for other data structures, so the space complexity is O(n).

    // Summary:
    // Time Complexity: O(n) (because we iterate through half of the string)

    // Space Complexity: O(n) (due to the StringBuilder holding the string)
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        StringBuilder  sb = new StringBuilder(s);
        for (int i = 0; i < n / 2; i++) {
            char left = sb.charAt(i);
            char right = sb.charAt(n - i - 1); //n - i - 1 is the mirror index from the end (right side).
            if (left != right) {
                char smallest = (left < right) ? left : right;
                sb.setCharAt(i, smallest);
                sb.setCharAt(n - i - 1, smallest);
            }
        }
        return sb.toString();
    }
}