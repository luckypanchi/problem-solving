from collections import deque


def getEndTime(start, playtime):
    hour, minute = map(int, start.split(":"))
    playtime = int(playtime)

    minute += playtime
    hour += minute // 60
    minute %= 60

    return f"{hour}:{minute}"


def getTimeGap(endTime, nextStartTime):
    hour1, minute1 = map(int, endTime.split(":"))
    hour2, minute2 = map(int, nextStartTime.split(":"))
    return (60 * hour2 + minute2) - (60 * hour1 + minute1)


def solution(plans):
    answer = []
    plans.sort(key=lambda x: x[1])

    que = deque(plans)
    paused = []

    while que:
        name, start, playtime = que.popleft()
        endTime = getEndTime(start, playtime)

        if len(que) == 0:
            answer.append(name)
            break

        timeGap = getTimeGap(endTime, que[0][1])

        if timeGap == 0:
            answer.append(name)
        elif timeGap < 0:
            paused.append((name, -timeGap))
        elif timeGap > 0:
            answer.append(name)
            while paused and timeGap > 0:
                name, timeLeft = paused.pop()
                if timeLeft <= timeGap:
                    timeGap -= timeLeft
                    answer.append(name)
                else:
                    timeLeft -= timeGap
                    paused.append((name, timeLeft))
                    break

    while paused:
        name, _ = paused.pop()
        answer.append(name)

    return answer