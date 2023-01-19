import sys
import heapq

input = sys.stdin.readline


def main():
    n = int(input())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    matrix.sort(key=lambda x: x[1], reverse=True)

    heap = []
    i = 0
    answer = 0

    for day in range(10000, 0, -1):
        while i < n and matrix[i][1] == day:
            heapq.heappush(heap, (-matrix[i][0], matrix[i][0]))
            i += 1
        if heap:
            answer += heapq.heappop(heap)[1]

    print(answer)


main()
