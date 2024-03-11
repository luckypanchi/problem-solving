from collections import deque

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def bfs(maps, start, dest):
    n = len(maps)
    m = len(maps[0])

    visited = [[-1] * m for _ in range(n)]
    visited[start[0]][start[1]] = 0

    que = deque()
    que.append((start[0], start[1]))

    while que:
        y, x = que.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and visited[ny][nx] == -1 and maps[ny][nx] != "X":
                visited[ny][nx] = visited[y][x] + 1
                que.append((ny, nx))

                if (ny, nx) == (dest[0], dest[1]):
                    return visited[ny][nx]

    return -1


def solution(maps):
    n = len(maps)
    m = len(maps[0])

    start, lever, dest = None, None, None
    for i in range(n):
        for j in range(m):
            if maps[i][j] == "S":
                start = (i, j)
            elif maps[i][j] == "L":
                lever = (i, j)
            elif maps[i][j] == "E":
                dest = (i, j)

    result1 = bfs(maps, start, lever)
    result2 = bfs(maps, lever, dest)

    if result1 == -1 or result2 == -1:
        return -1

    answer = result1 + result2
    return answer
