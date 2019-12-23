/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:

int isMatch(const char *s, const char *p)
Some examples:

isMatch("aa","a") → 0
isMatch("aa","aa") → 1
isMatch("aaa","aa") → 0
isMatch("aa", "a*") → 1
isMatch("aa", ".*") → 1
isMatch("ab", ".*") → 1
isMatch("aab", "c*a*b") → 1
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int isMatch(final String A, final String B) {
        if(A == null || B == null) return 0;
        boolean[][] dp = new boolean[A.length()+1][B.length()+1];
        dp[0][0] = true;
        char[] pattern = A.toCharArray();
        char[] matcher = B.toCharArray();
        for(int j=2;j<=matcher.length;j++){
            if(matcher[j-1] == '*' && dp[0][j-2])
                dp[0][j] = true;
        }
        for(int i=1;i<=pattern.length;i++){
            for(int j=1;j<=matcher.length;j++){
                if(matcher[j-1] == '.' || pattern[i-1] == matcher[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(matcher[j-1] == '*'){
                    dp[i][j] = dp[i][j-2] || (((matcher[j-2]==pattern[i-1]) || (matcher[j-2] =='.') ) && dp[i-1][j]);
                }
            }
        }
        return dp[A.length()][B.length()]== true?1:0;
    }
}
