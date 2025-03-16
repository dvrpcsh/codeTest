package 자료구조.투포인터;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
    	
    }
}


/**
 * 문제 1
 * 1부터 입력받은 숫자 n까지 연속된 자연수 중 몇개의 연속된 자연수의 합으로 나타낼 수 있는가?
 * 
 * 입력 예제
 * 15
 * 
 * 출력
 * 4
 * 
 * ex) 1+2+3+4+5 / 4+5+6 / 7+8 / 15
 *
 
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int count = 1;
int sttIdx = 1;
int endIdx = 1;
int sum = 1;

while(endIdx != n) {
	if(sum == n) {
		count++;
		endIdx++;
		sum += endIdx;
	} else if(sum > n) {
		sum -= sttIdx;
		sttIdx++;
	} else {
		endIdx++;
		sum += endIdx;
	}
}
System.out.print(count);

*/
    
/**
 * 문제 2
 * 첫번째 줄에 재료 갯수 n이 주어짐
 * 두번째 줄에 갑옷이 완성되는 번호의 합m이 주어짐
 * 세번째 줄에 재료들이 주어짐
 * 두 개의 재료를 조합해 갑옷이 되는 경우의 수를 구하라
 * 
 * 입력 예제
 * 6 			//재료의 개수
 * 9			//갑옷이 완성되는 번호의 합
 * 2 7 4 1 5 3  //재료들
 * 
 * 출력
 * 2
 

Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int m = sc.nextInt();
int[] arr = new int[n];
int answer = 0;
int sum = 0;

for(int i=0; i<n; i++) {
	arr[i] = sc.nextInt();
}

//받은 배열을 정렬한다
Arrays.sort(arr);

//투 포인터를 이용해 2개의 합이 9가되는 경우의 수를 찾는다
	int sttIdx = 0;
	int endIdx = n-1;
	
	 
	while(sttIdx < endIdx) {
		sum = arr[sttIdx]+arr[endIdx];
		if(sum < m) {
			sttIdx++;
		} else if(sum > m) {
			endIdx--;
		} else {
			answer++;
			sttIdx++;
			endIdx--;
		}
	}
	
	System.out.print(answer);
*/


/**
 * 문제 3
 * 주어진 N개의 수에서 다른 두 수의 합으로 표현되는 수가 있다면 그 수를 '좋은 수'라고 한다.
 * N개의 수 중 좋은 수가 총 몇개인지 구하시오.
 * 
 * 예제 입력
 * 10						//수의 개수
 * 1 2 3 4 5 6 7 8 9 10
 * 
 * 출력
 * 8
 * 
 * ex) 3 = 1+2
 *     5 = 2+3
 *     7 = 2+5 ...
 * 
 
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine());
int result = 0;
long arr[] = new long[n];

StringTokenizer st = new StringTokenizer(br.readLine());

for(int i=0; i<n; i++) {
	arr[i] = Long.parseLong(st.nextToken());
}

Arrays.sort(arr);

for(int k=0; k<n; k++) {
	long find = arr[k];
	int i=0;
	int j=n-1;
	
	while(i<j) {
		if(arr[i]+arr[j]==find) {
			if(i != k && j != k) {
				result++;
				break;
			} else if(i == k) {    					
				i++;
			} else if(j == k){
				j--;
			}
		} else if(arr[i] + arr[j] < find) {
			i++;
		} else {
			j--;
		}
	}
}

System.out.print(result);

*/


/**
 * 문제 4
 * 슬라이딩 윈도우
 * 
 * 2번째 문자열에서  3번째 숫자 A C G T 를 만족하는 문자열 구하기
 * 
 * 입력 예제
 * 9 8			//DNA문자열의 길이, 부분 문자열의 길이
 * CCTGGATTG	//DNA문자열
 * 2 0 1 1		//부분 문자열에 포함돼야 할 A, C, G, T의 최소 개수
 * 
 * 출력
 * 0
 * 
 * 입력 예제 2
 * 4 2
 * GATA
 * 1 0 0 1
 * 
 * 출력
 * 2
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int answer = 0;

//첫번째 줄 입력받기
int dnaLen = Integer.parseInt(st.nextToken());
int strLen = Integer.parseInt(st.nextToken());

//두번째 줄 입력받기
st = new StringTokenizer(br.readLine());
String dna = st.nextToken();
char[] dnaToChar = dna.toCharArray();

//세번째 줄 입력받기
st = new StringTokenizer(br.readLine());
int[] acgt = new int[4];
int[] danAcgt = new int[4];

for(int i=0; i<acgt.length; i++) {
	acgt[i] = Integer.parseInt(st.nextToken());
}

//길이를 부분 문자열만큼 고정 후 3번째 문자열과 비교해나가며 옆으로 한칸 씩 이동
if(dnaLen < strLen) {
	System.out.print(answer);
} else {
	int sttIdx = 0;
	int endIdx = strLen-1;
	
	while(endIdx < dnaLen) {
		//최초 실행 시 문자열 체크
		if(sttIdx==0) {
			for(int i=sttIdx; i<=endIdx; i++) {
        		switch(dnaToChar[i]) {
        			case 'A':
        				danAcgt[0]++;
        			case 'C':
        				danAcgt[1]++;
        			case 'G':
        				danAcgt[2]++;
        			case 'T':
        				danAcgt[3]++;
        		}
        	}
		//이후 들어오는 것과 나가는 것만 체크
		} else {
			switch(dnaToChar[sttIdx-1]) {
    			case 'A':
    				danAcgt[0]--;
    			case 'C':
    				danAcgt[1]--;
    			case 'G':
    				danAcgt[2]--;
    			case 'T':
    				danAcgt[3]--;
			}
			
			switch(dnaToChar[endIdx]) {
    			case 'A':
    				danAcgt[0]++;
    			case 'C':
    				danAcgt[1]++;
    			case 'G':
    				danAcgt[2]++;
    			case 'T':
    				danAcgt[3]++;
			}
		}
		
    	
    	//체크문자 일치여부
    	boolean checkSum = true;
    	for(int i=0; i<acgt.length; i++) {
    		if(acgt[i] > danAcgt[i]) {
    			checkSum = false;
    			break;
    		}
    	}
    	
    	//체크문자가 일치하면
    	if(checkSum) {
    		answer++;
    	}
    	
    	sttIdx++;
    	endIdx++;
	}
	
	System.out.print(answer);
}
*/