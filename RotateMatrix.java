/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]
*/

public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        if(a == null || a.size()==0) return;
        int length=a.size();
        int i=0;
        int j=length-1;
        while(i<j){
            for(int m=0;m<length;m++){
                int temp=a.get(i).get(m);
                a.get(i).set(m,a.get(j).get(m));
                a.get(j).set(m,temp);
            }
            i++;
            j--;
        }
        for(int m=0;m<length;m++){
            for(int n=m+1;n<length;n++){
                int temp=a.get(m).get(n);
                a.get(m).set(n,a.get(n).get(m));
                a.get(n).set(m,temp);
            }
        }
    }
}
