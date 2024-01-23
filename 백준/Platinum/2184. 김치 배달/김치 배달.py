import sys

input = sys.stdin.readline

INF = float("inf")


def solve(left, right, isRight):
    if left == 0 and right == n:
        return 0

    if dp[left][right][isRight] != -1:
        return dp[left][right][isRight]

    result = INF
    kimchi = n + 1 - (right - left + 1)

    if isRight == 0:
        if 0 <= left - 1:
            result = min(
                result,
                kimchi * abs(positions[left - 1] - positions[left]) + solve(left - 1, right, 0),
            )

        if right + 1 < n + 1:
            result = min(
                result,
                kimchi * abs(positions[right + 1] - positions[left]) + solve(left, right + 1, 1),
            )

    else:
        if 0 <= left - 1:
            result = min(
                result,
                kimchi * abs(positions[left - 1] - positions[right]) + solve(left - 1, right, 0),
            )

        if right + 1 < n + 1:
            result = min(
                result,
                kimchi * abs(positions[right + 1] - positions[right]) + solve(left, right + 1, 1),
            )

    dp[left][right][isRight] = result
    return result


n, start = map(int, input().split())
positions = sorted([start] + [int(input()) for _ in range(n)])
start = positions.index(start)

dp = [[[-1] * 2 for _ in range(n + 1)] for _ in range(n + 1)]

answer = solve(start, start, 0)

print(answer)