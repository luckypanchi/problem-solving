import sys

input = sys.stdin.readline


n = int(input())
arr = list(map(int, input().split()))
sorted_arr = sorted(arr)

answer = []

for i in range(n):
    idx = sorted_arr.index(arr[i])
    answer.append(idx)
    sorted_arr[idx] = -1

print(*answer)
