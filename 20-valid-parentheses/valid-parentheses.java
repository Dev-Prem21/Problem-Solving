class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        if(s.charAt(0)==')' || s.charAt(0)==']' || s.charAt(0)=='}') return false;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(st.isEmpty() && (s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}')) return false;
            if(ch=='(' || ch=='{' || ch=='[') st.push(ch);
            else if(st.peek()=='(' && ch==')') st.pop();
            else if(st.peek()=='{' && ch=='}') st.pop();
            else if(st.peek()=='[' && ch==']') st.pop();
            else st.push(ch);
        }
        return st.isEmpty();
    }
}