import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	static int N, M;
	static ArrayList<String[]> arr;
	static int cur;
	static Stack<String> leftSt,rightSt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		M = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();

		// statck 구조 사용
		leftSt = new Stack<String>();
		rightSt = new Stack<String>();

		String[] starr = str.split("");
		for (String s : starr) {
			leftSt.push(s);
		}

		cur = str.length();
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			arr.add(tmp.split(" "));

			if (arr.get(i)[0].equals("L")) {
				L();
			} else if (arr.get(i)[0].equals("D")) {
				D();
			} else if (arr.get(i)[0].equals("B")) {
				B();
			} else {// P
				P(arr.get(i)[1]);
			}
		}

		while (!leftSt.isEmpty())
			rightSt.push(leftSt.pop());

		while (!rightSt.isEmpty())
			bw.write(rightSt.pop());

		bw.flush();
		bw.close();
	}// main

	private static void P(String s) {
		leftSt.push(s);
	}

	private static void B() {
		if (!leftSt.isEmpty()) {
			leftSt.pop();
		}

	}

	private static void D() {
		if (!rightSt.isEmpty())
			leftSt.push(rightSt.pop());
	}

	private static void L() {
		if (!leftSt.isEmpty())
			rightSt.push(leftSt.pop());
	}

}