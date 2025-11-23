Voici la traduction complète en français 👇

---

# 🧩 Résumé du refactoring hexagonal

Ce document résume le refactoring effectué afin de réaligner le service de formules avec les principes d’une **architecture hexagonale**.
Les changements ont été introduits dans les couches **domaine**, **application**, **adaptateurs entrants**, **adaptateurs sortants**, et **configuration transversale**.

---

## 🏗️ Domaine

* Promotion de `Formula` en un véritable **agrégat de domaine** avec un identifiant et une méthode utilitaire `withId`, afin que les mises à jour ne dépendent plus des éléments d’infrastructure (`domain/models/Formula.java`).
* Enrichissement de `FormulaNotFoundException` avec un **code d’état stable** et l’identifiant manquant, permettant ainsi aux adaptateurs de construire des réponses API localisées tout en maintenant la logique de message dans le domaine (`domain/exceptions/FormulaNotFoundException.java`).
* Maintien de l’accès au dépôt de manière abstraite en continuant à s’appuyer sur le port `FormulaRepositoryPort` (`domain/ports/out/FormulaRepositoryPort.java`).

---

## ⚙️ Application

* `ManageFormulaService` implémente désormais le **port d’entrée**, coordonne les opérations du domaine et délègue exclusivement au port du dépôt, **sans stéréotypes Spring**, afin de permettre un **câblage explicite des beans** (`application/service/ManageFormulaService.java`).
* `FormulaCrudUseCase` définit la **frontière du cas d’utilisation** sur laquelle les adaptateurs entrants dépendent (`application/service/port/FormulaCrudUseCase.java`).

---

## 🌐 Adaptateur entrant (Web)

* Introduction de **DTOs de transport** pour les requêtes et les réponses (`infrastructure/inbound/web/dto/FormulaRequest.java`, `FormulaResponse.java`).
* Ajout d’un **mapper MapStruct** pour traduire les charges utiles HTTP vers le modèle de domaine (`infrastructure/inbound/web/mapper/FormulaWebMapper.java`).
* Refactorisation du **contrôleur CRUD** en un adaptateur minimal qui consomme le port du cas d’utilisation et s’appuie sur le mapper pour les conversions (`infrastructure/inbound/web/controller/CrudController.java`).
* Remplacement du gestionnaire d’erreurs global par des charges utiles `ApiError` exposant les **codes d’état**, **clés de traduction** et **arguments** afin de permettre au frontend de localiser les messages (`infrastructure/inbound/web/exception/ApiError.java`, `GlobalHandlerController.java`).

---

## 💾 Adaptateur sortant (Persistance)

* Isolation de l’**entité JPA**, afin que les annotations de persistance restent en dehors du domaine (`infrastructure/outbound/persistence/jpa/entity/FormulaEntity.java`).
* Création d’un **mapper MapStruct** pour traduire entre les modèles de domaine et les entités JPA (`infrastructure/outbound/persistence/jpa/mapper/FormulaJpaMapper.java`).
* Implémentation du **port du dépôt** via un composant Spring déléguant à `JpaRepository` et utilisant le mapper pour les conversions (`infrastructure/outbound/persistence/jpa/FormulaRepositoryAdapter.java`).

---

## 🧩 Configuration

* Le service est désormais câblé via une **classe de configuration** (future `FormulaApplicationConfig`) qui produit un bean `FormulaCrudUseCase` en instanciant `ManageFormulaService` avec l’implémentation du port sortant.
  Cela permet de **centraliser les préoccupations de câblage** dans le répertoire `configuration/`.

---

## ✅ Conclusion

Ces changements **découplent le domaine** des préoccupations de transport et de persistance, permettant au service de formules d’évoluer avec des **frontières claires**, tout en facilitant le **remplacement futur d’adaptateurs** ou l’ajout de nouvelles interfaces.
