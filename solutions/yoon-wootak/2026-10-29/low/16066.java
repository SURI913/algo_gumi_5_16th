import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] book = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				book[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = -1;
			for (int i=0; i<N; i++) {
				int count = 0;
				for (int j=i+1; j<N; j++) {
					if (book[i] > book[j]) {
						count++;
					}
				}
				max = Math.max(max, count);
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}
}