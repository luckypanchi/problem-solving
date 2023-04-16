import sys

input = sys.stdin.readline


def prime_list(n):
    sieve = [True] * (n + 1)

    m = int(n**0.5)
    for i in range(2, m + 1):
        if sieve[i] is True:
            for j in range(i + i, n + 1, i):
                sieve[j] = False

    return [i for i in range(2, n + 1) if sieve[i]]


tc = int(input())
for _ in range(tc):
    n = int(input())
    primes = prime_list(n)

    start, end = 0, len(primes) - 1

    ans1, ans2 = 0, 0

    while start <= end:
        s = primes[start] + primes[end]
        if s == n:
            ans1 = primes[start]
            ans2 = primes[end]

            start += 1
            end -= 1

        elif s < n:
            start += 1
        else:
            end -= 1

    print(ans1, ans2)