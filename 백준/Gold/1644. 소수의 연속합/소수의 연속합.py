import sys

input = sys.stdin.readline


def prime_list(number):
    sieve = [True] * (number + 1)

    m = int(number**0.5)
    for i in range(2, m + 1):
        if sieve[i] is True:
            for j in range(i + i, number + 1, i):
                sieve[j] = False

    return [i for i in range(2, n + 1) if sieve[i]]


n = int(input())
primes = prime_list(n)

answer = 0

for i in range(len(primes) - 1):
    s = primes[i]
    j = i + 1
    while j < len(primes):
        s += primes[j]
        if n == s:
            answer += 1
            break
        elif n < s:
            break
        j += 1

if len(primes) != 0 and primes[-1] == n:
    answer += 1

print(answer)