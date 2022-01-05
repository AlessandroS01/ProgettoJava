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

Inseriti queste due informazioni apparirà questa schermata:


|<img src="https://user-images.githubusercontent.com/95358949/148242605-d0c2af51-2484-4a90-847b-c03523010bf5.png" width="1000">|

