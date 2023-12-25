-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 25, 2023 at 04:17 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restomanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `customerlist`
--

CREATE TABLE `customerlist` (
  `id` varchar(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `cabang` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customerlist`
--

INSERT INTO `customerlist` (`id`, `name`, `cabang`) VALUES
('B509C', 'Bule', 'Surabaya'),
('S038C', 'Si cantik', 'Jakarta');

-- --------------------------------------------------------

--
-- Table structure for table `employeelist`
--

CREATE TABLE `employeelist` (
  `id` varchar(5) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `cabang` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employeelist`
--

INSERT INTO `employeelist` (`id`, `name`, `cabang`) VALUES
('N890E', 'Nelpi', 'Surabaya'),
('R575E', 'Ricat', 'Jakarta'),
('V659E', 'Vincent', 'Bali');

-- --------------------------------------------------------

--
-- Table structure for table `menulist`
--

CREATE TABLE `menulist` (
  `name` varchar(30) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `cabang` varchar(10) DEFAULT NULL,
  `story` varchar(100) DEFAULT NULL,
  `location` varchar(30) DEFAULT NULL,
  `characteristic` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menulist`
--

INSERT INTO `menulist` (`name`, `price`, `cabang`, `story`, `location`, `characteristic`) VALUES
('Babi guling', 150000, 'Jakarta', NULL, NULL, NULL),
('Ayam hijau', 40000, 'Jakarta', 'Ayam ini sangatlah hijau, dikutuk ama santa', NULL, NULL),
('Bebek panggang', 100000, 'Jakarta', 'Pada suatu hari, hiduplah sebuah bebek. eh bebeknya dimasak. THE END', NULL, NULL),
('Kue ikan', 30000, 'Jakarta', NULL, NULL, NULL),
('Smoothie es krim', 20000, 'Jakarta', NULL, NULL, NULL),
('Ikan tengil', 20000, 'Surabaya', NULL, 'Desa cikap', 'ada sirip ama matanya bulet'),
('Jus alpukat', 5000, 'Surabaya', NULL, NULL, NULL),
('Balinese ayam', 90000, 'Bali', NULL, NULL, NULL),
('Gold leaf monkey', 500000, 'Bali', 'Suatu hari, org berkata -mari kita mahalkan harga di bali-', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tablelist`
--

CREATE TABLE `tablelist` (
  `id` varchar(5) DEFAULT NULL,
  `order` varchar(300) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tablelist`
--

INSERT INTO `tablelist` (`id`, `order`, `type`, `status`) VALUES
('S038C', NULL, 'General', 'IN RESERVE'),
('S038C', NULL, 'Romantic', 'IN RESERVE'),
('B509C', 'Ikan tengil,Jus alpukat,', 'General', 'FINALIZED'),
('B509C', 'Jus alpukat,', 'Family', 'FINALIZED');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customerlist`
--
ALTER TABLE `customerlist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employeelist`
--
ALTER TABLE `employeelist`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
