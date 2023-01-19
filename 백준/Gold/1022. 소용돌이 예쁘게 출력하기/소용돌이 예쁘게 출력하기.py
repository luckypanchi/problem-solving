import sys

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, -1, 0, 1)


def main():
    r1, c1, r2, c2 = map(int, input().split())
    matrix = [[0] * (c2 - c1 + 1) for _ in range(r2 - r1 + 1)]

    y = 0
    x = 0

    num = 1
    d = 0
    limit = 1
    total = (c2 - c1 + 1) * (r2 - r1 + 1)
    max_num = 0

    while total > 0:
        for _ in range(2):
            for _ in range(limit):
                if r1 <= y < r2 + 1 and c1 <= x < c2 + 1:
                    matrix[y - r1][x - c1] = num
                    total -= 1
                    max_num = num

                y += dy[d]
                x += dx[d]
                num += 1

            d = (d + 1) % 4

        limit += 1

    for i in range(r2 - r1 + 1):
        for j in range(c2 - c1 + 1):
            print(str(matrix[i][j]).rjust(len(str(max_num))), end=" ")
        print()


main()
