#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>

using namespace std;
int dp[61][61][61];
int N;
int scv[3];


int  solve(int a, int b, int c) {
	if (a < 0)
		a = 0;
	if (b < 0)
		b = 0;
	if (c < 0)
		c = 0;
	if (!a&!b&!c)
		return 0;
	int& res = dp[a][b][c];
	
	if (res != -1) {
		return res;
	}
	res = 1e9;
	res = min(res, solve(a - 9, b - 3, c - 1)+1);
	res = min(res, solve(a - 9, b - 1, c - 3)+1);
	res = min(res, solve(a - 3, b - 9, c - 1)+1);
	res = min(res, solve(a - 3, b - 1, c - 9)+1);
	res = min(res, solve(a - 1, b - 9, c - 3)+1);
	res = min(res, solve(a - 1, b - 3, c - 9)+1);
	return res;


}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> scv[i];
	}
	memset(dp, -1, sizeof(dp));
	cout<<solve(scv[0],scv[1],scv[2]);

	return 0;
}