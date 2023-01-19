import sys

input = sys.stdin.readline


n, m = map(int, input().split())
points = sorted(list(map(int, input().split())))
lines = [list(map(int, input().split())) for _ in range(m)]


def binary_search(target):
    start, end = 0, n - 1
    while start <= end:
        mid = (start + end) // 2
        if points[mid] <= target:
            start = mid + 1
        else:
            end = mid - 1
    return start - 1


answers = []

for i in range(m):
    start, end = lines[i]
    start_idx = binary_search(start)
    end_idx = binary_search(end)

    if points[start_idx] != start:
        start_idx += 1

    answers.append(end_idx - start_idx + 1)

for answer in answers:
    print(answer)
