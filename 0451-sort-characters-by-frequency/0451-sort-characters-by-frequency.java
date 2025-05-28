class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Store frequency and characters in a list of pairs
        List<Map.Entry<Character, Integer>> freqList = new ArrayList<>(frequencyMap.entrySet());

        // Step 3: Sort the list based on frequency in descending order
        freqList.sort((a, b) -> b.getValue() - a.getValue());

        // Step 4: Build the result string based on frequency
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : freqList) {
            char ch = entry.getKey();
            int count = entry.getValue();
            while (count-- > 0) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}