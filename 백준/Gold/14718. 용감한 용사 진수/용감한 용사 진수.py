import sys
from itertools import combinations

input = sys.stdin.readline

INF = float("inf")


n, k = map(int, input().split())
stats = [list(map(int, input().split())) for _ in range(n)]
statX = []
statY = []
statZ = []
for x, y, z in stats:
    statX.append(x)
    statY.append(y)
    statZ.append(z)

answer = INF
for x in statX:
    for y in statY:
        for z in statZ:
            cnt = 0
            for a, b, c in stats:
                if a <= x and b <= y and c <= z:
                    cnt += 1
            if k <= cnt:
                answer = min(answer, x + y + z)

print(answer)