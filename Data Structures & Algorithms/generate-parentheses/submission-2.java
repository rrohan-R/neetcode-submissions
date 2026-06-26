class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, res, 0, 0, new StringBuilder());

        return res;
    }

    public void backtrack(int n, List<String> res, int opened, int closed, StringBuilder sb){
        if(opened == n && closed == opened){
            res.add(sb.toString());
            return;
        }

        if(opened < n){
            sb.append('(');
            backtrack(n, res, opened+1, closed, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(closed < opened){
            sb.append(')');
            backtrack(n, res, opened, closed+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
