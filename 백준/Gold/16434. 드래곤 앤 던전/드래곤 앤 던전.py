import sys
from math import ceil

input = sys.stdin.readline


n, atk = map(int, input().split())
currHp, maxHp = 0, 0
for _ in range(n):
    t, a, h = map(int, input().split())
    if t == 1:
        currHp += (ceil(h / atk) - 1) * a
    else:
        maxHp = max(maxHp, currHp)
        atk += a
        currHp -= h
        if currHp < 0:
            currHp = 0

print(max(maxHp, currHp) + 1)