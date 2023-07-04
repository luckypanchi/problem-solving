import sys

input = sys.stdin.readline


n, m = map(int, input().split())
a = [list(map(int, input().strip())) for _ in range(n)]
b = [list(map(int, input().strip())) for _ in range(n)]


answer = 0

for y in range(n):
    for x in range(m):
        if y < n - 2 and x < m - 2:
            if a[y][x] != b[y][x]:
                answer += 1
                for i in range(3):
                    for j in range(3):
                        a[y + i][x + j] = 1 - a[y + i][x + j]
        else:
            if a[y][x] != b[y][x]:
                print(-1)
                sys.exit()

print(answer)