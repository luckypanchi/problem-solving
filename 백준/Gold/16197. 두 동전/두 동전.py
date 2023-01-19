import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, -1, 0, 1)


def main():
    n, m = map(int, input().split())
    matrix = [list(input().strip()) for _ in range(n)]

    coins = []

    for i in range(n):
        for j in range(m):
            if matrix[i][j] == "o":
                coins.extend([i, j])

    def bfs(start):
        que = deque()
        que.append(start)
        while que:
            y_1, x_1, y_2, x_2, count = que.popleft()

            count += 1
            if count > 10:
                return -1
            for i in range(4):
                ny_1 = y_1 + dy[i]
                nx_1 = x_1 + dx[i]
                ny_2 = y_2 + dy[i]
                nx_2 = x_2 + dx[i]

                fall1 = not (0 <= ny_1 < n and 0 <= nx_1 < m)
                fall2 = not (0 <= ny_2 < n and 0 <= nx_2 < m)

                if fall1 and fall2:
                    continue
                elif fall1 or fall2:
                    return count
                if matrix[ny_1][nx_1] == "#":
                    ny_1 = y_1
                    nx_1 = x_1
                if matrix[ny_2][nx_2] == "#":
                    ny_2 = y_2
                    nx_2 = x_2
                que.append([ny_1, nx_1, ny_2, nx_2, count])

    answer = bfs(coins + [0])
    print(answer)


main()
