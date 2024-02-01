import sys

input = sys.stdin.readline

INF = float("inf")


def solve(left, right, isRight, remainCount):
    if remainCount == 0:
        return 0

    if dp[left][right][isRight] != -1:
        return dp[left][right][isRight]

    result = INF

    if isRight == 0 and left - 1 >= 0:  # 왼
        result = min(
            result,
            solve(left - 1, right, 0, remainCount - 1)
            + (positions[left] - positions[left - 1]) * remainCount,
        )

    if isRight == 0 and right + 1 < n:
        result = min(
            result,
            solve(left, right + 1, 1, remainCount - 1)
            + (positions[right + 1] - positions[left]) * remainCount,
        )

    if isRight == 1 and left - 1 >= 0:  # 오
        result = min(
            result,
            solve(left - 1, right, 0, remainCount - 1)
            + (positions[right] - positions[left - 1]) * remainCount,
        )

    if isRight == 1 and right + 1 < n:
        result = min(
            result,
            solve(left, right + 1, 1, remainCount - 1)
            + (positions[right + 1] - positions[right]) * remainCount,
        )

    dp[left][right][isRight] = result
    return result


n, m = map(int, input().split())
positions = [int(input()) for _ in range(n)]
isExists = 0 in positions

if not isExists:
    positions.append(0)
    n += 1

positions.sort()
start = positions.index(0)
answer = -INF
for remainCount in range(n):
    dp = [[[-1] * 2 for _ in range(n)] for _ in range(n)]
    answer = max(answer, m * remainCount - solve(start, start, 0, remainCount))

if isExists:
    answer += m

print(answer)