import java.util.*;
import java.io.*;

class Solution {
	static int n;
	static boolean[] selected;
	static int[][] arr;
	static int min;
	
	//depth : 지금까지 몇개 선택했는지, start : 다음 식재료를 몇번부터 탐색할지
	static void dfs(int depth, int start) {
		if (depth == n / 2) {
			int a = 0;
			int b = 0;
			
			for (int i=0; i<n-1; i++) {
				for (int j=i+1; j<n; j++) {
					if (selected[i] && selected[j]) {
						a += arr[i][j];
						a += arr[j][i];
					}
					else if (!selected[i] && !selected[j]) {
						b += arr[i][j];
						b += arr[j][i];
					}
				}
			}
			
			min = Math.min(Math.abs(a - b), min);
			
			return;
		}
		
		for (int i=start; i<n; i++) {
			selected[i] = true;
			
			dfs(depth + 1, i + 1);
			
			selected[i] = false;
		}
	}
	
	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase=1; testCase<=T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			min = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for (int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			selected = new boolean[n];
			
			dfs(0, 0);
			
			sb.append(min).append("\n");
		}
		
		System.out.println(sb);
	}
}