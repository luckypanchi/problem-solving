import sys
import heapq

input = sys.stdin.readline


tc = int(input())
answers = []

for _ in range(tc):
    k = int(input())
    files = list(map(int, input().split()))
    heapq.heapify(files)

    answer = 0

    while len(files) > 1:
        result = heapq.heappop(files) + heapq.heappop(files)
        heapq.heappush(files, result)
        answer += result

    answers.append(answer)

print(*answers, sep="\n")
