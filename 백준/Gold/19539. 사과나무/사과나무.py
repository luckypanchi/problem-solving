import sys

input = sys.stdin.readline


n = int(input())
trees = list(map(int, input().split()))
s = sum(trees)

a = s // 3
b = s % 3

if b == 0:
    cnt = 0
    for h in trees:
        cnt += h // 2

    if a <= cnt:
        print("YES")
    else:
        print("NO")
else:
    print("NO")