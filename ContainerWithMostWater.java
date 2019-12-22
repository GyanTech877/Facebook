/*
Given n non-negative integers a1, a2, ..., an,
where each represents a point at coordinate (i, ai).
'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Your program should return an integer which corresponds to the maximum area of water that can be contained ( Yes, we know maximum area instead of maximum volume sounds weird. But this is 2D plane we are working with for simplicity ).
*/

public class Solution {
    public int maxArea(int[] A) {
        if(A == null || A.length ==0) return 0;
        int maxArea = 0;
        int i = 0;
        int j = A.length -1;
        while(i<j){
            if(A[i]<=A[j]){
                 maxArea = Math.max(maxArea,((j-i)*A[i]));
                 i++;
            }
            else{
                 maxArea = Math.max(maxArea,((j-i)*A[j]));
                 j--;
            }
        }
        return maxArea;
    }
}
