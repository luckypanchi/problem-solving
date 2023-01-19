import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def pArr(arr):
    for i in arr:
        print(i)


def main():
    n, m = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    total = 0
    for i in range(n):
        total += sum(matrix[i])

    def solve():
        nonlocal matrix
        visited = [[0] * m for _ in range(n)]
        visited[0][0] = 1
        que = deque()
        que.append((0, 0))
        while que:
            y, x = que.popleft()
            for i in range(4):
                ny = y + dy[i]
                nx = x + dx[i]
                if 0 <= ny < n and 0 <= nx < m:
                    if matrix[ny][nx] == 0 and visited[ny][nx] == 0:
                        visited[ny][nx] = 1
                        que.append((ny, nx))
                    elif matrix[ny][nx] == 1:
                        visited[ny][nx] += 1

        cnt = 0
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 1 and visited[i][j] >= 2:
                    cnt += 1
                    matrix[i][j] = 0
        return cnt

    time = 0
    while True:
        total -= solve()
        time += 1
        if total == 0:
            print(time)
            break


main()
