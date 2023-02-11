package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q10828 {

    ArrayDeque<Integer> stack = new ArrayDeque<>();
    public void solve() throws Exception{
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int numberOfCommand = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfCommand; i++) {
            String[] parsedArray = br.readLine().split(" ");
            if(parsedArray.length==2){
                resolveCommand(parsedArray[0],parsedArray[1]);
            }else{
                System.out.println(resolveCommand(parsedArray[0]));
            }
        }
    }
    private int resolveCommand(String command, String...numbers){
        switch (command){
            case "push":
                for (String number : numbers) {
                    stack.push(Integer.parseInt(number));
                }
                return 0;
            case "pop":
                try{
                    return stack.pop();
                }catch(NoSuchElementException e){
                    return -1;
                }
            case "size":
                return stack.size();
            case "empty":
                if(stack.isEmpty()){
                    return 1;
                }else{
                    return 0;
                }
            case "top":
                try{
                    return stack.getFirst();
                }catch(NoSuchElementException e){
                    return -1;
                }
        }
        return -1;
    }
}
