#!/usr/bin/env python

import os
from urllib import parse

HEADER = """# 
# 백준 & 프로그래머스 & SWEA 문제 풀이 목록
"""

URLS = {
    "백준": "https://www.acmicpc.net/problem/",
    "프로그래머스": "https://school.programmers.co.kr/learn/courses/30/lessons/",
    "SWEA": ""
}

def main():
    content = ""
    content += HEADER

    directories = [];
    solveds = [];
    url = "";


    for root, dirs, files in os.walk("."):
        dirs.sort()
        if root == '.':
            for dir in ('.git', '.github'):
                try:
                    dirs.remove(dir)
                except ValueError:
                    pass
            continue

        category = os.path.basename(root)

        if category == 'images':
            continue

        directory = os.path.basename(os.path.dirname(root))

        if directory == '.':
            continue

        if directory not in directories:
            if directory in ["백준", "프로그래머스", "SWEA"]:
                content += "## 📚 {}\n".format(directory)
                url = URLS[directory]
            else:
                content += "### 🚀 {}\n".format(directory)
                content += "| 문제 번호 | 문제 이름 | 문제 링크 | 풀이 링크 |\n"
                content += "| :-----: | :-----: | :-----: | :-----: |\n"
            directories.append(directory)

        rows = []

        for file in files:
            if category not in solveds:
                splitedCatagory = list(map(lambda x: x.strip(), category.split(sep=".", maxsplit=1)))
                my_link = parse.quote(os.path.join(root, file))
                solveds.append(category)
                rows.append((int(splitedCatagory[0]), splitedCatagory[1], my_link))

        rows.sort(key=lambda x: x[0])

        for problem in rows:
            number, name, my_link = problem
            link = url + str(number)
            content += "|{}|{}|[링크]({})|[링크]({})|\n".format(number, name, link, my_link)

    with open("README.md", "w") as fd:
        fd.write(content)


if __name__ == "__main__":
    main()
