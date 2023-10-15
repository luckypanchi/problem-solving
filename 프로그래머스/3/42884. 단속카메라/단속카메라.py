def solution(routes):
    answer = 0
    camera = -30001
    routes.sort(key=lambda x: x[1])

    for start, end in routes:
        if camera < start:
            answer += 1
            camera = end

    return answer
