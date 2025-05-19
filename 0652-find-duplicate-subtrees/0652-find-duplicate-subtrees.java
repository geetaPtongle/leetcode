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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans=new ArrayList<TreeNode>();
        Map<String, Integer> mp=new HashMap<>();
       solve(root, mp, ans);
       return ans;
    }

    public String solve(TreeNode curr, Map<String, Integer> mp, List<TreeNode> ans) {
        if (curr == null) {
            return "-";
        }
        String leftTree = solve(curr.left, mp, ans);
        String rightTree = solve(curr.right, mp, ans);
        String st = Integer.toString(curr.val) + "#" + leftTree + "#" + rightTree; //root#left#right

            // mp.put(st, mp.getOrDefault(st, 0) + 1); 
            // if(mp.get(st) == 2) ans.add(curr);
            if(mp.containsKey(st)){
                if(mp.get(st) ==1)
                ans.add(curr);
                mp.put(st, mp.get(st)+1);
            }else{
                mp.put(st, 1);
            }

        return st;
    }
}