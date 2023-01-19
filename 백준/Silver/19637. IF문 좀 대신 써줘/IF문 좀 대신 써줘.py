import sys

input = sys.stdin.readline


n, m = map(int, input().split())

ranks = [list(input().split()) for _ in range(n)]


def binary_search(target):
    start, end = 0, n - 1
    while start <= end:
        mid = (start + end) // 2
        if int(ranks[mid][1]) < target:
            start = mid + 1
        else:
            end = mid - 1
    return ranks[start][0]


answers = []

for _ in range(m):
    target = int(input())
    answers.append(binary_search(target))

for answer in answers:
    print(answer)
