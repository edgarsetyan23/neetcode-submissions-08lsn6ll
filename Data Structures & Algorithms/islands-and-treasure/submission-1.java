class Solution {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void islandsAndTreasure(int[][] grid) {  
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == GATE) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != EMPTY) {
                    continue;
                }
                grid[r][c] = grid[row][col] + 1;
                queue.offer(new int[]{r, c});
            }
        }
    }
}