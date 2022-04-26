DROP TABLE hirdetes_jellege;
DROP TABLE munka_jellege;
DROP TABLE jelentkezesek;
DROP TABLE oneletrajzok;
DROP TABLE allaskeresok;
DROP TABLE adminok;
DROP TABLE hirdetesek;
DROP TABLE hirdetok;
DROP TABLE cegek;
DROP TABLE szekhelyek;

CREATE TABLE szekhelyek (
	szekhelyID NUMBER(3) NOT NULL PRIMARY KEY,
	megye VARCHAR(30) NOT NULL,
	varos VARCHAR(30) NOT NULL,
	utca VARCHAR(30),
	hazszam NUMBER(5),
	irsz NUMBER(5) NOT NULL
);

CREATE TABLE cegek (
	cegID NUMBER(3) NOT NULL PRIMARY KEY,
	nev VARCHAR(30),
	telefon VARCHAR(11),
	szekhelyID NUMBER(3) NOT NULL,
	FOREIGN KEY(szekhelyID) REFERENCES szekhelyek(szekhelyID)
);

CREATE TABLE hirdetok (
	hirdetoID NUMBER(3) NOT NULL PRIMARY KEY,
	felhasznalonev VARCHAR(30) NOT NULL,
	jelszo VARCHAR(15) NOT NULL,
	email VARCHAR(30) NOT NULL,
	telefon VARCHAR(11),
	nev VARCHAR(30) NOT NULL,
	cegID NUMBER(3) NOT NULL,
	FOREIGN KEY(cegID) REFERENCES cegek(cegID) ON DELETE CASCADE ENABLE
);

CREATE TABLE hirdetesek (
	hirdetesID NUMBER(3) NOT NULL PRIMARY KEY,
	cim VARCHAR(30) NOT NULL,
	leiras VARCHAR(300),
	hirdetoID NUMBER(3) NOT NULL,
	helyszin VARCHAR(30),
	FOREIGN KEY(hirdetoID) REFERENCES hirdetok(hirdetoID)
);

CREATE TABLE adminok (
	adminID NUMBER(3) NOT NULL PRIMARY KEY,
	felhasznalonev varchar(30),
	jelszo VARCHAR(15) NOT NULL
);

CREATE TABLE allaskeresok (
	allaskeresoID NUMBER(3) NOT NULL PRIMARY KEY,
	felhasznalonev VARCHAR(30) NOT NULL,
	jelszo VARCHAR(15) NOT NULL,
	nev VARCHAR(30) NOT NULL,
	vegzettseg VARCHAR(30),
	szuldatum DATE,
	nyelvismeret VARCHAR(30),
	email VARCHAR(30) NOT NULL,
	lakhely VARCHAR(30),
	telefon VARCHAR(11)
);

CREATE TABLE oneletrajzok (
	oneletrajzID NUMBER(3) NOT NULL PRIMARY KEY,
	bemutatkozas VARCHAR(200),
	tapasztalat VARCHAR(200),
	motivacio VARCHAR(200),
	allaskeresoID NUMBER(3),
	FOREIGN KEY(allaskeresoID) REFERENCES allaskeresok(allaskeresoID) ON DELETE CASCADE ENABLE
);

CREATE TABLE jelentkezesek (
	hirdetesID NUMBER(3) NOT NULL,
	allaskeresoID NUMBER(3) NOT NULL,
	FOREIGN KEY(hirdetesID) REFERENCES hirdetesek(hirdetesID) ON DELETE CASCADE ENABLE,
	FOREIGN KEY(allaskeresoID) REFERENCES allaskeresok(allaskeresoID) ON DELETE CASCADE ENABLE
);

CREATE TABLE munka_jellege (
	munkaID NUMBER(3) NOT NULL PRIMARY KEY,
	megnevezes VARCHAR(30) NOT NULL
);

CREATE TABLE hirdetes_jellege (
	hirdetesID NUMBER(3),
	munkaID NUMBER(3),
	FOREIGN KEY(hirdetesID) REFERENCES hirdetesek,
	FOREIGN KEY(munkaID) REFERENCES munka_jellege
);



INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (1, 'allaskereso1', 'test', 'Stan Junge', '8 altalanos', TO_DATE('1970 02 07', 'yyyy mm dd'), 'nemet', 'allaskereso1@email.com', 'Budapest', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (2, 'allaskereso2', 'test', 'Rudi MacLean', '8 altalanos', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso2@email.com', 'Budapest', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (3, 'allaskereso3', 'test', 'Filib Häusler', '8 altalanos', TO_DATE('1970 02 07', 'yyyy mm dd'), 'nemet', 'allaskereso3@email.com', 'Budapest', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (4, 'allaskereso4', 'test', 'Anna McNaughton', '8 altalanos', TO_DATE('1970 02 07', 'yyyy mm dd'), 'nemet', 'allaskereso4@email.com', 'Szeged', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (5, 'allaskereso5', 'test', 'Kirstin McCracken', '8 altalanos', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso5@email.com', 'Szeged', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (6, 'allaskereso6', 'test', 'Yianni Wood', '8 altalanos', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso6@email.com', 'Szeged', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (7, 'allaskereso7', 'test', 'Jessica Schwartz', 'felsofok', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso7@email.com', 'Szeged', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (8, 'allaskereso8', 'test', 'Hildebrand Brotz', 'felsofok', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso8@email.com', 'Szeged', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (9, 'allaskereso9', 'test', 'Angelos Freund', 'felsofok', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso9@email.com', 'Szeged', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (10, 'allaskereso10', 'test', 'Charilaos Schwartz', 'felsofok', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso10@email.com', 'Kecskemet', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (11, 'allaskereso11', 'test', 'Costas Reiher', 'felsofok', TO_DATE('1970 02 07', 'yyyy mm dd'), 'nemet', 'allaskereso11@email.com', 'Budapest', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (12, 'allaskereso12', 'test', 'Adi Kunz', 'felsofok', TO_DATE('1970 02 07', 'yyyy mm dd'), 'nemet', 'allaskereso12@email.com', 'Budapest', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (13, 'allaskereso13', 'test', 'Ewan Schultheiss', 'szakmunkas', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso13@email.com', 'Budapest', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (14, 'allaskereso14', 'test', 'Elisavet Fraser', 'szakmunkas', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso14@email.com', 'Kecskemet', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (15, 'allaskereso15', 'test', 'Jochen Jaeger', 'felsofok', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso15@email.com', 'Budapest', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (16, 'allaskereso16', 'test', 'Artemis Schultes', 'felsofok', TO_DATE('1970 02 07', 'yyyy mm dd'), 'magyar', 'allaskereso16@email.com', 'Budapest', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (17, 'allaskereso17', 'test', 'Sophie Stavros', 'felsofok', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso17@email.com', 'Kecskemet', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (18, 'allaskereso18', 'test', 'Leopold Barclay', 'felsofok', TO_DATE('1970 02 07', 'yyyy mm dd'), 'nemet', 'allaskereso18@email.com', 'Budapest', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (19, 'allaskereso19', 'test', 'Mathis Esser', '8 altalanos', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso19@email.com', 'Kecskemet', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (20, 'allaskereso20', 'test', 'Seonag Ionescu', '8 altalanos', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso20@email.com', 'Budapest', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (21, 'allaskereso21', 'test', 'Viktoria Mac Leoid', 'erettsegi', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso21@email.com', 'Debrecen', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (22, 'allaskereso22', 'test', 'Dietmar Gwerder', 'erettsegi', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso22@email.com', 'Budapest', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (23, 'allaskereso23', 'test', 'Samuel Haber', 'szakmunkas', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso23@email.com', 'Budapest', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (24, 'allaskereso24', 'test', 'Rike Macauley', 'szakmunkas', TO_DATE('1970 02 07', 'yyyy mm dd'), 'angol', 'allaskereso24@email.com', 'Budapest', '06201234567');
INSERT INTO allaskeresok (allaskeresoID, felhasznalonev, jelszo, nev, vegzettseg, szuldatum, nyelvismeret, email, lakhely, telefon) VALUES (25, 'allaskereso25', 'test', 'Ismini Acker', 'szakmunkas', TO_DATE('1970 02 07', 'yyyy mm dd'), 'magyar', 'allaskereso25@email.com', 'Budapest', '06201234567');

INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (1, null, 'tiz ev autoszereles','szeretek dolgozni', 1);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (2, null, 'tiz ev autoszereles', null, 1);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (3, null, 'tiz ev autoszereles', null, 2);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (4, null, 'tiz ev autoszereles', null, 3);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (5, null, 'tiz ev autoszereles', null, 4);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (6, null, 'tiz ev autoszereles', null, 4);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (7, null, 'tiz ev autoszereles', null, 4);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (8, null, 'tiz ev autoszereles', null, 6);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (9, null, 'tiz ev autoszereles', null, 7);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (10, null, 'tiz ev autoszereles', null, 8);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (11, null, 'harom ev programozas', null, 9);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (12, null, 'harom ev programozas', null, 10);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (13, null, 'harom ev programozas', null, 11);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (14, null, 'harom ev programozas', null, 12);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (15, null, 'harom ev programozas', null, 13);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (16, null, 'harom ev programozas', null, 14);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (17, null, 'ot ev ontozestechnika', null, 15);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (18, null, 'ot ev ontozestechnika', null, 16);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (19, null, 'ot ev ontozestechnika', null, 17);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (20, null, 'ot ev ontozestechnika', null, 18);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (21, null, 'ot ev ontozestechnika', null, 19);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (22, null, 'huszonharom ev jogasz tapasztalat', null, 20);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (23, null, 'huszonharom ev jogasz tapasztalat',null, 21);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (24, null, 'huszonharom ev jogasz tapasztalat',null, 22);
INSERT INTO oneletrajzok (oneletrajzID, bemutatkozas, tapasztalat, motivacio, allaskeresoID) VALUES (25, null, 'huszonharom ev jogasz tapasztalat',null, 23);

INSERT INTO munka_jellege (munkaID, megnevezes) VALUES (1, 'adminisztrációs');
INSERT INTO munka_jellege (munkaID, megnevezes) VALUES (2, 'fizikai');
INSERT INTO munka_jellege (munkaID, megnevezes) VALUES (3, 'IT');
INSERT INTO munka_jellege (munkaID, megnevezes) VALUES (4, 'ingatlan');
INSERT INTO munka_jellege (munkaID, megnevezes) VALUES (5, 'idegenforgalom');

INSERT INTO adminok (adminID, felhasznalonev, jelszo) VALUES (1, 'admin1', 'admin1');
INSERT INTO adminok (adminID, felhasznalonev, jelszo) VALUES (2, 'admin2', 'admin2');
INSERT INTO adminok (adminID, felhasznalonev, jelszo) VALUES (3, 'admin3', 'admin3');
INSERT INTO adminok (adminID, felhasznalonev, jelszo) VALUES (4, 'admin4', 'admin4');
INSERT INTO adminok (adminID, felhasznalonev, jelszo) VALUES (5, 'admin5', 'admin5');

INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (1,'vas','vas','akac','1',4000);
INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (2, 'vas', 'vas', 'virag', 2, 4000);
INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (3, 'vas', 'vas', 'alma', 3, 4000);
INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (4, 'vas', 'vas', 'korte', 4, 4000);
INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (5, 'vas', 'vas', 'afonya', 5, 4000);
INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (6, 'vas', 'vas', 'ag', 6, 4000);
INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (7, 'vas', 'vas', 'fa', 7, 4000);
INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (8, 'vas', 'vas', 'kalap', 8, 4000);
INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (9, 'vas', 'vas', 'ady', 9, 4000);
INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (10, 'vas', 'vas', 'petofi', 10, 4000);
INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (11, 'vas', 'vas', 'liszt', 11, 4000);
INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (12, 'vas', 'vas', 'pumped', 12, 4000);
INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (13, 'vas', 'vas', 'kati', 13, 4000);
INSERT INTO szekhelyek (szekhelyID, megye, varos, utca, hazszam, irsz) VALUES (14, 'vas', 'vas', 'bohos', 14, 4000);

INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (1, 'azura', '06209876543', 1);
INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (2, 'azurg', '06209876543', 2); 
INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (3, 'azurto', '06209876543', 3); 
INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (4, 'azurra', '06209876543', 4); 
INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (5, 'azurow', '06209876543', 5); 
INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (6, 'azuror', '06209876543', 6); 
INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (7, 'azuril', '06209876543', 7); 
INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (8, 'azurge', '06209876543', 8); 
INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (9, 'azurum', '06209876543', 9); 
INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (10, 'azurta', '06209876543', 10); 
INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (11, 'azurre', '06209876543', 11); 
INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (12, 'azuros', '06209876543', 12); 
INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (13, 'azurrod', '06209876543', 13); 
INSERT INTO cegek (cegId, nev, telefon, szekhelyID) VALUES (14, 'azurme', '06209876543', 14); 

INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (1, 'hirdeto1', 'test', 'hirdeto1@email.com', '06209876543', 'Random Name', 1);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (2, 'hirdeto2', 'test', 'hirdeto2@email.com', '06209876543', 'Random Name', 1);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (3, 'hirdeto3', 'test', 'hirdeto3@email.com', '06209876543', 'Random Name', 2);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (4, 'hirdeto4', 'test', 'hirdeto4@email.com', '06209876543', 'Random Name', 3);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (5, 'hirdeto5', 'test', 'hirdeto5@email.com', '06209876543', 'Random Name', 4);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (6, 'hirdeto6', 'test', 'hirdeto6@email.com', '06209876543', 'Random Name', 5);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (7, 'hirdeto7', 'test', 'hirdeto7@email.com', '06209876543', 'Random Name', 6);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (8, 'hirdeto8', 'test', 'hirdeto8@email.com', '06209876543', 'Random Name', 7);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (9, 'hirdeto9', 'test', 'hirdeto9@email.com', '06209876543', 'Random Name', 8);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (10, 'hirdeto10', 'test', 'hirdeto10@email.com', '06209876543', 'Random Name', 8);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (11, 'hirdeto11', 'test', 'hirdeto11@email.com', '06209876543', 'Random Name', 8);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (12, 'hirdeto12', 'test', 'hirdeto12@email.com', '06209876543', 'Random Name', 9);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (13, 'hirdeto13', 'test', 'hirdeto13@email.com', '06209876543', 'Random Name', 9);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (14, 'hirdeto14', 'test', 'hirdeto14@email.com', '06209876543', 'Random Name', 10);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (15, 'hirdeto15', 'test', 'hirdeto15@email.com', '06209876543', 'Random Name', 10);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (16, 'hirdeto16', 'test', 'hirdeto16@email.com', '06209876543', 'Random Name', 10);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (17, 'hirdeto17', 'test', 'hirdeto17@email.com', '06209876543', 'Random Name', 11);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (18, 'hirdeto18', 'test', 'hirdeto18@email.com', '06209876543', 'Random Name', 12);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (19, 'hirdeto19', 'test', 'hirdeto19@email.com', '06209876543', 'Random Name', 13);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (20, 'hirdeto20', 'test', 'hirdeto20@email.com', '06209876543', 'Random Name', 13);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (21, 'hirdeto21', 'test', 'hirdeto21@email.com', '06209876543', 'Random Name', 14);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (22, 'hirdeto22', 'test', 'hirdeto22@email.com', '06209876543', 'Random Name', 14);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (23, 'hirdeto23', 'test', 'hirdeto23@email.com', '06209876543', 'Random Name', 14);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (24, 'hirdeto24', 'test', 'hirdeto24@email.com', '06209876543', 'Random Name', 14);
INSERT INTO hirdetok (hirdetoID, felhasznalonev, jelszo, email, telefon, nev, cegID) VALUES (25, 'hirdeto25', 'test', 'hirdeto25@email.com', '06209876543', 'Random Name', 14);

INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (1, 'Senior Java fejleszto', null, 1, 'Szeged');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (2, 'Gepeszmernok', null, 2, 'Debrecen');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (3, 'Senior Python fejleszto', null, 3, 'Budapest');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (4, 'Higeniai manager', null, 4, 'Budapest');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (5, 'Igazgato helyettes', null, 5, 'Budapest');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (6, 'Mozi gepesz', null, 6, 'Budapest');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (7, 'Penztaros', null, 7, 'Debrecen');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (8, 'Csomagolo', null, 8, 'Szeged');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (9, 'Gyorsettermi alkalmazott', null, 9, 'Budapest');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (10, 'Konyvelo', null, 10, 'Szeged');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (11, 'Konyvelo', null, 11, 'Debrecen');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (12, 'Penztaros', null, 12, 'Szeged');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (13, 'Call Center operator', null, 13, 'Szeged');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (14, 'Recepcios', null, 14, 'Szeged');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (15, 'Gepeszmernok gyakornok', null, 15, 'Budapest');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (16, 'Logisztikai manager', null, 16, 'Szeged');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (17, 'Bartender', null, 17, 'Szeged');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (18, 'Junior Java fejleszto', null, 18, 'Szeged');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (19, 'Penztaros', null, 19, 'Szeged');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (20, 'Csoportvezeto', null, 20, 'Balatonöszöd');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (21, 'Gyorsettermi alkalmazott', null, 21, 'Szeged');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (22, 'Higeniai manager', null, 22, 'Budapest');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (23, 'Segedfelszolgalo', null, 23, 'Szombathely');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (24, 'Szakacs', null, 24, 'Szeged');
INSERT INTO hirdetesek (hirdetesID, cim, leiras, hirdetoID, helyszin) VALUES (25, 'Sport tanacsado', null, 25, 'Szeged');

INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (1, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (1, 3);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (1, 4);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (2, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (2, 3);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (2, 4);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (2, 5);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (3, 1);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (3, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (4, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (4, 1);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (5, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (6, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (7, 1);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (8, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (9, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (10, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (11, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (12, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (13, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (14, 1);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (14, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (14, 3);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (15, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (16, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (16, 3);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (17, 4);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (18, 4);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (19, 4);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (20, 1);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (21, 1);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (22, 1);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (23, 1);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (24, 2);
INSERT INTO hirdetes_jellege (hirdetesID, munkaID) VALUES (25, 1);

INSERT INTO jelentkezesek (hirdetesID, allaskeresoID) VALUES (1, 1);
INSERT INTO jelentkezesek (hirdetesID, allaskeresoID) VALUES (1, 2);
INSERT INTO jelentkezesek (hirdetesID, allaskeresoID) VALUES (1, 3);
INSERT INTO jelentkezesek (hirdetesID, allaskeresoID) VALUES (2, 4);
INSERT INTO jelentkezesek (hirdetesID, allaskeresoID) VALUES (2, 5);
INSERT INTO jelentkezesek (hirdetesID, allaskeresoID) VALUES (2, 6);
INSERT INTO jelentkezesek (hirdetesID, allaskeresoID) VALUES (3, 5);
INSERT INTO jelentkezesek (hirdetesID, allaskeresoID) VALUES (3, 10);

CREATE OR REPLACE PROCEDURE apply_for_job 
    (job_id IN jelentkezesek.hirdetesid%TYPE, 
    user_id IN jelentkezesek.allaskeresoid%TYPE) IS
BEGIN
    INSERT INTO jelentkezesek (hirdetesid, allaskeresoid) 
    VALUES (job_id, user_id);
END;   

CREATE OR REPLACE PROCEDURE allaskereso_create (
    username IN allaskeresok.felhasznalonev%TYPE,
    pass IN allaskeresok.jelszo%TYPE,
    legal_name IN allaskeresok.nev%TYPE,
    education IN allaskeresok.vegzettseg%TYPE,
    dateOfBirth IN allaskeresok.szuldatum%TYPE,
    know_language IN allaskeresok.nyelvismeret%TYPE,
    email IN allaskeresok.email%TYPE,
    address IN allaskeresok.lakhely%TYPE,
    phone IN allaskeresok.telefon%TYPE) 
IS
BEGIN
    INSERT INTO allaskeresok (
        felhasznalonev,
        jelszo,
        nev,
        vegzettseg,
        szuldatum,
        nyelvismeret,
        email,
        lakhely,
        telefon) 
        VALUES (username, pass, legal_name, 
            education, dateOfBirth, know_language, email, address, phone);
END; 

CREATE OR REPLACE FUNCTION can_delete_job
 (jobId IN hirdetesek.hirdetesid%TYPE, userID IN hirdetesek.hirdetoid%TYPE) RETURN NUMBER
IS
 v_hirdeto hirdetesek.hirdetoid%TYPE;
BEGIN
    SELECT hirdetoId INTO v_hirdeto FROM hirdetesek WHERE hirdetesId = jobId;
    IF (v_hirdeto = userID) THEN
    RETURN 1;
    ELSE
    RETURN 0;
    END IF;
END can_delete_job;

CREATE OR REPLACE PROCEDURE create_job (
    job_name IN hirdetesek.cim%TYPE, 
    job_description IN hirdetesek.leiras%TYPE,
    job_id IN hirdetesek.hirdetoID%TYPE,
    place IN hirdetesek.helyszin%TYPE,
	work_type IN munka_jellege.megnevezes%TYPE
) IS 
BEGIN
    INSERT INTO hirdetesek (cim, leiras, hirdetoID, helyszin) VALUES 
        (job_name, job_description, job_id, place);
END;

CREATE SEQUENCE hirdetesek_sequence;
ALTER SEQUENCE hirdetesek_sequence INCREMENT BY 25;
CREATE OR REPLACE TRIGGER hirdetesek_insert
BEFORE INSERT ON hirdetesek
FOR EACH ROW
BEGIN 
    SELECT hirdetesek_sequence.nextval
    INTO :new.hirdetesID
    FROM dual;
END;

CREATE SEQUENCE allaskeresok_sequence;
ALTER SEQUENCE allaskeresok_sequence INCREMENT BY 25;
CREATE OR REPLACE TRIGGER allaskeresok_insert
BEFORE INSERT ON allaskeresok
FOR EACH ROW
BEGIN 
    SELECT allaskeresok_sequence.nextval
    INTO :new.allaskeresoID
    FROM dual;
END;

CREATE SEQUENCE hirdetok_sequence;
ALTER SEQUENCE hirdetok_sequence INCREMENT BY 25;
CREATE OR REPLACE TRIGGER hirdetok_insert
BEFORE INSERT ON hirdetok
FOR EACH ROW
BEGIN 
    SELECT hirdetok_sequence.nextval
    INTO :new.hirdetoID
    FROM dual;
END;

CREATE SEQUENCE munka_jellege_sequence;
ALTER SEQUENCE munka_jellege_sequence INCREMENT BY 5;
CREATE OR REPLACE TRIGGER munka_jellege_insert
BEFORE INSERT ON munka_jellege
FOR EACH ROW
BEGIN 
    SELECT munka_jellege_sequence.nextval
    INTO :new.munkaID
    FROM dual;
END;

CREATE OR REPLACE TRIGGER insert_work_type
BEFORE UPDATE OR INSERT hirdetesek
FOR EACH ROW 
DECLARE 
	v_type_count NUMBER := 0;
BEGIN
	SELECT COUNT(*) INTO v_type_count FROM munka_jellege WHERE megnevezes = :NEW.megnevezes;
	IF v_type_count = 0 THEN
		INSERT INTO munka_jellege (megnevezes) VALUES (:NEW.megnevezes);
		DBMS_OUTPUT.PUT_LINE('Új munka jellege');
	END IF;
END;

CREATE TABLE hirdetes_letrehozas (felhasznalo NUMBER(3), hirdetes NUMBER(3), datum date);
CREATE OR REPLACE TRIGGER create_job_log 
AFTER INSERT ON hirdetesek
FOR EACH ROW
BEGIN
    INSERT INTO hirdetes_letrehozas VALUES (:NEW.hirdetoID, :NEW.hirdetesID, SYSDATE);
END;

CREATE OR REPLACE TRIGGER delete_children
BEFORE DELETE ON hirdetesek
FOR EACH ROW
BEGIN
    DELETE FROM hirdetes_jellege WHERE hirdetesID = :NEW.hirdetesID;
END;

CREATE OR REPLACE TRIGGER output_on_action
AFTER DELETE OR INSERT ON hirdetesek
BEGIN
    IF INSERTING THEN
        DBMS_OUTPUT.PUT_LINE('Új hirdetés létrejött');
    ELSIF DELETING THEN
        DBMS_OUTPUT.PUT_LINE('Hirdetés törlés');
    END IF;
END;

CREATE TRIGGER allaskereso_registration
AFTER INSERT ON allaskeresok
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Álláskereső regisztráció');
    DBMS_OUTPUT.PUT_LINE('felhasználónév: ' || :NEW.felhasznalonev);
END;