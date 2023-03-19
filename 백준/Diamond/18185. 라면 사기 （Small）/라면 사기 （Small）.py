import sys

input = sys.stdin.readline


n = int(input())
arr = list(map(int, input().split())) + [0, 0]

answer = 0

for i in range(n):
    if arr[i + 1] > arr[i + 2]:
        cnt = min(arr[i], arr[i + 1] - arr[i + 2])
        answer += 5 * cnt
        for k in range(2):
            arr[i + k] -= cnt

        cnt = min(arr[i], arr[i + 1], arr[i + 2])
        answer += 7 * cnt
        for k in range(3):
            arr[i + k] -= cnt
    else:
        cnt = min(arr[i], arr[i + 1], arr[i + 2])
        answer += 7 * cnt
        for k in range(3):
            arr[i + k] -= cnt

        cnt = min(arr[i], arr[i + 1])
        answer += 5 * cnt
        for k in range(2):
            arr[i + k] -= cnt

    answer += 3 * arr[i]

print(answer)