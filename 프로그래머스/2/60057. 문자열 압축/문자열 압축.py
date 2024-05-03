INF = float("inf")


def solution(s):
    totalLength = len(s)

    answer = INF

    for length in range(1, totalLength + 1):
        string = ""
        prev = ""
        count = 1

        end = 0
        for start in range(0, totalLength, length):
            end = start + length
            if prev == s[start:end]:
                count += 1
            else:
                if count != 1:
                    string += str(count)
                string += prev

                prev = s[start:end]
                count = 1

        if count != 1:
            string += str(count)
        string += prev
        string += s[end:]

        answer = min(answer, len(string))

    return answer