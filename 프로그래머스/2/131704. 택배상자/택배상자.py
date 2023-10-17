from collections import deque


def solution(order):
    container_que = deque(list(range(1, len(order) + 1)))
    sub_container_que = deque()
    answer = 0

    for curr in order:
        if sub_container_que and sub_container_que[-1] == curr:
            t = sub_container_que.pop()
            answer += 1
            continue

        if len(container_que) == 0:
            break

        while container_que:
            box = container_que.popleft()
            if box == curr:
                answer += 1
                break
            else:
                sub_container_que.append(box)

    return answer