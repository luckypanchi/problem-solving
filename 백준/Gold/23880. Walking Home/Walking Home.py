import sys

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def solve(curr, prev, count):
    if curr == n * n - 1:
        return 1

    if dp[curr][prev][count] != -1:
        return dp[curr][prev][count]

    y = curr // n
    x = curr % n

    if board[y][x] == "H":
        return 0

    result = 0

    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < n and 0 <= nx < n:
            nextNode = ny * n + nx
            if abs(prev - i) == 2:
                continue

            if prev == i:
                result += solve(nextNode, i, count)
            elif count < k:
                result += solve(nextNode, i, count + 1)

    dp[curr][prev][count] = result
    return result


tc = int(input())
for _ in range(tc):
    n, k = map(int, input().split())
    board = [list(input().strip()) for _ in range(n)]
    dp = [[[-1] * (k + 1) for _ in range(4)] for _ in range(n * n)]

    print(solve(1, 0, 0) + solve(n, 1, 0))
