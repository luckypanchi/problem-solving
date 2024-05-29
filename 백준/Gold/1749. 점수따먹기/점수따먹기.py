import sys

input = sys.stdin.readline

INF = float("inf")


def getArea(startY, startX, destY, destX):
    return (
        prefixSum[destY][destX]
        - prefixSum[destY][startX - 1]
        - prefixSum[startY - 1][destX]
        + prefixSum[startY - 1][startX - 1]
    )


n, m = map(int, input().split())
board = [[0] * (m + 1)] + [[0] + list(map(int, input().split())) for _ in range(n)]

prefixSum = [[0] * (m + 1) for _ in range(n + 1)]
for y in range(1, n + 1):
    for x in range(1, m + 1):
        prefixSum[y][x] = (
            board[y][x] + prefixSum[y - 1][x] + prefixSum[y][x - 1] - prefixSum[y - 1][x - 1]
        )

answer = -INF
for startY in range(1, n + 1):
    for startX in range(1, m + 1):
        for destY in range(startY, n + 1):
            for destX in range(startX, m + 1):
                answer = max(answer, getArea(startY, startX, destY, destX))

print(answer)