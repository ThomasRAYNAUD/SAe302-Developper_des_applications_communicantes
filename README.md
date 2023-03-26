# SAé302 | Développer des applications communicantes

## Objectif
Réaliser une application client/serveur utilisant les fonctions communicantes permettant de concevoir un protocole applicatif au-dessus de la pile de communication TCP/IP. 
Le choix dulangage s’est porté sur Java qui possède des fonctions d’assez haut niveau pour faciliter les communications entre client et serveur. TCP fonctionne en mode connecté et le serveur doit accepter plusieurs connexions simultanées. UDP est plus simple d’approche car tous les clients ont accès au même port pour communiquer avec le serveur.

## Description:
Réaliser une application de réseau social coté client et serveur permettant à un groupe d’utilisateurs de contacter d’autres utilisateurs (amis ou relations) et d’échanger des messages avec eux (en temps réel si les utilisateurs sont connectés ou en mode boîte à
lettre). Les messages échangés entre le serveur et le client prennent la forme d’une chaîne de caractères de la forme “login,commande,parametre1,parametre2,...”. Les messages provenant des clients indiquent pour login email de l’utilisateur tandis que les messages du
serveur indique “serveur”.

## Fonctionnalités
#### Le serveur fonctionne avec des sockets java. Il écoute sur le port TCP 3333. Les données du système sont stockées en mémoire. L’étudiant n’est pas tenu de proposer une solution à la persistance des données en cas de l’arrêt du serveur.
1. Le serveur permet de gérer un groupe d’au maximum 100 utilisateurs.
2. Un utilisateur est identifié par un email et un mot de passe stockés en clair (l’implémentation du stockage en code hash est un plus).
3. Un message est une chaîne de caractères définie par une action/commande (INVITATION ou MESSAGE), par une origine, par le destinataire, par le sujet et par
le corps.
4. Chaque utilisateur est autorisé à avoir jusqu’à 10 amis.
5. Le serveur stocke les messages relatifs aux utilisateurs en mémoire RAM.
6. Pour chaque utilisateur, seulement les 10 derniers messages reçus sont stockés. Les précédents sont automatiquement supprimés.
7. Le destinataire du message peut être “TOUS” Dans ce cas, le serveur réplique le message dans la liste des messages de tous les amis de l’émetteur.
8. Pour consulter ses messages, l’utilisateur connecté doit envoyer un message de lecture de ses messages au format “lecture,login”. (côté client l’utilisateur lit les messages chaque 10 secondes).
9. Pour inviter un autre utilisateur, l’invitant envoie un message “demande_ami,login,ami”.
10. A l’acceptation d’une invitation, l’invitant reçoit un message du serveur lui notifiant cette acceptation.
