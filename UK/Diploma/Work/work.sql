-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Май 31 2021 г., 21:57
-- Версия сервера: 10.4.10-MariaDB
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `work`
--
CREATE DATABASE IF NOT EXISTS `work` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `work`;

-- --------------------------------------------------------

--
-- Структура таблицы `allwork`
--

CREATE TABLE `allwork` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `countPerson` int(11) NOT NULL,
  `personsName` text NOT NULL,
  `weightPerOne` double NOT NULL,
  `weightProduced` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `allwork`
--

INSERT INTO `allwork` (`id`, `date`, `countPerson`, `personsName`, `weightPerOne`, `weightProduced`) VALUES
(18, '2021-04-22', 5, 'GB1 Маряна старша зміна\nGB1 Назирова Iнесса\nGB1 Дубанич  Жанна \nGB1 Марина Паривания\nGB1 Иванка Улиганець\n', 44.4, 222),
(19, '2021-04-11', 5, 'GB1 Дубанич  Жанна \nGB1 Марина Паривания\nGB1 Назирова Iнесса\nGB1 Маряна старша зміна\nGB1 Иванка Улиганець\n', 66.6, 333),
(20, '2021-05-22', 6, 'GB1 Дубанич  Жанна \nGB1 Назирова Iнесса\nGB1 Маряна старша зміна\nGB1 Марина Паривания\nGB1 Иванка Улиганець\nGB1 Евгения Макай\n', 33.333, 200),
(21, '2021-05-11', 6, 'GB1 Маряна старша зміна\nGB1 Назирова Iнесса\nGB1 Евгения Макай\nGB1 Ковальчук  Олена\nGB2 Кость Оксана \nGB1 Яна Карпаченка\n', 35, 210);

-- --------------------------------------------------------

--
-- Структура таблицы `cashier`
--

CREATE TABLE `cashier` (
  `id` int(11) NOT NULL,
  `PIB` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `SoldOut` double NOT NULL,
  `Salary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `cashier`
--

INSERT INTO `cashier` (`id`, `PIB`, `date`, `SoldOut`, `Salary`) VALUES
(7, 'GB2 Костик Ніколетта', '2021-01-09', 13348.34, 400.2251),
(8, 'GB2 Костик Ніколетта', '2021-01-10', 13000, 400),
(10, 'GB2 Костик Ніколетта', '2021-01-13', 19498, 492.46999999999997),
(11, 'GB2 Костик Ніколетта', '2021-01-14', 20793, 511.895),
(12, 'GB2 Костик Ніколетта', '2021-01-15', 21885, 528.275),
(13, 'GB2 Костик Ніколетта', '2021-01-19', 22515, 537.725),
(14, 'GB2 Костик Ніколетта', '2021-01-20', 23900, 558.5),
(15, 'GB2 Костик Ніколетта', '2021-01-21', 22627, 539.405),
(16, 'GB2 Костик Ніколетта', '2021-01-22', 29089, 636.335),
(17, 'GB2 Костик Ніколетта', '2021-01-03', 14686, 420.29),
(18, 'GB2 Костик Ніколетта', '2021-01-06', 13000, 400),
(19, 'GB2 Легеза Маряна', '2021-01-12', 22605, 539.075),
(20, 'GB2 Легеза Маряна', '2021-01-16', 25160, 577.4),
(21, 'GB2 Легеза Василь', '2021-01-11', 18248, 473.71999999999997),
(22, 'GB2 Легеза Василь', '2021-01-23', 19375, 490.625),
(23, 'GB2 Легеза Василь', '2021-05-13', 15000, 425),
(24, 'Курта Владислав Владиславович', '2021-05-23', 15000, 425),
(25, 'Курта Владислав Владиславович', '2021-05-23', 15000, 440);

-- --------------------------------------------------------

--
-- Структура таблицы `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `nameCategory` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `category`
--

INSERT INTO `category` (`id`, `nameCategory`) VALUES
(2, 'Касир'),
(1, 'Робочий'),
(3, 'Стажер');

-- --------------------------------------------------------

--
-- Структура таблицы `employees`
--

CREATE TABLE `employees` (
  `id` int(11) NOT NULL,
  `PIB` varchar(250) NOT NULL,
  `idCategory` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `employees`
--

INSERT INTO `employees` (`id`, `PIB`, `idCategory`) VALUES
(2, 'GB1 Маряна старша зміна', 1),
(4, 'GB1 Назирова Iнесса', 1),
(5, 'GB1 Дубанич Жанна ', 1),
(9, 'GB1 Марина Паривания', 1),
(11, 'GB1 Иванка Улиганець', 1),
(13, 'GB1 Евгения Макай', 1),
(15, 'GB1 Ковальчук  Олена', 1),
(19, 'GB1 Марьяна Агоштон', 1),
(20, 'GB2 Кость Оксана ', 1),
(21, 'GB1 Яна Карпаченка', 1),
(22, 'GB1 Наталія ', 1),
(23, 'GB2 Баран Василина', 1),
(24, 'GB2 Бузелюк Галина ', 1),
(25, 'GB2 Ткачова Лина ', 1),
(26, 'GB1 Наталья Крайниковец', 1),
(30, 'GB1 Саша (тісто)', 1),
(35, 'GB1 Таміла', 1),
(36, 'GB1 Алла Вейкай', 1),
(37, 'GB1 Стефания Ляхович', 1),
(40, 'GB2 Гнатишина Юля', 1),
(41, 'GB2 Костик Ніколетта', 2),
(42, 'GB2 Легеза Маряна', 2),
(43, 'GB2 Ніна (шокер)', 1),
(44, 'GB2 Тарцванія Марина', 1),
(45, 'GB2 Конкус Оксана ', 1),
(47, 'GB2 Легеза Василь', 2),
(48, 'Курта Владислав Владиславович', 3),
(49, 'Бруженяк Василь Васильович', 3);

-- --------------------------------------------------------

--
-- Структура таблицы `Interns`
--

CREATE TABLE `Interns` (
  `id` int(11) NOT NULL,
  `PIB` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `type` varchar(255) NOT NULL,
  `Salary` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `Interns`
--

INSERT INTO `Interns` (`id`, `PIB`, `date`, `type`, `Salary`) VALUES
(2, 'Курта Владислав Владиславович', '2021-05-13', 'Стажор_1', '200.0'),
(3, 'Бруженяк Василь Васильович', '2021-05-13', 'Стажер_2', '400.0');

-- --------------------------------------------------------

--
-- Структура таблицы `Payments`
--

CREATE TABLE `Payments` (
  `id` int(11) NOT NULL,
  `PIB` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `categoryPayment` varchar(100) NOT NULL,
  `Payment` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `Payments`
--

INSERT INTO `Payments` (`id`, `PIB`, `date`, `categoryPayment`, `Payment`) VALUES
(8, 'GB1 Маряна старша зміна', '2021-05-12', 'Премія', '1500.0');

-- --------------------------------------------------------

--
-- Структура таблицы `setcalc`
--

CREATE TABLE `setcalc` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `type` varchar(255) NOT NULL,
  `value` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `setcalc`
--

INSERT INTO `setcalc` (`id`, `name`, `type`, `value`) VALUES
(1, 'За кілограм', 'Робочий', 20),
(2, 'ВиручкаВідсоток', 'Касир', 13333),
(3, 'Відсоток', 'Касир', 1.5),
(4, 'ЗарплатаВідсоток', 'Касир', 200),
(5, 'ЗвичайнаЗарплата', 'Касир', 400),
(6, 'Стажер_1', 'Стажер', 200),
(7, 'Стажер_2', 'Стажер', 400);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `allwork`
--
ALTER TABLE `allwork`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `cashier`
--
ALTER TABLE `cashier`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nameCategory` (`nameCategory`);

--
-- Индексы таблицы `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCategory` (`idCategory`);

--
-- Индексы таблицы `Interns`
--
ALTER TABLE `Interns`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `Payments`
--
ALTER TABLE `Payments`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `setcalc`
--
ALTER TABLE `setcalc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `type` (`type`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `allwork`
--
ALTER TABLE `allwork`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT для таблицы `cashier`
--
ALTER TABLE `cashier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT для таблицы `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT для таблицы `Interns`
--
ALTER TABLE `Interns`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `Payments`
--
ALTER TABLE `Payments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT для таблицы `setcalc`
--
ALTER TABLE `setcalc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`idCategory`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `setcalc`
--
ALTER TABLE `setcalc`
  ADD CONSTRAINT `setcalc_ibfk_1` FOREIGN KEY (`type`) REFERENCES `category` (`nameCategory`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
