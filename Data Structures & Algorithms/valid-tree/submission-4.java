class Solution {
    public boolean validTree(int n, int[][] edges) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    for (int[] edge : edges) {
        graph.get(edge[0]).add(edge[1]);
        graph.get(edge[1]).add(edge[0]);
    }

    boolean[] visited = new boolean[n];
    if (dfs(graph, 0, -1, visited)) return false;
    for (boolean visit : visited) {
        if (!visit) return false;
    }
    return true;
}

private boolean dfs(List<List<Integer>> graph, int node, int parent, boolean[] visited) {
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
        if (neighbor == parent) continue;
        if (visited[neighbor]) return true;
        if (dfs(graph, neighbor, node, visited)) return true;
    }
    return false;
}
}
