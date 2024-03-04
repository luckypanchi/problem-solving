totalList = set()


def select(bannedList, selected, curr):
    if curr == len(bannedList):
        selected.sort()
        s = "".join(selected)
        if s not in totalList:
            totalList.add(s)
            return 1
        return 0

    result = 0

    for banned in bannedList[curr]:
        if banned not in selected:
            result += select(bannedList, selected + [banned], curr + 1)

    return result


def isTarget(banned, user):
    if len(banned) != len(user):
        return False

    for i in range(len(banned)):
        if banned[i] == "*":
            continue
        elif banned[i] != user[i]:
            return False

    return True


def solution(user_id, banned_id):
    bannedList = [[] for _ in range(len(banned_id))]

    for i in range(len(banned_id)):
        banned = banned_id[i]
        for user in user_id:
            if isTarget(banned, user):
                bannedList[i].append(user)

    answer = select(bannedList, [], 0)
    return answer