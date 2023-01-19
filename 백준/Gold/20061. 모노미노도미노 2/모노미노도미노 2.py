import sys


input = sys.stdin.readline


def go_green(green, t, x):
    y = 0
    if t == 2:
        while y < 5 and green[y + 1][x] == 0 and green[y + 1][x + 1] == 0:
            y += 1
        green[y][x] = 1
        green[y][x + 1] = 1
    else:
        while y < 5 and green[y + 1][x] == 0:
            y += 1
        green[y][x] = 1
        if t == 3:
            green[y - 1][x] = 1

    point = 0
    rows = []

    for i in range(2, 6):
        total = 0
        for j in range(4):
            total += green[i][j]
        if total == 4:
            rows.append(i)
            point += 1
            for j in range(4):
                green[i][j] = 0

    for row in rows:
        for i in range(row, 0, -1):
            for j in range(4):
                green[i][j] = green[i - 1][j]

    cnt = 0

    for i in range(2):
        for j in range(4):
            if green[i][j] == 1:
                cnt += 1
                break

    for i in range(5, 1, -1):
        for j in range(4):
            green[i][j] = green[i - cnt][j]

    for i in range(2):
        for j in range(4):
            green[i][j] = 0

    return point


def go_blue(blue, t, y):
    x = 0
    if t == 3:
        while x < 5 and blue[y][x + 1] == 0 and blue[y + 1][x + 1] == 0:
            x += 1
        blue[y][x] = 1
        blue[y + 1][x] = 1
    else:
        while x < 5 and blue[y][x + 1] == 0:
            x += 1
        blue[y][x] = 1
        if t == 2:
            blue[y][x - 1] = 1

    point = 0
    columns = []

    for j in range(2, 6):
        total = 0
        for i in range(4):
            total += blue[i][j]
        if total == 4:
            columns.append(j)
            point += 1
            for i in range(4):
                blue[i][j] = 0

    for column in columns:
        for i in range(4):
            for j in range(column, 0, -1):
                blue[i][j] = blue[i][j - 1]

    cnt = 0

    for j in range(2):
        for i in range(4):
            if blue[i][j] == 1:
                cnt += 1
                break

    for j in range(5, 1, -1):
        for i in range(4):
            blue[i][j] = blue[i][j - cnt]

    for j in range(2):
        for i in range(4):
            blue[i][j] = 0

    return point


n = int(input())

blocks = [list(map(int, input().split())) for _ in range(n)]

red = [[0] * 4 for _ in range(4)]
green = [[0] * 4 for _ in range(6)]
blue = [[0] * 6 for _ in range(4)]

answer = 0

for i in range(n):
    t, y, x = blocks[i]
    answer += go_green(green, t, x)
    answer += go_blue(blue, t, y)

cnt = 0

for i in range(6):
    for j in range(4):
        cnt += green[i][j]


for i in range(4):
    for j in range(6):
        cnt += blue[i][j]

print(answer)
print(cnt)
