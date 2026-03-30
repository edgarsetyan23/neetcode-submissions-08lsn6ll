class Solution {

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int num : nums) {
            if (!uniques.add(num)) {
                return true;
            }
        }
        return false;
    }
}