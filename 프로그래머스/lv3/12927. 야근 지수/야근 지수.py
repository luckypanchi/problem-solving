from heapq import heapify, heappop, heappush


def solution(n, works):
    if sum(works) <= n:
        return 0

    heap = [-w for w in works]
    heapify(heap)

    for _ in range(n):
        _max = heappop(heap)
        heappush(heap, _max + 1)

    answer = 0
    for v in heap:
        answer += v**2

    return answer