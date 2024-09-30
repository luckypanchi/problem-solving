import sys
import heapq

input = sys.stdin.readline

INF = float("inf")

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def dijkstra(start, end):
    dist = [[INF] * m for _ in range(n)]
    h = []

    dist[start[0]][start[1]] = 0
    heapq.heappush(h, (dist[start[0]][start[1]], start[0], start[1]))

    while h:
        prev_cost, x, y = heapq.heappop(h)

        if dist[x][y] < prev_cost:
            continue

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                next_cost = prev_cost
                if board[nx][ny] == "1" or board[nx][ny] == "#":
                    next_cost += 1

                if next_cost < dist[nx][ny]:
                    dist[nx][ny] = next_cost
                    heapq.heappush(h, (next_cost, nx, ny))

    return dist[end[0]][end[1]]


n, m = map(int, input().split())
x1, y1, x2, y2 = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]

answer = dijkstra((x1 - 1, y1 - 1), (x2 - 1, y2 - 1))

print(answer)