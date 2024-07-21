def solution(name):
    answer = 0
    moveCount = len(name) - 1

    for i in range(len(name)):
        answer += min(ord(name[i]) - ord("A"), ord("Z") - ord(name[i]) + 1)
        nextTarget = i + 1
        while nextTarget < len(name) and name[nextTarget] == "A":
            nextTarget += 1
        moveCount = min(moveCount, 2 * i + len(name) - nextTarget, 2 * (len(name) - nextTarget) + i)

    answer += moveCount

    return answer
