
Oppsett:
Jdk: 21
Maven

Lekse:
Du skal lage en diett plan som kan tilpassees etter personers behov.
Du må legge opp planen etter diett mål, allergener, og innhold.  


Ta til betraktening  mat preferanser: Vegansk, vegetarianer, laktosefrit, glutenfritt, eller alt etende.
Diette skal også lages etter personens sine ønsker: Opprettholding av normalvekt, vektnedgang, vektøkning
Denne Dietplanen skal da inneholde middagsplaner basert på personens diett og preferanser. 
Hvilken dietter har vi for enkelte personene, og hvem kan ha hva?. 

-------------- DIETTEN -----------------
Enum Mål
Lag et objekt mål:
* Ingen
* Normalvekt
* vektnedgang
* vektøkning

Class Allergener
Lag et objekt som tar for seg Allergener:

* Ingen
* Gluten
* Laktose
* Soya

Lag en metode hvor den filtrer gjennom matvarer og da returnerer riktig allergener.

Class Måltider 
Lag objekt måltider som inneholder:

* Navn
* Kcal
* Tid
* Matvarer [Liste]
* * Grønnsaker
* * kjøtt
* * Meieri produkter
* * Soya
* * Frukt
* * ETC...
* Mål
* Allergener [Liste]
* Livstil
* Beskrivelse

--------------- PERSONER --------------

Class Livstil
Lag objekt livstil:
* Pescetarianer
* Normal
* Kjøtt eter
* Vegetarianer
* Veganer

Lag en metode som filtrerer gjennom matvarer og returnerer riktig livstil.

Class 5
Lag et objekt person:
* Navn
* Alder
* Vekt
* Mål
* Livstil
* alergener

----------------- Oppgaver ----------------

Oppgave 1:

Lag et datasett med personer.
Du kan ha flere eller et datasett. 

Oppgave 2:

Lag et datasett med dietter
Du kan ha flere eller et datasett.

Oppgave 3:
Du skal ha en funksjon der et vedkomende blir anbefalt måltider som passer. 
Baseres på listil, allergener, og mål

Oppgave 4:
Ha en funksjon der du får et eksempel på vedkommende som ville ha passet til dette måltidet.


PS: Ignorer mine skrivefeil og skriv ting riktig.



docker run -d --name oracle-db -p 1521:1521 -p 5500:5500 -e ORACLE_SID=ORCLCDB -e ORACLE_PDB=ORCLPDB1 -e ORACLE_PWD=Potett0g container-registry.oracle.com/database/enterprise:latest