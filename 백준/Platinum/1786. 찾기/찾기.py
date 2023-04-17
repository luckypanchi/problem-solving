import sys

input = sys.stdin.readline


def KMP_table(pattern):
    lp = len(pattern)
    tb = [0] * lp

    pidx = 0
    for idx in range(1, lp):
        while pidx > 0 and pattern[idx] != pattern[pidx]:
            pidx = tb[pidx - 1]

        if pattern[idx] == pattern[pidx]:
            pidx += 1
            tb[idx] = pidx

    return tb


def KMP(word, pattern):
    tb = KMP_table(pattern)

    results = []
    pidx = 0

    for idx in range(len(word)):
        while pidx > 0 and word[idx] != pattern[pidx]:
            pidx = tb[pidx - 1]

        if word[idx] == pattern[pidx]:
            if pidx == len(pattern) - 1:
                results.append(idx - len(pattern) + 2)
                pidx = tb[pidx]
            else:
                pidx += 1

    return results


word = input().rstrip()
pattern = input().rstrip()

answer = KMP(word, pattern)

print(len(answer))
for ans in answer:
    print(ans, end=" ")