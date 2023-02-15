import sys
from collections import deque

input = sys.stdin.readline

"""
# x로 물 붓는 경우
x + min(y, a - x), y - min(y, a - x), z
x + min(z, a - x), y, z - min(z, a - x)

# y로 물 붓는 경우
x - min(x, b - y), y + min(x, b - y), z
x, y + min(z, b - y), z - min(z, b - y)

# z로 물 붓는 경우
x - min(x, c - z), y, z + min(x, c - z)
x, y - min(y, c - z), z + min(y, c - z)

x -> y로 물 붓는 경우

현재 가지고 있는 물의 양과 가득 부을 수 있는 양
min(x, b-y)

a-x
b-y
c-z

"""

a, b, c = map(int, input().split())


que = deque()
que.append((0, 0, c))
visited = [(0, 0, c)]
answer = [c]

while que:
    x, y, z = que.popleft()

    ds = [
        [min(y, a - x), -min(y, a - x), 0],
        [min(z, a - x), 0, -min(z, a - x)],
        [-min(x, b - y), min(x, b - y), 0],
        [0, min(z, b - y), -min(z, b - y)],
        [-min(x, c - z), 0, min(x, c - z)],
        [0, -min(y, c - z), min(y, c - z)],
    ]

    for dx, dy, dz in ds:
        nx = x + dx
        ny = y + dy
        nz = z + dz

        if (nx, ny, nz) not in visited:
            visited.append((nx, ny, nz))
            que.append((nx, ny, nz))
            if nx == 0:
                answer.append(nz)


print(*sorted(answer))