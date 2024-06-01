import sys
from collections import defaultdict

input = sys.stdin.readline


def counterAdd(counter1, counter2):
    for i in range(1, 11):
        counter1[i] += counter2[i]


def counterDelete(counter1, counter2):
    for i in range(1, 11):
        counter1[i] -= counter2[i]


n = int(input())
board = [[0] * (n + 1)] + [[0] + list(map(int, input().split())) for _ in range(n)]
prefixCounter = [[defaultdict(int) for _ in range(n + 1)] for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        for v in range(1, 11):
            prefixCounter[i][j][v] = (
                prefixCounter[i - 1][j][v]
                + prefixCounter[i][j - 1][v]
                - prefixCounter[i - 1][j - 1][v]
            )

        v = board[i][j]
        prefixCounter[i][j][v] += 1


tc = int(input())
for _ in range(tc):
    x1, y1, x2, y2 = map(int, input().split())
    answer = 0
    for v in range(1, 11):
        count = (
            prefixCounter[x2][y2][v]
            - prefixCounter[x2][y1 - 1][v]
            - prefixCounter[x1 - 1][y2][v]
            + prefixCounter[x1 - 1][y1 - 1][v]
        )
        if count > 0:
            answer += 1

    print(answer)