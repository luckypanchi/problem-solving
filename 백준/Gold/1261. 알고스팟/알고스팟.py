import sys
import heapq

input = sys.stdin.readline

INF = float("inf")

dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)


def bfs():
    h = []
    visited = [[INF] * m for _ in range(n)]

    heapq.heappush(h, (0, 0, 0))
    visited[0][0] = 0

    while h:
        d, y, x = heapq.heappop(h)

        if visited[y][x] < d:
            continue

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and d + board[ny][nx] < visited[ny][nx]:
                total = d + board[ny][nx]
                visited[ny][nx] = total
                heapq.heappush(h, (total, ny, nx))

    return visited[n - 1][m - 1]


m, n = map(int, input().split())
board = [list(map(int, input().strip())) for _ in range(n)]

print(bfs())