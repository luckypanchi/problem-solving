import heapq


max_heap = []
min_heap = []
flag = []


def solution(operations):
    
    for operation in operations:
        op, num = operation.split()
        num = int(num)
        if op == "I":
            heapq.heappush(max_heap, (-num, len(flag)))
            heapq.heappush(min_heap, (num, len(flag)))
            flag.append(True)
        elif op == "D" and num == 1:
            while max_heap and not flag[max_heap[0][1]]:
                heapq.heappop(max_heap)
            if len(max_heap) != 0:
                flag[max_heap[0][1]] = False
                heapq.heappop(max_heap)
        elif op == "D" and num == -1:
            while min_heap and not flag[min_heap[0][1]]:
                heapq.heappop(min_heap)
            if len(min_heap) != 0:
            	flag[min_heap[0][1]] = False
            	heapq.heappop(min_heap)
                
    while max_heap and not flag[max_heap[0][1]]:
        heapq.heappop(max_heap)
    while min_heap and not flag[min_heap[0][1]]:
        heapq.heappop(min_heap)
                
    if len(min_heap) == 0 or len(max_heap) == 0:
        answer = [0, 0]
    else:
        answer = [-max_heap[0][0], min_heap[0][0]]

    return answer