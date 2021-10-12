-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 03, 2021 at 10:54 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sielekthor`
--

--
-- Dumping data for table `tipe`
--

INSERT INTO `tipe` (`id`, `nama`, `deskripsi_tipe`) VALUES
(1, 'Infinity Stone', 'Batu akik yang punya kekuatan super'),
(2, 'Vibranium', 'Metal yang sangat kuat mampu menahan rasa rindu'),
(3, 'Reaktor', 'Pembangkit Listrik Tenaga Kuli'),
(4, 'Senjata', '\'No full auto in buildings\' - Sun Tzu, The Art of War'),
(5, 'Armor', 'Berani kotor itu baik - Rinso'),
(6, 'Spaceship', 'Benda melayang-layang tapi bukan layangan'),
(7, 'Amulet', 'Benda yang digantung di leher'),
(8, 'Buku', 'Benda yang dapat dibaca (Warning: May contain spells)'),
(9, 'Artifak', 'Benda-benda penting yang punya kekuatan magis khusus'),
(10, 'Artificial Intelligence', 'Kecerdasan Buatan yang dapat membantu meningkatkan kualitas hidup manusia');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;