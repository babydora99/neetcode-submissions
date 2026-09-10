class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> prevMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int diff=target-num;

            if(prevMap.containsKey(diff)){
                return new int[]{prevMap.get(diff),i};
            }
            prevMap.put(num,i);
        }
        return new int[]{};
    }
}
