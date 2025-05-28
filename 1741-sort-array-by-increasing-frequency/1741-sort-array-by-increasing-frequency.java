class Solution {
   public int[] frequencySort(int[] nums) {
        // Step 1: Count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 3: Sort the array by frequency
       List<Integer> sortedList = new ArrayList<>(frequencyMap.keySet());
        sortedList.sort((a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) {
                return freqA - freqB; // increasing frequency
            } else {
                return b - a; // decreasing value
            }
        });


        // Step 4: Build result array
        List<Integer> resultList = new ArrayList<>();
        int index = 0;
        for (int num : sortedList) {
            int count = frequencyMap.get(num);
            for (int i = 0; i < count; i++) {
                resultList.add(num);
            }
        }
         int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}