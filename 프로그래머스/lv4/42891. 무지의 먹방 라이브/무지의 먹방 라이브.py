import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1
    
    heap = []
    for idx, food in enumerate(food_times):
        heapq.heappush(heap, (food, idx + 1))
    
    total = 0
    prev = 0
    length = len(food_times)
    
    while total + (heap[0][0] - prev) * length <= k:
        curr = heapq.heappop(heap)[0]
        total += (curr - prev) * length
        length -= 1
        prev = curr
        
    result = sorted(heap, key=lambda x: x[1])
    return result[(k - total) % length][1]