import sys

input = sys.stdin.readline


def solve(usedGems, currBag, left):
    if usedGems == (1 << n) - 1:
        return 0

    if dp[usedGems][currBag][left] != -1:
        return dp[usedGems][currBag][left]

    result = 0

    for i in range(n):
        if usedGems & (1 << i) != 0 or gems[i] > c:
            continue

        if gems[i] <= left:
            result = max(result, solve(usedGems | (1 << i), currBag, left - gems[i]) + 1)
        elif currBag + 1 < m:
            result = max(result, solve(usedGems | (1 << i), currBag + 1, c - gems[i]) + 1)

    dp[usedGems][currBag][left] = result
    return result


n, m, c = map(int, input().split())
gems = list(map(int, input().split()))
dp = [[[-1] * (c + 1) for _ in range(m)] for _ in range((1 << n) - 1)]

print(solve(0, 0, c))