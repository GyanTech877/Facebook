/*
Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants. 
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor 
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    boolean bExists;
    boolean cExists;
    
    public int lca(TreeNode A, int B, int C) {
       int lca=lcaUtil(A,B,C);
       if(bExists && cExists) return lca;
       return -1;
    }
    private int lcaUtil(TreeNode A, int B, int C){
        if(A == null) return -1;
        int temp =-1;
        if(A.val == B){
            bExists = true;
            temp= A.val;
        } 
        if(A.val == C){
            cExists = true;
            temp= A.val;
        }
        int leftLca = lcaUtil(A.left,B,C);
        int rightLca = lcaUtil(A.right,B,C);
        if(temp!=-1) return temp;
        if(leftLca != -1 && rightLca!= -1) return A.val;
        return (leftLca == -1)?rightLca:leftLca;
    }
}
