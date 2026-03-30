class Solution {
    public boolean canJump(int[] nums) {
    int goal = nums.length - 1;  // Initialize goal as the last index
    for (int i = nums.length - 2; i >= 0; i--) {  // Start from the second-last index
        if (nums[i] + i >= goal) {  // Check if we can jump to or beyond the goal
            goal = i;  // Update the goal to the current index
        }
    }
    return goal == 0;  // Check if the goal can reach the start
}

}
