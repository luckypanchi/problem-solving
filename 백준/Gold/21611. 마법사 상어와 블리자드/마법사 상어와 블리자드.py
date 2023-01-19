import sys
from collections import deque

input = sys.stdin.readline

dy = (0, 1, 0, -1)
dx = (-1, 0, 1, 0)

convert_d = {1: 3, 4: 2, 2: 1, 3: 0}


def flush():
    global marbles
    que = deque(marbles)
    que.append(que.popleft())
    for _ in range(n**2 - 1):
        poped = que.popleft()
        if poped != 0:
            que.append(poped)
    while len(que) != n**2:
        que.append(0)
    marbles = list(que)


def get_marbles():
    x, y = n // 2, n // 2
    marbles = []
    depth = 0

    while True:
        for i in range(4):
            if i % 2 == 0:
                depth += 1
            for _ in range(depth):
                marbles.append(matrix[y][x])
                x += dx[i]
                y += dy[i]
                if x == -1 and y == 0:
                    return marbles


def blizzard(d, length):
    global marbles
    idx = 0
    diff = 2 * d + 1
    for _ in range(length):
        idx += diff
        marbles[idx] = 0
        diff += 8
    flush()


def bomb():
    global marbles
    results = [0, 0, 0, 0]
    curr = marbles[1]
    cnt = 1
    for i in range(2, n**2):
        if curr == marbles[i]:
            cnt += 1
        else:
            if cnt >= 4:
                results[curr] += cnt
                for j in range(i - 1, i - 1 - cnt, -1):
                    marbles[j] = 0
            curr = marbles[i]
            cnt = 1
    flush()
    return results


def change():
    global marbles
    new_marbles = [0]
    curr = marbles[1]
    cnt = 1
    for i in range(2, n**2):
        if curr == marbles[i]:
            cnt += 1
        else:
            if len(new_marbles) < n**2:
                new_marbles.append(cnt)
            if len(new_marbles) < n**2:
                new_marbles.append(curr)
            curr = marbles[i]
            cnt = 1
    while len(new_marbles) != n**2:
        new_marbles.append(0)
    marbles = new_marbles


n, m = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]
magics = []
for _ in range(m):
    d, s = map(int, input().split())
    magics.append([convert_d[d], s])

answer = 0
marbles = get_marbles()

for d, s in magics:
    blizzard(d, s)
    flag = True
    while flag:
        results = bomb()
        if sum(results) == 0:
            flag = False
        for i in range(4):
            answer += i * results[i]
    change()


print(answer)
