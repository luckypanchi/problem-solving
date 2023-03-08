import sys

input = sys.stdin.readline


n = int(input())
w = [list(map(int, input().split())) for _ in range(n)]
w.sort(key=lambda x: x[0])
b = [x[1] for x in w]
dp = [1] * n

for i in range(n):
    for j in range(i):
        if b[j] < b[i]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))