import sys

input = sys.stdin.readline


def calc(mid):
    a = (x**2 - mid**2) ** 0.5
    b = (y**2 - mid**2) ** 0.5
    return a * b / (a + b)


x, y, c = map(float, input().split())

start = 0
end = min(x, y)

answer = 0
while end - start > 1e-3:
    mid = (start + end) / 2
    if c <= calc(mid):
        answer = mid
        start = mid
    else:
        end = mid

print(answer)