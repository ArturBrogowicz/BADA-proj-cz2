/*
Created: 06/11/2024
Modified: 30/11/2024
Project: BADAcz1
Model: ModelLogiczny
Company: BADA Big Data Development
Author: Artur Brogowicz (331161) i Pawel Dobrosielski (331166)
Version: 2,0
Database: Oracle 19c
*/


-- Create tables section -------------------------------------------------

-- Table Salony

CREATE TABLE Salony(
  id_salonu Integer NOT NULL,
  nazwa Varchar2(50 ) NOT NULL,
  id_adresu Integer NOT NULL
)
TABLESPACE SYSTEM
/

-- Create indexes for table Salony

CREATE INDEX IX_salon_ma_adres ON Salony (id_adresu)
TABLESPACE SYSTEM
/

-- Add keys for table Salony

ALTER TABLE Salony ADD CONSTRAINT id_salonu PRIMARY KEY (id_salonu)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Pracownicy

CREATE TABLE Pracownicy(
  id_pracownika Integer NOT NULL,
  imie Varchar2(20 ) NOT NULL,
  nazwisko Varchar2(20 ) NOT NULL,
  pesel Char(11 ),
  czy_pracuje Char(1 ),
  id_salonu Integer NOT NULL,
  id_modelu Integer NOT NULL,
  id_adresu Integer NOT NULL
)
TABLESPACE SYSTEM
/

-- Create indexes for table Pracownicy

CREATE INDEX IX_salon_ma_pracownikow ON Pracownicy (id_salonu)
TABLESPACE SYSTEM
/

CREATE INDEX IX_pracownik_ma_tryby ON Pracownicy (id_modelu)
TABLESPACE SYSTEM
/

CREATE INDEX IX_nazwisko_pracownika ON Pracownicy (nazwisko)
TABLESPACE SYSTEM
/

CREATE INDEX IX_pracownik_ma_adres ON Pracownicy (id_adresu)
TABLESPACE SYSTEM
/

-- Add keys for table Pracownicy

ALTER TABLE Pracownicy ADD CONSTRAINT id_pracownika PRIMARY KEY (id_pracownika)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Uslugi

CREATE TABLE Uslugi(
  id_uslugi Integer NOT NULL,
  nazwa Varchar2(50 ) NOT NULL,
  opis Varchar2(2500 ) NOT NULL,
  koszt Number(10,2) NOT NULL,
  czy_oferowana Char(1 ) NOT NULL,
  id_salonu Integer NOT NULL
)
TABLESPACE SYSTEM
/

-- Create indexes for table Uslugi

CREATE INDEX IX_salon_oferuje_usluge ON Uslugi (id_salonu)
TABLESPACE SYSTEM
/

-- Add keys for table Uslugi

ALTER TABLE Uslugi ADD CONSTRAINT id_uslugi PRIMARY KEY (id_uslugi)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Sprzedawcy

CREATE TABLE Sprzedawcy(
  id_pracownika Integer NOT NULL,
  laczna_sprzedaz Number(10,2) NOT NULL,
  liczba_transakcji Integer NOT NULL
)
TABLESPACE SYSTEM
/

-- Add keys for table Sprzedawcy

ALTER TABLE Sprzedawcy ADD CONSTRAINT id_pracownika11 PRIMARY KEY (id_pracownika)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Uslugery

CREATE TABLE Uslugery(
  id_pracownika Integer NOT NULL,
  srednia_ocen Integer
        CHECK (srednia_ocen IN ('1','2','3','4','5','6','7','8','9','10'))
)
TABLESPACE SYSTEM
/

-- Add keys for table Uslugery

ALTER TABLE Uslugery ADD CONSTRAINT id_pracownikakk PRIMARY KEY (id_pracownika)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Klienci

CREATE TABLE Klienci(
  id_klienta Integer NOT NULL,
  imie Varchar2(20 ) NOT NULL,
  nazwisko Varchar2(20 ) NOT NULL,
  nr_telefonu Varchar2(16 ),
  plec Char(1 )
        CHECK (plec IN ('K', 'M')),
  id_salonu Integer NOT NULL,
  id_adresu Integer
)
TABLESPACE SYSTEM
/

-- Create indexes for table Klienci

CREATE INDEX IX_salon_ma_klientow ON Klienci (id_salonu)
TABLESPACE SYSTEM
/

CREATE INDEX IX_nazwisko_klienta ON Klienci (nazwisko)
TABLESPACE SYSTEM
/

CREATE INDEX IX_klient_ma_adres ON Klienci (id_adresu)
TABLESPACE SYSTEM
/

-- Add keys for table Klienci

ALTER TABLE Klienci ADD CONSTRAINT id_klienta PRIMARY KEY (id_klienta)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Produkty

CREATE TABLE Produkty(
  id_produktu Integer NOT NULL,
  nazwa Varchar2(50 ) NOT NULL,
  cena Number(10,2) NOT NULL,
  opis Varchar2(500 ) NOT NULL,
  liczba_sztuk Integer NOT NULL,
  czy_oferowany Char(1 ) NOT NULL,
  id_producenta Integer NOT NULL,
  id_salonu Integer NOT NULL
)
TABLESPACE SYSTEM
/

-- Create indexes for table Produkty

CREATE INDEX IX_produkt_ma_producenta ON Produkty (id_producenta)
TABLESPACE SYSTEM
/

CREATE INDEX IX_salon_oferuje_produkt ON Produkty (id_salonu)
TABLESPACE SYSTEM
/

-- Add keys for table Produkty

ALTER TABLE Produkty ADD CONSTRAINT id_produktu PRIMARY KEY (id_produktu)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Narzedzia

CREATE TABLE Narzedzia(
  id_narzedzia Integer NOT NULL,
  nazwa Varchar2(30 ) NOT NULL,
  cena Number(10,2) NOT NULL,
  opis Varchar2(500 ) NOT NULL,
  id_salonu Integer NOT NULL
)
TABLESPACE SYSTEM
/

-- Create indexes for table Narzedzia

CREATE INDEX IX_salon_ma_narzedzie ON Narzedzia (id_salonu)
TABLESPACE SYSTEM
/

-- Add keys for table Narzedzia

ALTER TABLE Narzedzia ADD CONSTRAINT id_narzedzia PRIMARY KEY (id_narzedzia)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Zakupy_Produktow

CREATE TABLE Zakupy_Produktow(
  id_zakupu Integer NOT NULL,
  data Date NOT NULL,
  czy_dostawa Char(1 ) NOT NULL,
  id_klienta Integer NOT NULL,
  id_produktu Integer NOT NULL,
  id_pracownika Integer
)
TABLESPACE SYSTEM
/

-- Create indexes for table Zakupy_Produktow

CREATE INDEX IX_produkt_jest_kupowany ON Zakupy_Produktow (id_produktu)
TABLESPACE SYSTEM
/

CREATE INDEX IX_klient_kupuje_produkt ON Zakupy_Produktow (id_klienta)
TABLESPACE SYSTEM
/

CREATE INDEX IX_pracownik_sprzedaje_produkt ON Zakupy_Produktow (id_pracownika)
TABLESPACE SYSTEM
/

CREATE INDEX IX_data_zakupy_produktow ON Zakupy_Produktow (data)
TABLESPACE SYSTEM
/

-- Add keys for table Zakupy_Produktow

ALTER TABLE Zakupy_Produktow ADD CONSTRAINT id_zakupu PRIMARY KEY (id_zakupu)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Wykorzystane_Narzedzia

CREATE TABLE Wykorzystane_Narzedzia(
  id_uslugi Integer NOT NULL,
  id_narzedzia Integer NOT NULL
)
TABLESPACE SYSTEM
/

-- Add keys for table Wykorzystane_Narzedzia

ALTER TABLE Wykorzystane_Narzedzia ADD CONSTRAINT id_wykorzystania PRIMARY KEY (id_uslugi, id_narzedzia)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Wykonanie_Uslug

CREATE TABLE Wykonanie_Uslug(
  id_wykonania Integer NOT NULL,
  data Date NOT NULL,
  czas_trwania Integer,
  id_uslugi Integer NOT NULL,
  id_klienta Integer NOT NULL,
  id_pracownika Integer
)
TABLESPACE SYSTEM
/

-- Create indexes for table Wykonanie_Uslug

CREATE INDEX IX_pracownik_wykonuje_usluge_Usluga ON Wykonanie_Uslug (id_uslugi)
TABLESPACE SYSTEM
/

CREATE INDEX IX_pracownik_wykonuje_usluge_Pracownik ON Wykonanie_Uslug (id_pracownika)
TABLESPACE SYSTEM
/

CREATE INDEX IX_data_wykonanie_uslug ON Wykonanie_Uslug (data)
TABLESPACE SYSTEM
/

-- Add keys for table Wykonanie_Uslug

ALTER TABLE Wykonanie_Uslug ADD CONSTRAINT id_wykonania PRIMARY KEY (id_wykonania)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Adresy

CREATE TABLE Adresy(
  id_adresu Integer NOT NULL,
  miasto Varchar2(40 ) NOT NULL,
  ulica Varchar2(40 ) NOT NULL,
  kod_pocztowy Char(6 ) NOT NULL,
  nr_budynku Integer NOT NULL,
  nr_lokalu Integer
)
TABLESPACE SYSTEM
/

-- Add keys for table Adresy

ALTER TABLE Adresy ADD CONSTRAINT id_adresu PRIMARY KEY (id_adresu)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Wlasciciele

CREATE TABLE Wlasciciele(
  id_wlasciciela Integer NOT NULL,
  imie Varchar2(20 ) NOT NULL,
  nazwisko Varchar2(20 ) NOT NULL,
  id_salonu Integer NOT NULL,
  id_adresu Integer NOT NULL
)
TABLESPACE SYSTEM
/

-- Create indexes for table Wlasciciele

CREATE INDEX IX_salon_ma_wlascicieli ON Wlasciciele (id_salonu)
TABLESPACE SYSTEM
/

CREATE INDEX IX_wlasciciel_ma_adres ON Wlasciciele (id_adresu)
TABLESPACE SYSTEM
/

-- Add keys for table Wlasciciele

ALTER TABLE Wlasciciele ADD CONSTRAINT id_wlasciciela PRIMARY KEY (id_wlasciciela)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Producenci

CREATE TABLE Producenci(
  id_producenta Integer NOT NULL,
  nazwa Varchar2(40 ) NOT NULL,
  kod_kraju Char(2 ) NOT NULL,
  adres_email Varchar2(40 ),
  opis Varchar2(2500 )
)
TABLESPACE SYSTEM
/

-- Add keys for table Producenci

ALTER TABLE Producenci ADD CONSTRAINT PK_Producenci PRIMARY KEY (id_producenta)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Modele_Pracy

CREATE TABLE Modele_Pracy(
  id_modelu Integer NOT NULL,
  stanowisko Varchar2(30 ) NOT NULL
        CHECK (stanowisko IN ('sprzedawca','usluger','menadzer','inne')),
  tryb_pracy Varchar2(30 ) NOT NULL
        CHECK (tryb_pracy IN ('pelny etat', 'pol etatu', 'cwierc etatu','umowa zlecenie','umowa o dzielo')),
  pensja Number(10,2) NOT NULL
)
TABLESPACE SYSTEM
/

-- Add keys for table Modele_Pracy

ALTER TABLE Modele_Pracy ADD CONSTRAINT id_modelu PRIMARY KEY (id_modelu)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Oceny_Klientow

CREATE TABLE Oceny_Klientow(
  id_oceny Integer NOT NULL,
  wysokosc Integer NOT NULL
        CHECK (wysokosc IN ('1','2','3','4','5','6','7','8','9','10')),
  tresc Varchar2(2500 ),
  id_pracownika Integer NOT NULL,
  id_klienta Integer NOT NULL
)
TABLESPACE SYSTEM
/

-- Create indexes for table Oceny_Klientow

CREATE INDEX IX_usluger_ma_ocene ON Oceny_Klientow (id_pracownika)
TABLESPACE SYSTEM
/

CREATE INDEX IX_usluger_jest_zarezerwowany ON Oceny_Klientow (id_klienta)
TABLESPACE SYSTEM
/

-- Add keys for table Oceny_Klientow

ALTER TABLE Oceny_Klientow ADD CONSTRAINT id_oceny PRIMARY KEY (id_oceny)
   USING INDEX TABLESPACE SYSTEM
/

-- Table Rezerwacje_Uslugerow

CREATE TABLE Rezerwacje_Uslugerow(
  id_rezerwacji Integer NOT NULL,
  id_pracownika Integer NOT NULL,
  data Date NOT NULL
)
TABLESPACE SYSTEM
/

-- Create indexes for table Rezerwacje_Uslugerow

CREATE INDEX IX_klient_wystawia_ocene ON Rezerwacje_Uslugerow (id_pracownika)
TABLESPACE SYSTEM
/

-- Add keys for table Rezerwacje_Uslugerow

ALTER TABLE Rezerwacje_Uslugerow ADD CONSTRAINT PK_Rezerwacje_Uslugerow PRIMARY KEY (id_rezerwacji)
   USING INDEX TABLESPACE SYSTEM
/


-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE Pracownicy ADD CONSTRAINT salon_ma_pracownikow FOREIGN KEY (id_salonu) REFERENCES Salony (id_salonu)
/



ALTER TABLE Klienci ADD CONSTRAINT salon_ma_klientow FOREIGN KEY (id_salonu) REFERENCES Salony (id_salonu)
/



ALTER TABLE Wlasciciele ADD CONSTRAINT salon_ma_wlascicieli FOREIGN KEY (id_salonu) REFERENCES Salony (id_salonu)
/



ALTER TABLE Produkty ADD CONSTRAINT produkt_ma_producenta FOREIGN KEY (id_producenta) REFERENCES Producenci (id_producenta)
/



ALTER TABLE Wykorzystane_Narzedzia ADD CONSTRAINT narzedzie_jest_wykorzystywane FOREIGN KEY (id_narzedzia) REFERENCES Narzedzia (id_narzedzia)
/

ALTER TABLE Wykorzystane_Narzedzia ADD CONSTRAINT usluga_wykorzystuje_narzedzie FOREIGN KEY (id_uslugi) REFERENCES Uslugi (id_uslugi)
/



ALTER TABLE Pracownicy ADD CONSTRAINT pracownik_ma_model_pracy FOREIGN KEY (id_modelu) REFERENCES Modele_Pracy (id_modelu)
/



ALTER TABLE Wykonanie_Uslug ADD CONSTRAINT klient_rezerwuje_usluge FOREIGN KEY (id_klienta) REFERENCES Klienci (id_klienta)
/

ALTER TABLE Wykonanie_Uslug ADD CONSTRAINT pracownik_wykonuje_usluge FOREIGN KEY (id_pracownika) REFERENCES Pracownicy (id_pracownika)
/

ALTER TABLE Wykonanie_Uslug ADD CONSTRAINT usluga_zostaje_wykonana FOREIGN KEY (id_uslugi) REFERENCES Uslugi (id_uslugi)
/



ALTER TABLE Zakupy_Produktow ADD CONSTRAINT pracownik_sprzedaje_produkt FOREIGN KEY (id_pracownika) REFERENCES Pracownicy (id_pracownika)
/

ALTER TABLE Zakupy_Produktow ADD CONSTRAINT produkt_jest_kupowany FOREIGN KEY (id_produktu) REFERENCES Produkty (id_produktu)
/

ALTER TABLE Zakupy_Produktow ADD CONSTRAINT klient_dokonuje_zakupu FOREIGN KEY (id_klienta) REFERENCES Klienci (id_klienta)
/

ALTER TABLE Oceny_Klientow ADD CONSTRAINT usluger_ma_ocene FOREIGN KEY (id_pracownika) REFERENCES Pracownicy (id_pracownika)
/

ALTER TABLE Sprzedawcy ADD CONSTRAINT pracownik_ma_specjalizacje_sprzedawca FOREIGN KEY (id_pracownika) REFERENCES Pracownicy (id_pracownika)
/

ALTER TABLE Rezerwacje_Uslugerow ADD CONSTRAINT usluger_jest_zarezerwowany FOREIGN KEY (id_pracownika) REFERENCES Pracownicy (id_pracownika)
/



ALTER TABLE Oceny_Klientow ADD CONSTRAINT klient_wystawia_ocene FOREIGN KEY (id_klienta) REFERENCES Klienci (id_klienta)
/



ALTER TABLE Uslugi ADD CONSTRAINT salon_oferuje_usluge FOREIGN KEY (id_salonu) REFERENCES Salony (id_salonu)
/



ALTER TABLE Produkty ADD CONSTRAINT salon_oferuje_produkt FOREIGN KEY (id_salonu) REFERENCES Salony (id_salonu)
/



ALTER TABLE Narzedzia ADD CONSTRAINT salon_ma_narzedzia FOREIGN KEY (id_salonu) REFERENCES Salony (id_salonu)
/



ALTER TABLE Wlasciciele ADD CONSTRAINT wlasciciel_ma_adres FOREIGN KEY (id_adresu) REFERENCES Adresy (id_adresu)
/



ALTER TABLE Salony ADD CONSTRAINT salon_ma_adres FOREIGN KEY (id_adresu) REFERENCES Adresy (id_adresu)
/



ALTER TABLE Klienci ADD CONSTRAINT klient_ma_adres FOREIGN KEY (id_adresu) REFERENCES Adresy (id_adresu)
/



ALTER TABLE Pracownicy ADD CONSTRAINT pracownik_ma_adres FOREIGN KEY (id_adresu) REFERENCES Adresy (id_adresu)
/

-- Create Sequences and Triggers for Ids' -------------------------------------------------------

-- Adresy --

CREATE SEQUENCE seq_id_adresu
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_adresu
    BEFORE INSERT ON adresy
    FOR EACH ROW
BEGIN
    IF :NEW.ID_ADRESU IS NULL THEN
        :NEW.ID_ADRESU := seq_id_adresu.NEXTVAL;
END IF;
END;
/

-- Klienci --

CREATE SEQUENCE seq_id_klienta
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_klienta
    BEFORE INSERT ON klienci
    FOR EACH ROW
BEGIN
    IF :NEW.ID_KLIENTA IS NULL THEN
        :NEW.ID_KLIENTA := seq_id_klienta.NEXTVAL;
END IF;
END;
/

-- Modele_Pracy --

CREATE SEQUENCE seq_id_modelu
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_modelu
    BEFORE INSERT ON modele_pracy
    FOR EACH ROW
BEGIN
    IF :NEW.ID_MODELU IS NULL THEN
        :NEW.ID_MODELU := seq_id_modelu.NEXTVAL;
END IF;
END;
/

-- Narzedzia --

CREATE SEQUENCE seq_id_narzedzia
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_narzedzia
    BEFORE INSERT ON narzedzia
    FOR EACH ROW
BEGIN
    IF :NEW.ID_NARZEDZIA IS NULL THEN
        :NEW.ID_NARZEDZIA := seq_id_narzedzia.NEXTVAL;
END IF;
END;
/

-- Oceny_Klientow

CREATE SEQUENCE seq_id_oceny
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_oceny
    BEFORE INSERT ON oceny_klientow
    FOR EACH ROW
BEGIN
    IF :NEW.ID_OCENY IS NULL THEN
        :NEW.ID_OCENY := seq_id_oceny.NEXTVAL;
END IF;
END;
/

-- Pracownicy --

CREATE SEQUENCE seq_id_pracownika
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_pracownika
    BEFORE INSERT ON pracownicy
    FOR EACH ROW
BEGIN
    IF :NEW.ID_PRACOWNIKA IS NULL THEN
        :NEW.ID_PRACOWNIKA := seq_id_pracownika.NEXTVAL;
END IF;
END;
/

-- Producenci --

CREATE SEQUENCE seq_id_producenta
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_producenta
    BEFORE INSERT ON producenci
    FOR EACH ROW
BEGIN
    IF :NEW.ID_PRODUCENTA IS NULL THEN
        :NEW.ID_PRODUCENTA := seq_id_producenta.NEXTVAL;
END IF;
END;
/

-- Produkty

CREATE SEQUENCE seq_id_produktu
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_produktu
    BEFORE INSERT ON produkty
    FOR EACH ROW
BEGIN
    IF :NEW.ID_PRODUKTU IS NULL THEN
        :NEW.ID_PRODUKTU := seq_id_produktu.NEXTVAL;
END IF;
END;
/

-- Rezerwacje_Uslugerow

CREATE SEQUENCE seq_id_rezerwacji
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_rezerwacji
    BEFORE INSERT ON rezerwacje_uslugerow
    FOR EACH ROW
BEGIN
    IF :NEW.ID_REZERWACJI IS NULL THEN
        :NEW.ID_REZERWACJI := seq_id_rezerwacji.NEXTVAL;
END IF;
END;
/

-- Salony --

CREATE SEQUENCE seq_id_salonu
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_salonu
    BEFORE INSERT ON salony
    FOR EACH ROW
BEGIN
    IF :NEW.ID_SALONU IS NULL THEN
        :NEW.ID_SALONU := seq_id_salonu.NEXTVAL;
END IF;
END;
/

-- Uslugi --

CREATE SEQUENCE seq_id_uslugi
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_uslugi
    BEFORE INSERT ON uslugi
    FOR EACH ROW
BEGIN
    IF :NEW.ID_USLUGI IS NULL THEN
        :NEW.ID_USLUGI := seq_id_uslugi.NEXTVAL;
END IF;
END;
/

-- Wlasciciele --

CREATE SEQUENCE seq_id_wlasciciela
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_wlasciciela
    BEFORE INSERT ON wlasciciele
    FOR EACH ROW
BEGIN
    IF :NEW.ID_WLASCICIELA IS NULL THEN
        :NEW.ID_WLASCICIELA := seq_id_wlasciciela.NEXTVAL;
END IF;
END;
/

-- Wykonanie_Uslugi --

CREATE SEQUENCE seq_id_wykonania
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_wykonania
    BEFORE INSERT ON wykonanie_uslug
    FOR EACH ROW
BEGIN
    IF :NEW.ID_WYKONANIA IS NULL THEN
        :NEW.ID_WYKONANIA := seq_id_wykonania.NEXTVAL;
END IF;
END;
/

-- Zakupy_Produktow --

CREATE SEQUENCE seq_id_zakupu
    START WITH 1
    INCREMENT BY 1
    NOCACHE;


CREATE OR REPLACE TRIGGER trg_id_zakupu
    BEFORE INSERT ON zakupy_produktow
    FOR EACH ROW
BEGIN
    IF :NEW.ID_ZAKUPU IS NULL THEN
        :NEW.ID_ZAKUPU := seq_id_zakupu.NEXTVAL;
END IF;
END;
/