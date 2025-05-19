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
    //Using List with inorder approch 
    public int kthSmallest1(TreeNode root, int k) {
        List<Integer> ans =new ArrayList<>();
        solve(root, ans);
        return ans.get(k-1);
    }

    public void solve(TreeNode root, List<Integer> ans){
        if(root ==null) return;
        solve(root.left, ans);
        ans.add(root.val);
        solve(root.right, ans);
    }

    //without extra space inorder approch 
    public int kthSmallest(TreeNode root, int k) {
        int[] count =new int[1];
        int[] ans=new int[]{-1};
         helper(root, k, count, ans);
         return ans[0];
    }

    private void helper(TreeNode root, int k, int[] count, int[] ans) {
    if (root == null) return;

    helper(root.left, k, count, ans);
    
    count[0]++;
    if (count[0] == k) {
        ans[0] = root.val;
        return;
    }

    helper(root.right, k, count, ans);
}
}