import sys

input = sys.stdin.readline


n, k = map(int, input().split())
numbers = list(map(int, input().split()))

start = 0
end = k - 1

curr = sum(numbers[:k])
answer = curr
cnt = 1

while end + 1 < n:
    curr -= numbers[start]
    start += 1
    end += 1
    curr += numbers[end]

    if answer < curr:
        answer = curr
        cnt = 1
    elif answer == curr:
        cnt += 1

if answer == 0:
    print("SAD")
else:
    print(answer)
    print(cnt)