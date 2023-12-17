from collections import deque

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def bfs(maps, visited, y, x):
    r = len(maps)
    c = len(maps[0])

    que = deque()

    que.append((y, x))
    visited[y][x] = True
    count = int(maps[y][x])

    while que:
        y, x = que.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < r and 0 <= nx < c and not visited[ny][nx] and maps[ny][nx] != "X":
                count += int(maps[ny][nx])
                visited[ny][nx] = True
                que.append((ny, nx))

    return count


def solution(maps):
    r = len(maps)
    c = len(maps[0])
    visited = [[False] * c for _ in range(r)]
    answer = []

    for i in range(r):
        for j in range(c):
            if not visited[i][j] and maps[i][j] != "X":
                answer.append(bfs(maps, visited, i, j))

    answer.sort()

    if len(answer) == 0:
        answer.append(-1)

    return answer
