import sys

input = sys.stdin.readline

MOD = 1000000

n = int(input())
p = MOD // 10 * 15

fibo = [0, 1]

for i in range(2, p):
    fibo.append(fibo[i - 1] + fibo[i - 2])
    fibo[i] %= MOD

print(fibo[n % p])