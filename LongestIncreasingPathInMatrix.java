/*
Given an integer matrix, find the length of the longest increasing path.
From each cell, you can either move to four directions: left, right, up or down.
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int longestPath = Integer.MIN_VALUE;
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                cache[i][j] = -1;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                longestPath = Math.max(longestPath,dfs(matrix,i,j,m,n,Integer.MIN_VALUE,cache));
            }
        }
        return longestPath;
    }
    private int dfs(int[][] matrix,int i,int j,int m,int n,int prev,int[][] cache){
        if(i<0 || i==m || j<0 || j==n || prev>=matrix[i][j]) return 0;
        if(cache[i][j]!=-1) return cache[i][j];
        int curr = matrix[i][j];
        int maxLength = 1;
        maxLength = Math.max(maxLength, 1+ dfs(matrix,i-1,j,m,n,curr,cache));
        maxLength = Math.max(maxLength, 1+ dfs(matrix,i,j-1,m,n,curr,cache));
        maxLength = Math.max(maxLength, 1+ dfs(matrix,i+1,j,m,n,curr,cache));
        maxLength = Math.max(maxLength, 1+ dfs(matrix,i,j+1,m,n,curr,cache));
        cache[i][j] = maxLength;
        return maxLength;
    }
}
