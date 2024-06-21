import sys

input = sys.stdin.readline

INF = float("inf")


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


n, m = map(int, input().split())
x = m // n


minSum = INF
answer = []

for i in range(1, int(x**0.5) + 1):
    if x % i == 0 and gcd(x // i, i) == 1:
        a = i * n
        b = (x // i) * n
        if a + b < minSum:
            minSum = a + b
            answer = [a, b]

print(*answer)