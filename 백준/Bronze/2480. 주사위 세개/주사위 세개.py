import sys

input = sys.stdin.readline


a, b, c = map(int, input().split())

answer = 0

if a == b == c:
    answer = 10000 + a * 1000
elif a != b and b != c and c != a:
    answer = max(a, b, c) * 100
else:
    if a == b:
        answer = 1000 + a * 100
    elif b == c:
        answer = 1000 + b * 100
    else:
        answer = 1000 + c * 100

print(answer)
