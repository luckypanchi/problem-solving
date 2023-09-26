from itertools import permutations


def solution(k, dungeons):
    n = len(dungeons)
    answer = 0
    for permu in permutations(range(n)):
        p = k
        count = 0
        for idx in permu:
            if p < dungeons[idx][0]:
                break
            p -= dungeons[idx][1]
            count += 1
            
        answer = max(answer, count)
            
    return answer