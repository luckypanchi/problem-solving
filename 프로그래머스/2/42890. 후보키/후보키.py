from itertools import combinations


def solution(relation):
    rowCount = len(relation)
    colCount = len(relation[0])

    answer = 0
    uniqueList = []

    for r in range(1, colCount + 1):
        candidates = list(combinations(range(colCount), r))
        for candidate in candidates:
            selected = set()
            for row in relation:
                array = [row[i] for i in candidate]
                selected.add(",".join(array))

            if len(selected) == rowCount:
                isContain = False
                for _set in uniqueList:
                    if len(_set & set(candidate)) == len(_set):
                        isContain = True
                        break

                if not isContain:
                    uniqueList.append(set(candidate))
                    answer += 1

    return answer
