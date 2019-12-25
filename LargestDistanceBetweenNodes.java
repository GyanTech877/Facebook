/*
Find largest distance
Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.
The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree).
The nodes will be numbered 0 through N - 1.

The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N). Exactly one of the i’s will have P[i] equal to -1, it will be root node.

Example:
If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this: 
          0
       /  |  \
      1   2   3
               \
                4  
 One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus the answer is 3. Note that there are other paths with maximal distance. 
 
 */
 
 class Node{
    int value;
    List<Node> edges;
    int level;
    public Node(int value){
        this.value = value;
        this.edges = new ArrayList<>();
    }
}
public class Solution {
    public int solve(ArrayList<Integer> A) {
        Map<Integer,Node> graph = new HashMap<>();
        Node root = null;
        for(int i=0;i<A.size();i++){
            if(A.get(i)==-1){
                root = new Node(i);
                graph.put(i,root);
            }
            else{
                Node parent;
                Node child;
                if(graph.containsKey(A.get(i))){
                    parent = graph.get(A.get(i));
                }
                else{
                    parent = new Node(A.get(i));
                }
                if(graph.containsKey(i)){
                    child = graph.get(i);
                }
                else{
                    child = new Node(i);
                }
                graph.put(A.get(i),parent);
                graph.put(i,child);
                parent.edges.add(child);
                child.edges.add(parent);
            }
        }
        Node farthestNodeFromRoot = BFS1(root,A.size());
        return BFS2(farthestNodeFromRoot,A.size());
    }
    
    private Node BFS1(Node root,int n){
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(root);
        Node curr = root;
        while(!queue.isEmpty()){
            curr= queue.poll();
            visited[curr.value] = true;
            for(Node edge: curr.edges){
                if(!visited[edge.value])
                queue.offer(edge);
            }
        }
        return curr;
    }
    
     private int BFS2(Node root,int n){
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(root);
        Node curr = root;
        while(!queue.isEmpty()){
            curr= queue.poll();
            visited[curr.value] = true;
            for(Node edge: curr.edges){
                if(!visited[edge.value]){
                    edge.level = curr.level+1;
                    queue.offer(edge);
                }
            }
        }
        return curr.level;
    }
}
