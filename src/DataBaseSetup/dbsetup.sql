-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 11, 2026 at 05:23 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coursework_db`
--
CREATE DATABASE IF NOT EXISTS `coursework_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `coursework_db`;

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `question_id` int(11) NOT NULL,
  `question_text` text NOT NULL,
  `option_a` varchar(255) NOT NULL,
  `option_b` varchar(255) NOT NULL,
  `option_c` varchar(255) NOT NULL,
  `option_d` varchar(255) NOT NULL,
  `correct_option` char(1) NOT NULL,
  `difficulty` enum('Beginner','Intermediate','Advanced') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`question_id`, `question_text`, `option_a`, `option_b`, `option_c`, `option_d`, `correct_option`, `difficulty`) VALUES
(1, 'What is the capital of Nepal?', 'Kathmandu', 'Pokhara', 'Lalitpur', 'Biratnagar', 'A', 'Beginner'),
(2, 'Which planet is known as the Red Planet?', 'Earth', 'Mars', 'Jupiter', 'Venus', 'B', 'Beginner'),
(3, 'How many days are there in a leap year?', '364', '365', '366', '367', 'C', 'Beginner'),
(4, 'Which animal is known as the King of the Jungle?', 'Elephant', 'Tiger', 'Lion', 'Leopard', 'C', 'Beginner'),
(5, 'What color do you get by mixing red and white?', 'Pink', 'Purple', 'Orange', 'Brown', 'A', 'Beginner'),
(6, 'Which is the largest ocean on Earth?', 'Indian', 'Atlantic', 'Pacific', 'Arctic', 'C', 'Beginner'),
(7, 'How many continents are there?', '5', '6', '7', '8', 'C', 'Beginner'),
(8, 'Which is the tallest mountain in the world?', 'K2', 'Everest', 'Kangchenjunga', 'Makalu', 'B', 'Beginner'),
(9, 'Which day comes after Friday?', 'Thursday', 'Saturday', 'Sunday', 'Monday', 'B', 'Beginner'),
(10, 'Which animal gives us milk?', 'Dog', 'Cow', 'Cat', 'Goat', 'B', 'Beginner'),
(11, 'What is the boiling point of water?', '50°C', '100°C', '150°C', '200°C', 'B', 'Beginner'),
(12, 'Which organ pumps blood in the body?', 'Lungs', 'Brain', 'Heart', 'Kidney', 'C', 'Beginner'),
(13, 'Which is the smallest planet?', 'Mars', 'Mercury', 'Venus', 'Earth', 'B', 'Beginner'),
(14, 'Which festival is known as the festival of lights?', 'Holi', 'Tihar', 'Dashain', 'Teej', 'B', 'Beginner'),
(15, 'What is H2O?', 'Salt', 'Oxygen', 'Water', 'Hydrogen', 'C', 'Beginner'),
(16, 'Which is the largest mammal?', 'Elephant', 'Blue Whale', 'Giraffe', 'Shark', 'B', 'Beginner'),
(17, 'How many letters are there in the English alphabet?', '24', '25', '26', '27', 'C', 'Beginner'),
(18, 'Which shape has three sides?', 'Square', 'Circle', 'Triangle', 'Rectangle', 'C', 'Beginner'),
(19, 'Which is the fastest land animal?', 'Horse', 'Tiger', 'Cheetah', 'Lion', 'C', 'Beginner'),
(20, 'Which gas do plants absorb?', 'Oxygen', 'Carbon Dioxide', 'Nitrogen', 'Helium', 'B', 'Beginner'),
(21, 'Which is the nearest star to Earth?', 'Sun', 'Sirius', 'Alpha Centauri', 'Polaris', 'A', 'Beginner'),
(22, 'Which sense organ helps us see?', 'Ear', 'Eye', 'Nose', 'Skin', 'B', 'Beginner'),
(23, 'Which is the largest planet?', 'Earth', 'Saturn', 'Jupiter', 'Neptune', 'C', 'Beginner'),
(24, 'Which month has 28 or 29 days?', 'February', 'January', 'March', 'April', 'A', 'Beginner'),
(25, 'Which instrument is used to measure temperature?', 'Barometer', 'Thermometer', 'Speedometer', 'Altimeter', 'B', 'Beginner'),
(26, 'Which animal is known as man’s best friend?', 'Cat', 'Dog', 'Horse', 'Rabbit', 'B', 'Beginner'),
(27, 'Which fruit is yellow and curved?', 'Apple', 'Banana', 'Mango', 'Grapes', 'B', 'Beginner'),
(28, 'Which is the largest land animal?', 'Elephant', 'Rhino', 'Hippo', 'Giraffe', 'A', 'Beginner'),
(29, 'How many legs does a spider have?', '6', '8', '10', '12', 'B', 'Beginner'),
(30, 'Which direction does the sun rise from?', 'North', 'South', 'East', 'West', 'C', 'Beginner'),
(31, 'Who discovered gravity?', 'Newton', 'Einstein', 'Galileo', 'Darwin', 'A', 'Intermediate'),
(32, 'Which is the longest river in the world?', 'Amazon', 'Nile', 'Yangtze', 'Mississippi', 'B', 'Intermediate'),
(33, 'Which gas is most abundant in Earth’s atmosphere?', 'Oxygen', 'Nitrogen', 'Carbon Dioxide', 'Hydrogen', 'B', 'Intermediate'),
(34, 'Who wrote Hamlet?', 'Charles Dickens', 'William Shakespeare', 'Mark Twain', 'Jane Austen', 'B', 'Intermediate'),
(35, 'What is the chemical symbol for gold?', 'Go', 'Au', 'Ag', 'Gd', 'B', 'Intermediate'),
(36, 'Which planet has rings?', 'Mars', 'Earth', 'Saturn', 'Venus', 'C', 'Intermediate'),
(37, 'What is the hardest natural substance?', 'Gold', 'Iron', 'Diamond', 'Silver', 'C', 'Intermediate'),
(38, 'Which country invented paper?', 'India', 'China', 'Egypt', 'Greece', 'B', 'Intermediate'),
(39, 'Which is the largest desert?', 'Sahara', 'Gobi', 'Kalahari', 'Arctic', 'A', 'Intermediate'),
(40, 'What is the capital of Japan?', 'Beijing', 'Seoul', 'Tokyo', 'Bangkok', 'C', 'Intermediate'),
(41, 'Which blood group is universal donor?', 'A', 'B', 'AB', 'O', 'D', 'Intermediate'),
(42, 'Which metal is liquid at room temperature?', 'Mercury', 'Gold', 'Iron', 'Silver', 'A', 'Intermediate'),
(43, 'Who painted Mona Lisa?', 'Picasso', 'Da Vinci', 'Van Gogh', 'Rembrandt', 'B', 'Intermediate'),
(44, 'Which is the smallest bone in the human body?', 'Stapes', 'Femur', 'Ulna', 'Radius', 'A', 'Intermediate'),
(45, 'Which is the largest country by area?', 'USA', 'China', 'Canada', 'Russia', 'D', 'Intermediate'),
(46, 'Which organ purifies blood?', 'Heart', 'Liver', 'Kidney', 'Lungs', 'C', 'Intermediate'),
(47, 'Which element has atomic number 1?', 'Helium', 'Hydrogen', 'Oxygen', 'Carbon', 'B', 'Intermediate'),
(48, 'Which planet is closest to the Sun?', 'Venus', 'Earth', 'Mercury', 'Mars', 'C', 'Intermediate'),
(49, 'What is the speed of light?', '300,000 km/s', '150,000 km/s', '100,000 km/s', '50,000 km/s', 'A', 'Intermediate'),
(50, 'Which continent has the most countries?', 'Asia', 'Africa', 'Europe', 'South America', 'B', 'Intermediate'),
(51, 'Which vitamin is produced in sunlight?', 'A', 'B', 'C', 'D', 'D', 'Intermediate'),
(52, 'Which is the smallest prime number?', '0', '1', '2', '3', 'C', 'Intermediate'),
(53, 'Who invented the telephone?', 'Edison', 'Bell', 'Tesla', 'Newton', 'B', 'Intermediate'),
(54, 'Which is the largest organ in the human body?', 'Liver', 'Skin', 'Heart', 'Lungs', 'B', 'Intermediate'),
(55, 'Which gas is used in balloons?', 'Hydrogen', 'Helium', 'Oxygen', 'Nitrogen', 'B', 'Intermediate'),
(56, 'Which is the longest bone?', 'Femur', 'Tibia', 'Ulna', 'Humerus', 'A', 'Intermediate'),
(57, 'Which country hosted the 2016 Olympics?', 'China', 'Brazil', 'UK', 'Japan', 'B', 'Intermediate'),
(58, 'What is the study of earthquakes called?', 'Geology', 'Seismology', 'Meteorology', 'Astronomy', 'B', 'Intermediate'),
(59, 'Which ocean is the smallest?', 'Indian', 'Atlantic', 'Arctic', 'Pacific', 'C', 'Intermediate'),
(60, 'Which instrument measures air pressure?', 'Thermometer', 'Barometer', 'Hygrometer', 'Anemometer', 'B', 'Intermediate'),
(61, 'Who developed the theory of relativity?', 'Newton', 'Einstein', 'Tesla', 'Bohr', 'B', 'Advanced'),
(62, 'Which country has the most natural lakes?', 'USA', 'Russia', 'Canada', 'Brazil', 'C', 'Advanced'),
(63, 'What is the SI unit of electric current?', 'Volt', 'Ohm', 'Ampere', 'Watt', 'C', 'Advanced'),
(64, 'Which element has the highest melting point?', 'Carbon', 'Iron', 'Tungsten', 'Platinum', 'C', 'Advanced'),
(65, 'What is the powerhouse of the cell?', 'Nucleus', 'Ribosome', 'Mitochondria', 'Golgi body', 'C', 'Advanced'),
(66, 'Who proposed the three laws of motion?', 'Galileo', 'Newton', 'Kepler', 'Einstein', 'B', 'Advanced'),
(67, 'Which vitamin is also called ascorbic acid?', 'A', 'B', 'C', 'D', 'C', 'Advanced'),
(68, 'Which blood cells help in clotting?', 'RBC', 'WBC', 'Platelets', 'Plasma', 'C', 'Advanced'),
(69, 'Which planet rotates on its side?', 'Uranus', 'Neptune', 'Saturn', 'Mars', 'A', 'Advanced'),
(70, 'Which acid is present in vinegar?', 'Citric', 'Acetic', 'Sulfuric', 'Lactic', 'B', 'Advanced'),
(71, 'Which law states that pressure of gas is inversely proportional to volume?', 'Boyle’s Law', 'Charles’s Law', 'Avogadro’s Law', 'Newton’s Law', 'A', 'Advanced'),
(72, 'What is the pH of pure water?', '5', '6', '7', '8', 'C', 'Advanced'),
(73, 'Which metal has the highest electrical conductivity?', 'Copper', 'Silver', 'Gold', 'Aluminum', 'B', 'Advanced'),
(74, 'Which country launched the first artificial satellite?', 'USA', 'Germany', 'Russia', 'China', 'C', 'Advanced'),
(75, 'What is the currency of Switzerland?', 'Euro', 'Franc', 'Dollar', 'Krone', 'B', 'Advanced'),
(76, 'Which hormone regulates sleep?', 'Melatonin', 'Adrenaline', 'Insulin', 'Thyroxine', 'A', 'Advanced'),
(77, 'Which particle has no electric charge?', 'Electron', 'Proton', 'Neutron', 'Ion', 'C', 'Advanced'),
(78, 'Which country has the longest coastline?', 'USA', 'Canada', 'Russia', 'Australia', 'B', 'Advanced'),
(79, 'Which organ produces insulin?', 'Liver', 'Pancreas', 'Kidney', 'Heart', 'B', 'Advanced'),
(80, 'What is the speed of sound in air?', '330 m/s', '340 m/s', '350 m/s', '360 m/s', 'B', 'Advanced'),
(81, 'Which part of brain controls balance?', 'Cerebrum', 'Cerebellum', 'Medulla', 'Pons', 'B', 'Advanced'),
(82, 'Which element is known as quicksilver?', 'Iron', 'Silver', 'Mercury', 'Lead', 'C', 'Advanced'),
(83, 'Which country gifted the Statue of Liberty to USA?', 'UK', 'France', 'Germany', 'Italy', 'B', 'Advanced'),
(84, 'Which gas causes acid rain?', 'CO2', 'SO2', 'O2', 'H2', 'B', 'Advanced'),
(85, 'What is the SI unit of force?', 'Newton', 'Joule', 'Watt', 'Pascal', 'A', 'Advanced'),
(86, 'Which is the main ore of aluminium?', 'Bauxite', 'Hematite', 'Galena', 'Magnetite', 'A', 'Advanced'),
(87, 'Which planet has the strongest gravity?', 'Earth', 'Saturn', 'Jupiter', 'Neptune', 'C', 'Advanced'),
(88, 'Which scientist discovered penicillin?', 'Pasteur', 'Fleming', 'Darwin', 'Curie', 'B', 'Advanced'),
(89, 'Which country has the highest GDP?', 'China', 'Japan', 'USA', 'Germany', 'C', 'Advanced'),
(90, 'Which blood group is universal recipient?', 'A', 'B', 'AB', 'O', 'C', 'Advanced');

-- --------------------------------------------------------

--
-- Table structure for table `scores`
--

CREATE TABLE `scores` (
  `score_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `difficulty` enum('Beginner','Intermediate','Advanced') NOT NULL,
  `score` int(11) NOT NULL,
  `total_questions` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `scores`
--

INSERT INTO `scores` (`score_id`, `user_id`, `difficulty`, `score`, `total_questions`) VALUES
(1, 2, 'Beginner', 19, 20),
(2, 3, 'Beginner', 9, 20),
(3, 2, 'Intermediate', 14, 20),
(4, 2, 'Beginner', 4, 20),
(5, 2, 'Advanced', 11, 20),
(6, 2, 'Beginner', 7, 20),
(7, 4, 'Beginner', 19, 20),
(8, 3, 'Advanced', 7, 20);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `is_admin` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `name`, `password`, `is_admin`) VALUES
(1, 'admin', 'admin123', 1),
(2, 'Praju', '1234567890', 0),
(3, 'sunil', 'sunil@123', 0),
(4, 'Praju Maharjan', 'qwerty', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`question_id`);

--
-- Indexes for table `scores`
--
ALTER TABLE `scores`
  ADD PRIMARY KEY (`score_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;

--
-- AUTO_INCREMENT for table `scores`
--
ALTER TABLE `scores`
  MODIFY `score_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `scores`
--
ALTER TABLE `scores`
  ADD CONSTRAINT `scores_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
