import sys
import copy

input = sys.stdin.readline

dx = (0, 0, 1, -1)
dy = (-1, 1, 0, 0)


def pArr(arr):
    for i in arr:
        print(i)


def main():
    r, c, m = map(int, input().split())
    temp = [list(map(int, input().split())) for _ in range(m)]
    matrix = [[0] * c for _ in range(r)]

    for shark in temp:
        y, x, s, d, z = shark
        matrix[y - 1][x - 1] = [s, d - 1, z]

    answer = 0

    for man in range(c):
        for i in range(r):
            if matrix[i][man] != 0:
                answer += matrix[i][man][2]
                matrix[i][man] = 0
                break

        temp = [[0] * c for _ in range(r)]

        for i in range(r):
            for j in range(c):
                if matrix[i][j] != 0:
                    s, d, z = matrix[i][j]
                    y, x = i, j
                    matrix[y][x] = 0
                    for _ in range(s):
                        ny = y + dy[d]
                        nx = x + dx[d]
                        if 0 <= ny < r and 0 <= nx < c:
                            y = ny
                            x = nx
                        else:
                            if d in (0, 1):
                                d = 1 - d
                            else:
                                d = 5 - d
                            y += dy[d]
                            x += dx[d]
                    if temp[y][x] != 0:
                        if temp[y][x][2] < z:
                            temp[y][x] = [s, d, z]
                        else:
                            continue
                    else:
                        temp[y][x] = [s, d, z]
        matrix = temp

    print(answer)


main()
