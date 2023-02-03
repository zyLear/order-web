CREATE
DATABASE IF NOT EXISTS `app_order`
USE `app_order`;


CREATE TABLE `order_info`
(
    `id`               BIGINT(19,0) NOT NULL AUTO_INCREMENT,
    `phone_number`     VARCHAR(32)  NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `order_status`     TINYINT(3,0) NOT NULL,
    `remark`           VARCHAR(255) NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
    `finish_time`      DATETIME NULL DEFAULT NULL,
    `create_time`      DATETIME     NOT NULL,
    `last_update_time` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;