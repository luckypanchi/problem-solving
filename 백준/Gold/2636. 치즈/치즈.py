import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def pArr(arr):
    for i in arr:
        print(i)


def main():
    n, m = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    total_cnt = 0
    for arr in matrix:
        total_cnt += sum(arr)

    time = 0

    while True:
        time += 1

        que = deque()
        visited = [[0] * m for _ in range(n)]
        que.append((0, 0))
        visited[0][0] = 1
        melt = []

        while que:
            y, x = que.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < m and 0 <= ny < n and not visited[ny][nx]:
                    visited[ny][nx] = 1
                    if matrix[ny][nx] == 1:
                        melt.append((ny, nx))
                    else:
                        que.append((ny, nx))

        if total_cnt - len(melt) == 0:
            break
        else:
            total_cnt -= len(melt)

        for y, x in melt:
            matrix[y][x] = 0

    print(time)
    print(total_cnt)


main()
