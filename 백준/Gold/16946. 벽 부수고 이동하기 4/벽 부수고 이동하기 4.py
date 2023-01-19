import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, -1, 0, 1)


def main():
    n, m = map(int, input().split())
    matrix = [list(map(int, input().strip())) for _ in range(n)]

    mark = [[-1] * m for _ in range(n)]
    count = []

    def bfs(start):
        nonlocal mark, count
        mark_num = len(count)
        cnt = 0
        que = deque()
        que.append(start)
        y, x = start
        mark[y][x] = mark_num
        while que:
            y, x = que.popleft()
            cnt += 1
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if (
                    0 <= nx < m
                    and 0 <= ny < n
                    and matrix[ny][nx] == 0
                    and mark[ny][nx] == -1
                ):
                    que.append((ny, nx))
                    mark[ny][nx] = mark_num
        count.append(cnt)

    for i in range(n):
        for j in range(m):
            if matrix[i][j] == 0 and mark[i][j] == -1:
                bfs((i, j))

    for y in range(n):
        for x in range(m):
            if matrix[y][x] == 0:
                print(0, end="")
            else:
                near = set()
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0 <= nx < m and 0 <= ny < n and mark[ny][nx] != -1:
                        near.add(mark[ny][nx])
                acc = 1
                for mark_num in near:
                    acc += count[mark_num]
                print(acc % 10, end="")
        print()


main()