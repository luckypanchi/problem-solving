import sys
import heapq

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)

INF = float("inf")


m, n = map(int, input().split())
board = [list(map(int, input().strip())) for _ in range(n)]

dist = [[INF] * m for _ in range(n)]

heap = []
heapq.heappush(heap, (0, 0, 0))
dist[0][0] = 0

while heap:
    d, y, x = heapq.heappop(heap)

    if dist[y][x] < d:
        continue

    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]

        if 0 <= ny < n and 0 <= nx < m:
            if d + board[ny][nx] < dist[ny][nx]:
                dist[ny][nx] = d + board[ny][nx]
                heapq.heappush(heap, (dist[ny][nx], ny, nx))


answer = dist[n - 1][m - 1]

print(answer)