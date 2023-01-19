import sys
from collections import defaultdict

input = sys.stdin.readline


n = int(input())
books = defaultdict(int)

for _ in range(n):
    book = input().strip()
    books[book] += 1

books = sorted(books.items())
books.sort(key=lambda x: x[1], reverse=True)
print(books[0][0])
