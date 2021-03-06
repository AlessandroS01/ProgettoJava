# ProgettoJava

# Introduzione 
La nostra applicazione è un RESTful Web Service che comunicando tramite HTTP, utilizzando Postman , dà la possibilità agli utenti di usufruire delle rotte messe a disposizione.

Il progetto dà l'opportunità di visualizzare:  

 •statistiche riguardanti i valori minimi, massimi, media e varianza della velocità e angolatura del vento nel periodo e nella località indicati; 
 
 •differenza tra il forecast e l'attuale dei valori del vento nel periodo e nella località indicati;
 
 •prevesioni meteoroligiche  di una città a propria scelta;
 
 •file al cui interno sono contenuti i dati dei precedenti campionamenti e che vengono continuamente aggiornati in base alle chiamate all'API.
 
I nostri campionamenti , ottenuti tramite le due API sotto scritte , sono stati effettuati dal 29 dicembre (16:00) al 3 gennaio (13:00) e riguardano solamente la città di Ancona;
                  
• api.openweathermap.org/data/2.5/forecast?q={city%20name}&appid={API%20key} : per ottenere dati riguardo al meteo ogni 3 ore per 5 giorni.

• api.openweathermap.org/data/2.5/weather?q={city%20name}&appid={API%20key} : per ottenere dati riguardo al meteo all'istante in cui avviene la chiamata.

All'interno di entrambe le API troviamo :

• city name : nome della città di cui si vuole andare ad ottenere i dati ;

• API key : il codice di accesso al servizio.

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


•"/filter/per/hour/{time}" : funge da filtro e permette all'utente di vedere le condizioni meteorologiche ad un'ora ben precisa.

Grazie alla classe FillingModel che si trova nel Package Statistics, più precisamente grazie al metodo fillPlaceCurrent, possiamo effettuare il Parsing dei JSONObject salvati nel file locale ApiCallsByTime tramite la rotta "/writer/3/hours/{city}" e far stampare le condizioni meteorologiche relative ad un'orario impostato dall'utente. Nell'evenienza che l'utente non metta un orario , questo viene settato di default alle 4:00,PM. L'orario deve essere scritto nel metodo illustrato ( ora:minuti,AM_PM ).
Se l'orario impostato non esiste allora all'utente avrà restituito un messaggio di errore ottenuto tramite un'eccezzione personalizzata.

•"/filter/per/day/{date}" : funge da filtro e permette all'utente di vedere le condizioni meteorologiche ad una data ben precisa.

Come nel caso di "/filter/per/hour/{time}" , a seguito del parsing effettuato dal metodo fillPlaceCurrent , possiamo far stampare le condizioni meteorologiche relative ad una giornata in cui è stato effettuato il campionamento . Se non viene immesso il parametro time , questo viene settato di default Wednesday,December 29,2021 . La data deve essere scritta nel metodo illustrato ( giorno_della_settimana,mese giorno_del_mese,anno ).
Se la data impostata non esiste allora all'utente avrà restituito un messaggio di errore ottenuto tramite un'eccezzione personalizzata.

•"/difference/speed/" : permette all'utente di vedere la differenza della velocità del vento tra il meteo corrente e il forecast.

Attraverso un confronto tra i dati salvati a seguito del campionamento , vengono effettuati dei controlli in base all'orario e alla data contenuti nei JSONObject che situano nei due file di testo locali . Quindi se orario e data sono gli stessi per entrambi gli oggetti dei due file , l'applicazione fornisce come ritorno una Stringa contenente al suo interno le differenze del dato relativo alla velocità del vento . Il funzionamento della rotta è reso possibile grazie al metodo differenceSpeedCurrentForecast contenuto nella Classe Stats all'interno del package Statistics.


•"/see/statistics/{date}" : permette all'utente di visualizzare l'andamento meteorologico in un determinato giorno.
 
Come in altri casi precedenti , la rotta può essere modificata dall'utente utilizzando un parametro date . Se date non viene inizializzata , allora assumerà come valore di default "Wednesday,December 29,2021" . Se invece passiamo un valore a date che non trova congruenze con i valori di date all'interno dei file , stamperà una scritta di errore.
Date è un parametro che deve essere immesso sempre nel metodo seguente : ( giorno_della_settimana,mese giorno_del_mese,anno ).
Se la data impostata non esiste o risulta sbagliata allora all'utente verrà restituito un messaggio di errore ottenuto tramite un'eccezzione personalizzata.

   
•"/see/ApiCallsByTime" : permette di visualizzare il parsing del file ApiCallsByTime su cui è registrato il meteo corrente.

•"/see/ApiForecast" : permette di vedere il parsing del file ApiForecast su cui è registrato il forecast.

# Test

All'interno del programma sono stati implementati 2 test :

i) serve a capire se la rotta "/writer/3/hours/{city}" & "/writer/forecast/{city}" funziona in modo corretto .

ii) serve a capire se il contenuto all'interno del file ApiCallsByTime risulta "danneggiato" o incompleto .

# Come ottenerlo


Clonando questo repository sul vostro computer e importandolo nell'IDE Eclipse avrete accesso al nostro progetto.

Per avviare il programma basta selezionare il package it.univpm.ProgettoOOP e dare il comando Run as -> Spring Boot App. 

Quando apparirà la schermata Springboot sulla propria console allora sarete pronti a partire. Per usufruire dei servizi potete utilizzare il localhost sulla porta 8081 digitando sulla barra di ricerca localhost:8081/ROTTA_DESIDERATA.



# Divisione del lavoro

-Seghini Alessandro : creazione delle rotte , della chiamata all'API , del parsing dei JSONObject e delle eccezioni . 

-Manuel Mulloni : creazione dei test , del Model , delle statistiche e dei filtri . 










