/*
	 * Suppose we have some input data describing a graph of relationships between
	 * parents and children over multiple generations. The data is formatted as a
	 * list of (parent, child) pairs, where each individual is assigned a unique
	 * integer identifier.
	 * 
	 * For example, in this diagram, 6 and 8 have a common ancestor of 4.
	 * 
	 * 14 13 | | 1 2 4 12 \ / / | \ / 3 5 8 9 \ / \ \ 6 7 11
	 * 
	 * parentChildPairs1 = [ (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5), (4, 8),
	 * (4, 9), (9, 11), (14, 4), (13, 12), (12, 9) ]
	 * 
	 * Write a function that takes the graph, as well as two of the individuals in
	 * our dataset, as its inputs and returns true if and only if they share at
	 * least one ancestor.
	 * 
	 * Sample input and output:
	 * 
	 * hasCommonAncestor(parentChildPairs1, 3, 8) => false
	 * hasCommonAncestor(parentChildPairs1, 5, 8) => true
	 * hasCommonAncestor(parentChildPairs1, 6, 8) => true
	 * hasCommonAncestor(parentChildPairs1, 6, 9) => true
	 * hasCommonAncestor(parentChildPairs1, 1, 3) => false
	 * hasCommonAncestor(parentChildPairs1, 7, 11) => true
	 * hasCommonAncestor(parentChildPairs1, 6, 5) => true
	 * hasCommonAncestor(parentChildPairs1, 5, 6) => true
	 * 
	 * Additional example: In this diagram, 4 and 12 have a common ancestor of 11.
	 * 
	 * 11 / \ 10 12 / \ 1 2 5 \ / / \ 3 6 7 \ \ 4 8
	 * 
	 * parentChildPairs2 = [ (11, 10), (11, 12), (10, 2), (10, 5), (1, 3), (2, 3),
	 * (3, 4), (5, 6), (5, 7), (7, 8), ]
	 * 
	 * hasCommonAncestor(parentChildPairs2, 4, 12) => true
	 * hasCommonAncestor(parentChildPairs2, 1, 6) => false
	 * hasCommonAncestor(parentChildPairs2, 1, 12) => false
	 * 
	 * n: number of pairs in the input
	 */
   
   public static void main(String[] argv) {
		int[][] parentChildPairs1 = new int[][] { { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 }, { 4, 8 },
				{ 4, 9 }, { 9, 11 }, { 14, 4 }, { 13, 12 }, { 12, 9 } };
		int[][] parentChildPairs2 = new int[][] { { 11, 10 }, { 11, 12 }, { 10, 2 }, { 10, 5 }, { 1, 3 }, { 2, 3 },
				{ 3, 4 }, { 5, 6 }, { 5, 7 }, { 7, 8 } };
		System.out.println(hasCommonAncestor(parentChildPairs1, 3, 8));
		System.out.println(hasCommonAncestor(parentChildPairs1, 5, 8));
		System.out.println(hasCommonAncestor(parentChildPairs1, 6, 8));
		System.out.println(hasCommonAncestor(parentChildPairs1, 6, 9));
		System.out.println(hasCommonAncestor(parentChildPairs1, 1, 3));
		System.out.println(hasCommonAncestor(parentChildPairs1, 7, 11));
		System.out.println(hasCommonAncestor(parentChildPairs1, 6, 5));
		System.out.println(hasCommonAncestor(parentChildPairs1, 5, 6));
		System.out.println(hasCommonAncestor(parentChildPairs2, 4, 12));
		System.out.println(hasCommonAncestor(parentChildPairs2, 1, 6));
		System.out.println(hasCommonAncestor(parentChildPairs2, 1, 12));
	}

	private static boolean hasCommonAncestor(int[][] parentChildPairs, int a, int b) {
		if (parentChildPairs == null || parentChildPairs.length == 0)
			return false;
		Map<Integer, Node> graph = new HashMap<>();
		for (int[] parentChildPair : parentChildPairs) {
			int parent = parentChildPair[0];
			int child = parentChildPair[1];
			Node parentNode;
			Node childNode;
			if (graph.containsKey(parent)) {
				parentNode = graph.get(parent);
			} else {
				parentNode = new Node(parent);
			}
			if (graph.containsKey(child)) {
				childNode = graph.get(child);
			} else {
				childNode = new Node(child);
			}
			parentNode.childrens.add(childNode);
			childNode.parents.add(parentNode);
			graph.put(parent, parentNode);
			graph.put(child, childNode);
		}
		if (!graph.containsKey(a) || !graph.containsKey(a))
			return false;
		Node nodeA = graph.get(a);
		Node nodeB = graph.get(b);
		boolean[] visited = new boolean[1000];
		return findAndProcessParents(graph, nodeA, nodeB, visited);
	}

	private static boolean findAndProcessParents(Map<Integer, Node> graph, Node nodeA, Node nodeB, boolean[] visited) {
		boolean contains = false;
		if (nodeA.parents.size() == 0)
			return contains;
		for (Node element : nodeA.parents) {
			if (dfs(element, nodeB.data, visited))
				return true;
			contains |= findAndProcessParents(graph, element, nodeB, visited);
		}
		return contains;
	}

	private static boolean dfs(Node node, int data, boolean[] visited) {
		if (visited[node.data])
			return false;
		if (node.data == data)
			return true;
		visited[node.data] = true;
		boolean found = false;
		for (Node element : node.childrens) {
			if (!visited[element.data]) {
				found |= dfs(element, data, visited);
				if (found)
					return true;
			}
		}
		return found;
	}
