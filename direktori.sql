-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 05, 2016 at 01:03 
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `startup`
--

-- --------------------------------------------------------

--
-- Table structure for table `direktori`
--

CREATE TABLE `direktori` (
  `id_db` int(11) NOT NULL,
  `nama` varchar(300) NOT NULL,
  `alamat` text NOT NULL,
  `founder` varchar(300) NOT NULL,
  `kontak` varchar(300) NOT NULL,
  `gambar` varchar(300) NOT NULL,
  `website` varchar(300) NOT NULL,
  `koordinat` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `direktori`
--

INSERT INTO `direktori` (`id_db`, `nama`, `alamat`, `founder`, `kontak`, `gambar`, `website`, `koordinat`) VALUES
(1, 'Kinerja Pay', 'Jalan Mongonsidi No.6 Medan', 'Edwin Ng', '+6280989999', 'https://www.kinerjapay.com/images/template/logo.png', 'https://www.kinerjapay.com/', ''),
(2, 'Paprika', 'Grand Serela Hotel - Ground Floor,\r\nJl. Gatot Subroto, No. 395', 'Indra Halim', '0614140297 ', 'https://d26bwjyd9l0e3m.cloudfront.net/wp-content/uploads/web/droptofree/Paprika-icon.jpg', 'https://www.paprika.co.id', ''),
(3, 'Deal Medan', 'Jalan Mongonsidi No.6 Medan', 'Cakra Danu Sedayu', '+6280989999', 'https://dealmedan.com/newlayout_resources/images/logo.png', 'https://www.dealmedan.com/', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `direktori`
--
ALTER TABLE `direktori`
  ADD PRIMARY KEY (`id_db`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `direktori`
--
ALTER TABLE `direktori`
  MODIFY `id_db` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
