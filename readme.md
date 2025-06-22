# Predictive Maintenance Service

Questo progetto è un servizio di **predictive maintenance** sviluppato in **Spring Boot** seguendo i principi della **Clean Architecture** e del **Domain Driven Design (DDD)**. L'obiettivo è creare un'applicazione modulare, testabile e facilmente estendibile per gestire le manutenzioni predittive di veicoli e componenti.

---

## 🖥️ Copia e incolla in IntelliJ

Per utilizzare questo README direttamente in IntelliJ IDEA:

1. Apri il tuo progetto in IntelliJ.
2. Nella vista **Project**, fai clic destro sulla radice del progetto e seleziona **New » File**.
3. Assegna al file il nome **README.md** e premi **Invio**.
4. Apri il nuovo file e incolla il contenuto di questo documento.
5. IntelliJ evidenzierà automaticamente la sintassi Markdown e potrai visualizzare l'anteprima con **Ctrl+Shift+V** (Windows/Linux) o **⌘⇧V** (macOS).

---

## 🗂️ Struttura del progetto

Il codice è organizzato in tre macro-categorie indipendenti tra loro:

1. **Domain**: contiene il cuore dell'applicazione, ovvero entità, chiavi, aggregati e use cases. Il dominio guida il design e non dipende né da Application né da Interface.
2. **Application**: implementa l’interazione con il database (repository, service di persistenza) e funge da manovalanza per le operazioni definite nel dominio.
3. **Interface**: espone le API REST per loambio dati verso l’esterno (Controller, DTO, Mapper).

```
src/main/java/
├── com.example.domain
│   ├── model
│   │   ├── User.java         // Entità utente
│   │   ├── Vehicle.java      // Entità veicolo
│   │   ├── DueDate.java      // Entità scadenza
│   │   └── Component.java    // Entità componente
│   ├── key
│   │   └── ...               // Chiavi primarie/uniche immutabili
│   ├── aggregate
│   │   └── MaintenanceAggregate.java  // Aggregato principale
│   └── usecase
│       └── ...               // UseCases del dominio
│
├── com.example.application
│   ├── repository
│   └── service
│
└── com.example.interface
    ├── controller
    ├── dto
    └── mapper
```

---

## 🔧 Prerequisiti

- JDK 17+
- Maven 3.6+
- IntelliJ IDEA (Community o Ultimate)
- Database PostgreSQL (o in-memory H2 per sviluppo)

---

## 🚀 Importare il progetto in IntelliJ

1. Clona la repository:
   ```bash
   git clone https://github.com/FedericoIafolla/predictive-maintenance.git
   ```
2. Apri IntelliJ IDEA e seleziona **Open**.
3. Seleziona la cartella del progetto (dove hai clonato la repo).
4. IntelliJ rileva automaticamente il progetto Maven e scarica le dipendenze.
5. Configura il **Project SDK** su JDK 17 nelle impostazioni di progetto.
6. Crea una configurazione di esecuzione Spring Boot:
   - **Run** > **Edit Configurations** > **+** > **Spring Boot**
   - Seleziona la classe principale: `com.example.PredictiveMaintenanceApplication`

---

## ⚙️ Configurazione database

Il progetto utilizza il profilo `dev` con database H2 in memoria:

```properties
# src/main/resources/application-dev.properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

Per PostgreSQL, crea un profilo `prod` in:

```properties
# src/main/resources/application-prod.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/predictive
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username=<user>
spring.datasource.password=<password>
spring.jpa.hibernate.ddl-auto=validate
```

---

## 📦 Entità e Aggregati

- **Entità**: User, Vehicle, DueDate, Component. Ogni entità ha attributi immutabili (chiavi) e versioning per ogni modifica.
- **Chiavi**: package `domain.key`, contengono identificatori univoci (UUID, codice veicolo, ecc.) che non cambiano nel tempo.
- **Aggregato**: `MaintenanceAggregate`, l’unica unità autorizzata a modificare le scadenze.
- **Use Cases**: operazioni dell’aggregato, es. `ScheduleMaintenance`, `CompleteMaintenance`, `ListDueMaintenances`.

---

## 🛠️ Casi d'uso principali

1. **scheduleMaintenance**: programma una nuova scadenza per un componente.
2. **completeMaintenance**: registra il completamento di una manutenzione.
3. **getDueMaintenances**: recupera tutte le scadenze imminenti o scadute.

Ogni caso d’uso si trova in `com.example.domain.usecase` e viene orchestrato dall’aggregato.

---

## 🔄 Estendibilità futura

Grazie alla Clean Architecture, è possibile sostituire o aggiungere interfacce senza impattare il dominio:

- Importare dati da terze parti tramite worker di messaging anziché REST.
- Aggiungere un’interfaccia gRPC o GraphQL semplicemente implementando nuovi adapter in `Interface`.

---

## 📈 Testing

- Unit tests su **Use Cases** e **Aggregato** in `src/test/java/...`
- Integration tests per il livello `Application` con Spring Boot Test e H2.

Esegui tutti i test con:

```bash
mvn clean test
```

---

## 📚 Esempi di chiamate API

### Schedule Maintenance

```http
POST /api/maintenances
Content-Type: application/json

{
  "vehicleId": "...",
  "componentCode": "...",
  "dueDate": "2025-07-15"
}
```

### List Due Maintenances

```http
GET /api/maintenances?status=due
```

---

## 🤝 Contribuire

1. Fork del repository
2. Crea un branch feature: `git checkout -b feature/my-feature`
3. Commit e push: `git commit -m 'Add my feature'` `git push origin feature/my-feature`
4. Apri una Pull Request

---

## 📄 Licenza

Questo progetto è distribuito sotto licenza **MIT**. Vedi [LICENSE](LICENSE) per i dettagli.

---

*Buon lavoro con Predictive Maintenance!*

