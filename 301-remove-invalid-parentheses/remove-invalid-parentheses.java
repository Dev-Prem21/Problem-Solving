class Solution {
    Set<String> result = new HashSet<>();
    int maxLength = 0;
    public List<String> removeInvalidParentheses(String s) {
        backtrack(s,0,new StringBuilder());
        return new ArrayList<>(result);
    }
    private void backtrack(String s, int index, StringBuilder current) {
        if (index == s.length()) {
            String candidate = current.toString();

            if (check(candidate)) {
                if (candidate.length() > maxLength) {
                    maxLength = candidate.length();
                    result.clear();
                }

                if (candidate.length() == maxLength) {
                    result.add(candidate);
                }
            }
            return;
        }
        char c = s.charAt(index);
        current.append(c);
        backtrack(s, index + 1, current);
        current.deleteCharAt(current.length() - 1);
        if (c == '(' || c == ')') {
            backtrack(s, index + 1, current);
        }
    }

    private boolean check(String s){
        if(s.length()==0) return true;
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(') st.push(c);
            else if(c==')' && st.isEmpty()) return false;
            else if(c==')' && !st.isEmpty()) st.pop();
            else continue;
        }
        return st.isEmpty();
    }
}