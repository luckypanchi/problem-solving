def solution(scores):
    target_score1, target_score2 = scores[0]
    target_sum = target_score1 + target_score2
    
    scores.sort(key=lambda x: (-x[0], x[1]))
    
    max_score2 = 0
    answer = 1
    for score1, score2 in scores:
        if target_score1 < score1 and target_score2 < score2:
            return -1
        
        if max_score2 <= score2:
            max_score2 = score2
            if target_sum < score1 + score2:
                answer += 1
                
    return answer