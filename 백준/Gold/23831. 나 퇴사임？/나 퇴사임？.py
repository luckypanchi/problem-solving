import sys

input = sys.stdin.readline

INF = float("inf")


def solve(curr, count, isPrevLounge, relaxCount):
    if curr == n:
        if count < b:
            return -INF
        return 0

    if dp[curr][count][int(isPrevLounge)][relaxCount] != -1:
        return dp[curr][count][int(isPrevLounge)][relaxCount]

    result = -INF

    result = max(
        result,
        solve(curr + 1, count + 1, False, relaxCount) + max(manjok[curr][0], manjok[curr][1]),
    )
    if not isPrevLounge:
        result = max(result, solve(curr + 1, count, True, relaxCount) + manjok[curr][2])
    if relaxCount < a:
        result = max(result, solve(curr + 1, count, False, relaxCount + 1) + manjok[curr][3])

    dp[curr][count][int(isPrevLounge)][relaxCount] = result

    return result


n = int(input())
a, b = map(int, input().split())
manjok = [list(map(int, input().split())) for _ in range(n)]
dp = [[[[-1] * (a + 1) for _ in range(2)] for _ in range(n + 1)] for _ in range(n)]

print(solve(0, 0, False, 0))
