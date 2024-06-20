import sys
from collections import Counter

input = sys.stdin.readline

INF = float("inf")


def factorization(target):
    results = []
    for i in range(2, int(target**0.5) + 1):
        while target % i == 0:
            results.append(i)
            target //= i

    if target != 1:
        results.append(target)

    return results


def count(num):
    result = 0
    d = num
    while d <= n:
        result += n // d
        d *= num
    return result


tc = int(input())
for _ in range(tc):
    n, k = map(int, input().split())

    res = factorization(k)
    counter = Counter(res)

    answer = INF
    for num in counter:
        c = count(num)
        answer = min(answer, c // counter[num])

    print(answer)