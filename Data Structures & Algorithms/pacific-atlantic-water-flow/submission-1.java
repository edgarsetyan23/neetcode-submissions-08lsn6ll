class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];
        
        // DFS from top and left edges (Pacific Ocean)
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacificReachable, i, 0, rows, cols);
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights, pacificReachable, 0, j, rows, cols);
        }
        
        // DFS from bottom and right edges (Atlantic Ocean)
        for (int i = 0; i < rows; i++) {
            dfs(heights, atlanticReachable, i, cols - 1, rows, cols);
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights, atlanticReachable, rows - 1, j, rows, cols);
        }
        
        // Find cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] reachable, int row, int col, int rows, int cols) {
        reachable[row][col] = true;
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                && !reachable[newRow][newCol] 
                && heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, reachable, newRow, newCol, rows, cols);
            }
        }
    }
}