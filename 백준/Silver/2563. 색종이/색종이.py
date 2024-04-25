import sys

input = sys.stdin.readline


board = [[0] * 101 for _ in range(101)]

n = int(input())
for _ in range(n):
    startX, startY = map(int, input().split())
    for x in range(startX, startX + 10):
        for y in range(startY, startY + 10):
            board[x][y] = 1

answer = 0
for i in range(101):
    for j in range(101):
        answer += board[i][j]

print(answer)