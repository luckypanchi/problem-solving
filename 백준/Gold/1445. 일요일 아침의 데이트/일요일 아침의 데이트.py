import sys
import heapq

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)

INF = float("inf")
GAR = 3000


n, m = map(int, input().split())
tmp_board = [list(input().strip()) for _ in range(n)]
board = [[0] * m for _ in range(n)]

start_y, start_x, dest_y, dest_x = 0, 0, 0, 0

for y in range(n):
    for x in range(m):
        if tmp_board[y][x] == "g":
            board[y][x] = GAR
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if 0 <= ny < n and 0 <= nx < m and tmp_board[ny][nx] == "." and board[ny][nx] == 0:
                    board[ny][nx] = 1
        elif tmp_board[y][x] == "S":
            start_y, start_x = y, x
        elif tmp_board[y][x] == "F":
            dest_y, dest_x = y, x


dist = [[INF] * m for _ in range(n)]
dist[start_y][start_x] = 0
heap = []
heapq.heappush(heap, (dist[start_y][start_x], start_y, start_x))
results = []

while heap:
    cost, y, x = heapq.heappop(heap)

    if (y, x) == (dest_y, dest_x):
        results.append(cost)
        continue

    if dist[y][x] < cost:
        continue

    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < n and 0 <= nx < m:
            next_cost = cost + board[ny][nx]
            if next_cost < dist[ny][nx]:
                dist[ny][nx] = next_cost
                heapq.heappush(heap, (next_cost, ny, nx))

answer = min(results)
ans1 = answer // GAR
ans2 = answer % GAR

print(ans1, ans2)