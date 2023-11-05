def solution(skill, skill_trees):
    answer = 0
    
    for skill_tree in skill_trees:
        i, j = 0, 0
        for s in skill_tree:
            if s in skill:
                if skill[i] == skill_tree[j]:
                    i += 1
                    j += 1
                else:
                    break
            else:
                j += 1    
        else:
            answer += 1
                    
    return answer