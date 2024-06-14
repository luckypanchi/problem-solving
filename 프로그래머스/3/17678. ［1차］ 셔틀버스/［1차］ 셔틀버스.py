from collections import deque


def convert(timeString):
    h, m = map(int, timeString.split(":"))
    return h * 60 + m


def solution(n, t, m, timetable):
    timetable = sorted(list(map(convert, timetable)))
    que = deque(timetable)

    answer = 0
    currTime = 9 * 60
    for _ in range(n):
        crewCount = 0
        last = -1
        while crewCount < m and que and que[0] <= currTime:
            last = que.popleft()
            crewCount += 1

        if crewCount < m:
            answer = currTime
        else:
            answer = last - 1

        currTime += t

    answer = str(answer // 60).zfill(2) + ":" + str(answer % 60).zfill(2)
    return answer

