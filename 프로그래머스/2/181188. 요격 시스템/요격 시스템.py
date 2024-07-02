def solution(targets):
    targets.sort(key=lambda x: (x[1]))

    answer = 0
    curr = -1
    for s, e in targets:
        if curr <= s:
            curr = e
            answer += 1

    return answer
