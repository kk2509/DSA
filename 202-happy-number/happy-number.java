class Solution {
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=square(slow);
            fast=square(square(fast));
        } while(slow!=fast);
        return slow==1;
    }
    public int square(int num){
        int sum=0;
        while(num>0){
            int digit=num%10;
            sum+=digit*digit;
            num/=10;
        }
        return sum;
    }
}