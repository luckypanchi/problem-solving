import sys

input = sys.stdin.readline

INF = float("inf")


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


tc = int(input())
for _ in range(tc):
    numbers = list(map(int, input().split()))
    answer = -INF
    for i in range(len(numbers) - 1):
        for j in range(i + 1, len(numbers)):
            answer = max(answer, gcd(numbers[i], numbers[j]))

    print(answer)