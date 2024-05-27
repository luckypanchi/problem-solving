import heapq
from collections import deque


def solution(jobs):
    jobs.sort(key=lambda x: (x[0], x[1]))

    que = deque(jobs)
    waiting = []

    results = []
    endTime = 0

    while waiting or que:
        while que and que[0][0] <= endTime:
            startTime, execTime = que.popleft()
            heapq.heappush(waiting, [execTime, startTime])

        if len(waiting) != 0:
            execTime, startTime = heapq.heappop(waiting)
            endTime += execTime
            results.append(endTime - startTime)
        else:
            startTime, execTime = que.popleft()
            endTime = startTime + execTime
            results.append(execTime)

    answer = sum(results) // len(results)
    return answer


print(solution([[0, 3], [1, 9], [2, 6]]))
