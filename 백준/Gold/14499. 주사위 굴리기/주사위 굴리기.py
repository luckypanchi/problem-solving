import sys

input = sys.stdin.readline

dx = (None, 1, -1, 0, 0)
dy = (None, 0, 0, -1, 1)


def main():
    n, m, y, x, k = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    orders = list(map(int, input().split()))

    arr_h = [0, 0, 0, 0]
    arr_v = [0, 0, 0, 0]

    top_h = 0
    top_v = 0

    for order in orders:
        if 0 <= x + dx[order] < m and 0 <= y + dy[order] < n:
            y += dy[order]
            x += dx[order]

            if order == 1 or order == 2:
                if order == 1:
                    top_v -= 1
                else:
                    top_v += 1
                top_v = top_v % 4
                print(arr_v[top_v])
                if matrix[y][x] == 0:
                    matrix[y][x] = arr_v[(top_v + 2) % 4]
                else:
                    arr_v[(top_v + 2) % 4] = matrix[y][x]
                    matrix[y][x] = 0
                arr_h[top_h] = arr_v[top_v]
                arr_h[(top_h + 2) % 4] = arr_v[(top_v + 2) % 4]

            else:
                if order == 3:
                    top_h += 1
                else:
                    top_h -= 1
                top_h = top_h % 4
                print(arr_h[top_h])
                if matrix[y][x] == 0:
                    matrix[y][x] = arr_h[(top_h + 2) % 4]
                else:
                    arr_h[(top_h + 2) % 4] = matrix[y][x]
                    matrix[y][x] = 0
                arr_v[top_v] = arr_h[top_h]
                arr_v[(top_v + 2) % 4] = arr_h[(top_h + 2) % 4]


main()
