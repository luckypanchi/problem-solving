import sys

sys.setrecursionlimit = 10**6

input = sys.stdin.readline

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]


n, m = map(int, input().split())
r, c, d = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]

answer = 1
matrix[r][c] = -1


def go(y, x, d):
    global answer

    direct = d

    for _ in range(4):
        direct = (direct + 3) % 4
        nx = x + dx[direct]
        ny = y + dy[direct]

        if matrix[ny][nx] == 1:
            continue

        if matrix[ny][nx] == 0:
            matrix[ny][nx] = -1
            answer += 1
            go(ny, nx, direct)
            return

    direct = (d + 2) % 4
    nx = x + dx[direct]
    ny = y + dy[direct]

    if matrix[ny][nx] == 1:
        return

    else:
        go(ny, nx, d)


go(r, c, d)

print(answer)
