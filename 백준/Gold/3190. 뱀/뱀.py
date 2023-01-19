import sys
from collections import deque

input = sys.stdin.readline

direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]


def get_direction(idx, d):

    if d == "L":
        return (idx + 3) % 4

    elif d == "D":
        return (idx + 1) % 4


def main():
    n = int(input())

    matrix = [[0] * (n + 2) for _ in range(n + 2)]
    for i in range(n + 2):
        for j in range(n + 2):
            if i == 0 or i == n + 1:
                matrix[i][j] = -1

        matrix[i][0] = -1
        matrix[i][-1] = -1

    k = int(input())
    for _ in range(k):
        a, b = map(int, input().split())
        matrix[a][b] = 1

    d = int(input())
    turn = deque()
    for _ in range(d):
        a, b = input().split()
        turn.append([int(a), b])

    direct = 0
    time = 0
    body = deque()
    body.append((1, 1))

    while True:
        dy, dx = direction[direct]
        head_y, head_x = body[-1]

        ny = head_y + dy
        nx = head_x + dx

        time += 1

        if (ny, nx) in body or matrix[ny][nx] == -1:
            break

        body.append((ny, nx))

        if matrix[ny][nx] == 1:
            matrix[ny][nx] = 0
        else:
            body.popleft()

        if turn and time == turn[0][0]:
            direct = get_direction(direct, turn[0][1])
            turn.popleft()

    print(time)


main()
