import requests
import random
import _thread
import threading
def getNum():
    return str(random.random())[3:random.randint(10,13)]
def ss():
    for i in range(0,99999):
        print(i)
        requests.post(url="http://www.qlrs-vip.cn/2017.php",data={"u":"","p":getNum()+getNum()+getNum(),"bianhao":1})
for i in range(0,50):
    threading.Thread(target=ss).start()