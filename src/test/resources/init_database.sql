CREATE TABLE IF NOT EXISTS `students` (
                                          `id` int NOT NULL AUTO_INCREMENT,
                                          `firstname` varchar(50) NOT NULL,
    `lastname` varchar(50) NOT NULL,
    `day_of_birth` date NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

