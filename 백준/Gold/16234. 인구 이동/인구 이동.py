import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def main():
    n, l, r = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    answer = 0

    while True:
        visited = [[0] * n for _ in range(n)]
        que = deque()
        flag = True
        for i in range(n):
            for j in range(n):
                if visited[i][j] == 0:
                    que.append((i, j))
                    visited[i][j] = 1
                    arr = [(i, j)]
                    tmp = matrix[i][j]
                    while que:
                        y, x = que.popleft()
                        for k in range(4):
                            ny = y + dy[k]
                            nx = x + dx[k]
                            if (
                                0 <= ny < n
                                and 0 <= nx < n
                                and visited[ny][nx] == 0
                                and l <= abs(matrix[ny][nx] - matrix[y][x]) <= r
                            ):
                                visited[ny][nx] = 1
                                que.append((ny, nx))
                                arr.append((ny, nx))
                                tmp += matrix[ny][nx]
                    if len(arr) > 1:
                        flag = False
                        s = tmp // len(arr)

                        for p in arr:
                            y, x = p
                            matrix[y][x] = s
        if flag:
            break
        answer += 1

    print(answer)


main()
