import sys

input = sys.stdin.readline


def main():
    n, m = map(int, input().split())
    matrix_from = [list(map(int, input().strip())) for _ in range(n)]
    matrix_to = [list(map(int, input().strip())) for _ in range(n)]

    def flip(y, x):
        for i in range(y - 1, y + 2):
            for j in range(x - 1, x + 2):
                matrix_to[i][j] = 1 - matrix_to[i][j]

    answer = 0

    for i in range(n - 2):
        for j in range(m - 2):
            if matrix_from[i][j] != matrix_to[i][j]:
                answer += 1
                flip(i + 1, j + 1)

    for i in range(n):
        for j in range(m):
            if matrix_from[i][j] != matrix_to[i][j]:
                print(-1)
                return

    print(answer)


main()
