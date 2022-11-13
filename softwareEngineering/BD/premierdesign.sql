#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: ouvrages
#------------------------------------------------------------

CREATE TABLE ouvrages(
        idOuvrage      Int  Auto_increment  NOT NULL ,
        editeur        Varchar (50) NOT NULL ,
        imprimeur      Varchar (50) NOT NULL ,
        lieuImpression Varchar (50) NOT NULL ,
        dateEdition    Date NOT NULL ,
        nbPage         Smallint NOT NULL ,
        lien           Varchar (256) NOT NULL
	,CONSTRAINT ouvrages_PK PRIMARY KEY (idOuvrage)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: lettrines
#------------------------------------------------------------

CREATE TABLE lettrines(
        idLettrine Int  Auto_increment  NOT NULL ,
        nbPage     Smallint NOT NULL ,
        lien       Text NOT NULL ,
        idOuvrage  Int
	,CONSTRAINT lettrines_PK PRIMARY KEY (idLettrine)

	,CONSTRAINT lettrines_ouvrages_FK FOREIGN KEY (idOuvrage) REFERENCES ouvrages(idOuvrage)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: metadonnees
#------------------------------------------------------------

CREATE TABLE metadonnees(
        idMeta      Int  Auto_increment  NOT NULL ,
        nom         Varchar (256) NOT NULL ,
        description Text NOT NULL ,
        valeur      Varchar (50) NOT NULL ,
        unite       Varchar (50) NOT NULL ,
        idLettrine  Int
	,CONSTRAINT metadonnees_PK PRIMARY KEY (idMeta)

	,CONSTRAINT metadonnees_lettrines_FK FOREIGN KEY (idLettrine) REFERENCES lettrines(idLettrine)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: tags
#------------------------------------------------------------

CREATE TABLE tags(
        idTag       Int  Auto_increment  NOT NULL ,
        description Text NOT NULL ,
        nom         Varchar (50) NOT NULL
	,CONSTRAINT tags_PK PRIMARY KEY (idTag)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: auteurs
#------------------------------------------------------------

CREATE TABLE auteurs(
        idAuteur Int  Auto_increment  NOT NULL ,
        nom      Varchar (50) NOT NULL ,
        prenom   Varchar (50) NOT NULL ,
        note     Text NOT NULL
	,CONSTRAINT auteurs_PK PRIMARY KEY (idAuteur)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: utilisateur
#------------------------------------------------------------

CREATE TABLE utilisateur(
        login    Varchar (50) NOT NULL ,
        password Varchar (50) NOT NULL ,
        email    Varchar (50) NOT NULL ,
        statut   Varchar (20) NOT NULL
	,CONSTRAINT utilisateur_PK PRIMARY KEY (login)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: ecrit
#------------------------------------------------------------

CREATE TABLE ecrit(
        idAuteur  Int NOT NULL ,
        idOuvrage Int NOT NULL
	,CONSTRAINT ecrit_PK PRIMARY KEY (idAuteur,idOuvrage)

	,CONSTRAINT ecrit_auteurs_FK FOREIGN KEY (idAuteur) REFERENCES auteurs(idAuteur)
	,CONSTRAINT ecrit_ouvrages0_FK FOREIGN KEY (idOuvrage) REFERENCES ouvrages(idOuvrage)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: regroupe
#------------------------------------------------------------

CREATE TABLE regroupe(
        idLettrine Int NOT NULL ,
        idTag      Int NOT NULL
	,CONSTRAINT regroupe_PK PRIMARY KEY (idLettrine,idTag)

	,CONSTRAINT regroupe_lettrines_FK FOREIGN KEY (idLettrine) REFERENCES lettrines(idLettrine)
	,CONSTRAINT regroupe_tags0_FK FOREIGN KEY (idTag) REFERENCES tags(idTag)
)ENGINE=InnoDB;

