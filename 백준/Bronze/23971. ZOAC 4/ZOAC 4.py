import sys
import math

input = sys.stdin.readline


H, W, N, M = map(int, input().split())

answer = math.ceil(H / (N + 1)) * math.ceil(W / (M + 1))
print(answer)