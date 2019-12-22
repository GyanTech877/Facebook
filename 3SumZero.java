/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.
*/

class Pair{
        int x;
        int y;
        int z;
        public Pair(int x,int y,int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
        public boolean equals(Object o){
            if(o==this) return true;
            if(!(o instanceof Pair)) return false;
            Pair p=(Pair)o;
            return (this.x==p.x && this.y==p.y && this.z==p.z);
        }
        public int hashCode() {
             int result = 17;
             result = 31 * result + x;
             result = 31 * result + y;
             result = 31 * result + z;
             return result;
        }
    }


public class Solution {
    public int[][] threeSum(int[] A) {
        Arrays.sort(A);
        Set<Pair> result=new HashSet();
        for(int i=0;i<A.length-1;i++){
            int j=i+1;  
            int k=A.length-1;
            while(j<k){
                if((A[i]+A[j]+A[k])==0) {
                    result.add(new Pair(A[i],A[j],A[k]));
                    k--;
                    j++;
                }
                else if((A[i]+A[j]+A[k])>0) k--;
                else j++;
            }
        }
        int[][] res=new int[result.size()][3];
        int i=0;
        for(Pair p:result){
            res[i++]=new int[]{p.x,p.y,p.z};
        }
        return res;
    }
}
