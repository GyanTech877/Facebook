/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.



Input Format

The only argument given is character array A.
Output Format

Return the value of arithmetic expression formed using reverse Polish Notation.
For Example

Input 1:
    A =   ["2", "1", "+", "3", "*"]
Output 1:
    9
Explaination 1:
    starting from backside:
    *: ( )*( )
    3: ()*(3)
    +: ( () + () )*(3)
    1: ( () + (1) )*(3)
    2: ( (2) + (1) )*(3)
    ((2)+(1))*(3) = 9
    
Input 2:
    A = ["4", "13", "5", "/", "+"]
Output 2:
    6
Explaination 2:
    +: ()+()
    /: ()+(() / ())
    5: ()+(() / (5))
    1: ()+((13) / (5))
    4: (4)+((13) / (5))
    (4)+((13) / (5)) = 6
    */
    
    public class Solution {
    public int evalRPN(String[] A) {
        if(A ==null || A.length ==0) return 0;
        Stack<String> stack = new Stack<>();
        for(String str:A){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                if(stack.size()<2) continue;
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int combined = 0;
                if(str.equals("+")) combined = b+a;
                else if(str.equals("-")) combined = b-a;
                else if(str.equals("*")) combined = b*a;
                else  combined = b/a;
                stack.push(String.valueOf(combined));
            }
            else stack.push(str);
        }
        return Integer.valueOf(stack.pop());
    }
}
