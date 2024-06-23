import sys

input = sys.stdin.readline


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


n, m, k = map(int, input().split())

answer = 0
for x1 in range(n + 1):
    for y1 in range(m + 1):
        for x2 in range(n + 1):
            for y2 in range(m + 1):
                if gcd(abs(x1 - x2), abs(y1 - y2)) + 1 == k:
                    answer += 1

print(answer // 2)