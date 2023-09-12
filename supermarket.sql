-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Set 12, 2023 alle 14:49
-- Versione del server: 10.4.27-MariaDB
-- Versione PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `supermarket`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `categorie`
--

CREATE TABLE `categorie` (
  `id` bigint(20) NOT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `cognome`, `email`) VALUES
(1, 'Nakama', 'Lafitte', 'nakama.lafitte@gmail.com'),
(2, 'Marco', 'Esposito', 'marco.esposito@gmail.com'),
(4, 'Maria', 'Piperna', 'maria.piperna@gmail.com'),
(5, 'Fortunato', 'Panico', 'fortunato.panico@gmail.com');

-- --------------------------------------------------------

--
-- Struttura della tabella `dettagli_vendite`
--

CREATE TABLE `dettagli_vendite` (
  `id` int(11) NOT NULL,
  `idvendita` int(11) NOT NULL,
  `idprodotto` int(11) NOT NULL,
  `quantita` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `dettagli_vendite`
--

INSERT INTO `dettagli_vendite` (`id`, `idvendita`, `idprodotto`, `quantita`) VALUES
(1, 2, 1, 7),
(2, 1, 4, 10),
(4, 2, 4, 8),
(5, 2, 4, 8);

-- --------------------------------------------------------

--
-- Struttura della tabella `dipendenti`
--

CREATE TABLE `dipendenti` (
  `id` bigint(20) NOT NULL,
  `codicemansione` bigint(20) DEFAULT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `mansione`
--

CREATE TABLE `mansione` (
  `id` bigint(20) NOT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotto`
--

CREATE TABLE `prodotto` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `descrizione` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `prodotto`
--

INSERT INTO `prodotto` (`id`, `nome`, `descrizione`) VALUES
(1, 'PC ASUS', 'Peggio del pc di Evangelion'),
(2, 'Videogioco Tekken', 'Picchiaduro più bello in assoluto!'),
(4, 'Mouse wirless', 'mouse da gaming wirless di ultima generazione'),
(5, 'Gioco di Nakama', 'Gioco per pc fatto con Unity');

-- --------------------------------------------------------

--
-- Struttura della tabella `vendite`
--

CREATE TABLE `vendite` (
  `id` int(11) NOT NULL,
  `codice` int(11) NOT NULL,
  `data` varchar(255) NOT NULL,
  `idcliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `vendite`
--

INSERT INTO `vendite` (`id`, `codice`, `data`, `idcliente`) VALUES
(1, 11, '10/01/2019', 1),
(3, 3, '10/02/2015', 4),
(4, 8, '10/02/2015', 2),
(5, 55, '24/12/2015', 2);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `dettagli_vendite`
--
ALTER TABLE `dettagli_vendite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlqfgxsxna7xv8ldcedrnqbp1` (`idprodotto`);

--
-- Indici per le tabelle `dipendenti`
--
ALTER TABLE `dipendenti`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKd4q392u6j6tlxgmha7tnckw78` (`codicemansione`);

--
-- Indici per le tabelle `mansione`
--
ALTER TABLE `mansione`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `prodotto`
--
ALTER TABLE `prodotto`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `vendite`
--
ALTER TABLE `vendite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK70rq73dsw5v6m0e4la1e8o1jj` (`idcliente`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `dettagli_vendite`
--
ALTER TABLE `dettagli_vendite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `dipendenti`
--
ALTER TABLE `dipendenti`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `mansione`
--
ALTER TABLE `mansione`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `prodotto`
--
ALTER TABLE `prodotto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `vendite`
--
ALTER TABLE `vendite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `dettagli_vendite`
--
ALTER TABLE `dettagli_vendite`
  ADD CONSTRAINT `FKlqfgxsxna7xv8ldcedrnqbp1` FOREIGN KEY (`idprodotto`) REFERENCES `prodotto` (`id`);

--
-- Limiti per la tabella `dipendenti`
--
ALTER TABLE `dipendenti`
  ADD CONSTRAINT `FKd4q392u6j6tlxgmha7tnckw78` FOREIGN KEY (`codicemansione`) REFERENCES `mansione` (`id`);

--
-- Limiti per la tabella `vendite`
--
ALTER TABLE `vendite`
  ADD CONSTRAINT `FK70rq73dsw5v6m0e4la1e8o1jj` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
