#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <string>
#include <queue>
#include <vector>
#include <tuple>
#include <utility>
#include <stdio.h>
using namespace std;
#define MAX 101
#define INF 987654321


int n;

int dr[4] = { 0,1,0,-1 };
int dc[4] = { 1,0,-1,0 };

int grid[MAX][MAX];

bool IsRange(int r, int c) {
	return r >= 0 && r < n && c >= 0 && c < n;
}

int Daj(int startR, int startC) {
	priority_queue<
		tuple<int, int, int>,
		vector<tuple<int, int,int >>,
		greater<tuple<int, int, int>>
	> pq;

	int dist[MAX][MAX];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			dist[i][j] = INF;
		}
	}
	dist[startR][startC] = 0;
	pq.push({ 0,startR, startC });

	while (!pq.empty()) {

		int currentW, currentR, currentC;
		tie(currentW, currentR, currentC) = pq.top();
		pq.pop();

		if (currentW > dist[currentR][currentC]) continue;

		for (int i = 0; i < 4; i++) {
			int nextR = currentR + dr[i];
			int nextC = currentC + dc[i];

			if (!IsRange(nextR, nextC)) continue;

			int nextW = grid[nextR][nextC] + currentW;

			if (nextW >= dist[nextR][nextC]) continue;
			
			dist[nextR][nextC] = nextW;
			pq.push({ nextW, nextR, nextC });
		}
	}

	return dist[n - 1][n - 1];
}

int main() {

	int T;
	//freopen("input.txt", "r", stdin);
	cin >> T;
	for (int test_case = 1; test_case <= T; test_case++) {
		cin >> n;
		for (int i = 0; i < n; i++) {
			string input;
			cin >> input;
			for (int j = 0; j < n; j++) {
				
				grid[i][j] = input[j] - '0';
			}
		}

		int result = Daj(0, 0);
		cout << "#" << test_case << " " << result << endl;
	}

	return 0;
}