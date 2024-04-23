import sys

input = sys.stdin.readline


n = int(input())
storages = [int(input()) for _ in range(n)]

answer = 0
for target in list(set(storages)):
    length = []
    currLength = 0
    currStorage = storages[0]
    for s in storages:
        if s == target:
            continue
        if s != currStorage:
            length.append(currLength)
            currLength = 1
            currStorage = s
        else:
            currLength += 1
    length.append(currLength)

    answer = max(answer, max(length))

print(answer)