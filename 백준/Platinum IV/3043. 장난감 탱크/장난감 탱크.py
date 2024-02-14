import sys

input = sys.stdin.readline


n = int(input())
tanks = [list(map(int, input().split())) + [i] for i in range(1, n + 1)]

answer = []

up = []
down = []

tanks.sort(key=lambda x: x[0])
for i in range(n):
    y = i + 1
    if tanks[i][0] < y:
        up.append(i)
    elif tanks[i][0] > y:
        down.append(i)

for i in range(len(down)):
    tankY, tankX, tankNumber = tanks[down[i]]
    targetY = down[i] + 1
    for _ in range(abs(targetY - tankY)):
        answer.append((tankNumber, "U"))

up.reverse()
for i in range(len(up)):
    tankY, tankX, tankNumber = tanks[up[i]]
    targetY = up[i] + 1
    for _ in range(abs(targetY - tankY)):
        answer.append((tankNumber, "D"))

right = []
left = []

tanks.sort(key=lambda x: x[1])
for i in range(n):
    x = i + 1
    if tanks[i][1] < x:
        right.append(i)
    elif tanks[i][1] > x:
        left.append(i)

for i in range(len(left)):
    tankY, tankX, tankNumber = tanks[left[i]]
    targetX = left[i] + 1
    for _ in range(abs(targetX - tankX)):
        answer.append((tankNumber, "L"))

right.reverse()
for i in range(len(right)):
    tankY, tankX, tankNumber = tanks[right[i]]
    targetX = right[i] + 1
    for _ in range(abs(targetX - tankX)):
        answer.append((tankNumber, "R"))

print(len(answer))
for ans in answer:
    print(*ans)