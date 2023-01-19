import sys

input = sys.stdin.readline

move_dx = (0, -1, -1, 0, 1, 1, 1, 0, -1)
move_dy = (0, 0, -1, -1, -1, 0, 1, 1, 1)

rain_dx = (-1, 1, 1, -1)
rain_dy = (-1, -1, 1, 1)


def main():
    n, m = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    moves = [list(map(int, input().split())) for _ in range(m)]

    clouds = [(n - 1, 0), (n - 1, 1), (n - 2, 0), (n - 2, 1)]

    for idx in range(m):
        d, s = moves[idx]

        for index, cloud in enumerate(clouds):
            y, x = cloud
            nx = (x + s * move_dx[d]) % n
            ny = (y + s * move_dy[d]) % n
            matrix[ny][nx] += 1
            clouds[index] = (ny, nx)

        for cloud in clouds:
            y, x = cloud
            cnt = 0
            for i in range(4):
                nx = x + rain_dx[i]
                ny = y + rain_dy[i]
                if 0 <= nx < n and 0 <= ny < n and matrix[ny][nx] != 0:
                    cnt += 1
            matrix[y][x] += cnt

        tmp = []

        for i in range(n):
            for j in range(n):
                if matrix[i][j] > 1 and (i, j) not in clouds:
                    tmp.append((i, j))
                    matrix[i][j] -= 2

        clouds = tmp

    answer = 0

    for i in range(n):
        for j in range(n):
            answer += matrix[i][j]

    print(answer)


main()
