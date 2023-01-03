#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: ouvrages
#------------------------------------------------------------

CREATE TABLE ouvrages(
        idOuvrage        Int  Auto_increment  NOT NULL ,
        libraire         Int NOT NULL ,
        imprimeur        Int NOT NULL ,
        lieuImpression   Varchar (50) NOT NULL ,
        dateEdition      Int NOT NULL ,
        lien             Varchar (256) NOT NULL ,
        nbPage           Smallint NOT NULL ,
        copyright        Varchar (100) NOT NULL ,
        creditPhoto      Varchar (200) NOT NULL ,
        resolution       Varchar (20) NOT NULL ,
        format           Varchar (20) NOT NULL ,
        titre            Varchar (200) NOT NULL ,
        reechantillonage Bool NOT NULL
	,CONSTRAINT ouvrages_PK PRIMARY KEY (idOuvrage)
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
# Table: personnes
#------------------------------------------------------------

CREATE TABLE personnes(
        idPersonne Int  Auto_increment  NOT NULL ,
        nom        Varchar (50) NOT NULL ,
        prenom     Varchar (50) NOT NULL ,
        note       Text NOT NULL
	,CONSTRAINT personnes_PK PRIMARY KEY (idPersonne)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: utilisateurs
#------------------------------------------------------------

CREATE TABLE utilisateurs(
        email      Varchar (50) NOT NULL ,
        motDePasse Varchar (64) NOT NULL ,
        statut     Varchar (20) NOT NULL
	,CONSTRAINT utilisateurs_PK PRIMARY KEY (email)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: logs
#------------------------------------------------------------

CREATE TABLE logs(
        idLog Int  Auto_increment  NOT NULL ,
        text  Text NOT NULL ,
        date  Date NOT NULL ,
        email Varchar (50)
	,CONSTRAINT logs_PK PRIMARY KEY (idLog)

	,CONSTRAINT logs_utilisateurs_FK FOREIGN KEY (email) REFERENCES utilisateurs(email)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: identiques
#------------------------------------------------------------

CREATE TABLE identiques(
        idIdentique Int  Auto_increment  NOT NULL ,
        description Text NOT NULL
	,CONSTRAINT identiques_PK PRIMARY KEY (idIdentique)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: lettrines
#------------------------------------------------------------

CREATE TABLE lettrines(
        idLettrine  Int  Auto_increment  NOT NULL ,
        nbPage      Smallint NOT NULL ,
        lien        Text NOT NULL ,
        idOuvrage   Int ,
        idIdentique Int ,
        idPersonne  Int
	,CONSTRAINT lettrines_PK PRIMARY KEY (idLettrine)

	,CONSTRAINT lettrines_ouvrages_FK FOREIGN KEY (idOuvrage) REFERENCES ouvrages(idOuvrage)
	,CONSTRAINT lettrines_identiques0_FK FOREIGN KEY (idIdentique) REFERENCES identiques(idIdentique)
	,CONSTRAINT lettrines_personnes1_FK FOREIGN KEY (idPersonne) REFERENCES personnes(idPersonne)
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
# Table: ecrit
#------------------------------------------------------------

CREATE TABLE ecrit(
        idPersonne Int NOT NULL ,
        idOuvrage  Int NOT NULL
	,CONSTRAINT ecrit_PK PRIMARY KEY (idPersonne,idOuvrage)

	,CONSTRAINT ecrit_personnes_FK FOREIGN KEY (idPersonne) REFERENCES personnes(idPersonne)
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

