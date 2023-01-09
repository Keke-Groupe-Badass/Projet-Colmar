# Projet Colmar
## Guide d'Installation
### Java
Nous avons utilisé java 17 pour la réalisation de cette application, nous ne garantissons pas le fonctionnement pour une autre version.

### Installation du projet
Importer le projet ici: https://github.com/Keke-Groupe-Badass/Projet-Colmar.git
Nous recommendons l'usage d'IntelliJ pour importer le projet.

### Bibliothèques
#### JavaFX
JavaFX étant dépendant du système, nous vous laissons le soin de le télécharger. L'application a été developpée avec JavaFX 17.
Une fois téléchargée, décompressez l'archive JavaFX dans lib, et ajoutez les jars présents dans le dossier javafx/lib au build path.


Ajoutez à la virtual machine les arguments (sous IntelliJ : run > Edit Configuration > Modify options > Add VM options)
--module-path <chemin absolu>/lib/JavaFX/lib/ --add-modules=javafx.base,javafx.graphics,javafx.controls,javafx.fxml,javafx.web,javafx.media

#### MySQL Connector
MySQL Connector est fourni dans le dossier lib, il ne reste qu'à l'ajouter à la bibliothèque dans le projet :
Fichiers > Project Structure > Librairies > cliquer sur + > selectionner le mysql-connector-java-8.0.13.jar dans le dossier lib > cliquer sur Apply > cliquer sur Close

### Configuration
#### Configfile
Dans Projet-Colmar\code\CleanProject\src il y a un fichier configfile.txt, il est lu au lancement de l'application, il est sous le format nom;valeur.

La première ligne correspond au lien avec la base de donnée (généralement jdbc:mysql://localhost:3306/<nom db>).
La seconde ligne correspond au login de la bd (votre login phpmyadmin).
La troisième ligne correspond au mot de passe (votre mot de passe phpmyadmin), si aucun, alors ne rien mettre apres le point-virgule.

### Customisation
L'image par défaut des lettrines est stockée dans Projet-Colmar\code\CleanProject\src , il suffit de changer le fichier lettrine.png pour changer l'image.

### Base de données
#### Création
Il faut créer une base de données MySql nommée "fprojectcolmar"
#### Importation des données
Importer Projet-Colmar\BD\SQL.sql dans la base de données fprojectcolmar sous phpMyAdmin

### Python
Python 3+ est nécessaire pour le nuage de tag, si vous ne souhaitez pas utiliser cette option, son installation n'est pas nécessaire.
Sinon, installer python depuis le site https://www.python.org/downloads/ (non nécessaire si vous avez déjà une version de python3 installée)

#### Bibliothèque python
De même il est nécessaire d'avoir les bibliothèques extérieures matplotlib et WordCloud. Un script marchant pour windows et linux est disponible à la racine du projet "totalImport(.bat[windows]/.sh[linux non testé])"
Pour run ces scripts, il est necessaire d'avoir le module python pip.

## Première utilisation
### Se Connecter
Pour se connecter à l'application lors de la première utilisation, un utilisateur par défaut est inclu.
login : andreasmulard@gmail.com 
mot de passe : motdepasseSafe101_

Il est recommandé de modifier le mot de passe plus tard. Pour ce faire, cliquer sur Utilisateurs dans la barre, puis créer un utilisateur