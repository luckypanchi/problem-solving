import sys
from collections import Counter

input = sys.stdin.readline


N, M = map(int, input().split())
words = []
for _ in range(N):
    word = input().strip()
    if len(word) >= M:
        words.append(word)

counter = Counter(words)
words = list(set(words))
words.sort(key=lambda x: (-counter[x], -len(x), x))
print(*words, sep="\n")