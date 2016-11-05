-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 05, 2016 at 11:04 
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nongkrong`
--

-- --------------------------------------------------------

--
-- Table structure for table `tempat`
--

CREATE TABLE `tempat` (
  `id_db` int(10) NOT NULL,
  `nama_tempat` varchar(300) NOT NULL,
  `kordinat` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tempat`
--

INSERT INTO `tempat` (`id_db`, `nama_tempat`, `kordinat`) VALUES
(1, 'HermesPlaces', '3.5655214, 98.6655594'),
(2, 'fasilkomti', '3.5655214, 98.6655594'),
(3, 'HOTEL_POLONIA', '3.5655214, 98.6655594'),
(4, 'CBD_Polonia', '3.5595249, 98.6712672'),
(5, 'Kolam-Renang-Selayang', '3.5695048, 98.6459042'),
(6, 'Desadesa-Resto', '3.5700617, 98.6480929'),
(7, 'Mie-Aceh-Titi-Bobrok', '3.5825685, 98.6355187'),
(8, 'Pekan-Raya-Sumatra-Utara', '3.5850099, 98.6354758'),
(9, 'Stasiun-Medan', '3.5903697, 98.6730271'),
(10, 'LemburKuring', '3.6018949, 98.6496786');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tempat`
--
ALTER TABLE `tempat`
  ADD PRIMARY KEY (`id_db`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tempat`
--
ALTER TABLE `tempat`
  MODIFY `id_db` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
