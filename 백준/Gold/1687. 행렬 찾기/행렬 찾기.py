import sys

input = sys.stdin.readline


n, m = map(int, input().split())
board = [[0] * (m + 1)] + [[0] + list(map(int, input().strip())) for _ in range(n)]
prefixSum = [[0] * (m + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, m + 1):
        if board[i][j] == 0:
            board[i][j] = 1
        elif board[i][j] == 1:
            board[i][j] = 0
        prefixSum[i][j] = (
            board[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1]
        )

answer = 0
for col1 in range(1, m + 1):
    for col2 in range(col1, m + 1):
        count = 0
        for row in range(1, n + 1):
            length = (
                prefixSum[row][col2]
                - prefixSum[row][col1 - 1]
                - prefixSum[row - 1][col2]
                + prefixSum[row - 1][col1 - 1]
            )

            if length == col2 - col1 + 1:
                count += length
                answer = max(answer, count)
            else:
                count = 0

print(answer)