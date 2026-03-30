class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(candidates, target, ans, cur, 0);
        return ans;
    }

    public void backtrack(
        int[] candidates,
        int target,
        List<List<Integer>> ans,
        List<Integer> cur,
        int index
    ) {
        // Base Case: If target is met, add the combination
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        // If target is negative or no more candidates are available, backtrack
        if (target < 0 || index >= candidates.length) {
            return;
        }
        
        // Step 1: Include the current candidate
        cur.add(candidates[index]);
        backtrack(candidates, target - candidates[index], ans, cur, index); // Explore further with same candidate

        // Step 2: Backtrack and remove the last added element
        cur.remove(cur.size() - 1);

        // Step 3: Exclude the current candidate and move to the next one
        backtrack(candidates, target, ans, cur, index + 1);
    }
}
