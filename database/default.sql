
CREATE TABLE ComicCharacter (
                CharacterId INT NOT NULL,
                CharacterName VARCHAR(50) NOT NULL,
                PRIMARY KEY (CharacterId)
);


CREATE TABLE Creator (
                CreatorId INT NOT NULL,
                CreatorName VARCHAR(50) NOT NULL,
                PRIMARY KEY (CreatorId)
);


CREATE TABLE Publisher (
                PublisherId INT NOT NULL,
                PublisherName VARCHAR(50) NOT NULL,
                PRIMARY KEY (PublisherId)
);


CREATE TABLE ComicCondition (
                ConditionId INT NOT NULL,
                ConditionName VARCHAR(50) NOT NULL,
                PRIMARY KEY (ConditionId)
);


CREATE TABLE Genre (
                GenreId INT NOT NULL,
                GenreName VARCHAR(50) NOT NULL,
                PRIMARY KEY (GenreId)
);


CREATE TABLE Title (
                TitleId INT NOT NULL,
                TitleName VARCHAR(50) NOT NULL,
                PublisherId INT NOT NULL,
                GenreId INT NOT NULL,
                PRIMARY KEY (TitleId)
);


CREATE TABLE Comic (
                ComicId INT NOT NULL,
                Image LONGBLOB,
                IssueNumber DECIMAL(5,1) NOT NULL,
                TitleId INT NOT NULL,
                PublicationDate DATE NOT NULL,
                ConditionId INT NOT NULL,
                RetailPrice DECIMAL(5,2) NOT NULL,
                MarketPrice DECIMAL(9,2) NOT NULL,
                Description TEXT NOT NULL,
                PRIMARY KEY (ComicId)
);


CREATE TABLE FirstAppearance (
                FirstAppearanceId INT NOT NULL,
                CharacterId INT NOT NULL,
                ComicId INT NOT NULL,
                PRIMARY KEY (FirstAppearanceId)
);


CREATE TABLE ComicCreator (
                ComicCreatorId INT NOT NULL,
                ComicId INT NOT NULL,
                CreatorId INT NOT NULL
);


ALTER TABLE FirstAppearance ADD CONSTRAINT comiccharacter_firstappearance_fk
FOREIGN KEY (CharacterId)
REFERENCES ComicCharacter (CharacterId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE ComicCreator ADD CONSTRAINT creator_comiccreator_fk
FOREIGN KEY (CreatorId)
REFERENCES Creator (CreatorId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Title ADD CONSTRAINT publisher_title_fk
FOREIGN KEY (PublisherId)
REFERENCES Publisher (PublisherId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Comic ADD CONSTRAINT condition_comic_fk
FOREIGN KEY (ConditionId)
REFERENCES ComicCondition (ConditionId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Title ADD CONSTRAINT genre_title_fk
FOREIGN KEY (GenreId)
REFERENCES Genre (GenreId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Comic ADD CONSTRAINT title_comic_fk
FOREIGN KEY (TitleId)
REFERENCES Title (TitleId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE ComicCreator ADD CONSTRAINT comic_comiccreator_fk
FOREIGN KEY (ComicId)
REFERENCES Comic (ComicId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE FirstAppearance ADD CONSTRAINT comic_firstappearance_fk
FOREIGN KEY (ComicId)
REFERENCES Comic (ComicId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (1, 'Spider-Man');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (2, 'Superman');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (3, 'Batman');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (4, 'Iron Man');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (5, 'Nova');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (6, 'Animal Man');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (7, 'Madman');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (8, 'Wonder Woman');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (9, 'Hulk');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (10, 'Abe Sapian');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (11, 'Darkseid');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (12, 'Orion');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (13, 'Mister Miracle');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (14, 'Iron Fist');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (15, 'Galactus');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (16, 'Emma Frost');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (17, 'Venom');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (18, 'Silver Surfer');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (19, 'Jack Knight');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (20, 'Deadpool');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (21, 'Ultron');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (22, 'Thanos');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (23, 'Rorshach');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (24, 'Hawkeye');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (25, 'Nick Fury');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (26, 'Miracleman');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (27, 'Swamp Thing');
INSERT INTO `comiccharacter` (`CharacterId`, `CharacterName`) VALUES (28, 'Spider Jerusalem');




