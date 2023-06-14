import sys

input = sys.stdin.readline


N = 1000000

sieve = [True] * (N + 1)

m = int((N + 1) ** 0.5) + 1
sieve[1] = False
for i in range(2, m):
    if sieve[i]:
        for j in range(i + i, N + 1, i):
            sieve[j] = False

for i in range(1, N + 1):
    if i % 2 == 0:
        sieve[i] = False

while True:
    n = int(input())

    if n == 0:
        break

    flag = False
    for i in range(1, n // 2 + 1):
        if sieve[i] and sieve[n - i]:
            print(f"{n} = {i} + {n - i}")
            flag = True
            break

    if not flag:
        print("Goldbach's conjecture is wrong.")