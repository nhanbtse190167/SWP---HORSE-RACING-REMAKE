USE master;
GO

-- 1. DỌN DẸP DATABASE CŨ (Nếu có) ĐỂ TRÁNH LỖI "ALREADY EXISTS"
IF EXISTS (SELECT name FROM sys.databases WHERE name = N'SWP391_HorseRacing')
BEGIN
    -- Ngắt toàn bộ kết nối đang kẹt trước khi xóa
    ALTER DATABASE SWP391_HorseRacing SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE SWP391_HorseRacing;
END
GO

-- 2. TẠO DATABASE MỚI
CREATE DATABASE SWP391_HorseRacing;
GO

USE SWP391_HorseRacing;
GO

-- ==========================================
-- PHẦN 1: TẠO CẤU TRÚC BẢNG (TABLES)
-- ==========================================

-- Bảng thông tin người dùng chung (Super Type)
CREATE TABLE users (
    id INT IDENTITY(1,1) PRIMARY KEY,
    full_name NVARCHAR(255) NOT NULL,
    email NVARCHAR(255) UNIQUE NOT NULL,
    phone NVARCHAR(20),
    created_at DATETIME DEFAULT GETDATE()
);

-- Bảng tài khoản đăng nhập (Phân quyền)
CREATE TABLE accounts (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(100) UNIQUE NOT NULL,
    password NVARCHAR(255) NOT NULL,
    role NVARCHAR(50) NOT NULL CHECK (role IN ('ADMIN', 'JOCKEY', 'HORSE_OWNER', 'SPECTATOR')),
    status NVARCHAR(20) DEFAULT 'ACTIVE',
    user_id INT NOT NULL FOREIGN KEY REFERENCES users(id) ON DELETE CASCADE
);

-- Các bảng phân loại vai trò chi tiết (Sub Types)
CREATE TABLE admins (
    id INT PRIMARY KEY FOREIGN KEY REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE jockeys (
    id INT PRIMARY KEY FOREIGN KEY REFERENCES users(id) ON DELETE CASCADE,
    weight DECIMAL(5,2),
    experience_years INT
);

CREATE TABLE horse_owners (
    id INT PRIMARY KEY FOREIGN KEY REFERENCES users(id) ON DELETE CASCADE,
    company_name NVARCHAR(255)
);

CREATE TABLE spectators (
    id INT PRIMARY KEY FOREIGN KEY REFERENCES users(id) ON DELETE CASCADE,
    loyalty_points INT DEFAULT 0
);

-- Bảng Ngựa
CREATE TABLE horses (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    breed NVARCHAR(100),
    age INT,
    owner_id INT FOREIGN KEY REFERENCES horse_owners(id),
    status NVARCHAR(50) DEFAULT 'ACTIVE'
);

-- Bảng Giải đấu & Cuộc đua
CREATE TABLE tournaments (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    start_date DATE,
    end_date DATE,
    status NVARCHAR(50) DEFAULT 'UPCOMING'
);

CREATE TABLE races (
    id INT IDENTITY(1,1) PRIMARY KEY,
    tournament_id INT FOREIGN KEY REFERENCES tournaments(id),
    name NVARCHAR(255),
    race_date DATETIME,
    distance DECIMAL(6,2),
    status NVARCHAR(50) DEFAULT 'SCHEDULED'
);

-- ==========================================
-- PHẦN 2: THÊM DỮ LIỆU MẪU (DUMMY DATA)
-- ==========================================

-- 1. Thêm Thông tin người dùng (Users)
INSERT INTO users (full_name, email, phone) VALUES
(N'Quản trị viên Hệ thống', 'admin@horseracing.com', '0901234567'),
(N'Kỵ sĩ John Doe', 'jockey1@horseracing.com', '0912345678'),
(N'Chủ ngựa Trần Văn A', 'owner1@horseracing.com', '0923456789'),
(N'Khán giả Nguyễn Thị B', 'spectator1@horseracing.com', '0934567890');

-- 2. Thêm Tài khoản (Accounts) - Mật khẩu mặc định là '123456' cho dễ test
INSERT INTO accounts (username, password, role, user_id) VALUES
('admin', '123456', 'ADMIN', 1),
('jockey01', '123456', 'JOCKEY', 2),
('owner01', '123456', 'HORSE_OWNER', 3),
('spectator01', '123456', 'SPECTATOR', 4);

-- 3. Phân bổ User ID vào các bảng Vai trò tương ứng
INSERT INTO admins (id) VALUES (1);
INSERT INTO jockeys (id, weight, experience_years) VALUES (2, 62.5, 5);
INSERT INTO horse_owners (id, company_name) VALUES (3, N'Trại ngựa Hoàng Gia');
INSERT INTO spectators (id, loyalty_points) VALUES (4, 150);

-- 4. Thêm Dữ liệu Ngựa (Thuộc sở hữu của Chủ ngựa ID = 3)
INSERT INTO horses (name, breed, age, owner_id) VALUES
(N'Xích Thố', N'Thoroughbred', 4, 3),
(N'Bạch Long', N'Arabian', 5, 3);

-- 5. Thêm Dữ liệu Giải đấu và Cuộc đua
INSERT INTO tournaments (name, start_date, end_date) VALUES
(N'Giải vô địch Mùa Hè 2026', '2026-08-01', '2026-08-15');

INSERT INTO races (tournament_id, name, race_date, distance) VALUES
(1, N'Vòng sơ loại 1000m', '2026-08-01 08:30:00', 1000.00),
(1, N'Vòng chung kết 2000m', '2026-08-15 15:00:00', 2000.00);

PRINT N'Database SWP391_HorseRacing đã được khởi tạo và chèn dữ liệu thành công!';
GO