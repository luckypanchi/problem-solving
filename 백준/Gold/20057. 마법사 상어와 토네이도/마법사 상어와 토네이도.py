import sys

input = sys.stdin.readline

rate_map = [
    # 왼쪽
    [
        [0, 0, 0.02, 0, 0],
        [0, 0.1, 0.07, 0.01, 0],
        [0.05, 0, 0, 0, 0],
        [0, 0.1, 0.07, 0.01, 0],
        [0, 0, 0.02, 0, 0],
    ],
    # 아래
    [
        [0, 0, 0, 0, 0],
        [0, 0.01, 0, 0.01, 0],
        [0.02, 0.07, 0, 0.07, 0.02],
        [0, 0.1, 0, 0.1, 0],
        [0, 0, 0.05, 0, 0],
    ],
    # 오른쪽
    [
        [0, 0, 0.02, 0, 0],
        [0, 0.01, 0.07, 0.1, 0],
        [0, 0, 0, 0, 0.05],
        [0, 0.01, 0.07, 0.1, 0],
        [0, 0, 0.02, 0, 0],
    ],
    # 위
    [
        [0, 0, 0.05, 0, 0],
        [0, 0.1, 0, 0.1, 0],
        [0.02, 0.07, 0, 0.07, 0.02],
        [0, 0.01, 0, 0.01, 0],
        [0, 0, 0, 0, 0],
    ],
]


rate_dx = (2, 1, 1, 0, 0, -1, -1, -2, -1, 0, 0, 1)
rate_dy = (0, 0, -1, -1, -2, -1, 0, 0, 1, 1, 2, 1)

dx = (-1, 0, 1, 0)
dy = (0, 1, 0, -1)


def main():
    n = int(input())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    y, x = n // 2, n // 2
    d = 0
    length = 1
    cnt = 0
    answer = 0

    while True:

        if (y, x) == (0, -1):
            break

        for _ in range(length):
            y += dy[d]
            x += dx[d]

            total_sand = matrix[y][x]
            matrix[y][x] = 0
            total_moved = 0
            for i in range(12):
                nx = x + rate_dx[i]
                ny = y + rate_dy[i]
                moving_sand = int(
                    total_sand * rate_map[d][rate_dy[i] + 2][rate_dx[i] + 2]
                )
                total_moved += moving_sand
                if 0 <= nx < n and 0 <= ny < n:
                    matrix[ny][nx] += moving_sand
                else:
                    answer += moving_sand
            ny = y + dy[d]
            nx = x + dx[d]
            moving_sand = total_sand - total_moved
            if 0 <= nx < n and 0 <= ny < n:
                matrix[ny][nx] += moving_sand
            else:
                answer += moving_sand

        d = (d + 1) % 4
        cnt += 1
        if cnt == 2:
            cnt = 0
            length += 1

    print(answer)


main()
