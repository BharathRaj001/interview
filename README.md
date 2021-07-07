We are Exposing 2 services to forecast the weather details .
1. client can input the City  and country of which he wants to check the weather details.
2. client can choose to input latitute and longitude of the place.

Both of the service will provide the detailed weather details with include coordinate ,base,visibility,wind speed ,cloud etc.

the service  will call underneath thirdpary APIs and cache the data for 2 hours

Below are the curds to the apis:

1.By city
curl --location --request GET 'http://localhost:8080/weather/byCity?country=in&city=Delhi'

2. By Polar co ordinates
curl --location --request GET 'http://localhost:8080/weather/byOrdinates?lat=35&lon=13'
