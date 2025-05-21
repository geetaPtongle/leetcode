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
    public int rangeSumBST1(TreeNode root, int low, int high) {
      int[] sum = new int[]{0};
        solve(root, low, high, sum);
        return sum[0];
    }

     public void solve(TreeNode root, int low, int high, int[] sum) {
        if(root ==null) return;
        solve(root.left, low, high, sum);
        if(low <=root.val &&  root.val<=high){
            sum[0] +=root.val;
        }
         solve(root.right, low, high, sum);
     }

     public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        if(low> root.val) return rangeSumBST(root.right, low, high);
        else if(high<root.val) return rangeSumBST(root.left, low, high);
        else return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

     }
}