-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 07, 2020 at 04:08 PM
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
-- Database: `inquiry`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
CREATE TABLE IF NOT EXISTS `answer` (
  `answer_id` int(11) NOT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `is_correct` bit(1) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `FK8frr4bcabmmeyyu60qt7iiblo` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`answer_id`, `answer`, `is_correct`, `question_id`) VALUES
(6, 'Odgovor', b'1', 5),
(10, 'Odgovor', b'1', 9),
(14, 'Odgovor', b'1', 13),
(18, 'Odgovor', b'1', 17);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(1, 'Sport');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(19),
(19),
(19),
(19),
(19);

-- --------------------------------------------------------

--
-- Table structure for table `inquiry`
--

DROP TABLE IF EXISTS `inquiry`;
CREATE TABLE IF NOT EXISTS `inquiry` (
  `inquiry_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `inquiry_name` varchar(255) DEFAULT NULL,
  `number_of_question_group` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`inquiry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inquiry`
--

INSERT INTO `inquiry` (`inquiry_id`, `category_id`, `inquiry_name`, `number_of_question_group`, `user_id`) VALUES
(3, 3, 'Test', 4, 3),
(7, 3, 'Test', 4, 3),
(11, 3, 'Test', 4, 3),
(15, 3, 'Test', 4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `question_id` int(11) NOT NULL,
  `question` varchar(255) DEFAULT NULL,
  `question_group_id` int(11) NOT NULL,
  PRIMARY KEY (`question_id`),
  KEY `FK7v6es33lcfjb7ud98vmmr6axl` (`question_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`question_id`, `question`, `question_group_id`) VALUES
(5, 'Pitanje', 4),
(9, 'Pitanje', 8),
(13, 'Pitanje', 12),
(17, 'Pitanje', 16);

-- --------------------------------------------------------

--
-- Table structure for table `question_group`
--

DROP TABLE IF EXISTS `question_group`;
CREATE TABLE IF NOT EXISTS `question_group` (
  `question_group_id` int(11) NOT NULL,
  `number_of_question` int(11) NOT NULL,
  `question_group_name` varchar(255) DEFAULT NULL,
  `inquiry_id` int(11) NOT NULL,
  PRIMARY KEY (`question_group_id`),
  KEY `FKe2knn46k9g2o583votiq87l5w` (`inquiry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `question_group`
--

INSERT INTO `question_group` (`question_group_id`, `number_of_question`, `question_group_name`, `inquiry_id`) VALUES
(4, 5, 'Grupa2', 3),
(8, 5, 'Grupa2', 7),
(12, 5, 'Grupa2', 11),
(16, 5, 'Grupa2', 15);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `FK8frr4bcabmmeyyu60qt7iiblo` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`);

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `FK7v6es33lcfjb7ud98vmmr6axl` FOREIGN KEY (`question_group_id`) REFERENCES `question_group` (`question_group_id`);

--
-- Constraints for table `question_group`
--
ALTER TABLE `question_group`
  ADD CONSTRAINT `FKe2knn46k9g2o583votiq87l5w` FOREIGN KEY (`inquiry_id`) REFERENCES `inquiry` (`inquiry_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
