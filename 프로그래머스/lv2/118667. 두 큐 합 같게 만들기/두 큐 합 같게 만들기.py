from collections import deque


def solution(queue1, queue2):
    answer = 0
    
    que1 = deque(queue1)
    que2 = deque(queue2)
    
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    total = sum1 + sum2
    
    limit = (len(que1) + len(que2)) * 2

    if total % 2 != 0:
        return -1

    while True:
        if sum1 > sum2:
            temp = que1.popleft()
            que2.append(temp)
            sum1 -= temp
            sum2 += temp
            answer += 1
        elif sum1 < sum2:
            temp = que2.popleft()
            que1.append(temp)
            sum1 += temp
            sum2 -= temp
            answer += 1
        else:
            break
            
        if answer == limit:
            answer = -1
            break
        
    return answer
