import sys
import heapq


input = sys.stdin.readline

INF = float("inf")

tc = int(input())
for _ in range(tc):
    k = int(input())
    check = dict()
    min_heap = []
    max_heap = []

    for idx in range(k):
        a, b = input().split()
        b = int(b)

        if a == "I":
            heapq.heappush(min_heap, (b, idx))
            heapq.heappush(max_heap, (-b, idx))
            check[idx] = False

        elif a == "D" and b == 1:
            while max_heap:
                num, num_idx = heapq.heappop(max_heap)
                num = -num
                if not check[num_idx]:
                    check[num_idx] = True
                    break

        elif a == "D" and b == -1:
            while min_heap:
                num, num_idx = heapq.heappop(min_heap)
                if not check[num_idx]:
                    check[num_idx] = True
                    break

    _m, _M = INF, INF

    while max_heap:
        num, num_idx = heapq.heappop(max_heap)
        num = -num
        if not check[num_idx]:
            _M = num
            break

    while min_heap:
        num, num_idx = heapq.heappop(min_heap)
        if not check[num_idx]:
            _m = num
            break

    if _m == INF and _M == INF:
        print("EMPTY")
    else:
        print(_M, _m)