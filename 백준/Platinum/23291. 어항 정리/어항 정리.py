import sys

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def get_rolled_idx_map():
    r = h
    c = w + leftover

    rolled_idx_map = [[0] * c for _ in range(r)]
    idx = n

    for x in range(c - 1, -1, -1):
        rolled_idx_map[r - 1][x] = idx
        idx -= 1

    y, x = r - 1, 0
    _h, _w = h, w
    d = 3

    while 0 < idx:
        t = _w if d % 2 == 0 else _h

        for _ in range(t - 1):
            y += dy[d]
            x += dx[d]
            rolled_idx_map[y][x] = idx
            idx -= 1

        if d % 2 == 0:
            _w -= 1
        else:
            _h -= 1

        d = (d + 1) % 4

    return rolled_idx_map


def add_fish():
    indexes = []
    _m = int(1e9)

    for i in range(n):
        if _m == fishes[i]:
            indexes.append(i)
        elif fishes[i] < _m:
            _m = fishes[i]
            indexes = [i]

    for i in indexes:
        fishes[i] += 1


def roll1():
    r = h
    c = w + leftover

    rolled = [[0] * c for _ in range(r)]
    for i in range(r):
        for j in range(c):
            idx = rolled_idx_map[i][j]
            if idx != 0:
                rolled[i][j] = fishes[idx - 1]

    return rolled


def roll2():
    length = n // 4
    rolled = [[0] * length for _ in range(4)]

    idx = 0
    for i in range(length - 1, -1, -1):
        rolled[2][i] = fishes[idx]
        idx += 1
    for i in range(length):
        rolled[1][i] = fishes[idx]
        idx += 1
    for i in range(length - 1, -1, -1):
        rolled[0][i] = fishes[idx]
        idx += 1
    for i in range(length):
        rolled[3][i] = fishes[idx]
        idx += 1

    return rolled


def spread(rolled):
    r = len(rolled)
    c = len(rolled[0])

    visited = [[False] * c for _ in range(r)]
    ops = [[0] * c for _ in range(r)]
    for y in range(r):
        for x in range(c):
            if rolled[y][x] != 0 and not visited[y][x]:
                visited[y][x] = True
                for i in range(4):
                    ny = y + dy[i]
                    nx = x + dx[i]
                    if (
                        0 <= ny < r
                        and 0 <= nx < c
                        and not visited[ny][nx]
                        and rolled[ny][nx] != 0
                    ):
                        diff = abs(rolled[y][x] - rolled[ny][nx]) // 5
                        if 0 < diff:
                            if rolled[y][x] < rolled[ny][nx]:
                                ops[y][x] += diff
                                ops[ny][nx] -= diff
                            else:
                                ops[y][x] -= diff
                                ops[ny][nx] += diff

    for y in range(r):
        for x in range(c):
            rolled[y][x] += ops[y][x]


def get_flattened(rolled):
    global fishes

    r = len(rolled)
    c = len(rolled[0])

    new_fishes = [0] * n
    idx = 0
    for j in range(c):
        for i in range(r - 1, -1, -1):
            if rolled[i][j]:
                new_fishes[idx] = rolled[i][j]
                idx += 1

    fishes = new_fishes


def check():
    _m = min(fishes)
    _M = max(fishes)

    return _M - _m <= k


n, k = map(int, input().split())
fishes = list(map(int, input().split()))

roll_cnt = 0
h, w = 0, 0

while True:
    if h * w <= n < h * w + h:
        break

    roll_cnt += 1
    if roll_cnt % 2 == 0:
        w = roll_cnt // 2 + 1
        h = w
    else:
        w = (roll_cnt + 1) // 2
        h = w + 1

leftover = n - h * w

rolled_idx_map = get_rolled_idx_map()

answer = 0
while True:
    if check():
        break

    add_fish()
    rolled = roll1()
    spread(rolled)
    get_flattened(rolled)
    rolled = roll2()
    spread(rolled)
    get_flattened(rolled)
    answer += 1

print(answer)