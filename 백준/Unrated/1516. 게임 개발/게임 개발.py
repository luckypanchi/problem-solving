import sys
from collections import defaultdict

input = sys.stdin.readline

INF = float("inf")


def solve(curr):
    if dp[curr] == 0:
        dp[curr] = cost[curr]
        if len(prev[curr]) != 0:
            _max = -INF
            for p in prev[curr]:
                _max = max(_max, solve(p))
            dp[curr] += _max

    return dp[curr]


n = int(input())
cost = [0] * (n + 1)
dp = [0] * (n + 1)
prev = defaultdict(list)

for i in range(1, n + 1):
    row = list(map(int, input().split()))
    cost[i] = row[0]
    for j in range(1, len(row)):
        if row[j] == -1:
            break
        prev[i].append(row[j])

for i in range(1, n + 1):
    print(solve(i))