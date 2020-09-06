# basic-rest-ws-rules

### Descrizione
Questo progetto mostra come implementare un servizio rest attraverso Spring Boot seguendo le linee guida canoniche. Vengono affrontati:

* [Metodi HTTP](#metodi-http)
* [Codici Risposta](#codici-risposta)
* [Gestione Eccezioni](#gestione-eccezioni)
* [connessione al db](#connessione-al-db)
* [Unit Test](#unit-test)
* [Sicurezza](#sicurezza)

#### Metodi HTTP
Le 4 operazione della persistenza **C**reate, **R**ead, **U**pdate e **D**elete (**CRUD**) sono mappate rispettivamente sui seguenti 4 metodi HTTP:
* POST
* GET
* PUT
* DELETE

Per implementare un servizio basta creare un controller annotandolo con ```@RestController``` annotando i vari metodi come in ```com.mdev.restws.br.controller.AppController```.

Relativamente alle **C**reate la richiesta porta all'interno del body l'entità da aggiungere in formato JSON.
La **R**ead può essere effettuata in due modalità differenti: per singolo oggetto o per tutte le entità. Nel primo caso, generalmente, la risorsa è richiesta passando l'identificativo tramite una variabile all'interno dell'url, nel secondo caso invece senza alcuna variabile.
L'operazione di **U**pdate prevede che sia presente all'interno del body l'entità modificata e all'interno dell'url l'identificativo della stessa.
La **D**elete prevede che l'identificativo dell'entità da cancellare sia passato all'interno dell'url.

#### Codici Risposta
Ogni [metodo HTTP](#metodi-http) prevede risposte ben definite come riportato in tabella:

| Operazione     | Metodo  | Success Code  | Success Header                 | Success Body       | Failure                                 |
| -------------- | ------- | ------------- | ------------------------------ | ------------------ | --------------------------------------- | 
| **C**reate     | POST    | 201 - Created | location: {url-risorsa-creata} | -                  | [Fallimento Create](#fallimento-create) | 
| **R**ead       | GET     | 200 - Success | -                              | entità richiesta/e | [Fallimento Read](#fallimento-read)     |
| **U**pdate     | PUT     | 200 - Success | -                              | -                  | [Fallimento Update](fallimento-update)  |
| **D**elete     | DELETE  | 200 - Success | -                              | -                  | [Fallimento Delete](#fallimento-delete) |

##### Fallimento Create

Nel caso di fallimento di una create è buona norma rispondere con i codici di errore:

* *400 Bad Request* nel caso in cui vi siano errori di validazione o risultino violati i vincoli di integrità.
* *401 Unauthorized* nel caso di errori di autenticazione.
* *500 Internal Server Error* in tutti gli altri casi. 

##### Fallimento Read

Nel caso di fallimento di una read è buona norma rispondere con i codici di errore:

* se la richiesta è effettuata per singola risorsa:
    * *401 Unauthorized* nel caso di errori di autenticazione.
    * *404 Not Found* nel caso in cui all'identificativo passato come parametro non sia associata nessuna risorsa.
    * *500 Internal Server Error* in tutti gli altri casi. 
* altrimenti:
    * *401 Unauthorized* nel caso di errori di autenticazione.
    * *500 Internal Server Error* in tutti gli altri casi.

##### Fallimento Update

In aggiunta a quanto riportato in [Fallimento Create](#fallimento-create) si aggiunge:

* *404 Not Found* nel caso in cui all'identificativo passato come parametro non sia associata nessuna risorsa.

##### Fallimento Delete

Nel caso di fallimento di una Delete è buona norma rispondere con i codici di errore:

* *401 Unauthorized* nel caso di errori di autenticazione.
* *404 Not Found* nel caso in cui all'identificativo passato come parametro non sia associata nessuna risorsa.
* *500 Internal Server Error* in tutti gli altri casi. 

#### Gestione Eccezioni

Per uniformare la gestione delle eccezzioni è buona norma:
* Standardizzare il formato delle risposte d'errore (vedi ```com.mdev.restws.br.dto.ExceptionResponse```).
* Estendere la classe ```org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler``` e procedere com in ```com.mdev.restws.br.controller.ResponseEntityExceptionController```.

#### Connessione Al Db

#### Unit Test

#### Sicurezza