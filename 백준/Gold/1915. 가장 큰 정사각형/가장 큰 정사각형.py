import sys

input = sys.stdin.readline


n, m = map(int, input().split())
board = [list(map(int, input().strip())) for _ in range(n)]


answer = 0
for i in range(n):
    for j in range(m):
        if i > 0 and j > 0 and board[i][j] != 0:
            board[i][j] += min(board[i - 1][j], board[i][j - 1], board[i - 1][j - 1])
        answer = max(answer, board[i][j])


print(answer * answer)

"""
3 3
000
000
100
"""