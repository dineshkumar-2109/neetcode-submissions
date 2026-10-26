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
    private int sum=Integer.MIN_VALUE;
    public int pathSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=pathSum(root.left);
        int right=pathSum(root.right);
        int total=left+right+root.val;
        sum=Math.max(sum,total);
        return total<0?0:Math.max(left+root.val,right+root.val);


    }
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return sum;
    }
}
