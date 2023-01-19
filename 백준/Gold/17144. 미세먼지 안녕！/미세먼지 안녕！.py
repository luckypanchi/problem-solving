import sys

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def main():
    r, c, t = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(r)]

    purifier = []

    for i in range(r):
        for j in range(c):
            if matrix[i][j] == -1:
                matrix[i][j] = 0
                purifier.append((i, j))

    def rotate():
        py, px = purifier[0]

        tmp1 = matrix[0][0]
        tmp2 = matrix[py][c - 1]

        for j in range(c - 1):
            matrix[0][j] = matrix[0][j + 1]

        for j in range(c - 1, 0, -1):
            matrix[py][j] = matrix[py][j - 1]

        for i in range(py, 0, -1):
            matrix[i][0] = matrix[i - 1][0]

        for i in range(py - 1):
            matrix[i][c - 1] = matrix[i + 1][c - 1]

        matrix[1][0] = tmp1
        matrix[py - 1][c - 1] = tmp2

        matrix[py][px] = 0

        py, px = purifier[1]

        tmp1 = matrix[py][c - 1]
        tmp2 = matrix[r - 1][0]

        for j in range(c - 1, 0, -1):
            matrix[py][j] = matrix[py][j - 1]

        for j in range(c - 1):
            matrix[r - 1][j] = matrix[r - 1][j + 1]

        for i in range(r - 1, py, -1):
            matrix[i][c - 1] = matrix[i - 1][c - 1]

        for i in range(py, r - 1):
            matrix[i][0] = matrix[i + 1][0]

        matrix[py + 1][c - 1] = tmp1
        matrix[r - 2][0] = tmp2

        matrix[py][px] = 0

    def spread():
        temp = [[0] * c for _ in range(r)]

        for i in range(r):
            for j in range(c):
                if matrix[i][j] != 0:
                    cnt = 0
                    for k in range(4):
                        ni = i + dy[k]
                        nj = j + dx[k]
                        if (
                            0 <= ni < r
                            and 0 <= nj < c
                            and (ni, nj) != purifier[0]
                            and (ni, nj) != purifier[1]
                        ):
                            temp[ni][nj] += matrix[i][j] // 5
                            cnt += 1
                    matrix[i][j] = matrix[i][j] - ((matrix[i][j] // 5) * cnt)

        for i in range(r):
            for j in range(c):
                matrix[i][j] += temp[i][j]

    for _ in range(t):
        spread()
        rotate()

    answer = 0

    for i in range(r):
        answer += sum(matrix[i])

    print(answer)


main()
