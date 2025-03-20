package 정렬.삽입정렬;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		/**
		 * 문제 1
		 * 1대의 atm기기로 마지막 사람의 대기시간이 가장 적게 걸리게 프로그램을 작성하세요
		 * 
		 * 입력
		 * 1번째 줄에 사람의 수 N(1<=N<=1000)
		 * 2번쨰 줄에 각 사람이 돈을 인출하는데 걸리는 시간 P(1<=P<=1000)이 주어진다
		 * 
		 * 예제 입력
		 *  5	//사람의 수
		 *  3
		 *  1
		 *  4
		 *  3
		 *  2
		 *  
		 *  예제 출력
		 *  32
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] arrSub = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<n; i++) {
			int insert = i;
			int insert_val = arr[i];
			
			for(int j=i-1; j>=0; j--) {
				if(arr[j] < arr[i]) {
					insert = j+1;
					break;
				}
				if(j == 0) {
					insert = 0;
				}
			}
			
			for(int j=i; j>insert; j--) {
				arr[j] = arr[j-1];
			}
			arr[insert] = insert_val;
		}
		
		arrSub[0] = arr[0];	//합 배열 만들기
		
		for(int i=1; i<n; i++) {
			arrSub[i] = arrSub[i-1] + arr[i];
		}
		
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			sum += arrSub[i];
		}
		
		System.out.println(sum);
	}
}



