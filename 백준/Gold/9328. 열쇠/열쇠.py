import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def check_unlock(matrix, y, x, keys):
    if not (matrix[y][x].isalpha() and matrix[y][x].isupper()):
        return True

    for key in keys:
        if key.upper() == matrix[y][x]:
            return True

    return False


def bfs(matrix, visited, doors, keys, h, w, y, x):
    que = deque()
    que.append((y, x))
    visited[y][x] = 1
    cnt = 0
    while que:
        y, x = que.popleft()

        if matrix[y][x] == "$":
            cnt += 1
            matrix[y][x] = "."

        elif matrix[y][x].isalpha() and matrix[y][x].islower():
            key = matrix[y][x]
            keys += key
            matrix[y][x] = "."
            while doors[ord(key.upper()) - ord("A")]:
                r, c = doors[ord(key.upper()) - ord("A")].pop()
                matrix[r][c] = "."
                visited[r][c] = 1
                que.append((r, c))

        elif matrix[y][x].isalpha() and matrix[y][x].isupper():
            matrix[y][x] = "."

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if (
                0 <= nx < w
                and 0 <= ny < h
                and visited[ny][nx] == 0
                and matrix[ny][nx] != "*"
            ):
                if check_unlock(matrix, ny, nx, keys):
                    visited[ny][nx] = 1
                    que.append((ny, nx))
                else:
                    doors[ord(matrix[ny][nx]) - ord("A")].append((ny, nx))

    return cnt


def main():
    t = int(input())

    for _ in range(t):
        h, w = map(int, input().split())
        matrix = [list(input().strip()) for _ in range(h)]
        keys = list(input().strip())
        if keys == "0":
            keys = []

        doors = [[] for _ in range(26)]
        answer = 0
        visited = [[0] * w for _ in range(h)]

        for y in range(h):
            for x in range(w):
                if (
                    (y in (0, h - 1) or x in (0, w - 1))
                    and matrix[y][x] != "*"
                    and visited[y][x] == 0
                ):
                    if check_unlock(matrix, y, x, keys):
                        answer += bfs(matrix, visited, doors, keys, h, w, y, x)
                    else:
                        doors[ord(matrix[y][x]) - ord("A")].append((y, x))

        print(answer)


main()
