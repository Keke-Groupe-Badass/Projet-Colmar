# Projet Colmar
## Guide d'Installation
### Java
Nous avons utilisé java 17, nous ne garantissons pas le fonctionnement pour une autre version

### Installation du projet
Importer le projet ici: https://github.com/Keke-Groupe-Badass/Projet-Colmar.git
Nous recommendons l'usage d'IntelliJ pour importer le projet

### Bibliothèques
#### JavaFX
JavaFX étant dépendant du système, nous vous laissons le soin de le télécharger. L'application a été developée avec JavaFX 17

Décompressez l'archive JavaFX dans lib, et ajoutez les jars présents dans le dossier javafx/lib au build path.


Ajouter à la virtual machine les arguments
--module-path <chemin absolue>/lib/JavaFX/lib/
--add-modules=javafx.base,javafx.graphics,javafx.controls,javafx.fxml,javafx.web,javafx.media

#### MySQL Connector
MySQL Connector est fourni dans le dossier lib, il ne reste plus qu'à l'ajouter à la bibliothèque dans le projet

### Configuration
#### Configfile
Dans Projet-Colmar\code\CleanProject\src il y a un fichier configfile.txt, il est lu au lancement de l'application, il est sous le format nom;valeur

la première ligne correspond au lien avec la base de données
la seconde ligne correspond au login de la bd
la troisième ligne correspond au mot de passe, si aucun, alors ne rien mettre apres le point-virgule

### Customisation
L'image par défaut des lettrines est stockée dans Projet-Colmar\code\CleanProject\src , il suffit de changer le fichier lettrine.png pour changer l'image.

### Base de données
#### Création
Il faut créer une base de données MySql nommée "fprojectcolmar"
#### Importation des données
Importer Projet-Colmar\BD\SQL.sql notamment via phpMyAdmin

### Python
Python 3+ est nécessaire pour le nuage de tag, si vous ne souhaitez pas utiliser cette option, son installation n'est pas nécessaire.

#### Bibliothèque python
De même il est nécessaire d'avoir les bibliothèques extérieures matplotlib et WordCloud. Un script marchant pour beaucoup d'ordinateurs est disponible à la racine du projet "totalImport(.bat[windows]/.sh[linux non testé])"

## Première utilisation
### Se Connecter
Un utilisateur par défaut est inclu
"andreasmulard@gmail.com" avec pour mot de passe motdepasseSafe101_

Il est recommandé de modifier le mot de passe plus tard




