'''this file could get questions templates'''

import codecs
path = 'Questiondir/'
import os
import sys
import re
import requests

data_list = {}
code_count = {}
lastid = 600


def read_question_name(q_n):
    q2 = "ls {0}*.java > q".format(q_n)
    os.system(q2)
    question_t_file = ''
    with open('q') as f:
        filename = f.readline()
        question_t_file = filename[:-1]
        filename = filename.split('.')
        try:
            question = filename[1]
        except:
            return (-1, -1)
    with open(question_t_file) as f:

        first_line = f.readline()
        while "*" in first_line:
            first_line = f.readline()
        content = f.readline()
        if "Solution" not in first_line:
            content = re.findall("class (\w+) {", first_line)[0]
        else:
            content = re.findall(" (\w+)\(", content)[0]

    if not os.path.exists(path + "/" + question_t_file[:-5]):
        os.mkdir(path + "/" + question_t_file[:-5])
    os.system("mv question {1}/{0}/{0}.txt".format(question_t_file[:-5], path))
    os.system("mv {0} {2}/{1}/".format(question_t_file,
                                       question_t_file[:-5], path))
    os.system("rm q".format(question_t_file))
    return (question_t_file[:-5], content)


def download_question(q_n):

    # login in
    #c = "leetcode user -l < a1"
    # os.system(c)
    # get question
    q = "leetcode show -g -l java {0} > question".format(q_n)

    os.system(q)
    (question, function_name) = read_question_name(q_n)
    if question == -1:
        return
    with open("data", "a") as f:
        f.write("{2}\t{0}\t{1}\n".format(question, function_name, q_n))


def read_from_data():
    global data_list, code_count
    with open('data') as f:
        for line in f.readlines():
            n, q, question_key = line.split("\t")
            data_list[n] = [q, question_key[:-1]]
            code_count[n] = 0


def findq(q_n):
    if str(q_n) not in data_list:
        return "m"
    return data_list[str(q_n)][0]


def get_contest(contest):
    rs = {}
    if contest > 57:
        url = "https://leetcode.com/contest/api/ranking/weekly-contest-{0}/?pagination=".format(
            contest)
    else:
        url = "https://leetcode.com/contest/api/ranking/leetcode-weekly-contest-{0}/?pagination=".format(
            contest)
    for i in range(2):
        r = requests.get(url + str(i + 1))
        r = r.json()
        allsub = r['submissions']
        for one in allsub:
            for q_n in one:
                if q_n not in rs:
                    rs[q_n] = []
                rs[q_n].append(one[q_n]['submission_id'])
    return rs


def download_code(id, q_n):

    submission = "https://leetcode.com/api/submissions/" + str(id)
    r = requests.get(submission)
    if not r.ok:
        return

    response = r.json()
    print(response['lang'])
    if response['lang'] == 'java':
        question = findq(q_n)
        print(question)
        if question == "m":
            download_question(q_n)
            read_from_data()
            question = findq(q_n)
        try:
            with open("{2}/{0}/{0}_{1}.java".format(question, response['id'], path), 'w') as f:
                f.write(response['code'])
            code_count[str(lastid)] += 1
        except:
            return
    if 'python' in response['lang']:
        question = findq(q_n)
        if question == "m":
            download_question(q_n)
            read_from_data()
            question = findq(q_n)
        try:
            with open("{2}/{0}/{0}_{1}.py".format(question, response['id'], path), 'w') as f:
                f.write(response['code'])
            code_count[str(lastid)] += 1
        except:
            return


read_from_data()
for i in range(68, 69):
    rs = get_contest(i)
    for k in rs:
        for num in rs[k]:
            # for contest 68 you have to replace k with  str(int(k) - 11)
            download_code(num, k)
