# ProgettoJava

# Introduzione 
La nostra applicazione è un RESTful Web Service che comunicando tramite HTTP, utilizzando Postman , dà la possibilità agli utenti di usufruire delle rotte messe a disposizione.

abbiamo creato questo progetto che dà l'opportunità di visualizzare:  

 •statistiche riguardanti i valori minimi, massimi, media e varianza della velocità e angolatura del vento nel periodo e nella località indicati; 
 
 •differenza tra il forecast e l'attuale dei valori del vento nel periodo e nella località indicati;
 
 •prevesioni meteoroliche  di una città a propria scelta;
 
 •file al cui interno sono contenuti i dati dei precedenti campionamenti e che vengono continuamente aggiornati in base alle chiamate all'API.
 
I nostri campionamenti sono stati effettuati dal 29 dicembre (16:00) al  3 gennaio (13:00) e riguardano solamente la città di Ancona;

Tramite l'utilizzo di due API:
                          
• api.openweathermap.org/data/2.5/forecast?q={city%20name}&appid={API%20key}

• api.openweathermap.org/data/2.5/weather?q={city%20name}&appid={API%20key}

In cui:

• city name è il nome della città selezionata;

• API key è il codice di accesso al servizio;

Esempio schermata:

![image](https://user-images.githubusercontent.com/94000505/148247759-ef46803b-2322-4c9e-905a-f819e17b401a.png)


•coord

  •coord.lon City geo location, longitude
  
  •coord.lat City geo location, latitude
  
•weather (more info Weather condition codes)

  •weather.id Weather condition id
  
  •weather.main Group of weather parameters (Rain, Snow, Extreme etc.)
  
  •weather.description Weather condition within the group. You can get the output in your language.
  
  •weather.icon Weather icon id
  
•base Internal parameter

 •main
 
 •main.temp Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
 
  •main.feels_like Temperature. This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
  
  •main.pressure Atmospheric pressure (on the sea level, if there is no sea_level or grnd_level data), hPa
  
  •main.humidity Humidity, %
  
  •main.temp_min Minimum temperature at the moment. This is minimal currently observed temperature (within large megalopolises and urban areas). Unit Default: Kelvin,            Metric: •Celsius, Imperial: Fahrenheit.
  
   •main.temp_max Maximum temperature at the moment. This is maximal currently observed temperature (within large megalopolises and urban areas). Unit Default: Kelvin,           Metric: •Celsius, Imperial: Fahrenheit.
   
   •main.sea_level Atmospheric pressure on the sea level, hPa
   
   •main.grnd_level Atmospheric pressure on the ground level, hPa
   
•wind

  •wind.speed Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.
  
  •wind.deg Wind direction, degrees (meteorological)
  
  •wind.gust Wind gust. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour
  
•clouds

  •clouds.all Cloudiness, %
  
•rain

  •rain.1h Rain volume for the last 1 hour, mm
  
  •rain.3h Rain volume for the last 3 hours, mm
  
•snow

  •snow.1h Snow volume for the last 1 hour, mm
  
  •snow.3h Snow volume for the last 3 hours, mm
  
•dt Time of data calculation, unix, UTC

•sys

 •sys.type Internal parameter
 
 •sys.id Internal parameter
 
 •sys.message Internal parameter
 
 •sys.country Country code (GB, JP etc.)
 
 •sys.sunrise Sunrise time, unix, UTC
 
 •sys.sunset Sunset time, unix, UTC
 
 •timezone Shift in seconds from UTC
 
 •id City ID
 
 •name City name
 
 •cod Internal parameter



# Come funziona:

Il nostro programma presenta diverse rotte collocate nella server.port 8081.

• "/get/current/{city}" : questa rotta presenta una variabile "city" di default (Ancona) e permette di vedere in tempo reale le condizioni meteorologiche della località precedentemente scelta. 

Per il suo funzionamento abbiamo implementato la classe StartConnectionURLCurrent, la quale attraverso un URL richiama l'API. In tal modo le informazioni vengono salvate all'interno di un JSONObject e quest'ultimo può essere stampato a schermo dall'utente tramite la rotta precedentemente scritta.

• "/get/forecast/{city}" : questa rotta presenta una variabile "city" di default (Ancona) e permette di vedere le condizioni meteorologiche della località in anticipo di 5 giorni ogni 3 ore . 

Per il suo funzionamento abbiamo implementato la classe StartConnectionURL5Days, la quale attraverso un URL richiama l'API. In tal modo le informazioni vengono salvate all'interno di un JSONObject e quest'ultimo può essere stampato a schermo dall'utente tramite la rotta precedentemente scritta.

• "/writer/3/hours/{city}" & "/writer/forecast/{city}" :

Le 2 rotte citate presentano una variabile String "city" di default (Ancona) e permettono all'utente di salvare in modo automatico le informazioni delle 2 API all'interno di 2 file locali chiamati "ApiCallsByTime" e "ApiForecast". All'interno del primo file vengono salvati i JSONObject ottenuti ogni 3 ore , grazie all'utilizzo di un timer , tramite la rotta "/get/current/{city}". All'interno del secondo file invece viene salvato un solo JSONObject ottenuto tramite la rotta "/get/forecast/{city}". Quindi "/writer/3/hours/{city}" & "/writer/forecast/{city}" sono state utilizzate per salvare le informazioni per poi andare a fare delle statistiche sui campioni ottenuti.


•"/filter/per/hour/{time}" questa rotta funge da filtro e permette all'utente di vedere le condizioni meteorologiche ad un'ora ben precisa.

Grazie alla classe FillingModel che si trova nel Package Statistics, più precisamente grazie al metodo fillPlaceCurrent, possiamo effettuare il Parsing dei JSONObject salvati nel file locale ApiCallsByTime tramite la rotta "/writer/3/hours/{city}" e far stampare le condizioni meteorologiche relative ad un'orario impostato dall'utente. Nell'evenienza che l'utente non metta un orario , questo viene settato di default alle 4:00,PM. L'orario deve essere scritto nel metodo illustrato ( ora:minuti,AM_PM ).

•"/filter/per/day/{date}" questa rotta funge da filtro e permette all'utente di vedere le condizioni meteorologiche ad una data ben precisa.

Come nel caso di "/filter/per/hour/{time}" , a seguito del parsing effettuato dal metodo fillPlaceCurrent , possiamo far stampare le condizioni meteorologiche relative ad una giornata in cui è stato effettuato il campionamento . Se non viene immesso il parametro time , questo viene settato di default Wednesday,December 29,2021 . La data deve essere scritta nel metodo illustrato ( giorno_della_settimana,mese giorno_del_mese,anno ).


•"/difference/speed/" questa rotta permette all'utente di vedere la differenza della velocità del vento tra il meteo corrente e il forecast.


•"/see/statistics/{date}" questa rotta permette all'utente di guardare l'andamento meteorologico di un determinato giorno;
   •Velocità massima del vento;
   •Velocità minima del vento;
   •Temperatura media del vento;
   
•"/see/ApiCallsByTime" questa rotta permette di vedere il parsing del file su cui è registrato il meteo corrente.

•"/see/ApiForecast" questa rotta permette di vedere il parsing del file su cui è registrato il forecast.

# Classi implementate














