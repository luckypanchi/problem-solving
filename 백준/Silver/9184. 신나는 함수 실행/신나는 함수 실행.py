import sys

input = sys.stdin.readline

dp = [[[0] * 21 for _ in range(21)] for _ in range(21)]


def func(x, y, z):
    if dp[x][y][z] == 0:
        if x <= 0 or y <= 0 or z <= 0:
            dp[x][y][z] = 1
        elif x < y < z:
            dp[x][y][z] = func(x, y, z - 1) + func(x, y - 1, z - 1) - func(x, y - 1, z)
        else:
            dp[x][y][z] = (
                func(x - 1, y, z)
                + func(x - 1, y - 1, z)
                + func(x - 1, y, z - 1)
                - func(x - 1, y - 1, z - 1)
            )

    return dp[x][y][z]


for x in range(21):
    for y in range(21):
        for z in range(21):
            dp[x][y][z] = func(x, y, z)


while True:
    a, b, c = map(int, input().split())

    if (a, b, c) == (-1, -1, -1):
        break

    if a <= 0 or b <= 0 or c <= 0:
        answer = 1
    elif 20 < a or 20 < b or 20 < c:
        answer = dp[20][20][20]
    else:
        answer = dp[a][b][c]

    print(f"w({a}, {b}, {c}) = {answer}")