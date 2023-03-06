import sys

input = sys.stdin.readline


d, h, w = map(int, input().split())
k = (d**2 / (h**2 + w**2)) ** (1 / 2)
print(int(h * k), int(w * k))