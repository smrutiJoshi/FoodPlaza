-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 07, 2019 at 01:21 PM
-- Server version: 5.7.12-0ubuntu1
-- PHP Version: 7.0.4-7ubuntu2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `FoodPlaza_80075`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin_80075`
--

CREATE TABLE `Admin_80075` (
  `adminid` int(11) NOT NULL,
  `adminame` varchar(20) NOT NULL,
  `adminpassword` varchar(20) NOT NULL,
  `adminemail` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Admin_80075`
--

INSERT INTO `Admin_80075` (`adminid`, `adminame`, `adminpassword`, `adminemail`) VALUES
(1, 'admin', 'Admin123', 'admin@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `Cart_80075`
--

CREATE TABLE `Cart_80075` (
  `cart_id` int(11) NOT NULL,
  `food_id` int(11) NOT NULL,
  `cust_email` varchar(30) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Cart_80075`
--

INSERT INTO `Cart_80075` (`cart_id`, `food_id`, `cust_email`, `quantity`) VALUES
(5, 1, 's@gmail.com', 3),
(6, 2, 's@gmail.com', 4),
(7, 3, 's@gmail.com', 2),
(8, 2, 'j@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Customer_80075`
--

CREATE TABLE `Customer_80075` (
  `cust_id` int(20) NOT NULL,
  `cust_name` varchar(30) NOT NULL,
  `cust_email` varchar(30) NOT NULL,
  `cust_add` varchar(30) NOT NULL,
  `cust_contact` varchar(30) NOT NULL,
  `cust_password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Customer_80075`
--

INSERT INTO `Customer_80075` (`cust_id`, `cust_name`, `cust_email`, `cust_add`, `cust_contact`, `cust_password`) VALUES
(1, 'smru', 's@gmail.com', 'sss', '1234', '11111'),
(2, 'Jayu', 'j@gmail.com', 'Kothrud', '14680', '888888'),
(3, 'Shruti', 'sh@gmail.com', 'Goa', '678', '666'),
(4, 'Vai', 'vai@gmail.com', 'Kothrud', '4444', '44'),
(7, 'Prasanna', 'prank@gmail.com', 'Goa', '92222222222', 'prank@K123'),
(9, 'shruti Joshi', 'sh234@gmail.com', 'Kothrud', '83456667777', 'Sh12345678'),
(10, 'reeya', 'r@gmail.com', 'Mumbai', '999999993', 'R1234r5678'),
(11, 'gauri ', 'g23@gmail.com', 'Kothrud', '96677777777', 'g@12345678G'),
(12, 'smmm', 'a1234@gmail.com', 'Boston', '8567777777', 'Aa12345679'),
(13, 'shayru', 'afggj@gmail.com', 'asfjgklgh', '87777777', 'Aa12345678'),
(15, 'abc', 'a@gmail.com', 'Kanpur', '99333434', 'aA12345678'),
(16, 'snehal', 'snehal@gmail.com', 'Warje', '834444444', 'Sn12345678'),
(17, 'salil', 'sal@gmail.com', 'Manglore', '999994444', 'sal!S45678'),
(18, 'ghjkl', 'sris@gmail.com', 'Asdfghj', '7543', 'Sris221@3456R'),
(20, 'seema', 'seema@gmail.com', 'Goa', '92222222222', 'Sn12345678'),
(21, 'gayatri', 'gayu@gmail.com', 'Kolhapur', '89999999', 'Gg12345678'),
(22, 'aradhya', 'a@gmail.26.com', 'Banglore', '9866666664', 'Aa12345678'),
(23, 'gauree', 'gau@gmail.com', 'Goa', '98666665432', 'Gau12345678'),
(25, 'sayuli', 'sayu@gmail.com', 'panaji', '86777777732', 'Sayu12345678'),
(26, 'aaa', 'aaa@gmail.com', 'fsadf', '4235', 'Aaaa12345'),
(27, 'Mukul Samant', 'm96@gmail.com', 'Mumbai', '8764322111', 'Mukul961234'),
(28, 'asdfdff', 'admin@gmail.com', '', '', 'Admin123');

-- --------------------------------------------------------

--
-- Table structure for table `Feedback_80075`
--

CREATE TABLE `Feedback_80075` (
  `feedback_id` int(20) NOT NULL,
  `cust_email` varchar(30) NOT NULL,
  `message` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Feedback_80075`
--

INSERT INTO `Feedback_80075` (`feedback_id`, `cust_email`, `message`) VALUES
(2, 'g23@gmail.com', 'Nice Service!!'),
(3, 'm96@gmail.com', 'Good Service..enjoyed a lot!!');

-- --------------------------------------------------------

--
-- Table structure for table `Food_80075`
--

CREATE TABLE `Food_80075` (
  `food_id` int(11) NOT NULL,
  `food_name` varchar(30) NOT NULL,
  `food_category` varchar(30) NOT NULL,
  `food_price` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Food_80075`
--

INSERT INTO `Food_80075` (`food_id`, `food_name`, `food_category`, `food_price`) VALUES
(1, 'samosa', 'veg', 10),
(2, 'Vada', 'veg', 20),
(4, 'Pizza', 'nonveg', 250),
(6, 'Chicken Biryani', 'nonveg', 200),
(7, 'Pulav', 'veg', 200),
(8, 'Appe', 'veg', 120),
(9, 'Appe&Chutney', 'veg', 150),
(10, 'Biryani', 'veg', 150),
(11, 'addgg', 'veg', 1234),
(12, 'Abc', 'veg', 123455);

-- --------------------------------------------------------

--
-- Table structure for table `Orderr_80075`
--

CREATE TABLE `Orderr_80075` (
  `Order_id` int(11) NOT NULL,
  `cust_email` varchar(30) NOT NULL,
  `total_bill` double NOT NULL,
  `Order_date` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Orderr_80075`
--

INSERT INTO `Orderr_80075` (`Order_id`, `cust_email`, `total_bill`, `Order_date`) VALUES
(1, 's@gmail.com', 760, 'Tue Dec 11 11:33:25 IST 2018'),
(2, 'j@gmail.com', 70, 'Tue Dec 11 11:47:34 IST 2018'),
(3, 'g23@gmail.com', 680, 'Tue Feb 05 12:52:05 IST 2019'),
(4, 'g23@gmail.com', 1300, 'Tue Feb 05 12:55:13 IST 2019'),
(5, 'g23@gmail.com', 430, 'Tue Feb 05 13:27:23 IST 2019'),
(6, 'g23@gmail.com', 320, 'Tue Feb 05 13:28:42 IST 2019'),
(7, 'g23@gmail.com', 460, 'Tue Feb 05 13:31:46 IST 2019'),
(8, 'm96@gmail.com', 500, 'Wed Feb 06 11:05:01 IST 2019');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Admin_80075`
--
ALTER TABLE `Admin_80075`
  ADD PRIMARY KEY (`adminid`),
  ADD UNIQUE KEY `adminemail` (`adminemail`);

--
-- Indexes for table `Cart_80075`
--
ALTER TABLE `Cart_80075`
  ADD PRIMARY KEY (`cart_id`);

--
-- Indexes for table `Customer_80075`
--
ALTER TABLE `Customer_80075`
  ADD PRIMARY KEY (`cust_id`),
  ADD UNIQUE KEY `cust_email` (`cust_email`);

--
-- Indexes for table `Feedback_80075`
--
ALTER TABLE `Feedback_80075`
  ADD PRIMARY KEY (`feedback_id`);

--
-- Indexes for table `Food_80075`
--
ALTER TABLE `Food_80075`
  ADD PRIMARY KEY (`food_id`);

--
-- Indexes for table `Orderr_80075`
--
ALTER TABLE `Orderr_80075`
  ADD PRIMARY KEY (`Order_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Admin_80075`
--
ALTER TABLE `Admin_80075`
  MODIFY `adminid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Cart_80075`
--
ALTER TABLE `Cart_80075`
  MODIFY `cart_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `Customer_80075`
--
ALTER TABLE `Customer_80075`
  MODIFY `cust_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `Feedback_80075`
--
ALTER TABLE `Feedback_80075`
  MODIFY `feedback_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `Food_80075`
--
ALTER TABLE `Food_80075`
  MODIFY `food_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `Orderr_80075`
--
ALTER TABLE `Orderr_80075`
  MODIFY `Order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
