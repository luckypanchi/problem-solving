import sys

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, -1, 0, 1)


def main():
    matrix = [[0] * 101 for _ in range(101)]
    n = int(input())
    points = [list(map(int, input().split())) for _ in range(n)]

    def go(point):
        nonlocal matrix

        x, y, d, g = point
        matrix[y][x] = 1
        y = y + dy[d]
        x = x + dx[d]
        matrix[y][x] = 1

        direction = [d]

        for _ in range(g):
            tmp = []
            for i in range(len(direction) - 1, -1, -1):
                nd = (direction[i] + 1) % 4
                y = y + dy[nd]
                x = x + dx[nd]
                matrix[y][x] = 1
                tmp.append(nd)
            direction.extend(tmp)

    for point in points:
        go(point)

    answer = 0

    for i in range(100):
        for j in range(100):
            if (
                matrix[i][j] == 1
                and matrix[i + 1][j] == 1
                and matrix[i][j + 1] == 1
                and matrix[i + 1][j + 1] == 1
            ):
                answer += 1

    print(answer)


main()
