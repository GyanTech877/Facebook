/*
A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:
Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
Example 2:
Input: "1*"
Output: 9 + 9 = 18
Note:
The length of the input string will fit in range [1, 105].
The input string will only contain the character '*' and digits '0' - '9'.
*/

class Solution {
    public int numDecodings(String s) {
      if(s==null || s.length()== 0 || s.startsWith("0")) return 0;
        if(s.length() == 1){
            if(s.charAt(0) == '*') return 9;
            return 1;
        } 
        long prev1 = 1;
        long prev = s.charAt(0)=='*'?9:1;
        long curr = 0;
        long mod = 1000000007;
        for(int i=2;i<=s.length();i++){
            curr = 0;
            char current = s.charAt(i-1);
            char previous = s.charAt(i-2);
            if(current == '*'){
                curr=9*prev;
            }
            else if(current!='0'){
                 curr = prev;
            }
            if(previous == '*'){
                if(current == '*'){
                     curr+=15*prev1; 
                }
                else if(current<='6'){
                    curr+=2*prev1;
                }
                else{
                   curr+=prev1; 
                }
            }
            else if(previous == '1' || previous == '2'){
                    if(current == '*'){
                        if(previous == '1')
                            curr+=9*prev1; 
                        else
                            curr+=6*prev1;
                    }
                     else if(((previous-'0')*10 + (current-'0')) <= 26) {
                        curr+=prev1;    
                    }  
            }
            curr=curr%mod;
            prev1=prev%mod;
            prev=curr%mod;
        }
        return (int)curr;  
    }
}
