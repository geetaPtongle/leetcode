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
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> dp=new HashMap<>();
       return solve(root, dp);
    }

    int solve(TreeNode curr,HashMap<TreeNode, Integer> dp ){
        if(curr == null) return 0;
        if(dp.containsKey(curr)){
            return dp.get(curr);
        }

        int take =curr.val;
        if(curr.left != null){
            take +=solve(curr.left.left, dp) +solve(curr.left.right, dp) ;
        }
        if(curr.right != null){
            take +=solve(curr.right.left, dp) +solve(curr.right.right, dp);
        }

        int not_take =solve(curr.left, dp) +solve(curr.right, dp);

        int ans= Math.max(take, not_take);

         dp.put(curr, ans);
         return ans;
    }
}