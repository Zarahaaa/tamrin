import requests

API_KEY = "d5a8f3bc47f6a62557967f944a6be268"
city = str(input("enter the city: "))
url = f"https://api.openweathermap.org/data/2.5/weather?q={city}&appid={API_KEY}&units=metric&lang=fa"

response = requests.get(url)

print(response.text)       




