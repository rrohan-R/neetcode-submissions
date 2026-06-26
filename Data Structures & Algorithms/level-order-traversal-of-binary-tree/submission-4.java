/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> levels = new ArrayList<>();

            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                if(node != null){
                    levels.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }

            if(levels.size() > 0){
                res.add(levels);
            }
        }

        return res;
    }
}
