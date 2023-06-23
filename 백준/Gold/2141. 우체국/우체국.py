import sys

input = sys.stdin.readline


n = int(input())
villages = [list(map(int, input().split())) for _ in range(n)]

villages.sort(key=lambda x: x[0])

all_people = 0
for i in range(n):
    all_people += villages[i][1]

cnt = 0
for d, p in villages:
    cnt += p
    if all_people / 2 <= cnt:
        print(d)
        break