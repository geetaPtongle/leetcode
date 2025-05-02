class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char arr[] = new char[n + 2];
        int k = 0, j = 0;
        arr[0] = 'L';
        arr[n + 1] = 'R';
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = dominoes.charAt(i - 1);
        }
        while (k < arr.length) {
            while (arr[k] == '.') {
                k++;
            }
            if (k - j > 1)
                solveConfiguration(arr, j, k);
            j = k;
            k++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < arr.length - 1; i++)
            sb.append(arr[i]);

        return sb.toString();
    }

    public void solveConfiguration(char[] arr, int i, int j) {
        if (arr[i] == 'L' && arr[j] == 'L') {
            //make all string L
            for (int k = i + 1; k < j; k++) {
                arr[k] = 'L';
            }
        } else if (arr[i] == 'R' && arr[j] == 'R') {
            //make all field as R
            for (int k = i + 1; k < j; k++) {
                arr[k] = 'R';
            }
        } else if (arr[i] == 'L' && arr[j] == 'R') {
            //nothing has been change
        } else {
            int diff = j - i;
           int mid = (i + j) / 2;
            if (diff % 2 == 0) { //odd dots
                for (int k = i + 1; k < mid; k++) {
                    arr[k] = 'R';
                }
                for (int k = mid + 1; k < j; k++) {
                    arr[k] = 'L';
                }
            } else {//even dots
                for (int k = i + 1; k <= mid; k++) {
                    arr[k] = 'R';
                }
                for (int k = mid + 1; k < j; k++) {
                    arr[k] = 'L';
                }
            }
        }
    }
}