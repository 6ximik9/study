-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Сен 16 2021 г., 00:38
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
-- База данных: `DoorsGallery`
--
CREATE DATABASE IF NOT EXISTS `DoorsGallery` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `DoorsGallery`;

-- --------------------------------------------------------

--
-- Структура таблицы `Coating`
--

CREATE TABLE `Coating` (
  `id` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `Coating`
--

INSERT INTO `Coating` (`id`, `name`) VALUES
(3, 'Плівка');

-- --------------------------------------------------------

--
-- Структура таблицы `Door`
--

CREATE TABLE `Door` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `appointment` varchar(100) NOT NULL,
  `type` varchar(30) NOT NULL,
  `style` varchar(30) NOT NULL,
  `coating` varchar(30) NOT NULL,
  `size` varchar(30) NOT NULL,
  `material` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `Material`
--

CREATE TABLE `Material` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Material`
--

INSERT INTO `Material` (`id`, `name`) VALUES
(5, '3'),
(3, 'Дерево');

-- --------------------------------------------------------

--
-- Структура таблицы `Style`
--

CREATE TABLE `Style` (
  `id` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `Style`
--

INSERT INTO `Style` (`id`, `name`) VALUES
(1, 'Класика');

-- --------------------------------------------------------

--
-- Структура таблицы `Type`
--

CREATE TABLE `Type` (
  `id` int(11) NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Дамп данных таблицы `Type`
--

INSERT INTO `Type` (`id`, `name`) VALUES
(1, 'Звичайний');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `Coating`
--
ALTER TABLE `Coating`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Индексы таблицы `Door`
--
ALTER TABLE `Door`
  ADD PRIMARY KEY (`id`),
  ADD KEY `material` (`material`),
  ADD KEY `type` (`type`),
  ADD KEY `coating` (`coating`),
  ADD KEY `style` (`style`);

--
-- Индексы таблицы `Material`
--
ALTER TABLE `Material`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Индексы таблицы `Style`
--
ALTER TABLE `Style`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Индексы таблицы `Type`
--
ALTER TABLE `Type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `Coating`
--
ALTER TABLE `Coating`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `Door`
--
ALTER TABLE `Door`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT для таблицы `Material`
--
ALTER TABLE `Material`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT для таблицы `Style`
--
ALTER TABLE `Style`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `Type`
--
ALTER TABLE `Type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `Door`
--
ALTER TABLE `Door`
  ADD CONSTRAINT `door_ibfk_1` FOREIGN KEY (`material`) REFERENCES `Material` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `door_ibfk_2` FOREIGN KEY (`coating`) REFERENCES `Coating` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `door_ibfk_3` FOREIGN KEY (`style`) REFERENCES `Style` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `door_ibfk_4` FOREIGN KEY (`type`) REFERENCES `Type` (`name`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
