from collections import deque

INF = int(1e9)


def solution(s):
    answer = INF
    
    for length in range(1, len(s) + 1):
        que = deque(s.strip())
        result = ""
        curr = ""
        cnt = 1
        for _ in range(length):
            curr += que.popleft()
        
        while que:
            tmp = ""
            for _ in range(length):
                if que:
                    tmp += que.popleft()
            if curr == tmp:
                cnt += 1
            else:
                if cnt == 1:
                    result += curr
                else:
                    result += str(cnt) + curr
                curr = tmp
                cnt = 1
        if cnt == 1:
            result += curr
        else:
            result += str(cnt) + curr 
        answer = min(answer, len(result))
    
    return answer