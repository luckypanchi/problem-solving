import sys

input = sys.stdin.readline

INF = float("inf")


def f(num):
    return int((2 * num) ** 0.5)


n, m = map(int, input().split())
banned = set([int(input()) for _ in range(m)])

dp = [[INF] * (f(n) + 2) for _ in range(n + 1)]
dp[1][0] = 0

for stone in range(2, n + 1):
    if stone in banned:
        continue

    for jump in range(1, f(stone) + 1):
        dp[stone][jump] = (
            min(dp[stone - jump][jump - 1], dp[stone - jump][jump], dp[stone - jump][jump + 1]) + 1
        )

answer = min(dp[n])

if answer == INF:
    answer = -1

print(answer)