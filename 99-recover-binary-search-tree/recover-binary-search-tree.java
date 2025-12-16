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
     TreeNode firstelement=null;
      TreeNode secondelement=null;
      TreeNode prevelement=null;  
    public void recoverTree(TreeNode root) {
     traverse(root);
     int temp=firstelement.val;
     firstelement.val=secondelement.val;
     secondelement.val=temp;
    }
    private void traverse(TreeNode root){
        if(root==null) return;
        traverse(root.left);
        if(prevelement!=null){
            //If first element has not been found, assign it to prevElement 
        if(firstelement==null && prevelement.val>=root.val){
            firstelement=prevelement;
        }
        }
        
        // If first element is found, assign the second element to the root
        if(firstelement!=null && prevelement.val>=root.val){
            secondelement=root;
        }
        prevelement=root;
        traverse(root.right);
    }
    
}