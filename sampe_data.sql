-- ==========================================
-- 1. TẠO BẢNG CHA (SUPERTYPE) VÀ CÁC BẢNG ĐỘC LẬP
-- ==========================================

-- Tạo database mới cho đồ án
CREATE DATABASE SWP391_HorseRacing;
GO

-- Chuyển sang sử dụng database vừa tạo thay vì master
USE SWP391_HorseRacing;
GO

CREATE TABLE users (
    id INT IDENTITY(1,1) PRIMARY KEY,
    full_name NVARCHAR(255) NOT NULL,
    email NVARCHAR(255) UNIQUE NOT NULL,
    phone NVARCHAR(20),
    role NVARCHAR(50),
    status NVARCHAR(50)
);

-- ==========================================
-- 2. TẠO CÁC BẢNG CON (SUBTYPES - QUAN HỆ 1-1)
-- ==========================================

CREATE TABLE admins (
    user_id INT PRIMARY KEY,
    manage_horses BIT DEFAULT 0,
    manage_jockeys BIT DEFAULT 0,
    create_tournaments BIT DEFAULT 0,
    issue_regulations BIT DEFAULT 0,
    penalty_rules BIT DEFAULT 0,
    operate_system BIT DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE horse_owners (
    user_id INT PRIMARY KEY,
    address NVARCHAR(500),
    note NVARCHAR(MAX),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE jockeys (
    user_id INT PRIMARY KEY,
    weight DECIMAL(5,2),
    height DECIMAL(5,2),
    experience_years INT,
    training_certificate NVARCHAR(255),
    achievement NVARCHAR(MAX),
    status NVARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE referees (
    user_id INT PRIMARY KEY,
    license_number NVARCHAR(100),
    status NVARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE spectators (
    user_id INT PRIMARY KEY,
    total_prediction_points INT DEFAULT 0,
    status NVARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- ==========================================
-- 3. TẠO CÁC BẢNG QUY CHUẨN (QUAN HỆ 1-N)
-- ==========================================

CREATE TABLE horses (
    id INT IDENTITY(1,1) PRIMARY KEY,
    owner_id INT,
    name NVARCHAR(255) NOT NULL,
    breed NVARCHAR(100),
    age INT,
    weight DECIMAL(5,2),
    achievement NVARCHAR(MAX),
    vaccination_certificate NVARCHAR(255),
    FOREIGN KEY (owner_id) REFERENCES horse_owners(user_id)
);

CREATE TABLE tournaments (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    start_date DATE,
    end_date DATE,
    status NVARCHAR(50),
    created_by_admin_id INT,
    FOREIGN KEY (created_by_admin_id) REFERENCES admins(user_id)
);

CREATE TABLE tournament_rules (
    id INT IDENTITY(1,1) PRIMARY KEY,
    tournament_id INT,
    rule_title NVARCHAR(255),
    rule_content NVARCHAR(MAX),
    issued_by_admin_id INT,
    FOREIGN KEY (tournament_id) REFERENCES tournaments(id),
    FOREIGN KEY (issued_by_admin_id) REFERENCES admins(user_id)
);

CREATE TABLE penalty_rules (
    id INT IDENTITY(1,1) PRIMARY KEY,
    tournament_id INT,
    violation_type NVARCHAR(100),
    penalty_description NVARCHAR(MAX),
    point_deduction INT,
    fine_amount DECIMAL(18,2),
    ban_days INT,
    FOREIGN KEY (tournament_id) REFERENCES tournaments(id)
);

CREATE TABLE rankings (
    id INT IDENTITY(1,1) PRIMARY KEY,
    tournament_id INT,
    ranking_type NVARCHAR(50),
    entity_id INT, -- Có thể là ID của ngựa hoặc nài ngựa tùy thuộc vào ranking_type
    total_points INT,
    rank_position INT,
    FOREIGN KEY (tournament_id) REFERENCES tournaments(id)
);

CREATE TABLE races (
    id INT IDENTITY(1,1) PRIMARY KEY,
    tournament_id INT,
    name NVARCHAR(255) NOT NULL,
    race_datetime DATETIME,
    status NVARCHAR(50),
    distance DECIMAL(8,2),
    age_limit INT,
    weight_requirement DECIMAL(5,2),
    FOREIGN KEY (tournament_id) REFERENCES tournaments(id)
);

-- ==========================================
-- 4. TẠO CÁC BẢNG TRUNG GIAN (QUAN HỆ N-N) & PHỤ THUỘC
-- ==========================================

-- Bảng đăng ký tham gia vòng đua (Nối Races với Horses, Owners, Jockeys)
CREATE TABLE race_entries (
    id INT IDENTITY(1,1) PRIMARY KEY,
    race_id INT,
    horse_id INT,
    owner_id INT,
    jockey_id INT,
    lane_number INT,
    registration_status NVARCHAR(50),
    FOREIGN KEY (race_id) REFERENCES races(id),
    FOREIGN KEY (horse_id) REFERENCES horses(id),
    FOREIGN KEY (owner_id) REFERENCES horse_owners(user_id),
    FOREIGN KEY (jockey_id) REFERENCES jockeys(user_id)
);

-- Phân công trọng tài (Nối Referees với Races)
CREATE TABLE referee_assignments (
    id INT IDENTITY(1,1) PRIMARY KEY,
    referee_id INT,
    race_id INT,
    assignment_role NVARCHAR(100),
    FOREIGN KEY (referee_id) REFERENCES referees(user_id),
    FOREIGN KEY (race_id) REFERENCES races(id)
);

-- Dự đoán của khán giả (Nối Spectators với Races)
CREATE TABLE spectator_predictions (
    id INT IDENTITY(1,1) PRIMARY KEY,
    spectator_id INT,
    race_id INT,
    predicted_top_1 INT, -- Có thể tham chiếu tới race_entries.id hoặc horses.id
    predicted_top_2 INT,
    predicted_top_3 INT,
    status NVARCHAR(50),
    points_awarded INT DEFAULT 0,
    FOREIGN KEY (spectator_id) REFERENCES spectators(user_id),
    FOREIGN KEY (race_id) REFERENCES races(id)
);

-- ==========================================
-- 5. CÁC BẢNG KẾT QUẢ, VI PHẠM & LOGGING
-- ==========================================

CREATE TABLE race_results (
    id INT IDENTITY(1,1) PRIMARY KEY,
    race_id INT,
    race_entry_id INT,
    position INT,
    finish_time TIME, -- Hoặc NVARCHAR/DECIMAL tùy cách bạn lưu trữ thời gian cụ thể
    confirmed_by_referee INT,
    FOREIGN KEY (race_id) REFERENCES races(id),
    FOREIGN KEY (race_entry_id) REFERENCES race_entries(id),
    FOREIGN KEY (confirmed_by_referee) REFERENCES referees(user_id)
);

CREATE TABLE violations (
    id INT IDENTITY(1,1) PRIMARY KEY,
    race_id INT,
    race_entry_id INT,
    referee_id INT,
    penalty_rule_id INT,
    violation_name NVARCHAR(255),
    penalty_applied NVARCHAR(MAX),
    status NVARCHAR(50),
    FOREIGN KEY (race_id) REFERENCES races(id),
    FOREIGN KEY (race_entry_id) REFERENCES race_entries(id),
    FOREIGN KEY (referee_id) REFERENCES referees(user_id),
    FOREIGN KEY (penalty_rule_id) REFERENCES penalty_rules(id)
);

CREATE TABLE notifications (
    id INT IDENTITY(1,1) PRIMARY KEY,
    receiver_user_id INT,
    title NVARCHAR(255),
    content NVARCHAR(MAX),
    message_type NVARCHAR(50),
    is_read BIT DEFAULT 0,
    FOREIGN KEY (receiver_user_id) REFERENCES users(id)
);

CREATE TABLE admin_activity_logs (
    id INT IDENTITY(1,1) PRIMARY KEY,
    admin_id INT,
    action_type NVARCHAR(100),
    action_description NVARCHAR(MAX),
    FOREIGN KEY (admin_id) REFERENCES admins(user_id)
);

-- ==========================================
-- Account
-- ==========================================
CREATE TABLE accounts (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(100) UNIQUE NOT NULL,
    password NVARCHAR(100) NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
GO

INSERT INTO users (full_name, email, phone, role, status)
VALUES 
    ('Admin System', 'admin@horseracing.com', '0900000000', 'Admin', 'active'),
    ('John Owner', 'owner@horseracing.com', '0900000001', 'Horse Owner', 'active'),
    ('Jack Jockey', 'jockey@horseracing.com', '0900000002', 'Jockey', 'active'),
    ('Spectator Lee', 'spectator@horseracing.com', '0900000004', 'Spectator', 'active');
GO

INSERT INTO accounts (username, password, user_id)
VALUES 
    ('admin', 'Admin1234', 1),
    ('horseowner', 'Horseowner123', 2),
    ('jockey', 'Jockey111', 3),
    ('spectator', 'Spectator11', 4);
GO

