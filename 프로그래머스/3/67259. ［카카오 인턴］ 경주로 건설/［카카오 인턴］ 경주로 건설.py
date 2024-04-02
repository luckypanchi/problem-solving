from collections import deque

dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)

INF = float("inf")


def getCost(visited, y, x, prevDir, currDir):
    if prevDir == -1:
        return 100
    elif prevDir == currDir:
        return visited[y][x][prevDir] + 100
    else:
        return visited[y][x][prevDir] + 600


def solution(board):
    n = len(board)

    visited = [[[INF] * 4 for _ in range(n)] for _ in range(n)]
    visited[0][0] = [0] * 4
    que = deque()
    que.append((0, 0, -1))
    answer = INF

    while que:
        y, x, prevDir = que.popleft()

        if (y, x) == (n - 1, n - 1):
            answer = min(answer, visited[n - 1][n - 1][prevDir])
            continue

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            cost = getCost(visited, y, x, prevDir, i)
            if 0 <= ny < n and 0 <= nx < n and board[ny][nx] == 0 and cost < visited[ny][nx][i]:
                visited[ny][nx][i] = cost
                que.append((ny, nx, i))

    return answer