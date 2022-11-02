package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2003 {

    private static int targetNumber = 0;

    public static void main(String[] args) throws Exception {
        Integer[] array = new Q2003().parse();
        System.out.println(solution(array, targetNumber));

    }

    public Integer[] parse() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String arrayString = br.readLine();
        Integer[] firstLine = Arrays.stream(T.split(" ")).map(Integer::parseUnsignedInt).toArray(Integer[]::new);
        targetNumber = firstLine[1];
        return Arrays.stream(arrayString.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
    }

    public static int solution(Integer[] inputArray, int targetNumber) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int answer = 0;
        int length = inputArray.length;
        while (end <= length) {// end 가 leng와 동일해도 start는 아직 움직일 수 있다.
            if (sum >= targetNumber) { // 줄여워야 함
                sum -= inputArray[start];
                start += 1;
            } else if (sum < targetNumber) { //늘려줘야함
                if(end == length) break;//end 를 움직여야 하는데 end는 이미 끝이기 때문에 break를 한다.
                sum += inputArray[end];
                end += 1;
            }

            if (targetNumber == sum) { //answer에 1을 더해 줘야 한다.
                answer += 1;
            }
        }
        return answer;
    }
}
