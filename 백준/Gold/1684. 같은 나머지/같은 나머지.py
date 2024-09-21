import sys

input = sys.stdin.readline


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


n = int(input())
numbers = sorted(list(map(int, input().split())))

gaps = [numbers[i] - numbers[i - 1] for i in range(1, n)]
answer = gaps[0]
for i in range(1, n - 1):
    answer = gcd(answer, gaps[i])

print(answer)