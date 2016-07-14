# Asumpcions

S'han fet les següents assumpcions per a la generació del projecte:

* En un poema els versos són cadascuna de les unitats de text separades per una línea en blanc.

* En un vers una línea es cada unitat de text que finalitza amb un line feed `\n`.

* Un poema està format per un o més versos.

* Un vers està format per una o més línies.

* Un poema serà considerat com anagrama si les seves línies o els seus versos són una anagrama entre si.

* En poemes d'un sol vers, només es considerarà anagrama en cas que les línies d'aquest ho siguin.

* Poemes amb un únic vers, d'una sola línea, no serà considerat anagrama.

* Per comparar línies no és té en compte espais en blanc, símbols de puntuació, ni accents, dieresis... . La comparació també és case insensitive.

* Dues línies amb el mateix text exacte NO es considera anagrama. És a dir: "hola com estàs" i "hola com estàs" no són un anagrama.

# Run test & compile
* El build tool utilitzat és [*Gradle*](https://gradle.org/). Si heu utilitzat *Maven* i/o *Ant* no tindreu problema en fer-lo servir `:)`, només cal descarregar els binaris o l'instal•lable des [d'aquí](https://gradle.org/), un cop instal•lat assegurar-se que està al path del sistema operatiu i executar la següent comanda per veure que la instal•lació és correcte `gradle -version`. Gradle fa servir maven com a gestor de dependencies i a més comparteix la mateixa estructura de projecte (`src/main/java`, `src/main/resources`,`src/test/java`, etc...)
* Per a executar els test unitaris només és necessari executar `gradle test`. El resultat dels mateixos es desarà en un html en la següent ruta del projecte `./build/reports/tests/index.html`.
* Per a generar el jar a partir dels binaris `gradle jar`. El `jar` queda generat a la següent ubicació `.build/libs/`. 
* Per tal d'executar el `jar` es pot fer servir la següent comanda des de la pròpia ubicació on s'ha generat: `java -cp .\AnagramPoem-0.0.0.1.jar cat.test.anagram.AnagramPoem -f path/to/poem.txt`. El resultat simplement dirà si el poema que conté el fitxer és anagrama o no. No hi ha tractament d'errors, el programa és resilent :P... simplement tornarà false en cas q no existeixi el fitxer. Si la comanda és incorrecte mostrarà un missatge explicant com ha de ser la comanda.
* També existeix la tasca `gradle help` que mostrarà aquesta mateixa explicació.
* Les comandes *Gradle* s'han d'executar des del path base del projecte on es troba el fitxer `build.gradle`.


# Altres consideracions
* S'ha evitat fer ús de dependencies de llibreries o mètodes de tercers a excepció del *Junit* per a l'execució dels tests.
