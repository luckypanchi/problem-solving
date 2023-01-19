import sys

input = sys.stdin.readline

STAR = "*"
BLANK = " "


def solve(arr, kind, y, x, size):
    if kind == BLANK:
        for i in range(y, y + size):
            for j in range(x, x + size):
                arr[i][j] = BLANK

    else:
        if size == 1:
            arr[y][x] = STAR
        else:
            m = size // 3
            for i in range(3):
                for j in range(3):
                    new_kind = STAR
                    if i == 1 and j == 1:
                        new_kind = BLANK
                    solve(arr, new_kind, y + m * i, x + m * j, m)


def main():
    n = int(input())
    arr = [[BLANK] * n for _ in range(n)]

    solve(arr, STAR, 0, 0, n)

    for row in arr:
        print("".join(row))


main()
