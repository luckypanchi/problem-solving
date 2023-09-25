from collections import Counter
import heapq


def solution(k, tangerine):
    counter = Counter(tangerine)
    
    heap = []
    for key, value in counter.items():
        heapq.heappush(heap, -value)
        
    answer = 0
    while 0 < k:
        answer += 1
        k += heapq.heappop(heap)
    
    return answer