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

#### Codici Risposta
Ogni [metodo HTTP](#metodi-http) prevede risposte ben definite come riportato in tabella:

| Operazione     | Metodo  | Success       | Failure                                 |
| -------------- | ------- | ------------- | --------------------------------------- | 
| **C**reate     | POST    | 201 - Created | [Fallimento Create](#fallimento-create) | 
| **R**ead       | GET     | 200 - Success | [Fallimento Read](#fallimento-read)     |
| **U**pdate     | PUT     | 200 - Success | [Fallimento Update](fallimento-update)  |
| **D**elete     | DELETE  | 200 - Success | [Fallimento Delete](#fallimento-delete) |

##### Fallimento Create
Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre.
##### Fallimento Read
Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre.
##### Fallimento Update
Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre.
##### Fallimento Delete
Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre.
#### Gestione Eccezioni
Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre.
#### Connessione Al Db
Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre.
#### Unit Test
Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre.
#### Sicurezza
Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre. Questo è un test per vedere se la pagina scorre.