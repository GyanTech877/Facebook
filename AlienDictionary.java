/*
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
Derive the order of letters in this language.

You may assume all letters are in lowercase.
The dictionary is invalid, if a is prefix of b and b is appear before a.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return the smallest in normal lexicographical order.

Example 1:

Input：["wrt","wrf","er","ett","rftt"]
Output："wertf"
Explanation：
from "wrt"and"wrf" ,we can get 't'<'f'
from "wrt"and"er" ,we can get 'w'<'e'
from "er"and"ett" ,we can get 'r'<'t'
from "ett"and"rftt" ,we can get 'e'<'r'
So return "wertf"

Example 2:

Input：["z","x"]
Output："zx"
Explanation：
from "z" and "x"，we can get 'z' < 'x'
So return "zx"
*/

class Graph{
   List<Integer>[] adjacencyList;
   public Graph(){
       adjacencyList = new ArrayList[26];
       for(int i=0;i<26;i++){
           adjacencyList[i] = new ArrayList<>();
       }
   }
   public void addEdge(int a,int b){
       adjacencyList[a].add(b);
   }
   public StringBuilder topologicalSort(int[] count){
       StringBuilder res= new StringBuilder();
       Stack<Integer> stack = new Stack<>();
       boolean[] visited = new boolean[26];
       for(int i=25;i>=0;i--){
           if(!visited[i] && count[i]>0){
               topologicalSortUtil(i,visited,stack);
           }
       }
       while(!stack.isEmpty()){
           int value='a'+stack.pop();
           res.append((char)value);
       }
       return res;
   }
   private void topologicalSortUtil(int currentIndex,boolean[] visited,Stack<Integer> stack){
       visited[currentIndex] = true;
       for(Integer index : adjacencyList[currentIndex]){
           if(!visited[index]){
               topologicalSortUtil(index,visited,stack);
           }
       }
       stack.push(currentIndex);
   }
   public boolean hasCycle(int[] count){
       int[] color = new int[26];
       for(int i=0;i<26;i++){
          if(count[i]>0 && color[i]==0){
              if(hasCycleUtil(i,count,color)) return true;
          } 
       }
       return false;
   }
   private boolean hasCycleUtil(int currentIndex,int[] count,int[] color){
       color[currentIndex] = 1;
       for(Integer index : adjacencyList[currentIndex]){
            if(color[index]==1) return true;
            if(color[index]==0 && count[index]!=0){
                if(hasCycleUtil(index,count,color)) return true;
            }
       }
       color[currentIndex] = 2;
       return false;
   }
}


public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        if(words == null || words.length ==0) return "";
        int[] count = new int[26];
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                count[words[i].charAt(j)-'a']++;
            }
        }
        
        Graph graph = new Graph();
        for(int i=0;i<words.length-1;i++){
            for(int j=0;j<words[i].length() && j<words[i+1].length();j++){
                if(words[i].charAt(j) != words[i+1].charAt(j)){
                    graph.addEdge(words[i].charAt(j)-'a',words[i+1].charAt(j)-'a');
                    break;
                }
            }
        }
        boolean hasCycle = graph.hasCycle(count);
        if(hasCycle) return "";
        return graph.topologicalSort(count).toString();
    }
}

