-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2021 at 03:19 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prms`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_data`
--

CREATE TABLE `admin_data` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Profession` varchar(30) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_data`
--

INSERT INTO `admin_data` (`ID`, `Name`, `Profession`, `Email`, `username`, `password`) VALUES
('A0001', 'Admin', 'Admin', 'Admin@gmail.com', 'Admin', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `admin_record`
--

CREATE TABLE `admin_record` (
  `ID_Record` int(11) NOT NULL,
  `ID_Admin` varchar(10) NOT NULL,
  `ID_Medicine` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_record`
--

INSERT INTO `admin_record` (`ID_Record`, `ID_Admin`, `ID_Medicine`) VALUES
(1, 'A0001', 'A001'),
(2, 'A0001', 'A002'),
(3, 'A0001', 'A003'),
(4, 'A0001', 'A004'),
(5, 'A0001', 'A005'),
(6, 'A0001', 'A006'),
(7, 'A0001', 'B001'),
(8, 'A0001', 'B002'),
(9, 'A0001', 'B003'),
(10, 'A0001', 'C001'),
(11, 'A0001', 'C002'),
(12, 'A0001', 'C003'),
(13, 'A0001', 'D001'),
(14, 'A0001', 'P001');

-- --------------------------------------------------------

--
-- Table structure for table `medicines`
--

CREATE TABLE `medicines` (
  `ID_Medicine` varchar(10) NOT NULL,
  `Medicines_Name` varchar(45) NOT NULL,
  `Status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicines`
--

INSERT INTO `medicines` (`ID_Medicine`, `Medicines_Name`, `Status`) VALUES
('A001', 'Amoxil', 'Available'),
('A002', 'Ambroxol', 'Unavailable'),
('A003', 'Allegra', 'Available'),
('A004', 'Atarax', 'Unavailable'),
('A005', 'Augmentin', 'Available'),
('A006', 'Ativan', 'Available'),
('B001', 'Bactroban', 'Available'),
('B002', 'Beclovent', 'Unavailable'),
('B003', 'Benzac', 'Unavailable'),
('C001', 'Capoten', 'Available'),
('C002', 'Claritin', 'Available'),
('C003', 'Colospa', 'Available'),
('D001', 'Ditropan', 'Available'),
('P001', 'Paracetamol', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `medicine_record`
--

CREATE TABLE `medicine_record` (
  `ID_Medicine` varchar(10) NOT NULL,
  `ID_Patient` varchar(10) NOT NULL,
  `ID_Record` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicine_record`
--

INSERT INTO `medicine_record` (`ID_Medicine`, `ID_Patient`, `ID_Record`) VALUES
('A002', '202A002', 1),
('A004', '202A001', 2),
('A002', '202A003', 3),
('C001', '193A001', 4);

-- --------------------------------------------------------

--
-- Table structure for table `patient_record`
--

CREATE TABLE `patient_record` (
  `ID_Patient` varchar(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Complain` varchar(30) NOT NULL,
  `Administration` varchar(20) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient_record`
--

INSERT INTO `patient_record` (`ID_Patient`, `Name`, `Complain`, `Administration`, `Date`) VALUES
('193A001', 'Sergei', 'High Blood Pressure', 'charged', '2019-03-14'),
('202A001', 'David Argus', 'Skin Allergic', 'charged', '2020-02-02'),
('202A002', 'Daniel Richard', 'Cough with Phlegm', 'charged', '2020-02-01'),
('202A003', 'Song Hye Kyo', 'Fever', 'charged', '2020-02-03');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_data`
--
ALTER TABLE `admin_data`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `admin_record`
--
ALTER TABLE `admin_record`
  ADD PRIMARY KEY (`ID_Record`),
  ADD KEY `ID_Admin` (`ID_Admin`),
  ADD KEY `ID_Medicine` (`ID_Medicine`);

--
-- Indexes for table `medicines`
--
ALTER TABLE `medicines`
  ADD PRIMARY KEY (`ID_Medicine`);

--
-- Indexes for table `medicine_record`
--
ALTER TABLE `medicine_record`
  ADD PRIMARY KEY (`ID_Record`),
  ADD KEY `ID_Medicine` (`ID_Medicine`),
  ADD KEY `ID_Patient` (`ID_Patient`);

--
-- Indexes for table `patient_record`
--
ALTER TABLE `patient_record`
  ADD PRIMARY KEY (`ID_Patient`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_record`
--
ALTER TABLE `admin_record`
  MODIFY `ID_Record` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `medicine_record`
--
ALTER TABLE `medicine_record`
  MODIFY `ID_Record` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin_record`
--
ALTER TABLE `admin_record`
  ADD CONSTRAINT `admin_record_ibfk_1` FOREIGN KEY (`ID_Admin`) REFERENCES `admin_data` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `admin_record_ibfk_2` FOREIGN KEY (`ID_Medicine`) REFERENCES `medicines` (`ID_Medicine`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `medicine_record`
--
ALTER TABLE `medicine_record`
  ADD CONSTRAINT `ID_Medicine` FOREIGN KEY (`ID_Medicine`) REFERENCES `medicines` (`ID_Medicine`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ID_Patient` FOREIGN KEY (`ID_Patient`) REFERENCES `patient_record` (`ID_Patient`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
