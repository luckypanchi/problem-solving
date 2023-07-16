import sys

input = sys.stdin.readline

N = 1000000


def prime_list(n):
    sieve = [True] * (n + 1)
    sieve[0] = False
    sieve[1] = False

    m = int((n + 1) ** 0.5) + 1
    for i in range(2, m):
        if sieve[i]:
            for j in range(i + i, n + 1, i):
                sieve[j] = False

    return sieve


primes = prime_list(N)

tc = int(input())
for _ in range(tc):
    n = int(input())
    answer = 0

    for i in range(n // 2 + 1):
        if primes[i] and primes[n - i]:
            answer += 1

    print(answer)