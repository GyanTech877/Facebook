/*
Given an array of integers A of size N. A represents a histogram i.e A[i] denotes height of
the ith histogram’s bar. Width of each bar is 1.

Largest Rectangle in Histogram: Example 1

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

Largest Rectangle in Histogram: Example 2

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Find the area of largest rectangle in the histogram.



Input Format

The only argument given is the integer array A.
Output Format

Return the area of largest rectangle in the histogram.
For Example

Input 1:
    A = [2, 1, 5, 6, 2, 3]
Output 1:
    10
    Explanation 1:
        The largest rectangle is shown in the shaded area, which has area = 10 unit.
 */
 
 public class Solution {
    public int largestRectangleArea(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        int top = 0;
        while(i<A.length){
            if(stack.isEmpty() || A[stack.peek()]<A[i]) stack.push(i++);
            else{
                top = stack.pop();
                if(stack.isEmpty())
                maxArea = Math.max(maxArea,A[top]*i);
                else maxArea = Math.max(maxArea,A[top]*(i-1-stack.peek()));
            }
        }
        while(!stack.isEmpty()){
            top = stack.pop();
            if(stack.isEmpty())
            maxArea = Math.max(maxArea,A[top]*i);
            else maxArea = Math.max(maxArea,A[top]*(i-1-stack.peek()));
        }
        return maxArea;
    }
}
