from collections import defaultdict
import math


def solution(enroll, referral, seller, amount):
    counter = defaultdict(int)
    superior = defaultdict(str)

    for p, s in zip(enroll, referral):
        superior[p] = s

    def dfs(person, money):
        if person == "-" or money == 0:
            return

        mine = math.ceil(money * 0.9)
        counter[person] += mine
        dfs(superior[person], money - mine)

    for person, c in zip(seller, amount):
        dfs(person, c * 100)

    return [counter[person] for person in enroll]
