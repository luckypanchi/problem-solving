import sys

input = sys.stdin.readline


w, h, f, c, x1, y1, x2, y2 = map(int, input().split())

min_size1 = (y2 - y1) * (min(w, f + x2) - min(w, f + x1))
answer = min_size1 * (c + 1)

min_size2 = (y2 - y1) * (min(2 * f, f + x2) - min(2 * f, f + x1))
answer += min_size2 * (c + 1)

print(w * h - answer)