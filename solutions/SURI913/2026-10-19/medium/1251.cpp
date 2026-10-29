#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <tuple>
#include <algorithm>
#include <stdio.h>
#include <cmath>

using namespace std;
#define MAX 1001
#define MAX_EDGE 500001

//크루스칼
int parent[MAX];
int depth[MAX];
int n;
double E;

long long x[MAX];
long long y[MAX]; 
//거리 계산용

tuple<long long, int, int> edges[MAX_EDGE]; //cost, from, to


void InitUnion(int n) {
	for (int i = 0; i <= n; i++) {
		parent[i] = i;
		depth[i] = 0;
	}
}

int Find(int x) {
	if (parent[x] == x) return x;

	return parent[x] = Find(parent[x]);
}

void Union(int a, int b) {
	int rootA = Find(a);
	int rootB = Find(b);

	if (rootA != rootB) {
		
		if (depth[rootA] < depth[rootB]) parent[rootA] = rootB;
		else if(depth[rootA] > depth[rootB])parent[rootB] = rootA;
		else {
			parent[rootB] = rootA;
			depth[rootA]++;
		}
	}
}

int Dist() {
	int edgeCnt = 0;

	//이거 가중치계산 우예하냐
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			long long dx = x[i] - x[j];
			long long dy = y[i] - y[j];

			long long dist = dx * dx + dy * dy;

			edges[edgeCnt++] = { dist, i,j };
		}
	}

	return edgeCnt;
}

long long K() {
	int edgeN = Dist();

	long long result = 0;
	int cnt = 0;

	sort(edges, edges + edgeN);

	for (int i = 0; i < edgeN; i++) {
		int from, to;
		long long cost;
		tie( cost, from, to ) = edges[i];
		//cout << cost << " " << from << " " << to << endl;
		if (Find(from) != Find(to)) {
			Union(from, to); //연결
			result += cost;
			cnt++;
		}
		if (cnt == n - 1) break;

	}
	return llround(result*E);
}

int main() {
	int T;
	//freopen("re_sample_input.txt", "r", stdin);
	cin >> T;

	for (int test_case = 1; test_case <= T; test_case++) {
		cin >> n;
		for (int i= 0; i < n; i++) {
			cin >> x[i];
		}
		for (int i = 0; i < n; i++) {
			cin >> y[i];
		}
		cin >> E;

		//이제 가중치 계산을 해보자
		InitUnion(n);
		long long result = K();

		cout << "#" << test_case << " " << result << endl;
	}

	return 0;
}