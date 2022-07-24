# pcbuilder
Spring boot project.</br>
Приложение для СЦ. Бэк приложения для сборки ПК. CRUD с сохранением в БД.
Технологии: java, spring, sql(postreSQL), hibernate, liquibase.

### REST api

**BodyController:**

GET **/api/body** get all bodies </br>
GET **/api/body/{id}** get body </br>
POST **/api/body** { ... } add new body </br>
PUT **/api/body/{id}** change body </br>
DELETE **/api/body/{id}** delete body </br>

**CpuController:**

GET **/api/cpu** get all cpu </br>
GET **/api/cpu/{id}** get cpu </br>
POST **/api/cpu** { ... } add new cpu </br>
PUT **/api/cpu/{id}** change cpu </br>
DELETE **/api/cpu/{id}** delete cpu </br>

**CpufanController:**

GET **/api/cpufan** get all cpufans </br>
GET **/api/cpufan/{id}** get cpufan </br>
POST **/api/cpufan** { ... } add new cpufan </br>
PUT **/api/cpufan/{id}** change cpufan </br>
DELETE **/api/cpufan/{id}** delete cpufan </br>

**FanController:**

GET **/api/fan** get all fans </br>
GET **/api/fan/{id}** get fan </br>
POST **/api/fan** { ... } add new fan </br>
PUT **/api/fan/{id}** change fan </br>
DELETE **/api/fan/{id}** delete fan </br>

**Gputroller:**

GET **/api/gpu** get all gpu </br>
GET **/api/gpu/{id}** get gpu </br>
POST **/api/gpu** { ... } add new gpu </br>
PUT **/api/gpu/{id}** change gpu </br>
DELETE **/api/gpu/{id}** delete gpu </br>

**MotherboardController:**

GET **/api/motherboard** get all motherboards </br>
GET **/api/motherboard/{id}** get motherboard </br>
POST **/api/motherboard** { ... } add new motherboard </br>
PUT **/api/motherboard/{id}** change motherboard </br>
DELETE **/api/motherboard/{id}** delete motherboard </br>

**PcController:**

GET **/api/pc** get all pc </br>
GET **/api/pc/{id}** get pc </br>
POST **/api/pc** { ... } add new pc </br>
PUT **/api/pc/{id}** change pc </br>
DELETE **/api/pc/{id}** delete pc </br>

**PowerunitController:**

GET **/api/powerunit** get all powerunits </br>
GET **/api/powerunit/{id}** get powerunit </br>
POST **/api/powerunit** { ... } add new powerunit </br>
PUT **/api/powerunit/{id}** change powerunit </br>
DELETE **/api/powerunit/{id}** delete powerunit </br>

**RamController:**

GET **/api/ram** get all ram </br>
GET **/api/ram/{id}** get ram </br>
POST **/api/ram** { ... } add new ram </br>
PUT **/api/ram/{id}** change ram </br>
DELETE **/api/ram/{id}** delete ram </br>

**StorageController:**

GET **/api/storage** get all storages </br>
GET **/api/storage/{id}** get storage </br>
POST **/api/storage** { ... } add new storage </br>
PUT **/api/storage/{id}** change storage </br>
DELETE **/api/storage/{id}** delete storage </br>