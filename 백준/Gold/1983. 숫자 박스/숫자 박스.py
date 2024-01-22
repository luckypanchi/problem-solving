import sys

input = sys.stdin.readline

INF = float("inf")


def solve(length, idx1, idx2):
    if length <= idx1 or length <= idx2:
        return -INF

    if length == 0 or idx1 == -1 or idx2 == -1:
        return 0

    if dp[length][idx1][idx2] != -INF:
        return dp[length][idx1][idx2]

    dp[length][idx1][idx2] = max(
        solve(length - 1, idx1 - 1, idx2),
        solve(length - 1, idx1, idx2 - 1),
        solve(length - 1, idx1 - 1, idx2 - 1) + box1[idx1] * box2[idx2],
    )

    return dp[length][idx1][idx2]


n = int(input())
box1 = [x for x in list(map(int, input().split())) if x != 0]
box2 = [x for x in list(map(int, input().split())) if x != 0]

dp = [[[-INF] * len(box2) for _ in range(len(box1))] for _ in range(n + 1)]

answer = solve(n, len(box1) - 1, len(box2) - 1)

print(answer)