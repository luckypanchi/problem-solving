import sys

input = sys.stdin.readline


def getPrimeSieve(target):
    sieve = [True] * (target + 1)

    sieve[1] = False

    for i in range(2, int(target**0.5) + 1):
        if sieve[i]:
            for j in range(i + i, target + 1, i):
                sieve[j] = False

    return sieve


primeSieve = getPrimeSieve(1000)

n = int(input())
numbers = list(map(int, input().split()))

answer = 0
for num in numbers:
    if primeSieve[num]:
        answer += 1

print(answer)