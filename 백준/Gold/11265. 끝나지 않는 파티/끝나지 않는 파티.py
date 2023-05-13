import sys

input = sys.stdin.readline

INF = float("inf")


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]


for z in range(n):
    for y in range(n):
        for x in range(n):
            board[y][x] = min(board[y][x], board[y][z] + board[z][x])

for _ in range(m):
    a, b, c = map(int, input().split())
    if board[a - 1][b - 1] <= c:
        print("Enjoy other party")
    else:
        print("Stay here")