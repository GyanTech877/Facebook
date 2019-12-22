/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example :
[1,1,2] have the following unique permutations:

[1,1,2]
[1,2,1]
[2,1,1]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[A.size()];
        Collections.sort(A);
        permuteRec(A,result,new ArrayList<Integer>(),used);
        return result;
    }
    private void permuteRec(ArrayList<Integer> A,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> curr,boolean[] used){
        if(curr.size()==A.size()){
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i=0;i<A.size();i++){
            if(used[i] || (i>0 &&A.get(i)==A.get(i-1) && ! used[i-1])) continue;
            curr.add(A.get(i));
            used[i] = true;
            permuteRec(A,result,curr,used);
            used[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}
