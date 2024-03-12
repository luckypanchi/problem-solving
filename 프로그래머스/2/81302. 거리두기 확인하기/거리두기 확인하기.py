from collections import deque


dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def check(place, pos):
    y, x = pos

    visited = [[False] * 5 for _ in range(5)]
    visited[y][x] = True

    que = deque()
    que.append((y, x, 0))

    while que:
        y, x, cnt = que.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < 5 and 0 <= nx < 5 and not visited[ny][nx] and place[ny][nx] != "X":
                if place[ny][nx] == "P":
                    return 0

                if cnt + 1 < 2:
                    visited[ny][nx] = True
                    que.append((ny, nx, cnt + 1))

    return 1


def solve(place):
    people = []

    for i in range(5):
        for j in range(5):
            if place[i][j] == "P":
                people.append((i, j))

    for p in people:
        result = check(place, p)
        if result == 0:
            return 0

    return 1


def solution(places):
    answer = []
    for place in places:
        answer.append(solve(place))
    return answer
