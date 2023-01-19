def getNumber(n, idx):
    r = idx // n + 1
    c = idx % n + 1
    return max(r, c)

def solution(n, left, right):
    answer = []
    for i in range(left, right + 1):
        answer.append(getNumber(n, i))
    
    return answer