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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int val=0;
        List<Integer> rightView=new ArrayList<>();

        while(!q.isEmpty()){
            int size=q.size();
            rightView.add(0);
            for(int i=0;i<size;i++){
                TreeNode c=q.poll();
                rightView.set(val,c.val);
                if(c.left!=null){
                    q.add(c.left);
                }
                if(c.right!=null){
                    q.add(c.right);
                }
            }
            val++;
            
        }
        return rightView;
        
    }
}
