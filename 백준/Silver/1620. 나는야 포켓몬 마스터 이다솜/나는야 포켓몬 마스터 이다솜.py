import sys

input = sys.stdin.readline


n, m = map(int, input().split())
d = dict()

for k in range(1, n + 1):
    pokemon = input().strip()
    d[pokemon] = str(k)
    d[str(k)] = pokemon
    k += 1

for _ in range(m):
    t = input().strip()
    print(d[t])