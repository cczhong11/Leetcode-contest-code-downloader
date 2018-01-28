'''this file could get questions templates'''

import codecs
path = 'Questiondir/'
import os
import sys
import re
import requests

question_id_map = {}
question_id_map["787"] = 771
question_id_map["788"] = 773
question_id_map["790"] = 774
question_id_map["782"] = 775


class Contest_download(object):

    def __init__(self, contest_id):
        self.contest_id = contest_id
        self.data_list = {}
        self.code_count = {}

    def login(self):
        # use leetcode cli to login
        c = "leetcode user -l < password"
        os.system(c)

    def get_question_description(self, question_id):
        '''
        1. download question
        2. save to data list
        '''
        q = "leetcode show -g -l java {0} > question".format(question_id)
        os.system(q)
        q2 = "ls {0}*.java > q".format(question_id)
        os.system(q2)
        question = ""
        question_t_file = ""
        # get template filename
        with open('q') as f:
            filename = f.readline()
            question_t_file = filename[:-1]
            filename = filename.split('.')
        # mkdir
        if not os.path.exists(path + "/" + question_t_file[:-5]):
            os.mkdir(path + "/" + question_t_file[:-5])
        os.system(
            "mv question {1}/{0}/{0}.txt".format(question_t_file[:-5], path))
        os.system("mv {0} {2}/{1}/".format(question_t_file,
                                           question_t_file[:-5], path))
        os.system("rm q")

        with open("data", "a") as f:
            f.write("{0}\t{1}\n".format(question_id, question_t_file[:-5]))

    def read_from_data(self):
        with open("data") as f:
            for line in f.readlines():
                n, q = line.split("\t")
                self.data_list[n] = q[:-1]
                self.code_count[n] = 0

    def find_question(self, question_id):
        if str(question_id) not in self.data_list:
            return None
        return self.data_list[str(question_id)]

    def get_contest(self):
        rs = {}
        if self.contest_id > 57:
            url = "https://leetcode.com/contest/api/ranking/weekly-contest-{0}/?pagination=".format(
                self.contest_id)
        else:
            url = "https://leetcode.com/contest/api/ranking/leetcode-weekly-contest-{0}/?pagination=".format(
                self.contest_id)
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

    def download_code(self, id, question_id):
        '''download answer with submission id and question id'''
        submission = "https://leetcode.com/api/submissions/" + str(id)
        r = requests.get(submission)
        if not r.ok:
            return

        response = r.json()

        question_name = self.find_question(question_id)
        if question_name == None:
            self.get_question_description(question_id)
            self.read_from_data()
            question_name = self.find_question(question_id)
        lang = ''
        print("downloading for {0}".format(question_name))
        if response['lang'] == 'python':
            lang = 'py'
        elif response['lang'] == 'java':
            lang = 'java'
        else:
            return

        with open("{2}/{0}/{0}_{1}.{3}".format(question_name, response['id'], path, lang), 'w') as f:
            f.write(response['code'])

        #self.code_count[question_id] += 1

    def download(self):

        rs = self.get_contest()
        for k in rs:
            for num in rs[k]:
                # for contest 68 you have to replace k with  str(int(k) - 11)
                if self.contest_id == 68:
                    question_id = str(int(k) - 11)
                elif self.contest_id == 69:
                    question_id = question_id_map[k]
                else:
                    question_id = k
                self.download_code(num, question_id)


if __name__ == "__main__":
    contest_id = input("Which contest you want to download:")
    q = Contest_download(int(contest_id))
    q.download()
