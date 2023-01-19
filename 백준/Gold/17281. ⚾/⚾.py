import sys
from itertools import permutations

input = sys.stdin.readline


def main():
    total_inning = int(input())
    expected = [list(map(int, input().split())) for _ in range(total_inning)]

    answer = 0
    tmp_list = list(map(list, permutations(range(1, 9))))

    for tmp in tmp_list:
        order = tmp[:3] + [0] + tmp[3:]
        score = 0
        current = 0
        for inning in range(total_inning):
            out = 0
            base1, base2, base3 = 0, 0, 0
            while out < 3:
                result = expected[inning][order[current]]
                if result == 0:
                    out += 1
                elif result == 1:
                    score += base3
                    base1, base2, base3 = 1, base1, base2
                elif result == 2:
                    score += base2 + base3
                    base1, base2, base3 = 0, 1, base1
                elif result == 3:
                    score += base1 + base2 + base3
                    base1, base2, base3 = 0, 0, 1
                elif result == 4:
                    score += base1 + base2 + base3 + 1
                    base1, base2, base3 = 0, 0, 0
                current = (current + 1) % 9

        answer = max(answer, score)

    print(answer)


main()
