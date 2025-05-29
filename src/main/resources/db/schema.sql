-- 账户表
CREATE TABLE IF NOT EXISTS accounts (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        email VARCHAR(255) NOT NULL UNIQUE,
                                        contract_id VARCHAR(12) NOT NULL,
                                        country_code CHAR(2) DEFAULT 'DE' NOT NULL,
                                        provider_id VARCHAR(3) DEFAULT '001' NOT NULL,
                                        instance CHAR(1) DEFAULT 'A' NOT NULL,
                                        next_service_id INT DEFAULT 1 NOT NULL,
                                        status VARCHAR(20) NOT NULL,
                                        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                        last_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
COMMENT ON TABLE accounts IS '存储账户信息';
COMMENT ON COLUMN accounts.contract_id IS '用于生成EMAID的合同ID';
COMMENT ON COLUMN accounts.next_service_id IS '下一个可用的服务ID（用于EMAID生成）';

-- 卡片表
CREATE TABLE IF NOT EXISTS cards (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     uid VARCHAR(64) NOT NULL,
                                     visible_number VARCHAR(50) NOT NULL,
                                     emaid VARCHAR(20) UNIQUE,
                                     status VARCHAR(20) NOT NULL,
                                     account_id BIGINT,
                                     assigned_at TIMESTAMP,
                                     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                     last_updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                     FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE SET NULL
);
COMMENT ON TABLE cards IS '存储卡片信息';
COMMENT ON COLUMN cards.emaid IS 'E-Mobility认证标识符（格式：国家代码+提供商ID+实例+合同ID+服务ID）';

-- 创建索引优化查询性能
CREATE INDEX idx_accounts_email ON accounts(email);
CREATE INDEX idx_accounts_status ON accounts(status);
CREATE INDEX idx_accounts_last_updated ON accounts(last_updated);

CREATE INDEX idx_cards_uid ON cards(uid);
CREATE INDEX idx_cards_visible_number ON cards(visible_number);
CREATE INDEX idx_cards_status ON cards(status);
CREATE INDEX idx_cards_last_updated ON cards(last_updated);
CREATE INDEX idx_cards_assigned_at ON cards(assigned_at);

-- 插入初始测试数据
INSERT INTO accounts (email, contract_id, status)
VALUES
    ('user1@example.com', 'DE001A0001', 'ACTIVATED'),
    ('user2@example.com', 'DE001A0002', 'CREATED'),
    ('user3@example.com', 'FR002B0003', 'DEACTIVATED');
