package com.algorithm.programmers.level2;

import java.util.EmptyStackException;
import java.util.Stack;

public class Q12909 {
    public static void main(String[] args) {
        boolean answer = new Solution().solution(")()(");
        System.out.println(answer);
    }

}
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> myStack= new Stack<>();

        String[] splited = s.split("");
        for (String str :
                splited) {
            if(str.equals("(")){
                myStack.push(str);
            }else{
                try{
                    myStack.pop();
                }catch (EmptyStackException e){
                    return false;
                }
            }
        }
        if(myStack.size()!= 0) return false;
        return answer;
    }
}