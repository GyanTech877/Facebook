/*
Given an array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

NOTE:- Array A was sorted in non-decreasing order before rotation.

NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

Return index of B in array A, otherwise return -1
Constraints

1 <= N <= 1000000
1 <= A[i] <= 10^9
all elements in A are disitinct.
For Example

Input 1:
    A = [4, 5, 6, 7, 0, 1, 2, 3]
    B = 4
Output 1:
    0
Explanation 1:
 Target 4 is found at index 0 in A.


Input 2:
    A = [5, 17, 100, 3]
    B = 6
Output 2:
    -1
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int search(final int[] A, int B) {
        if(A==null || A.length==0) return -1;
        int low=0;
        int high=A.length-1;
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(A[mid]==B) return mid;
            //Lower half is sorted
            if(A[low]<=A[mid]) {
                if(B<A[mid] && B>=A[low]) high=mid-1;
                else low=mid+1;
            }
            //Upper half is sorted
            else {
                if(B>A[mid] && B<=A[high]) low=mid+1;
                else high=mid-1;
            }
        }
        return -1;
    }
}
