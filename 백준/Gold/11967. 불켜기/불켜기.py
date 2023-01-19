import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def main():
    n, m = map(int, input().split())
    lights = [[0] * n for _ in range(n)]
    available = [[[] for _ in range(n)] for _ in range(n)]

    for _ in range(m):
        y, x, b, a = map(lambda x: int(x) - 1, input().split())
        available[y][x].append((b, a))

    visited = [[0] * n for _ in range(n)]

    lights[0][0] = 1
    visited[0][0] = 1

    def check(y, x):
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visited[ny][nx] == 1:
                return True
        return False

    def bfs():
        que = deque()
        que.append((0, 0))
        result = 1

        while que:
            y, x = que.popleft()

            for b, a in available[y][x]:
                if lights[b][a] == 0:
                    lights[b][a] = 1
                    result += 1
                    if check(b, a):
                        visited[b][a] = 1
                        que.append((b, a))

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if (
                    0 <= nx < n
                    and 0 <= ny < n
                    and lights[ny][nx] == 1
                    and visited[ny][nx] == 0
                ):
                    visited[ny][nx] = 1
                    que.append((ny, nx))

        return result

    print(bfs())


main()
