import sys
import heapq

input = sys.stdin.readline


def main():
    n, k = map(int, input().split())

    tmp = []

    for _ in range(n):
        tmp.append(list(map(int, input().split())))

    for _ in range(k):
        tmp.append([int(input()), -1])

    tmp.sort(key=lambda x: x[1], reverse=True)
    tmp.sort(key=lambda x: x[0])

    heap = []
    answer = 0

    for item in tmp:
        if item[1] != -1:
            heapq.heappush(heap, (-item[1], item[1]))
        else:
            if heap:
                answer += heapq.heappop(heap)[1]

    print(answer)


main()
