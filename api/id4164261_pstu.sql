-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 26, 2020 at 03:36 AM
-- Server version: 10.3.16-MariaDB
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
-- Database: `id4164261_pstu`
--

-- --------------------------------------------------------

--
-- Table structure for table `course_entry`
--

CREATE TABLE `course_entry` (
  `id` int(11) NOT NULL,
  `course_title` varchar(100) NOT NULL,
  `course_code` varchar(50) NOT NULL,
  `credit` varchar(55) NOT NULL,
  `faculty` varchar(50) NOT NULL,
  `semester` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_entry`
--

INSERT INTO `course_entry` (`id`, `course_title`, `course_code`, `credit`, `faculty`, `semester`) VALUES
(6, 'Physics-1', 'PHY 111', 'Credit: 3.00', 'Computer Science and Engineering', 'Semester-I'),
(14, 'Chemestry-1', 'CHE 111', 'Credit: 3.00', 'Computer Science and Engineering', 'Semester-I'),
(43, 'Mathematics-1', 'MAT 111', 'Credit: 3.00', 'Computer Science and Engineering', 'Semester-I'),
(44, 'Basic Electrical Engineering', 'EEE 111', 'Credit: 3.00', 'Computer Science and Engineering', 'Semester-I'),
(45, 'Programming Language', 'CIT 111', 'Credit: 3.00', 'Computer Science and Engineering', 'Semester-I'),
(46, 'Engineering Drawing', 'CCE 112', 'Credit: 0.75', 'Computer Science and Engineering', 'Semester-I'),
(47, 'Physics-1 Sessional', 'PHY 112', 'Credit: 0.75', 'Computer Science and Engineering', 'Semester-I'),
(48, 'Chemestry-1 Sessional', 'CHE-112', 'Credit: 0.75', 'Computer Science and Engineering', 'Semester-I'),
(49, 'Basic Electrical Engineering Sessional', 'EEE 112', 'Credit: 1.50', 'Computer Science and Engineering', 'Semester-I'),
(50, 'Programming Language Sessional', 'CIT 112', 'Credit: 1.50', 'Computer Science and Engineering', 'Semester-I');

-- --------------------------------------------------------

--
-- Table structure for table `student_registration`
--

CREATE TABLE `student_registration` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Id_no` varchar(7) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `reg_no` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `pass` varchar(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `faculty` varchar(40) NOT NULL,
  `batch` varchar(20) NOT NULL,
  `contact` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_registration`
--

INSERT INTO `student_registration` (`id`, `name`, `Id_no`, `reg_no`, `pass`, `faculty`, `batch`, `contact`, `email`) VALUES
(549, 'Tanvir Anwar Rafi', '1402060', '05409', 'rafi', 'Computer Science and Engineering', '12th Batch', '01721260457', 'rafi@gmail.com'),
(555, 'Shakib', '1804006', '07953', '72584916', 'Fisharies', '12th Batch', '01708896317', 'rizwanssnic@gmail.com'),
(567, 'Jyoti Ray Sarkar', '1402038', '05356', 'jyoti', 'Computer Science and Engineering', '12th Batch', '01721260456', 'jyoti@gmail.com'),
(568, 'Monir', '1602005', '06497', '123', 'Computer Science and Engineering', '14th Batch', '01772249872', 'monir@gmail.com'),
(584, 'MD Hasibur Rahman', '1902065', '08771', '55566152', 'Computer Science and Engineering', '17th Batch', '01959637585', 'hasibur.sci018@gmail.com'),
(591, 'Tarek', '1003008', '02923', 'gcbxn$#@p', 'Business Administration and Management', '08th Batch', '01916976600', 'shobuztarek@gmail.com'),
(592, 'Hafizur Rahman Ahad', '1701181', '07178', '55555', 'Agriculture', '19th Batch', '01714598476', 'hafizur.ahad1971@gmail.com'),
(595, 'papathoti Hemalath', '1100121', '01128', '12345', 'Agriculture', '01th Batch', '8790631059', 'hemalathapapathoti@gmail.con'),
(623, 'Shangita Das', '1402007', '05356', 'shangita', 'Computer Science and Engineering', '12th Batch', '01515255863', 'shangita@gmail.com'),
(627, 'Rafi Haydar', '546', '54349', 'vsjlsb', 'Computer Science and Engineering', '12th Batch', '01878072845', 'rafihaydar@gmail.com'),
(631, 'Saidur Rahman Sumon', '1402067', '05416', 'abcde', 'Computer Science and Engineering', '12th Batch', '01742340268', 'saidursumon96@gmail.com'),
(637, 'টেস্ট', '1234567', '0546', '1234567', 'Agriculture', '01th Batch', '01521438885', 'test@test.test'),
(642, 'Sultan Ahmed', '1402061', '05406', 'sultan', 'Computer Science and Engineering', '12th Batch', '01770000601', 'ssultan@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `teacher_registration`
--

CREATE TABLE `teacher_registration` (
  `id` int(11) NOT NULL,
  `t_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `t_post` varchar(30) NOT NULL,
  `t_faculty` varchar(100) NOT NULL,
  `t_dept` varchar(100) NOT NULL,
  `t_pass` varchar(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `t_contact` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `t_email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher_registration`
--

INSERT INTO `teacher_registration` (`id`, `t_name`, `t_post`, `t_faculty`, `t_dept`, `t_pass`, `t_contact`, `t_email`) VALUES
(7, 'Dr. Syed Md. Galib', 'Associate Professor', 'Computer Science and Engineering', 'Department of Computer Science and Information Technology', 'galib', '01781408274', 'galib@pstu.ac.bd'),
(15, 'Dr. Md. Samsujjaman Sabuj', 'Associate Professor', 'Computer Science and Engineering', 'Department of Computer and Communication Engineering', 'sabuj', '1234567890', 'sabuzcse@pstu.ac.bd'),
(16, 'Sajal Saha', 'Lecturer', 'Computer Science and Engineering', 'Department of Computer and Communication Engineering', 'sajalsir', '01736092609', 'sajalsir@gmail.com'),
(17, 'Chinmay Bepery', 'Assistant Professor', 'Computer Science and Engineering', 'Department of Computer Science and Information Technology', 'chinmay', '01710531024', 'chinmay.cse@pstu.ac.bd'),
(18, 'Dr. Md. Delowar Hossain', 'Professor', 'Agriculture', 'Department of Soil Science', 'delwar', '01911682121', 'delowarpstu@yahoo.co.in'),
(51, 'test', 'Professor', 'Agriculture', 'Department of Soil Science', 'test', '01721260456', 'test@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course_entry`
--
ALTER TABLE `course_entry`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_registration`
--
ALTER TABLE `student_registration`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `Id_no` (`Id_no`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `teacher_registration`
--
ALTER TABLE `teacher_registration`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course_entry`
--
ALTER TABLE `course_entry`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `student_registration`
--
ALTER TABLE `student_registration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=643;

--
-- AUTO_INCREMENT for table `teacher_registration`
--
ALTER TABLE `teacher_registration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
