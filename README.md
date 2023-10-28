# spring-backend-uek295

Kurze Beschreibung des Projekts.

---

### 1. Einleitung
Ein kurzer Überblick über den Zweck und die Funktionalität des Projekts.

---

### 2. Installation & Setup
- Schritt-für-Schritt-Anleitung zur Installation und Einrichtung.

---

### 3. API-Endpoints

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

### 4. Namensschema
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

#### 4.1. API-Parameter
(TBD - Bitte füge hier die Details für das Namensschema der API-Parameter hinzu.)

#### 4.2. Datenbanktabellen und -spalten

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

### 5. Fazit & Danksagung
Ein kurzer Abschluss und eventuelle Danksagungen.
