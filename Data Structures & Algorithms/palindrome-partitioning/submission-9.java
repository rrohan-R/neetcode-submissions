class Solution {
    List<String> temp = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0, 0);
        return res;
    }

    public void dfs(String s, int i, int j){
        if(j >= s.length()){
            if(i == j){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        

        if(isPalindrome(s, i, j)){
            temp.add(s.substring(i, j+1));
            dfs(s, j+1, j+1);
            temp.remove(temp.size() - 1);
        }

        dfs(s, i, j+1);
    }
    
    public boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
