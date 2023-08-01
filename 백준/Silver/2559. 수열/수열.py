import sys

input = sys.stdin.readline

INF = float("inf")


n, k = map(int, input().split())
numbers = list(map(int, input().split()))

start = 0
end = k - 1

answer = sum(numbers[:k])
curr = sum(numbers[:k])

while end + 1 < n:
    curr -= numbers[start]
    start += 1
    end += 1
    curr += numbers[end]
    answer = max(answer, curr)


print(answer)