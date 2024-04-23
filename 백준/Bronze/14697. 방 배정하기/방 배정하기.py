import sys

input = sys.stdin.readline


a, b, c, n = map(int, input().split())

for x in range(n // a + 1):
    for y in range(n // b + 1):
        for z in range(n // c + 1):
            if a * x + b * y + c * z == n:
                print(1)
                sys.exit()

print(0)
