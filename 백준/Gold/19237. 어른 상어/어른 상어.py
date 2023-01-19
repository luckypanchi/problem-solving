import sys

input = sys.stdin.readline

# 위 아 왼 오
dx = (0, 0, -1, 1)
dy = (-1, 1, 0, 0)


def main():
    n, m, k = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    current_directions = list(map(lambda x: int(x) - 1, input().split()))
    directions = []
    for _ in range(m):
        directions.append(
            [list(map(lambda x: int(x) - 1, input().split())) for _ in range(4)]
        )

    sharks = [1] * m
    positions = [0] * m
    for i in range(n):
        for j in range(n):
            if matrix[i][j] != 0:
                idx = matrix[i][j] - 1
                positions[idx] = (i, j)
                matrix[i][j] = [k, idx + 1]

    def move(y, x, idx):
        d = current_directions[idx]
        direction = directions[idx][d]
        for i in direction:
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if matrix[ny][nx] == 0:
                    return (ny, nx, i)
        for i in direction:
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if matrix[ny][nx][1] == idx + 1:
                    return (ny, nx, i)

    for time in range(1, 1001):

        check = [[0] * n for _ in range(n)]

        for idx in range(m):
            if sharks[idx] == 1:
                y, x = positions[idx]
                ny, nx, nd = move(y, x, idx)
                positions[idx] = (ny, nx)
                current_directions[idx] = nd

                if check[ny][nx] == 0 or idx + 1 < check[ny][nx]:
                    if idx + 1 < check[ny][nx]:
                        sharks[check[ny][nx] - 1] = 0
                    check[ny][nx] = idx + 1
                else:
                    sharks[idx] = 0

        for i in range(n):
            for j in range(n):
                if matrix[i][j] != 0:
                    matrix[i][j][0] -= 1
                    if matrix[i][j][0] == 0:
                        matrix[i][j] = 0

        for idx in range(m):
            if sharks[idx] == 1:
                y, x = positions[idx]
                matrix[y][x] = [k, idx + 1]

        if sum(sharks) == 1:
            print(time)
            return

    print(-1)


main()
