def solution(n, s):
    if s < n:
        answer = [-1]
    else:
        a = s // n
        b = s % n
        answer = [a] * (n - b) + [a + 1] * b
    return answer