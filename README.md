# spring-backend-uek295

---

# 1. Beschreibung
Das vorliegende Projekt stellt eine API zur Verwaltung von Produkten eines Online-Shops bereit. Das Hauptziel dieser API ist es, die erforderlichen Endpoints für die Erstellung, Abfrage, Aktualisierung und Löschung von Produkten und Kategorien in einer Datenbank bereitzustellen, wobei alle Endpoints dem REST-Standard entsprechen.

Da das Frontend für die Webanwendung in einem späteren Projekt entwickelt wird, wurde besonderer Wert auf eine saubere Strukturierung und gründliche Dokumentation der API gelegt. Dies stellt sicher, dass zukünftige Entwicklungen nahtlos integriert werden können und dass externe Entwickler oder Systeme problemlos mit der API interagieren können.

Die Datenstruktur dieses Projekts besteht aus den Haupttabellen product und category, die durch einen Fremdschlüssel, category_id, miteinander verbunden sind. Dies ermöglicht die Zuweisung von Produkten zu bestimmten Kategorien. Darüber hinaus wurde eine zusätzliche Tabelle Users eingeführt, um die Authentifizierung und Autorisierung von API-Anfragen zu unterstützen.

Um die Sicherheit und Integrität der Daten und der API-Interaktion zu gewährleisten, sind alle Endpoints (mit Ausnahme des Authentifizierungsendpoints) durch JSON Web Tokens (JWT) geschützt. Dies stellt sicher, dass nur autorisierte Benutzer auf die Daten zugreifen und Änderungen an ihnen vornehmen können.

---
# 2.Inhaltsverzeichnis
- [1. Einleitung](#1-beschreibung)
- [2. Inhaltsverzeichnis](#2Inhaltsverzeichnis)
- [3. Installation & Setup](#3-installation--setup)
- [4. API-Endpoints](#4-api-endpoints)
  - [Products Controller:](#products-controller)
  - [User Controller:](#user-controller)
  - [Category Controller:](#category-controller)
  - [Auth Controller:](#auth-controller)
- [5. Namensschema](#5-namensschema) 
- [6. Fazit & Danksagung](#6-fazit)

---


# 3. Installation & Setup
- **Schritt 1**: Klone das Repository auf deinen lokalen Computer mit `git clone.
- **Schritt 2**: Öffne das Projekt in deiner IDE und führe die Datei `docker.compose.yaml` aus.
- **Schritt 3**: Öffne ein Terminal und führe den Befehl `docker ps` aus, um die Container-ID des Containers mit dem Namen `spring-backend-uek295` zu erhalten.
- **Schritt 4**: Überprüfe, ob der Container läuft, indem du den Befehl `docker logs <container-id>` ausführst. Wenn der Container läuft.
- **Schritt 5**: Starte die Anwendung, indem du die Datei `SpringBackendUek295Application.java` ausführst.
- **Schritt 6**: Öffne einen Browser und navigiere zu `http://localhost:8080/swagger-ui.html` um die API-Dokumentation zu sehen.


---

# 4. API-Endpoints

| Endpoint                       | Methode | Beschreibung                                                                                              |
|--------------------------------|---------|-----------------------------------------------------------------------------------------------------------|
| `/api/auth/registration`       | POST    | Dieser Endpunkt wird verwendet, damit sich ein nicht registrierter Benutzer registrieren kann.            |
| `/api/auth/login`              | POST    | Dieser Endpunkt wird verwendet, damit sich ein registrierter Benutzer anmelden kann.                      |
| `/api/categories/{categoryId}` | GET     | Dieser Endpunkt wird verwendet, um eine bestimmte Kategorie anhand einer ID zu bekommen.                  |
| `/api/categories`              | GET     | Dieser Endpunkt wird verwendet, um alle Kategorien zu bekommen.                                           |
| `/api/categories`              | POST    | Dieser Endpunkt wird verwendet, um eine neue Kategorie zu erstellen (nur Admin).                          |
| `/api/categories/{categoryId}` | PUT     | Dieser Endpunkt wird verwendet, um eine bestimmte Kategorie anhand einer ID zu aktualisieren (nur Admin). |
| `/api/categories/{categoryId}` | DELETE  | Dieser Endpunkt wird verwendet, um eine bestimmte Kategorie anhand einer ID zu löschen (nur Admin).       |
| `/api/product/{productId}`     | GET     | Dieser Endpunkt wird verwendet, um ein bestimmtes Produkt anhand einer ID zu bekommen.                    |
| `/api/product`                 | GET     | Dieser Endpunkt wird verwendet, um alle Produkte zu bekommen.                                             |
| `/api/products`                | POST    | Dieser Endpunkt wird verwendet, um ein neues Produkt zu erstellen.                                        |
| `/api/product/{productId}`     | PUT     | Dieser Endpunkt wird verwendet, um ein bestimmtes Produkt anhand einer ID zu aktualisieren (nur Admin).   |
| `/api/product/{productId}`     | DELETE  | Dieser Endpunkt wird verwendet, um ein bestimmtes Produkt anhand einer ID zu löschen (nur Admin).         |
| `/api/user/{id}`               | GET     | Dieser Endpunkt wird verwendet, um einen bestimmten Benutzer anhand einer ID zu bekommen.                 |
| `/api/user`                    | GET     | Dieser Endpunkt wird verwendet, um alle Benutzer zu bekommen.                                             |
| `/api/user`                    | POST    | Dieser Endpunkt wird verwendet, um einen neuen Benutzer zu erstellen.                                     |
| `/api/user/promote/{userId}`   | POST    | Dieser Endpunkt wird verwendet, um einen bestimmten Benutzer zum Admin zu befördern (nur Admin).          |
| `/api/user/{id}/admin`         | PUT     | Dieser Endpunkt wird verwendet, um einen bestimmten Benutzer zum Admin zu aktualisieren (nur Admin).      |
| `/api/user/{id}`               | DELETE  | Dieser Endpunkt wird verwendet, um einen bestimmten Benutzer zu löschen (nur Admin).                      |


## Auth Controller:
- **Endpoint**: Benutzerregistrierung
  - **URL**: `/api/auth/registration`
  - **Methode**: `POST`
  - **Beschreibung**: Ermöglicht die Registrierung eines neuen Benutzers.
- **Endpoint**: Benutzeranmeldung
  - **URL**: `/api/auth/login`
  - **Methode**: `POST`
  - **Beschreibung**: Authentifiziert einen Benutzer und gibt ein JWT zurück.

## Category Controller:
- **Endpoint**: Liste aller Kategorien abrufen
  - **URL**: `/api/categories`
  - **Methode**: `GET`
  - **Beschreibung**: Ruft eine Liste aller Kategorien ab.
- **Endpoint**: Eine Kategorie anhand ihrer ID abrufen
  - **URL**: `/api/categories/{categoryId}`
  - **Methode**: `GET`
  - **Beschreibung**: Ruft eine Kategorie anhand ihrer ID ab.
- **Endpoint**: Neue Kategorie erstellen
  - **URL**: `/api/categories`
  - **Methode**: `POST`
  - **Beschreibung**: Erstellt eine neue Kategorie (nur Admin).
- **Endpoint**: Kategorie aktualisieren
  - **URL**: `/api/categories/{categoryId}`
  - **Methode**: `PUT`
  - **Beschreibung**: Aktualisiert eine Kategorie (nur Admin).
- **Endpoint**: Kategorie löschen
  - **URL**: `/api/categories/{categoryId}`
  - **Methode**: `DELETE`
  - **Beschreibung**: Löscht eine Kategorie (nur Admin).

## Products Controller:
- **Endpoint**: Liste aller Produkte abrufen
  - **URL**: `/api/products`
  - **Methode**: `GET`
  - **Beschreibung**: Ruft eine Liste aller Produkte ab.
- **Endpoint**: Produkt anhand seiner ID abrufen
  - **URL**: `/api/products/{productId}`
  - **Methode**: `GET`
  - **Beschreibung**: Ruft ein Produkt anhand seiner ID ab.
- **Endpoint**: Neues Produkt erstellen
  - **URL**: `/api/products`
  - **Methode**: `POST`
  - **Beschreibung**: Erstellt ein neues Produkt (nur Admin).
- **Endpoint**: Produkt aktualisieren
  - **URL**: `/api/products/{productId}`
  - **Methode**: `PUT`
  - **Beschreibung**: Aktualisiert ein Produkt (nur Admin).
- **Endpoint**: Produkt löschen
  - **URL**: `/api/products/{productId}`
  - **Methode**: `DELETE`
  - **Beschreibung**: Löscht ein Produkt (nur Admin).

## User Controller:
- **Endpoint**: Benutzer anhand seiner ID abrufen
  - **URL**: `/api/user/{id}`
  - **Methode**: `GET`
  - **Beschreibung**: Ruft einen Benutzer anhand seiner ID ab (nur Admin).
- **Endpoint**: Liste aller Benutzer abrufen
  - **URL**: `/api/user`
  - **Methode**: `GET`
  - **Beschreibung**: Ruft eine Liste aller Benutzer ab (nur Admin).
- **Endpoint**: Neuen Benutzer erstellen
  - **URL**: `/api/user`
  - **Methode**: `POST`
  - **Beschreibung**: Erstellt einen neuen Benutzer.
- **Endpoint**: Benutzer zum Admin befördern
  - **URL**: `/api/user/promote/{userId}`
  - **Methode**: `POST`
  - **Beschreibung**: Befördert einen Benutzer zum Admin (nur Admin).
- **Endpoint**: Benutzer zum Admin aktualisieren
  - **URL**: `/api/user/{id}/admin`
  - **Methode**: `PUT`
  - **Beschreibung**: Aktualisiert die Rolle eines Benutzers zum Admin (nur Admin).
- **Endpoint**: Benutzer löschen
  - **URL**: `/api/user/{id}`
  - **Methode**: `DELETE`
  - **Beschreibung**: Löscht einen Benutzer (nur Admin).

---

# 5. Namensschema
### Entities:
- Category
- Product
- User

### DTOs (Data Transfer Objects):
- CategoryDTO
- LoginDTO
- ProductDTO
- RegistrationDTO
- UserAuthDTO
- UserDTO

## 5.1. API-Parameter
### Auth Controller:
- **Endpoint**: `/api/auth/registration`
  - **Parameter**:
    - `username`: String
    - `password`: String
    - `roles`: List<String>
- **Endpoint**: `/api/auth/login`
  - **Parameter**:
    - `username`: String
    - `password`: String

### Category Controller:
- **Endpoint**: `/api/categories`
  - **Parameter** (für POST):
    - `name`: String
    - `active`: Integer
- **Endpoint**: `/api/categories/{categoryId}`
  - **Parameter**: `categoryId`: int (Path Variable)

### Products Controller:
- **Endpoint**: `/api/products`
  - **Parameter** (für POST):
    - `name`: String
    - `description`: String
    - `price`: float
    - `sku`: String
    - `active`: byte
    - `image`: String
    - `stock`: int
    - `category_id`: int (Fremdschlüssel)
- **Endpoint**: `/api/products/{productId}`
  - **Parameter**: `productId`: int (Path Variable)

### User Controller:
- **Endpoint**: `/api/user`
  - **Parameter** (für POST):
    - `username`: String
    - `password`: String
    - `roles`: List<String>
- **Endpoint**: `/api/user/{id}` und andere mit Benutzer-ID
  - **Parameter**: `id`: int (Path Variable)

## 5.2. Datenbanktabellen und -spalten

- **Tabelle**: `Product`
  - `id`: int
  - `sku`: String (Länge: 100)
  - `active`: byte
  - `name`: String (Länge: 500)
  - `image`: String (Länge: 1000)
  - `description`: String (MEDIUMTEXT)
  - `price`: float
  - `stock`: int
  - `user_id`: (Fremdschlüssel zur User Tabelle)
  - `category_id`: (Fremdschlüssel zur Category Tabelle)

- **Tabelle**: `User`
  - `userId`: int
  - `name`: String (Länge: 500)
  - `password`: String (Länge: 256)
  - `description`: String (MEDIUMTEXT)
  - `image`: String (Länge: 1000)

- **Tabelle**: `Category`
  - `id`: int
  - `name`: String (Länge: 255)
  - `active`: Integer (Standard: 0)

---

# 6. Fazit
Das Projekt `spring-backend-uek295` stellt eine solide Grundlage für die Backend-Entwicklung eines Online-Shops dar. Durch die Implementierung von RESTful-API-Endpunkten, die Integration von JWT für die Authentifizierung und die klare Strukturierung des Codes bietet es eine zuverlässige und skalierbare Lösung für zukünftige Entwicklungen.

Die Möglichkeit, Produkte, Kategorien und Benutzer effizient zu verwalten, hebt dieses Projekt hervor und macht es zu einem wertvollen Werkzeug für Entwickler und Online-Händler. Darüber hinaus legt die klare Dokumentation und Strukturierung den Grundstein für eine einfache Integration mit Frontend-Systemen und anderen Drittanbieter-Diensten.



# 7. Quellen und Arbeitsjournale
- Dieses Projekt wurde eigenständig und ohne externe Hilfe von mir, Joel Leimbacher, erstellt. 
- Die Hauptressourcen, die während der Entwicklung verwendet wurden, sind die offizielle Spring Dokumentation: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/ und die Unterrichtsmaterialien.
- Ich bin stolz darauf, dieses Projekt von Grund auf neu entwickelt zu haben und bin dankbar für die wertvollen Ressourcen und das Wissen, das mir während des Prozesses zur Verfügung stand.

## 7.1. Arbeitsjournal


| Datum        | Arbeit                                                                       | Zeit in Stunden |
|--------------|------------------------------------------------------------------------------|-----------------|
| Oct 30, 2023 | - Aktualisieren des README.md und Fertigstellung                             | 3h              |
| Oct 28, 2023 | - Javadoc und Swagger Kommentare und Fixes.                                  | 2h              |
|              | - Erstellung von README.md                                                   | 2h              |
| Oct 27, 2023 | - Javadoc und Swagger Kommentare und Fixes.                                  | 3h              |
| Oct 26, 2023 | - Update von `DatabaseSeeder.java`                                           | 2h              |
| Oct 23, 2023 | - Rollen zu `MessageController` für Sicherheit hinzugefügt.                  | 1h              |
|              | - Rollen zu `ChannelController` für Sicherheit hinzugefügt.                  | 1h              |
|              | - Rollen zu `CategoryController` Endpunkten für Sicherheit hinzugefügt.      | 1h              |
|              | - Sicherheitsrollen zu Endpunkten hinzugefügt.                               | 1h              |
| Oct 22, 2023 | - HTTP-Antworten angepasst.                                                  | 1.5h            |
|              | - Benutzervalidierung und -registrierung hinzugefügt.                        | 1h              |
| Oct 16, 2023 | - Beginn der Benutzervalidierung.                                            | 1h              |
|              | - Start der `AuthenticationResponse`.                                        | 1h              |
| Oct 14, 2023 | - Sicherheitsfeature für Authentifizierung hinzugefügt.                      | 1h              |
|              | - Ordnerstruktur refaktorieren.                                              | 0.5h            |
| Oct 13, 2023 | - Fixes für Produkte.                                                        | 1.5h            |
|              | - Einführung des `UserAuthDTO` für Benutzererstellung.                       | 1h              |
| Oct 8, 2023  | - Hochladen von Dateien.                                                     | 0.5h            |
|              | - Löschen von `uek295_backeend` Verzeichnis.                                 | 0.5h            |
|              | - Hochladen von Dateien.                                                     | 0.5h            |
| Oct 2, 2023  | - `UserDTO` Fix, um Passwort nicht auszustellen.                             | 1h              |
|              | - Einführung des `UserDTO`.                                                  | 1h              |
| Sep 30, 2023 | - Einführung des `ProductDTO`.                                               | 1h              |
| Sep 25, 2023 | - Abhängigkeit für Lombok hinzugefügt.                                       | 0.5h            |
|              | - Arbeit an den Services `Message` und `MessageServiceImplementation`.       | 1h              |
| Sep 24, 2023 | - Arbeit an den Services für Produkt, Kanal, Nachricht, Benutzer, Kategorie. | 4h              |
|              | - Erstes Release des Schulprojekts `spring-backend-uek295`.                  | 4h              |

