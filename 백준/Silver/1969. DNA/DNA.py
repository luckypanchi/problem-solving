import sys
from collections import defaultdict

input = sys.stdin.readline


n, m = map(int, input().split())

dnas = [input().strip() for _ in range(n)]

answer = ""
cnt = 0

for j in range(m):
    d = defaultdict(int)
    for i in range(n):
        d[dnas[i][j]] += 1
    arr = sorted(d.items(), key=lambda x: (-x[1], x[0]))
    answer += arr[0][0]
    cnt += n - arr[0][1]

print(answer)
print(cnt)
