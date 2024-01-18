from collections import deque, defaultdict

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def mark(land, visited, landNumber, y, x):
    n = len(land)
    m = len(land[0])

    que = deque()
    que.append((y, x))
    visited[y][x] = landNumber
    cnt = 1

    while que:
        y, x = que.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and land[ny][nx] == 1 and visited[ny][nx] == -1:
                visited[ny][nx] = landNumber
                que.append((ny, nx))
                cnt += 1

    return cnt


def solution(land):
    n = len(land)
    m = len(land[0])

    landSizes = defaultdict(int)
    visited = [[-1] * m for _ in range(n)]

    currLandNumber = 0
    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and visited[i][j] == -1:
                landSizes[currLandNumber] = mark(land, visited, currLandNumber, i, j)
                currLandNumber += 1

    answer = -1

    for x in range(m):
        landNumbers = set()
        for y in range(n):
            if land[y][x] == 1:
                landNumbers.add(visited[y][x])

        result = 0
        landNumbers = list(landNumbers)
        for landNumber in landNumbers:
            result += landSizes[landNumber]

        answer = max(answer, result)

    return answer
