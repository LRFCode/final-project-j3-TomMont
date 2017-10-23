
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

INSERT INTO `creator` VALUES (1, 'Geoff Johns');
INSERT INTO `creator` VALUES (2, 'Alan Moore');
INSERT INTO `creator` VALUES (3, 'Grant Morrison');
INSERT INTO `creator` VALUES (4, 'Brian K Vaughn');
INSERT INTO `creator` VALUES (5, 'Frank Miller');
INSERT INTO `creator` VALUES (6, 'Jeff Lemire');
INSERT INTO `creator` VALUES (7, 'Scott Snyder');
INSERT INTO `creator` VALUES (8, 'Rick Remender');
INSERT INTO creator (CreatorId, CreatorName) VALUES (9, 'Steve Ditko');
INSERT INTO creator (CreatorId, CreatorName) VALUES (10, 'Stan Lee');
INSERT INTO creator (CreatorId, CreatorName) VALUES (11, 'Bob Kane');
INSERT INTO creator (CreatorId, CreatorName) VALUES (12, 'Bill Finger');
INSERT INTO creator (CreatorId, CreatorName) VALUES (13, 'Chas Truog');
INSERT INTO creator (CreatorId, CreatorName) VALUES (14, 'Marv Wolfman');
INSERT INTO creator (CreatorId, CreatorName) VALUES (15, 'John Buscema');
INSERT INTO creator (CreatorId, CreatorName) VALUES (16, 'Fiona Staples');
INSERT INTO creator (CreatorId, CreatorName) VALUES (17, 'James Robinson');
INSERT INTO creator (CreatorId, CreatorName) VALUES (18, 'Tony Harris');
INSERT INTO creator (CreatorId, CreatorName) VALUES (19, 'Cliff Chiang');
INSERT INTO creator (CreatorId, CreatorName) VALUES (20, 'Howard Porter');
INSERT INTO creator (CreatorId, CreatorName) VALUES (21, 'Brian Azzarello');
INSERT INTO creator (CreatorId, CreatorName) VALUES (22, 'Eduardo Risso');
INSERT INTO creator (CreatorId, CreatorName) VALUES (23, 'Jock');


INSERT INTO `comiccondition` VALUES (1, 'Mint');
INSERT INTO `comiccondition` VALUES (2, 'Near Mint');
INSERT INTO `comiccondition` VALUES (3, 'Very Fine');
INSERT INTO `comiccondition` VALUES (4, 'Fine');
INSERT INTO `comiccondition` VALUES (5, 'Very Good');
INSERT INTO `comiccondition` VALUES (6, 'Good');
INSERT INTO `comiccondition` VALUES (7, 'Fair');
INSERT INTO `comiccondition` VALUES (8, 'Poor');

INSERT INTO `genre` VALUES (1, 'Superhero');
INSERT INTO `genre` VALUES (2, 'Science Fiction');
INSERT INTO `genre` VALUES (3, 'Fantasy');
INSERT INTO `genre` VALUES (4, 'Crime');
INSERT INTO `genre` VALUES (5, 'Slice of Life');
INSERT INTO `genre` VALUES (6, 'Humor');
INSERT INTO `genre` VALUES (7, 'Mystery');
INSERT INTO `genre` VALUES (8, 'Horror');

INSERT INTO `publisher` VALUES (1, 'Marvel');
INSERT INTO `publisher` VALUES (2, 'DC');
INSERT INTO `publisher` VALUES (3, 'Valiant');
INSERT INTO `publisher` VALUES (4, 'Image');
INSERT INTO `publisher` VALUES (5, 'Dark Horse');
INSERT INTO `publisher` VALUES (6, 'Top Cow');

INSERT INTO `comic` VALUES (1, NULL, 1.0, 1, '1963-03-01', 1, 0.12, 300000.00, NULL);

INSERT INTO `title` VALUES (1, 'Amazing Spider-Man', 1, 1);
INSERT INTO `title` VALUES (2, 'Batman', 2, 1);
INSERT INTO `title` VALUES (3, 'Animal Man', 2, 1);
INSERT INTO `title` VALUES (4, 'Nova', 1, 1);
INSERT INTO `title` VALUES (5, 'Saga', 4, 2);
INSERT INTO `title` VALUES (6, 'Starman', 2, 1);
INSERT INTO `title` VALUES (7, 'Paper Girls', 4, 2);
INSERT INTO `title` VALUES (8, 'Sweet Tooth', 2, 2);
INSERT INTO `title` VALUES (9, 'JLA', 2, 1);
INSERT INTO `title` VALUES (10, '100 Bullets', 2, 4);
INSERT INTO `title` VALUES (11, 'Wytches', 4, 8);

INSERT INTO comic (ComicId, IssueNumber, TitleId, PublicationDate, ConditionId, RetailPrice, MarketPrice) VALUES (1, 1, 1, '1963-03-01', 1, 0.12, 300000);
INSERT INTO comic (ComicId, IssueNumber, TitleId, PublicationDate, ConditionId, RetailPrice, MarketPrice) VALUES (2, 1, 2, '1940-06-01', 1, 0.10, 400000);
INSERT INTO comic (ComicId, IssueNumber, TitleId, PublicationDate, ConditionId, RetailPrice, MarketPrice) VALUES (3, 1, 3, '1988-09-01', 2, 1.25, 12);
INSERT INTO comic (ComicId, IssueNumber, TitleId, PublicationDate, ConditionId, RetailPrice, MarketPrice) VALUES (4, 1, 4, '1973-09-01', 4, 0.30, 30);
INSERT INTO comic (ComicId, IssueNumber, TitleId, PublicationDate, ConditionId, RetailPrice, MarketPrice) VALUES (5, 1, 5, '2012-03-01', 1, 2.99, 150);
INSERT INTO comic (ComicId, IssueNumber, TitleId, PublicationDate, ConditionId, RetailPrice, MarketPrice) VALUES (6, 20, 6, '1996-07-01', 1, 2.25, 8);
INSERT INTO comic (ComicId, IssueNumber, TitleId, PublicationDate, ConditionId, RetailPrice, MarketPrice) VALUES (7, 21, 6, '1996-08-01', 1, 2.25, 6);
INSERT INTO comic (ComicId, IssueNumber, TitleId, PublicationDate, ConditionId, RetailPrice, MarketPrice) VALUES (8, 1, 10, '1999-08-01', 1, 2.50, 28);
INSERT INTO comic (ComicId, IssueNumber, TitleId, PublicationDate, ConditionId, RetailPrice, MarketPrice) VALUES (9, 1, 11, '2014-03-01', 1, 2.99, 20);

INSERT INTO comiccreator (ComicId, CreatorId) VALUES (1, 9);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (1, 10);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (2, 11);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (2, 12);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (3, 3);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (3, 13);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (4, 14);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (4, 15);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (5, 4);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (5, 16);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (6, 17);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (6, 18);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (7, 17);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (7, 18);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (8, 21);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (8, 22);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (9, 7);
INSERT INTO comiccreator (ComicId, CreatorId) VALUES (9, 23);
