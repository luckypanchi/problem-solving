import sys

input = sys.stdin.readline


n, k = map(int, input().split())
nations = [list(map(int, input().split())) for _ in range(n)]
nations.sort(key=lambda x: (-x[1], -x[2], -x[3]))

grade = 1
for i in range(n - 1):
    if nations[i][0] == k:
        break

    if nations[i][1:] != nations[i + 1][1:]:
        grade += 1

print(grade)
