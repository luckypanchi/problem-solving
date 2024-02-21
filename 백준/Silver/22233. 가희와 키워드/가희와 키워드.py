import sys

input = sys.stdin.readline


N, M = map(int, input().split())
words = set([input().strip() for _ in range(N)])
count = N

for _ in range(M):
    ws = input().strip().split(",")
    for w in ws:
        if w in words:
            words.remove(w)
            count -= 1

    print(count)