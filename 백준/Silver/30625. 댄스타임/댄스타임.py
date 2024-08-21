import sys

input = sys.stdin.readline

MOD = 1_000_000_007


n, m = map(int, input().split())
cnt = 0
for _ in range(n):
    _, isBack = map(int, input().split())
    cnt += isBack


answer = ((m - 1) ** cnt + (n - cnt) * (m - 1) ** (cnt + 1)) % MOD

if cnt > 0:
    answer = (answer + cnt * (m - 1) ** (cnt - 1)) % MOD

print(answer)