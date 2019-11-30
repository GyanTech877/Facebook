/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] twoSum(final int[] A, int B) {
        if(A==null || A.length ==0) return new int[]{};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++){
            int toSearch = B - A[i];
            if(!map.isEmpty() && map.containsKey(toSearch))
            return new int[]{map.get(toSearch),i+1};
            if(!map.containsKey(A[i]))
            map.put(A[i],i+1);
        }
        return new int[]{};
    }
}
