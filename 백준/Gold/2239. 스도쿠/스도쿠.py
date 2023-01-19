import sys

input = sys.stdin.readline


def main():
    matrix = [list(map(int, input().strip())) for _ in range(9)]
    zeros = []
    for i in range(9):
        for j in range(9):
            if matrix[i][j] == 0:
                zeros.append((i, j))

    def solve(idx):
        if idx == len(zeros):
            for arr in matrix:
                print(*arr, sep="")
            sys.exit()

        y, x = zeros[idx]
        flag = [1] * 10

        for i in range((y // 3) * 3, (y // 3) * 3 + 3):
            for j in range((x // 3) * 3, (x // 3) * 3 + 3):
                flag[matrix[i][j]] = 0

        for i in range(9):
            flag[matrix[i][x]] = 0
            flag[matrix[y][i]] = 0

        for i in range(1, 10):
            if flag[i] == 1:
                matrix[y][x] = i
                solve(idx + 1)
                matrix[y][x] = 0

    solve(0)


main()
