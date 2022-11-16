CREATE TABLE `xiaomi`
(
    `id`       INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user`     VARCHAR(50) NOT NULL COMMENT '小米账号' COLLATE 'utf8mb4_general_ci',
    `password` VARCHAR(50) NOT NULL COMMENT '账号密码' COLLATE 'utf8mb4_general_ci',
    `steps`    VARCHAR(5)  NOT NULL COMMENT '步数' COLLATE 'utf8mb4_general_ci',
    PRIMARY KEY (`id`) USING BTREE
) COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
