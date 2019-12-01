/*
Given an array A of integers, find the index of values that satisfy A + B = C + D, 
where A,B,C & D are integers values in the array
*/

public class Solution {
    public static ArrayList<Integer> equal(List<Integer> A) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = A.size();
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                int sum = A.get(i) + A.get(j);
                if(map.containsKey(sum) && map.get(sum).size()==2){
                    int a1 = map.get(sum).get(0);
                    int b1 = map.get(sum).get(1);
                    int c1 = i;
                    int d1 = j;
                    if(a1<b1 && c1<d1 && a1<c1 && b1!=d1 && b1!=c1){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(a1);
                        temp.add(b1);
                        temp.add(c1);
                        temp.add(d1);
                        result.add(temp);
                        map.put(sum,new ArrayList<>());
                    }
                }
                else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    map.put(sum,list);
                }
            }
        }
        Collections.sort(result, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
                int result = l1.get(0).compareTo(l2.get(0));
                if(result!=0) return result;
                result= l1.get(1).compareTo(l2.get(1));
                if(result!=0) return result;
                result= l1.get(2).compareTo(l2.get(2));
                if(result!=0) return result;
                result= l1.get(3).compareTo(l2.get(3));
                if(result!=0) return result;
                return l1.get(4).compareTo(l2.get(4));
            }
        });
        return result.get(0);
    }
}
