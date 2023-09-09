import sys

input = sys.stdin.readline
MOD = 1000000007

n = int(input())
s = input().strip()

w = 0
h = 0
e = 0
answer = 0

for c in s:
    if c == "W":
        w += 1
    elif c == "H":
        h += w
    elif c == "E":
        answer = (2 * answer + e) % MOD
        e += h

print(answer)