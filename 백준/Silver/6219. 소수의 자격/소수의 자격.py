import sys

input = sys.stdin.readline


def getPrimeSieve(target):
    sieve = [True] * (target + 1)
    sieve[0] = False
    sieve[1] = False

    for i in range(2, int(target**0.5) + 1):
        if sieve[i]:
            for j in range(i + i, target + 1, i):
                sieve[j] = False

    return sieve


a, b, d = map(int, input().split())

primeSieve = getPrimeSieve(b)
answer = 0
for i in range(a, b + 1):
    if primeSieve[i] and str(d) in str(i):
        answer += 1

print(answer)