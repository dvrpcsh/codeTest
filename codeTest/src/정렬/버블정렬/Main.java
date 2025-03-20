package 정렬.버블정렬;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		/**
		 * 이 문제는 PASS << 나중에 다시 보기(이해가 안감)
		 * 문제 2
		 * 영식이는 다음과 같은 버블 소트 프로그램을 C++로 작성했다
		 * bool change = false;
		 * 
		 * for(int i=0; i<=n; i++) {
		 * 	  for(int j=1; j<=n-i; j++) {
		 * 	     if(a[j] > a[j+1]) {
		 * 		    change = true;
		 * 		    swap(a[j],a[j+1]);
		 * 	     }
		 *    }
		 * 
		 *    if(change == false) {
		 * 	     cout << i << '\n';
		 * 	     break;
		 *    }
		 * }
		 *
		 * 위 코드에서 n은 배열의 크기, a는 수가 들어있는 배열이다. 수는 배열의 1번방 부터 채운다.
		 * 위와 같은 코드를 실행했을 때 출력되는 값을 구하시오.
		 * 
		 * 입력
		 * 1번쨰 줄에 n이 주어진다. n은 500,000보다 작거나 같은 자연수다.
		 * 2번째 줄부터 n개의 줄에 A[1]부터 A[n]까지 1개씩 주어진다.
		 * A에 들어있는 수는 1,000,000보다 작거나 같은 자연수 또는 0이다.
		 */
		
		
	}
}



/**
 * 문제 1
 * N개의 숫자가 주어졌을 때 이를 오름차순 정렬하는 프로그램을 작성하세요
 * 
 * 입력
 * 1번째 줄에 수의 개수 N(1<=N<=1000), 2번째 줄 부터 N개의 줄에 숫자가 주어진다.
 * 이 수는 절댓값이 1000보다 작거나 같은 정수다.수는 중복되지 않는다.
 * 
 * 예제 입력
 *  5	//수의 개수
 *  5
 *  2
 *  3
 *  4
 *  1
 *  
 *  예제 출력
 *  1
 *  2
 *  3
 *  4
 *  5


Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int[] arr = new int[n];
int tmp = 0;

for(int i=0; i<n; i++) {
	arr[i] = sc.nextInt();
}

for(int i=0; i<n; i++) {
	for(int j=i+1; j<n; j++) {
		if(arr[i]>arr[j]) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}
}

for(int i=0; i<n; i++) {
	System.out.println(arr[i]);
}

 */