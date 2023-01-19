import sys
from collections import deque

input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]


def pArr(arr):
    for i in arr:
        print(i)


def main():
    n, m = map(int, input().split())
    matrix = [list(map(int, input().strip())) for _ in range(n)]
    visited = [[[0] * m for _ in range(n)] for _ in range(2)]

    def bfs():
        que = deque()
        que.append((0, 0, 0))
        visited[0][0][0] = 1
        while que:
            y, x, cnt = que.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if (
                    0 <= nx < m
                    and 0 <= ny < n
                    and visited[cnt][ny][nx] == 0
                    and matrix[ny][nx] == 0
                ):
                    visited[cnt][ny][nx] = visited[cnt][y][x] + 1
                    que.append((ny, nx, cnt))
                if (
                    cnt == 0
                    and 0 <= nx < m
                    and 0 <= ny < n
                    and visited[cnt + 1][ny][nx] == 0
                    and matrix[ny][nx] == 1
                ):
                    visited[cnt + 1][ny][nx] = visited[cnt][y][x] + 1
                    que.append((ny, nx, 1))

    bfs()

    result_1 = visited[0][n - 1][m - 1]
    result_2 = visited[1][n - 1][m - 1]

    if result_1 and result_2:
        answer = min(result_1, result_2)
    elif result_1:
        answer = result_1
    elif result_2:
        answer = result_2
    else:
        answer = -1
    print(answer)


main()
