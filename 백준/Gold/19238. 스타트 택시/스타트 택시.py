import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def main():
    n, m, fuel = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    start = list(map(lambda x: int(x) - 1, input().split()))
    destinations = [list(map(lambda x: int(x) - 1, input().split())) for _ in range(m)]

    for i in range(n):
        for j in range(n):
            if matrix[i][j] == 1:
                matrix[i][j] = -1

    for idx, value in enumerate(destinations):
        y, x, _, _ = value
        matrix[y][x] = idx + 1

    def find(start, fuel):
        y, x = start
        visited = [[0] * n for _ in range(n)]
        visited[y][x] = 1
        if matrix[y][x] != 0:
            return (matrix[y][x] - 1, fuel)
        que = deque()
        que.append((y, x))
        candidates = []
        min_fuel = -1
        while que:
            y, x = que.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if (
                    0 <= nx < n
                    and 0 <= ny < n
                    and visited[ny][nx] == 0
                    and matrix[ny][nx] != -1
                ):
                    visited[ny][nx] = visited[y][x] + 1
                    if matrix[ny][nx] != 0:
                        if min_fuel == -1 or visited[ny][nx] - 1 == min_fuel:
                            min_fuel = visited[ny][nx] - 1
                            candidates.append((ny, nx))
                    elif fuel != visited[ny][nx] - 1:
                        que.append((ny, nx))
        if candidates:
            candidates.sort(key=lambda x: (x[0], x[1]))
            y, x = candidates[0]
            return (matrix[y][x] - 1, fuel - visited[y][x] + 1)
        else:
            print(-1)
            sys.exit(0)

    def go(start_idx, fuel):
        start_y, start_x, dest_y, dest_x = destinations[start_idx]
        visited = [[0] * n for _ in range(n)]
        visited[start_y][start_x] = 1
        que = deque()
        que.append((start_y, start_x))
        while que:
            y, x = que.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if (
                    0 <= nx < n
                    and 0 <= ny < n
                    and visited[ny][nx] == 0
                    and matrix[ny][nx] != -1
                ):
                    visited[ny][nx] = visited[y][x] + 1
                    if (ny, nx) == (dest_y, dest_x):
                        return (ny, nx, fuel + visited[ny][nx] - 1)
                    elif fuel != visited[ny][nx] - 1:
                        que.append((ny, nx))
        print(-1)
        sys.exit(0)

    y, x = start

    for _ in range(m):
        idx, fuel = find((y, x), fuel)
        y, x, _, _ = destinations[idx]
        matrix[y][x] = 0
        y, x, fuel = go(idx, fuel)

    print(fuel)


main()
