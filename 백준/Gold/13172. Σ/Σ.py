import sys

input = sys.stdin.readline

MOD = 1000000007


def calc(n, s):
    return (s * power(n, MOD - 2)) % MOD


def power(num, exp):
    if exp == 1:
        return num

    if exp % 2 == 0:
        res = power(num, exp // 2)
        return res * res % MOD
    else:
        return num * power(num, exp - 1) % MOD


m = int(input())

answer = 0
for _ in range(m):
    n, s = map(int, input().split())
    if s % n == 0:
        answer = (answer + s // n) % MOD
    else:
        answer = (answer + calc(n, s)) % MOD

print(answer)