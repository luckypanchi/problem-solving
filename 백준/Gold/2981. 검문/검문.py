import sys

input = sys.stdin.readline


def euclidean(a, b):
    while b != 0:
        [a, b] = [b, a % b]
    return a


n = int(input())
numbers = [int(input()) for _ in range(n)]
numbers.sort()

intervals = []
for i in range(n - 1):
    intervals.append(numbers[i + 1] - numbers[i])

gcd = intervals[0]
for i in range(1, n - 1):
    gcd = euclidean(gcd, intervals[i])

m = int(gcd**0.5) + 1
answer = []
for i in range(1, m):
    if gcd % i == 0:
        answer.append(i)
        answer.append(gcd // i)

answer.remove(1)
answer = sorted(list(set(answer)))

print(*answer)