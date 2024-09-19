import sys

input = sys.stdin.readline


def get_prime_sieve(limit):
    sieve = [True] * (limit + 1)
    sieve[0] = False
    sieve[1] = False

    for i in range(2, int(limit**0.5) + 1):
        if sieve[i]:
            for j in range(i * i, limit + 1, i):
                sieve[j] = False

    return sieve


def get_list(target):
    result = 0

    i = 0
    while target != 1:
        if target % prime_numbers[i] == 0:
            target //= prime_numbers[i]
            result += 1
        else:
            i += 1

    return result


a, b = map(int, input().split())

prime_sieve = get_prime_sieve(b)
prime_numbers = [i for i in range(b + 1) if prime_sieve[i]]

answer = 0
for target in range(a, b + 1):
    cnt = get_list(target)
    if prime_sieve[cnt]:
        answer += 1


print(answer)