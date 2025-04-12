class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int n = students.length;
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum =0;
        for(int i=0; i<n ; i++ ){
            sum += Math.abs(seats[i] - students[i]);
        }
        return sum;
    }
}