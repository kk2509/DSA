class Solution {
    public int[] rearrangeArray(int[] nums) {
      List<Integer> v1=new ArrayList<>();
      List<Integer> v2=new ArrayList<>();
      List<Integer>ans=new ArrayList<>();
      for(int num:nums){
        if(num>0){
            v1.add(num);
        }
        else{
            v2.add(num);
        }
      }
      int idx1=0, idx2=0;
      while(idx1<nums.length/2){
        ans.add(v1.get(idx1));
        idx1++;
        ans.add(v2.get(idx2));
        idx2++;
      }
      return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}