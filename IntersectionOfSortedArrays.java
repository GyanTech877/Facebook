/*
Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] intersect(final int[] A, final int[] B) {
        List<Integer> resList = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<A.length && j<B.length){
            if(A[i]==B[j]){
                resList.add(A[i]);
                i++;
                j++;
            }
            else if(A[i]<B[j]) i++;
            else j++;
        }
        return resList.toArray(new Integer[resList.size()]);
    }
}
