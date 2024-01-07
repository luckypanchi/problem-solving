import sys

input = sys.stdin.readline


code = input().strip()
n = len(code)
dp = [[0] * n for _ in range(n)]

for length in range(1, n):
    for start in range(n):
        end = start + length

        if n <= end:
            break

        if (code[start] == "a" and code[end] == "t") or (code[start] == "g" and code[end] == "c"):
            dp[start][end] = dp[start + 1][end - 1] + 2

        for mid in range(start, end):
            dp[start][end] = max(dp[start][end], dp[start][mid] + dp[mid + 1][end])

print(dp[0][-1])