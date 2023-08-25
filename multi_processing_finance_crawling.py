# 병렬 처리를 통해
# naver_finance 파일에서 실행한 stock csv 파일 저장을 실행
# 보다 빠르게 실행 가능

# Multi-processing

import requests 
import csv 
import pickle 
from multiprocessing import Pool 

sise_url = "https://api.finance.naver.com/siseJson.naver?symbol={}&requestType=1&startTime=2020101&endTime=20230823&timeframe=day"

def get_stock(code):
    r2 = requests.post(sise_url.format(code))
    data_list = eval(r2.text.replace("\n", "").strip())
    with open('./stock/{}.csv'.format(code), 'w', encoding='utf-8-sig', newline='') as csvfile:
        writer = csv.writer(csvfile)
        for x in data_list:
            writer.writerow(x)

if __name__=="__main__":
    with open("./master.pkl", "rb") as f:
        master = pickle.load(f)

    pool = Pool(processes=4)
    pool.map(get_stock, master)