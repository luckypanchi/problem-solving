import sys

input = sys.stdin.readline


n, m = map(int, input().split())
db = dict()
for _ in range(n):
    url, pw = input().strip().split()
    db[url] = pw

for _ in range(m):
    url = input().strip()
    print(db[url])