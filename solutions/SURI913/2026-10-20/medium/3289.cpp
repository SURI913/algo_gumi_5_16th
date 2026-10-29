#include <iostream>
#include<string>
using namespace std;
#define MAX 1000001

int parent[MAX];

void setParent(int n) {
	for (int i = 1; i < n+1; i++) {
		parent[i] = i;
	}
}

int Find(int x) {
	if (parent[x] == x) return x;
	return parent[x] = Find(parent[x]);
}

void Union(int a, int b) {
	//이게문제네 루트를 찾아서 보내야함
	int rootA = Find(a);
	int rootB = Find(b);

	if (rootA != rootB) {
		//a자식 -> b로 만들기 같은 부모라는 뜻
		parent[rootB] = rootA;
	}
}

int main()
{
	int T;
	cin >> T;
	for (int test_case = 1; test_case <= T; test_case++) {
		int n, m;
		string result ="";
		cin >> n >> m; //n parent배열 초기화할 값, m 입력으로 주어지는 연산
		setParent(n);
		for (int i = 0; i < m; i++) {
			int t, a, b;
			cin >> t >> a >> b;
			if (t) {
				if (Find(a) == Find(b)) result += '1';
				else result += '0';
			}
			else Union(a, b);

		}


		cout << '#'<< test_case << " "<< result << endl;
	}
	return 0;
}