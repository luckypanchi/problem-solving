import sys

input = sys.stdin.readline


a, b, n, w = map(int, input().split())

answer = []
for sheep in range(1, n):
    goat = n - sheep

    if a * sheep + b * goat == w:
        if len(answer) == 0:
            answer.append(sheep)
            answer.append(goat)
        else:
            print(-1)
            sys.exit()

if len(answer) == 0:
    print(-1)
else:
    print(*answer)