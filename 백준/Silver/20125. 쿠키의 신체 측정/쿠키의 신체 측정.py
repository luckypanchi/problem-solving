import sys

input = sys.stdin.readline


n = int(input())
board = [list(input().strip()) for _ in range(n)]


leftArm = 0
rightArm = 0
waist = 0
leftLeg = 0
rightLeg = 0

headY, headX = 0, 0
for i in range(n):
    flag = False
    for j in range(n):
        if board[i][j] == "*":
            headY, headX = i, j
            flag = True
            break

    if flag:
        break

heartY, heartX = headY + 1, headX

x = heartX - 1
while 0 <= x < n and board[heartY][x] == "*":
    leftArm += 1
    x -= 1

x = heartX + 1
while 0 <= x < n and board[heartY][x] == "*":
    rightArm += 1
    x += 1

y = heartY + 1
while 0 <= y < n and board[y][heartX] == "*":
    waist += 1
    y += 1

waistEndY = y

y = waistEndY
while 0 <= y < n and board[y][heartX - 1] == "*":
    leftLeg += 1
    y += 1

y = waistEndY
while 0 <= y < n and board[y][heartX + 1] == "*":
    rightLeg += 1
    y += 1

print(heartY + 1, heartX + 1)
print(leftArm, rightArm, waist, leftLeg, rightLeg)