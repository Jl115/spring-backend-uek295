# spring-backend-uek295

Kurze Beschreibung des Projekts.

---

### 1. Einleitung
Das vorliegende Projekt stellt eine API zur Verwaltung von Produkten eines Online-Shops bereit. Das Hauptziel dieser API ist es, die erforderlichen Endpoints für die Erstellung, Abfrage, Aktualisierung und Löschung von Produkten und Kategorien in einer Datenbank bereitzustellen, wobei alle Endpoints dem REST-Standard entsprechen.

Da das Frontend für die Webanwendung in einem späteren Projekt entwickelt wird, wurde besonderer Wert auf eine saubere Strukturierung und gründliche Dokumentation der API gelegt. Dies stellt sicher, dass zukünftige Entwicklungen nahtlos integriert werden können und dass externe Entwickler oder Systeme problemlos mit der API interagieren können.

Die Datenstruktur dieses Projekts besteht aus den Haupttabellen product und category, die durch einen Fremdschlüssel, category_id, miteinander verbunden sind. Dies ermöglicht die Zuweisung von Produkten zu bestimmten Kategorien. Darüber hinaus wurde eine zusätzliche Tabelle Users eingeführt, um die Authentifizierung und Autorisierung von API-Anfragen zu unterstützen.

Um die Sicherheit und Integrität der Daten und der API-Interaktion zu gewährleisten, sind alle Endpoints (mit Ausnahme des Authentifizierungsendpoints) durch JSON Web Tokens (JWT) geschützt. Dies stellt sicher, dass nur autorisierte Benutzer auf die Daten zugreifen und Änderungen an ihnen vornehmen können.

---
### 2.Inhaltsverzeichnis
- [1. Einleitung](#1-einleitung)
- [2. Inhaltsverzeichnis](#2-inhaltsverzeichnis)
- [3. Installation & Setup](#3-installation--setup)
- [4. API-Endpoints](#4-api-endpoints)
  - [Products Controller:](#products-controller)
  - [User Controller:](#user-controller)
  - [Category Controller:](#category-controller)
  - [Auth Controller:](#auth-controller)
- [5. Namensschema](#5-namensschema) 
- [6. Fazit & Danksagung](#6-fazit--danksagung)

---

---
### 3. Installation & Setup
- **Schritt 1**: Klone das Repository auf deinen lokalen Computer mit `git clone.
- **Schritt 2**: Öffne das Projekt in deiner IDE und führe die Datei `docker.compose.yaml` aus.
- **Schritt 3**: Öffne ein Terminal und führe den Befehl `docker ps` aus, um die Container-ID des Containers mit dem Namen `spring-backend-uek295` zu erhalten.
- **Schritt 4**: Überprüfe, ob der Container läuft, indem du den Befehl `docker logs <container-id>` ausführst. Wenn der Container läuft.
- **Schritt 5**: Starte die Anwendung, indem du die Datei `SpringBackendUek295Application.java` ausführst.
- **Schritt 6**: Öffne einen Browser und navigiere zu `http://localhost:8080/swagger-ui.html` um die API-Dokumentation zu sehen.


---

### 4. API-Endpoints

| Endpoint | Methode | Beschreibung |
| --- | --- | --- |
| `/api/auth/registration` | POST | Dieser Endpunkt wird verwendet, damit sich ein nicht registrierter Benutzer registrieren kann. |
| `/api/auth/login` | POST | Dieser Endpunkt wird verwendet, damit sich ein registrierter Benutzer anmelden kann. |
| `/api/categories/{categoryId}` | GET | Dieser Endpunkt wird verwendet, um eine bestimmte Kategorie anhand einer ID zu bekommen. |
| `/api/categories` | GET | Dieser Endpunkt wird verwendet, um alle Kategorien zu bekommen. |
| `/api/categories` | POST | Dieser Endpunkt wird verwendet, um eine neue Kategorie zu erstellen (nur Admin). |
| `/api/categories/{categoryId}` | PUT | Dieser Endpunkt wird verwendet, um eine bestimmte Kategorie anhand einer ID zu aktualisieren (nur Admin). |
| `/api/categories/{categoryId}` | DELETE | Dieser Endpunkt wird verwendet, um eine bestimmte Kategorie anhand einer ID zu löschen (nur Admin). |
| `/api/product/{productId}` | GET | Dieser Endpunkt wird verwendet, um ein bestimmtes Produkt anhand einer ID zu bekommen. |
| `/api/product` | GET | Dieser Endpunkt wird verwendet, um alle Produkte zu bekommen. |
| `/api/products` | POST | Dieser Endpunkt wird verwendet, um ein neues Produkt zu erstellen. |
| `/api/product/{productId}` | PUT | Dieser Endpunkt wird verwendet, um ein bestimmtes Produkt anhand einer ID zu aktualisieren (nur Admin). |
| `/api/product/{productId}` | DELETE | Dieser Endpunkt wird verwendet, um ein bestimmtes Produkt anhand einer ID zu löschen (nur Admin). |
| `/api/user/{id}` | GET | Dieser Endpunkt wird verwendet, um einen bestimmten Benutzer anhand einer ID zu bekommen. |
| `/api/user` | GET | Dieser Endpunkt wird verwendet, um alle Benutzer zu bekommen. |
| `/api/user` | POST | Dieser Endpunkt wird verwendet, um einen neuen Benutzer zu erstellen. |
| `/api/user/promote/{userId}` | POST | Dieser Endpunkt wird verwendet, um einen bestimmten Benutzer zum Admin zu befördern (nur Admin). |
| `/api/user/{id}/admin` | PUT | Dieser Endpunkt wird verwendet, um einen bestimmten Benutzer zum Admin zu aktualisieren (nur Admin). |
| `/api/user/{id}` | DELETE | Dieser Endpunkt wird verwendet, um einen bestimmten Benutzer zu löschen (nur Admin). |


#### Products Controller:
- **Endpoint**: Get all products
  - **URL**: `/api/products`
  - **Methode**: `GET`
  - **Beschreibung**: Holt alle Produkte.
- **Endpoint**: Get product by ID
  - **URL**: `/api/products/{productId}`
  - **Methode**: `GET`
  - **Beschreibung**: Holt ein Produkt anhand seiner ID.

#### User Controller:
- **Endpoint**: Get user by ID
  - **URL**: `/api/user/{id}`
  - **Methode**: `GET`
  - **Beschreibung**: Holt einen Benutzer anhand seiner ID.

#### Category Controller:
- **Endpoint**: Get all categories
  - **URL**: `/api/categories`
  - **Methode**: `GET`
  - **Beschreibung**: Holt eine Liste aller Kategorien.

#### Auth Controller:
- **Endpoint**: Register a new user
  - **URL**: `/api/auth/registration`
  - **Methode**: `POST`
  - **Beschreibung**: Registriert einen neuen Benutzer.

---

### 5. Namensschema
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

#### 5.1. API-Parameter
(TBD - Bitte füge hier die Details für das Namensschema der API-Parameter hinzu.)

#### 5.2. Datenbanktabellen und -spalten

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

### 6. Fazit & Danksagung
Ein kurzer Abschluss und eventuelle Danksagungen.
