import sys
from collections import deque

input = sys.stdin.readline

dx = [-1, 1, -2, 2, -1, 1]
dy = [-2, -2, 0, 0, 2, 2]


def func(n, start, dest):
    visited = [[-1] * n for _ in range(n)]
    start_y, start_x = start
    dest_y, dest_x = dest
    visited[start_y][start_x] = 0

    que = deque()
    que.append(start)
    while que:
        y, x = que.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visited[ny][nx] == -1:
                que.append((ny, nx))
                visited[ny][nx] = visited[y][x] + 1

    return visited[dest_y][dest_x]


def main():
    n = int(input())
    r1, c1, r2, c2 = map(int, input().split())

    answer = func(n, (r1, c1), (r2, c2))

    print(answer)


main()
