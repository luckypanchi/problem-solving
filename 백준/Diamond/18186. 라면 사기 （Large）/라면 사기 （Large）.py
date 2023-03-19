import sys

input = sys.stdin.readline


n, b, c = map(int, input().split())
arr = list(map(int, input().split())) + [0, 0]
cost1 = b
cost2 = b + c
cost3 = b + 2 * c

answer = 0

if b < c:
    print(sum(arr) * b)
    sys.exit()

for i in range(n):
    if arr[i + 1] > arr[i + 2]:
        cnt = min(arr[i], arr[i + 1] - arr[i + 2])
        answer += cost2 * cnt
        for k in range(2):
            arr[i + k] -= cnt

        cnt = min(arr[i], arr[i + 1], arr[i + 2])
        answer += cost3 * cnt
        for k in range(3):
            arr[i + k] -= cnt
    else:
        cnt = min(arr[i], arr[i + 1], arr[i + 2])
        answer += cost3 * cnt
        for k in range(3):
            arr[i + k] -= cnt

        cnt = min(arr[i], arr[i + 1])
        answer += cost2 * cnt
        for k in range(2):
            arr[i + k] -= cnt

    answer += cost1 * arr[i]

print(answer)