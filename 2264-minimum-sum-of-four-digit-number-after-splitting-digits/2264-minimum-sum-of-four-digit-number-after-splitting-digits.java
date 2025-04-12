// Time Complexity: \U0001d442(\U0001d451log⁡\U0001d451)
// O(dlogd), where d is the number of digits in the input number num.

// Space Complexity: \U0001d442(\U0001d451)
// O(d), where d is the number of digits in the input number num
class Solution {
    public int minimumSum1(int num) {
        int res=0;
        char[] nums=("" + num).toCharArray();
        Arrays.sort(nums);
        for(int i =0, j= nums.length -1; i< j; i++, j-- ){
            res += Integer.parseInt(""+ nums[i] + nums[j]);
        }
        return res;
    }

    //Greedy Approch 
    public int minimumSum(int num) {
        // Convert the number to a char array and sort it
        char[] digits = Integer.toString(num).toCharArray();
        Arrays.sort(digits);
        
        // Initialize two numbers to form
        int num1 = 0, num2 = 0;
        
        // Distribute digits in alternating manner
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + (digits[i] - '0');
            } else {
                num2 = num2 * 10 + (digits[i] - '0');
            }
        }
        
        // Return the sum of the two numbers
        return num1 + num2;
    }
}