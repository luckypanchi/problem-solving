def check(t1, t2):
    t1Hour, t1Min = map(int, t1.split(":"))
    t2Hour, t2Min = map(int, t2.split(":"))

    t1Min += 10
    if t1Min > 60:
        t1Hour += 1
        t1Min -= 60

    return 100 * t1Hour + t1Min <= 100 * t2Hour + t2Min


def solution(book_time):
    book_time.sort()
    rooms = [[] for _ in range(len(book_time))]

    answer = 0
    for time in book_time:
        for room in rooms:
            if len(room) == 0:
                answer += 1
                room.append(time)
                break

            if check(room[-1][1], time[0]):
                room.append(time)
                break

    return answer
