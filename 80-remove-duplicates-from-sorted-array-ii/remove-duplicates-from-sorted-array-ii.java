class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer>mp=new HashMap<>();
        int k=0;
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
            if(mp.get(num)<=2){
                nums[k]=num;
                k++;
            }
        }
        return k;
    }
}