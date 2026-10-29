import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case + " ");

            st = new StringTokenizer(input.readLine());
            int dalent = Integer.parseInt(st.nextToken());
            int group = Integer.parseInt(st.nextToken());

            int defaultValue = dalent / group;
            int moreCount = dalent % group;

            long result = (long) Math.pow(defaultValue + 1, moreCount) * (long) Math.pow(defaultValue, group - moreCount);

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
