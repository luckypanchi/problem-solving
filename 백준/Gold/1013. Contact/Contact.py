import sys
import re

input = sys.stdin.readline

tc = int(input())

for _ in range(tc):
    target = input().split()[0]
    pattern = re.compile("(100+1+|01)+")
    res = pattern.fullmatch(target)
    print("YES" if res else "NO")