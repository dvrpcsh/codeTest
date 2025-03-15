import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 문제 2
         * 수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하는 프로그램을 작성하세요
         *
         * 입력
         * 1번째 줄 N(1<=N<=100,000)
         * 합을 구해야 하는 횟수 M(1<=M<=100000)
         * 2번째 줄에는 M개의 수가 주어진다
         * 3번째 줄에는 M개의 줄에 합을 구해야 하는 구간 i,j가 주어진다.
         *
         * 예제 입력
         * 5 3 //데이터의 개수, 질문 개수
         * 5 4 3 2 1 //구간 합을 구할 대상 배열
         * 1 3
         * 2 4
         * 5 5
         *
         * 출력
         * 12
         * 9
         * 1
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //데이터의 개수
        int dataEa = Integer.parseInt(st.nextToken());
        //질문 개수
        int questEa = Integer.parseInt(st.nextToken());
        //입력받은 배열
        int inputArr[] = new int[dataEa+1];
        //구간 합 배열
        int sumArr[] = new int[dataEa+1];
        //정답
        int answer[] = new int[questEa];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=dataEa; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
            System.out.println(inputArr[i]);
        }


        for(int i=1; i<=dataEa; i++) {
            sumArr[i] = inputArr[i-1] + inputArr[i];
            System.out.println(sumArr[i]);
        }

        for(int i=0; i<questEa; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            answer[i] = sumArr[m] - sumArr[n-1];
        }

        for(int i=0; i<questEa; i++) {
            System.out.println(answer[i]);
        }


    }
}