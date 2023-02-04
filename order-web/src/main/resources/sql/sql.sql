CREATE
DATABASE IF NOT EXISTS `app_order`
USE `app_order`;


CREATE TABLE `order_info`
(
    `id`               BIGINT(20) NOT NULL AUTO_INCREMENT,
    `phone_number`     VARCHAR(32)    NOT NULL COLLATE 'utf8mb4_general_ci',
    `order_status`     TINYINT(4) NOT NULL,
    `remark`           VARCHAR(255)   NOT NULL COLLATE 'utf8mb4_general_ci',
    `price`            DECIMAL(10, 2) NOT NULL DEFAULT '0.00',
    `finish_time`      DATETIME NULL DEFAULT NULL,
    `create_time`      DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_update_time` TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4_general_ci;