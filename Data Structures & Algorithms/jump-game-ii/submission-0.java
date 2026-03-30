class Solution {
    public int jump(int[] nums) {
        int jumps = 0;           // Number of jumps made
        int currentEnd = 0;       // The farthest index we can reach with the current jump
        int farthest = 0;         // The farthest index we can reach overall

        // Iterate until the second last element (no need to jump from the last element)
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest we can reach from this position
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump range, we must jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;  // Update the new jump range
            }
        }

        return jumps;
    }
}
