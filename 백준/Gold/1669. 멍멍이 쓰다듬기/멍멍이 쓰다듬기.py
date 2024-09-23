import sys

input = sys.stdin.readline


x, y = map(int, input().split())
diff = y - x

m = 1
moves = 0
cnt = 0

while moves < diff:
    moves += m
    cnt += 1
    if cnt % 2 == 0:
        m += 1

print(cnt)