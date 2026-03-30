class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int curNum = nums[i];
            int compliment  = target-curNum;
            if (prevMap.containsKey(compliment)){
                return new int[] {prevMap.get(compliment), i};
            }
            prevMap.put(curNum,i);

        }
        return new int[] {};
        
    }
}
