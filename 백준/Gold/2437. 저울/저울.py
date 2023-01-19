import sys

input = sys.stdin.readline


n = int(input())
weights = list(map(int, input().split()))

weights.sort()

start = 0
end = 0


for w in weights:
    new_start = start + w
    new_end = end + w

    if end + 1 < new_start:
        break
    else:
        end = new_end

answer = end + 1

print(answer)
