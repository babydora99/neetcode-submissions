class Solution {
    public int longestConsecutive(int[] nums) {
        //USING HashMap
        // Map<Integer,Integer> mp=new HashMap<>();
        // int res=0;
        // for(int num:nums){
        //     if(!mp.containsKey(num)){
        //         mp.put(num,mp.getOrDefault(num-1,0)+mp.getOrDefault(num+1,0)+1);
        //         mp.put(num-mp.getOrDefault(num-1,0),mp.get(num));
        //         mp.put(num+mp.getOrDefault(num+1,0),mp.get(num));
        //         res=Math.max(res,mp.get(num));
        //     }
        // }
        // return res;

        //USING HashSet
        Set<Integer> numSet=new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int longest=0;

        for(int num:numSet){
            if(!numSet.contains(num-1)){
                int length=1;
                while(numSet.contains(num+length)){
                    length++;
                }
                longest=Math.max(longest,length);
            }
        }
        return longest;

    }
}
