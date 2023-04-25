import sys

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def convert(s):
    if s == "R":
        return 0
    elif s == "D":
        return 1
    elif s == "L":
        return 2
    elif s == "U":
        return 3


def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])

    return parents[x]


def union(x, y):
    x = find(x)
    y = find(y)

    if x == y:
        return

    if x < y:
        parents[y] = x
    elif y < x:
        parents[x] = y


n, m = map(int, input().split())
board = [list(map(convert, input().strip())) for _ in range(n)]

parents = list(range(n * m))

for idx in range(n * m):
    x = idx % m
    y = idx // m
    d = board[y][x]

    ny = y + dy[d]
    nx = x + dx[d]
    nidx = m * ny + nx

    if 0 <= nidx < n * m:
        union(idx, nidx)


for idx in parents:
    find(idx)

visited = set()
answer = 0

for idx in range(n * m):
    p = find(parents[idx])
    if p not in visited:
        visited.add(p)
        answer += 1


print(answer)