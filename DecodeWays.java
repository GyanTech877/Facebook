/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
*/

class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()== 0 || s.startsWith("0")) return 0;
        if(s.length() == 1) return 1;
        int prev1 = 1;
        int prev = 1;
        int curr = 0;
        for(int i=2;i<=s.length();i++){
            curr = 0;
            int valueLast=Integer.parseInt(s.substring(i-1,i));
            if(valueLast>0 && valueLast<10)
               curr = prev;
            int valueLast2=Integer.parseInt(s.substring(i-2,i));
            if(valueLast2>=10 && valueLast2<=26) 
               curr += prev1;
            prev1=prev;
            prev=curr;
        }
        return curr;
    }
}
