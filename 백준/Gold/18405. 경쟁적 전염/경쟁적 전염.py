import sys

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def main():
    n, k = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    s, dest_x, dest_y = map(int, input().split())

    positions = [[] for _ in range(k)]

    cnt = 0

    for i in range(n):
        for j in range(n):
            if matrix[i][j] != 0:
                positions[matrix[i][j] - 1].append((i, j))
                cnt += 1

    for _ in range(s):
        if cnt == n**2:
            break

        for idx in range(k):
            tmp = []
            for point in positions[idx]:
                y, x = point
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0 <= nx < n and 0 <= ny < n and matrix[ny][nx] == 0:
                        matrix[ny][nx] = idx + 1
                        tmp.append((ny, nx))
            positions[idx].extend(tmp)
            cnt += len(tmp)

    print(matrix[dest_x - 1][dest_y - 1])


main()
