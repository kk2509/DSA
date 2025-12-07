class Solution {
    public char findTheDifference(String s, String t) {
        char xor=0;
        for(char S:s.toCharArray()) xor^=S;
        for(char T:t.toCharArray()) xor^=T;
        return xor;
    }
}