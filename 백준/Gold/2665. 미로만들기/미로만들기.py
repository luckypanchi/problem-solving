import sys
import heapq

input = sys.stdin.readline

INF = float("inf")

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


n = int(input())
board = [list(map(int, input().strip())) for _ in range(n)]

for i in range(n):
    for j in range(n):
        board[i][j] = 1 - board[i][j]

dist = [[INF] * n for _ in range(n)]
dist[0][0] = 0

heap = []
heapq.heappush(heap, (0, 0, 0))

while heap:
    d, y, x = heapq.heappop(heap)

    if dist[y][x] < d:
        continue

    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < n and 0 <= nx < n and d + board[ny][nx] < dist[ny][nx]:
            nd = d + board[ny][nx]
            dist[ny][nx] = nd
            heapq.heappush(heap, (nd, ny, nx))


print(dist[n - 1][n - 1])