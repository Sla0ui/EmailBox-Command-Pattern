# Email Box Command Pattern

Ce projet illustre l'implémentation des design patterns dans une simulation de gestion de boîte email.

## Design Patterns implémentés

- **Command Pattern** : Encapsule les opérations sur la boîte email en objets commandes
- **Proxy Pattern** : Fournit un contrôle d'accès à la boîte email
- **Singleton Pattern** : Garantit une instance unique de la boîte email

## Diagramme de classes

![DP](https://github.com/user-attachments/assets/0af58afd-716f-4db6-ba4a-3578a840bf85)


## Fonctionnalités

- Ajout de nouveaux emails
- Affichage de tous les emails
- Affichage du dernier email reçu
- Marquer un email comme lu
- Supprimer un email
- Affichage des emails non lus
- Combinaison de commandes (MacroCommand)
- Authentification pour accéder à la boîte email (Proxy)
- Instance unique de la boîte email (Singleton)

## Structure du projet

- `Mail.java` : Modèle représentant un email
- `MailBox.java` : Receiver qui gère les opérations sur les emails
- `Command.java` : Interface pour toutes les commandes
- `Invoker.java` : Exécuteur des commandes
- `NewMailCommand.java`, `GetInboxCommand.java`, etc. : Commandes concrètes
- `MacroCommand.java` : Commande composite qui exécute plusieurs commandes
- `MailBoxSubject.java` : Interface pour le pattern Proxy
- `MailBoxSecurityProxy.java` : Proxy contrôlant l'accès à la boîte email
- `MailBoxSingleton.java` : Implémentation Singleton de la boîte email

## Contexte académique

Ce projet a été réalisé dans le cadre d'un examen sur les Design Patterns.

## Licence

Ce projet est sous licence MIT. Voir le fichier [LICENSE](LICENSE) pour plus de détails.
