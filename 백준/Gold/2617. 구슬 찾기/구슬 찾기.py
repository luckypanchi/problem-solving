import sys

input = sys.stdin.readline


n, m = map(int, input().split())
board = [[0] * (n + 1) for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    board[a][b] = 1
    board[b][a] = -1

for mid in range(1, n + 1):
    for start in range(1, n + 1):
        for end in range(1, n + 1):
            if board[start][mid] == 1 and board[mid][end] == 1:
                board[start][end] = 1
            elif board[start][mid] == -1 and board[mid][end] == -1:
                board[start][end] = -1

heavierCount = [0] * (n + 1)
lighterCount = [0] * (n + 1)

for start in range(1, n + 1):
    for end in range(1, n + 1):
        if board[start][end] == 1:
            heavierCount[start] += 1
        elif board[start][end] == -1:
            lighterCount[start] += 1

answer = 0
p = (n + 1) // 2
for i in range(1, n + 1):
    if p <= heavierCount[i] or p <= lighterCount[i]:
        answer += 1

print(answer)
