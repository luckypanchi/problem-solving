import sys
import heapq

input = sys.stdin.readline

INF = float("inf")

dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)


def dijkstra():
    dist = [[INF] * n for _ in range(n)]
    h = []

    dist[0][0] = board[0][0]
    heapq.heappush(h, (dist[0][0], 0, 0))

    while h:
        currCost, y, x = heapq.heappop(h)

        if dist[y][x] < currCost:
            continue

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < n:
                totalCost = currCost + board[ny][nx]
                if totalCost < dist[ny][nx]:
                    dist[ny][nx] = totalCost
                    heapq.heappush(h, (dist[ny][nx], ny, nx))

    return dist[n - 1][n - 1]


problemNumber = 0
while True:
    n = int(input())
    problemNumber += 1
    if n == 0:
        break

    board = [list(map(int, input().split())) for _ in range(n)]

    answer = dijkstra()
    print(f"Problem {problemNumber}: {answer}")