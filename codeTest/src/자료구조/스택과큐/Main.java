package 자료구조.스택과큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		/**
		 * 문제 2
		 * 
		 * 크기가 n인 수열A가 있다. 수열의 각 원소에 관련된 오큰수 NGE(i)를 구하려고 한다.
		 * A(i)오큰수란 A(i)보다 오른쪽에 위치하면서 A(i)보다 큰수 중 가장 왼쪽에 있는 수를 의미한다.
		 * 이러한 수가 없을 경우 오큰수는 -1이된다
		 * 예를들어 A=[3,5,2,7] 일 때 NGE(1)=5, NGE(2)=7, NGE(3)=7, NGE(4)=-1 이다
		 * A=[9,5,4,8] 일 때 NGE(1)=-1, NGE(2)=8, NGE(3)=8, NGE(4)=-1 이다
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];		//수열 생성
		int[] answer = new int[n];	//정답 배열 생성
		String[] str = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);	//처음 스택 0으로 초기화
		
		for(int i=1; i<n; i++) {
			//스택이 비어있지 않고 현재 수열이 스택 top인덱스가 가리키는 수열보다 큰 경우
			while(!stack.empty() && arr[stack.peek()] < arr[i]) {
				answer[stack.pop()] = arr[i]; //정답 배열에 오큰수를 현재 수열로 지정
			}
			stack.push(i);	//신규 데이터 push
		}
		
		while(stack.empty()) {
			//반복문을 다 돈 후 스택이 비어있지 않으면 빌 때까지 -1
			answer[stack.pop()] = -1;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<n; i++) {
			bw.write(answer[i] + " ");
		}
		
		bw.write("\n");
		bw.flush();
		
	}

}


/**
 * 문제 1
 * 
 * 1부터 n까지의 수를 스택에 저장하고 출력하는 방식으로 하나의 수열을 만들 수 있다.
 * 이때 1부터 오름차순으로 스택에 push한다고 가정한다. 수열이 주어졌을 때 이 방식으로 주어진 수열을 만들 수 있는지
 * 확인하고 만들 수 있다면 어떤 순서로 push와 pop을 해야하는지 프로그램을 작성해보자
 * 
 * 입력
 * 1번째 줄에는 수열의 개수 n이 주어진다
 * 2번째 줄 ~ n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 1개씩 주어진다.
 * 이 때 같은 정수는 두 번이상 나오지 않는다.
 * 
 * 출력
 * 오름차순 수열을 만들기 위한 연산 순서를 출력한다.
 * push연산은 +
 * pop연산은 -
 * 불가능은 no로 출력한다
 * 
 * 예제 입력1              예제 입력 2
 * 8					  5			//수열의 개수 
 * 4					  1
 * 3					  2
 * 6					  5
 * 8					  3
 * 7					  4
 * 5
 * 2
 * 1
 * 
 * 예제 출력1				예제 출력2
 * +					  NO
 * +
 * +
 * +
 * -
 * -
 * +
 * +
 * -
 * +
 * +
 * -
 * -
 * -
 * -
 * -
 * 
 
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int[] arr = new int[n];

for(int i=0; i<n; i++) {
	arr[i] = sc.nextInt();
}

Stack<Integer> stack = new Stack<>();
StringBuffer bf = new StringBuffer();
int num = 1;
boolean result = true;

for(int i=0; i<arr.length; i++) {
	
	int su = arr[i];	//현재 수열의 수
	
	if(su >= num) {		//현재 수열 값 >= 오름차순 자연수: 값이 같아질 때 까지 push
		while(su >= num) {
			stack.push(num++);
			bf.append("+\n");
		}
		stack.pop();
		bf.append("-\n");
	} else {			//현재 수열 값 < 오름차순 자연수: pop
		int m = stack.pop();
		//스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없음
		if(m > su) {
			System.out.print("NO");
			result = false;
			break;
		} else {
			bf.append("-\n");
		}
	}
}

if(result) {
	System.out.print(bf.toString());
}
*/