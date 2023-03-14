import sys

input = sys.stdin.readline


def check(s, e):
    if dp[s][e] == -1:
        if numbers[s] == numbers[e] and (s + 1 == e or check(s + 1, e - 1) == 1):
            dp[s][e] = 1
        else:
            dp[s][e] = 0

    return dp[s][e]


n = int(input())
numbers = [0] + list(map(int, input().split()))
dp = [[-1] * (n + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    dp[i][i] = 1

for i in range(1, n + 1):
    for j in range(i, n + 1):
        check(i, j)


m = int(input())
for _ in range(m):
    s, e = map(int, input().split())
    print(dp[s][e])