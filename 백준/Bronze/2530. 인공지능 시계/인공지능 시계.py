import sys

input = sys.stdin.readline


a, b, c = map(int, input().split())
d = int(input())

a += d // 3600
d = d % 3600
b += d // 60
d = d % 60

c += d
b += c // 60
c %= 60
a += b // 60
b %= 60

a %= 24

print(a, b, c)