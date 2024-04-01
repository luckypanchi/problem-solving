import sys

input = sys.stdin.readline


n, m = map(int, input().split())
k = int(input())
board = [list(input().strip()) for _ in range(n)]
boardCount = [[[0, 0, 0] for _ in range(m + 1)] for _ in range(n + 1)]
for i in range(1, n + 1):
    for j in range(1, m + 1):
        for t in range(3):
            boardCount[i][j][t] = boardCount[i - 1][j][t] + boardCount[i][j - 1][t] - boardCount[i - 1][j - 1][t]  # fmt: skip
        if board[i - 1][j - 1] == "J":
            boardCount[i][j][0] += 1
        elif board[i - 1][j - 1] == "O":
            boardCount[i][j][1] += 1
        elif board[i - 1][j - 1] == "I":
            boardCount[i][j][2] += 1

for _ in range(k):
    a, b, c, d = map(int, input().split())
    result = [0] * 3
    for i in range(3):
        result[i] = boardCount[c][d][i] - boardCount[c][b - 1][i] - boardCount[a - 1][d][i] + boardCount[a - 1][b - 1][i]  # fmt: skip

    print(*result)