class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ']') {
                st.push(String.valueOf(ch));
            } else {
                StringBuilder buildString = new StringBuilder();

                while (!st.isEmpty()) {
                    String top = st.peek();
                    if (top.equals("[")) {
                        break;
                    }
                    buildString.insert(0, st.pop());
                }
                st.pop();

                StringBuilder digit = new StringBuilder();

                while (!st.isEmpty()) {
                    String top = st.peek();
                    if (!Character.isDigit(top.charAt(0)))
                        break;
                    digit.insert(0, st.pop());
                }

                int repeat = Integer.parseInt(digit.toString());
                StringBuilder expanded = new StringBuilder();
                for (int j = 0; j < repeat; j++) {
                    expanded.append(buildString);
                }
                st.push(expanded.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        for (String str : st) {
            result.append(str);
        }
        return result.toString();
    }
}