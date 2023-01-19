import sys

input = sys.stdin.readline

dx = (0, 1, 1, 1, 0, -1, -1, -1)
dy = (-1, -1, 0, 1, 1, 1, 0, -1)


def main():
    n, m, k = map(int, input().split())
    matrix = [[[] for _ in range(n)] for _ in range(n)]

    for _ in range(m):
        y, x, m, s, d = map(int, input().split())
        matrix[y - 1][x - 1].append((m, s, d))

    for _ in range(k):
        tmp = [[[] for _ in range(n)] for _ in range(n)]

        for i in range(n):
            for j in range(n):
                if matrix[i][j]:
                    for fireball in matrix[i][j]:
                        y, x = i, j
                        m, s, d = fireball
                        x = (x + s * dx[d]) % n
                        y = (y + s * dy[d]) % n

                        tmp[y][x].append((m, s, d))

        matrix = tmp

        for i in range(n):
            for j in range(n):
                if len(matrix[i][j]) > 1:
                    total_m = 0
                    total_s = 0
                    flag = 0
                    for fireball in matrix[i][j]:
                        m, s, d = fireball
                        total_m += m
                        total_s += s
                        flag += d % 2
                    m = total_m // 5
                    s = total_s // len(matrix[i][j])
                    idx = 1
                    if flag == 0 or flag == len(matrix[i][j]):
                        idx = 0
                    matrix[i][j].clear()
                    if m != 0:
                        for t in range(4):
                            matrix[i][j].append((m, s, idx + 2 * t))

    answer = 0

    for i in range(n):
        for j in range(n):
            if matrix[i][j]:
                for fireball in matrix[i][j]:
                    answer += fireball[0]

    print(answer)


main()
