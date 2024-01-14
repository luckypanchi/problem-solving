def solution(storey):
    answer = 0

    while storey:
        curr = storey % 10

        if curr > 5:
            answer += 10 - curr
            storey += 10
        elif curr < 5:
            answer += curr
        else:
            if (storey // 10) % 10 > 4:
                storey += 10
            answer += curr
        storey //= 10

    return answer
