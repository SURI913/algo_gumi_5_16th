import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private String[] words;

    private void swap(int first, int second) {
        String temp = words[first];
        words[first] = words[second];
        words[second] = temp;
    }

    private void quickSort(int start, int end) {
        if (start >= end) return;

        String pivot = words[start];
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && pivot.compareTo(words[left]) > 0) left++;
            while (right > start && pivot.compareTo(words[right]) < 0) right--;
            if (left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }

        int center = right;
        swap(start, center);
        quickSort(start, center - 1);
        quickSort(center + 1, end);
    }

    private String[] splitWords(String line) {
        Set<String> words = new HashSet<>();

        for (int start = 0; start < line.length(); start++) {
            for (int end = start + 1; end < line.length() + 1; end++) {
                words.add(line.substring(start, end));
            }
        }

        return words.toArray(new String[0]);
    }

    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");

            int N = Integer.parseInt(input.readLine());
            sol.words = sol.splitWords(input.readLine());
            sol.quickSort(0, sol.words.length - 1);

            if (sol.words.length < N) sb.append("none\n");
            else sb.append(sol.words[N - 1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
