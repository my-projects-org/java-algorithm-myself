package com.algorithm.programmers.level2;

import java.util.EmptyStackException;
import java.util.Stack;

public class Q12909 {
    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            Stack<String> myStack= new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='('){
                    myStack.push("(");
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

}
