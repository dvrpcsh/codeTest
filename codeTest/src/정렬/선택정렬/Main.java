package 정렬.선택정렬;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/**
		 * 문제 1
		 * 내림차순으로 자릿수 정렬하기
		 * 
		 * 입력
		 * 1번쨰 줄에 정렬할 수 N이 주어진다.
		 * N은 1,000,000,000보다 작거나 같은 자연수다.
		 * 
		 * 예제 입력
		 * 2143
		 * 
		 * 예제 출력
		 * 4321
		 */
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		char[] arrToChar = n.toCharArray();
		int[] arr = new int[arrToChar.length];
		int tmp = 0;
		
		for(int i=0; i<arrToChar.length; i++) {
			arr[i] = arrToChar[i]-'0';
		}
		
		for(int i=0; i<arr.length; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if(arr[i]<arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
		
	}

}
