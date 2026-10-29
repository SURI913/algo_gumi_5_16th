#include<iostream>
#include<vector>
#include <algorithm>
using namespace std;
#define MAX 11

int grid[MAX][MAX];
int profit[MAX][MAX];
int N, M, C;
vector<int> selected;

//부분 집합
 int DFS(int index, int honeySum, int profitSum) {
	 
	 if (honeySum > C) {
		 //합이 C를 넘으면 안됨
		 return 0;
	 }

	 if (index == selected.size()) {
		 // M개의 꿀을 모두 선택/미선택 결정 완료
		 return profitSum;
	 }


	 // 현재 꿀 선택
	 int select = DFS(index + 1, honeySum + selected[index], profitSum + selected[index]* selected[index]);

	 // 현재 꿀 선택 안 함
	 int skip = DFS(index + 1, honeySum, profitSum);

	 return max(select, skip);
}

int main() {
	int T;
	cin >> T;
	for (int test_case = 1; test_case <= T; test_case++) {
		cin >> N >> M >> C;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cin >> grid[i][j];
			}
			
		}

		int result = 0;

		for (int i = 0; i < N; i++) {
			//가로로만 체취 가능
			for (int j = 0; j <= N - M; j++) {
				selected.clear();
				for (int k = 0; k < M; k++) {
					selected.push_back(grid[i][j + k]);
				}
				profit[i][j] = DFS(0, 0, 0);
				//구간합 최대 수익 계산

			}
		}

		//구간 선택해서 합구하기
		for (int r1 = 0; r1 < N; r1++) {
			for (int c1 = 0; c1 <= N - M; c1++) {

				for (int r2 = 0; r2 < N; r2++) {
					for (int c2 = 0; c2 <= N - M; c2++) {

						// 두 구간이 겹치는지 검사
						if (r1 == r2 && !(c1 + M <= c2 || c2 + M <= c1)) continue;
						result = max(result,profit[r1][c1] + profit[r2][c2]);
					}
				}
			}
		}

		cout << "#" << test_case << " " << result << endl;

	}
	return 0;
}