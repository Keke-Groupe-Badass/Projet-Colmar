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
        dateEdition    Int NOT NULL ,
        table_s        Varchar (256) NOT NULL ,
        nbPage         Int NOT NULL ,
        copyright      Varchar (50) NOT NULL ,
        creditPhoto    Varchar (50) NOT NULL ,
        resolution     Varchar (50) NOT NULL ,
        format         Varchar (50) NOT NULL ,
        titre          Varchar (50) NOT NULL
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
# Table: personne
#------------------------------------------------------------

CREATE TABLE personne(
        idPersonne Int  Auto_increment  NOT NULL ,
        nom        Varchar (50) NOT NULL ,
        prenom     Varchar (50) NOT NULL ,
        note       Text NOT NULL
	,CONSTRAINT personne_PK PRIMARY KEY (idPersonne)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: utilisateur
#------------------------------------------------------------

CREATE TABLE utilisateur(
        email      Varchar (50) NOT NULL ,
        motDePasse Varchar (64) NOT NULL ,
        statut     Varchar (20) NOT NULL
	,CONSTRAINT utilisateur_PK PRIMARY KEY (email)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: log
#------------------------------------------------------------

CREATE TABLE log(
        id    Int  Auto_increment  NOT NULL ,
        text  Text NOT NULL ,
        date  Date NOT NULL ,
        email Varchar (50)
	,CONSTRAINT log_PK PRIMARY KEY (id)

	,CONSTRAINT log_utilisateur_FK FOREIGN KEY (email) REFERENCES utilisateur(email)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: identique
#------------------------------------------------------------

CREATE TABLE identique(
        idIdentique Int  Auto_increment  NOT NULL ,
        description Text NOT NULL
	,CONSTRAINT identique_PK PRIMARY KEY (idIdentique)
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
	,CONSTRAINT lettrines_identique0_FK FOREIGN KEY (idIdentique) REFERENCES identique(idIdentique)
	,CONSTRAINT lettrines_personne1_FK FOREIGN KEY (idPersonne) REFERENCES personne(idPersonne)
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

	,CONSTRAINT ecrit_personne_FK FOREIGN KEY (idPersonne) REFERENCES personne(idPersonne)
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

