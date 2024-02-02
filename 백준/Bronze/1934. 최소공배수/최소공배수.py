import sys
from math import gcd

input = sys.stdin.readline


tc = int(input())

for _ in range(tc):
    a, b = map(int, input().split())
    g = gcd(a, b)
    print((a // g) * (b // g) * g)