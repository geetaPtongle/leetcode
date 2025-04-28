class Solution {
    Map<String, Integer> mp = new HashMap<>();
    public int twoEggDrop(int n) {
            return findFloor(2, n);
    }

    public int findFloor(int eggs, int n) {
        if (n <= 1)
            return n;
        if (eggs == 1)
            return n;

        String temp = findString(eggs, n);
        if (mp.containsKey(temp))
            return mp.get(temp);

        int minSteps = Integer.MAX_VALUE;
        for (int floor = 1; floor < n; floor++) {
            // 2 options
            int op1 = findFloor(eggs - 1, floor - 1); // eggs break from floor and reducing floor by 1  floor 
            int op2 = findFloor(eggs, n - floor); // eggs not break icrease the floor from current floor which is n-i
            int steps = 1 + Math.max(op1, op2);
            minSteps = Math.min(minSteps, steps);
        }

        mp.put(temp, minSteps);
        return minSteps;
    }

    public String findString(int k, int i) {
        return k + " " + i;
    }
}