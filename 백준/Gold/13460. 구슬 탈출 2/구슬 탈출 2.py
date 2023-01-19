import sys
from collections import deque

input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def main():
    n, m = map(int, input().split())
    matrix = [list(input().strip()) for _ in range(n)]
    visited = [[[[False] * m for _ in range(n)] for _ in range(m)] for _ in range(n)]

    for i in range(n):
        for j in range(m):
            if matrix[i][j] == "R":
                red = (i, j)
            elif matrix[i][j] == "B":
                blue = (i, j)

    def go(y, x, dy, dx):
        cnt = 0

        while matrix[y + dy][x + dx] != "#" and matrix[y][x] != "O":
            y += dy
            x += dx
            cnt += 1

        return (y, x, cnt)

    def bfs(start):
        nonlocal visited

        que = deque()
        que.append(start)

        while que:
            red_y, red_x, blue_y, blue_x, cnt = que.popleft()

            if cnt > 10:
                break

            for i in range(4):
                nred_y, nred_x, red_cnt = go(red_y, red_x, dy[i], dx[i])
                nblue_y, nblue_x, blue_cnt = go(blue_y, blue_x, dy[i], dx[i])

                if matrix[nblue_y][nblue_x] != "O":
                    if matrix[nred_y][nred_x] == "O":
                        print(cnt)
                        return

                    if nred_y == nblue_y and nred_x == nblue_x:
                        if red_cnt < blue_cnt:
                            nblue_y -= dy[i]
                            nblue_x -= dx[i]
                        else:
                            nred_y -= dy[i]
                            nred_x -= dx[i]

                    if not visited[nred_y][nred_x][nblue_y][nblue_x]:
                        visited[nred_y][nred_x][nblue_y][nblue_x] = True
                        que.append((nred_y, nred_x, nblue_y, nblue_x, cnt + 1))

        print(-1)

    visited[red[0]][red[1]][blue[0]][blue[1]] = True

    bfs((red[0], red[1], blue[0], blue[1], 1))


main()
