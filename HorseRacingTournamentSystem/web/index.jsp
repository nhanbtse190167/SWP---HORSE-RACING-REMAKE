<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.horseracing.model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ - Horse Racing Management</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: Arial, sans-serif; background: #f4f6f9; }
        .header { 
            background: #1a1a2e; 
            color: white; 
            padding: 15px 30px; 
            display: flex; 
            justify-content: space-between; 
            align-items: center; 
        }
        .header h1 { font-size: 24px; }
        .header h1 span { color: #e94560; }
        .header .user-info { display: flex; align-items: center; gap: 20px; }
        .header .user-info .role-badge {
            background: #e94560;
            padding: 5px 15px;
            border-radius: 20px;
            font-size: 12px;
            font-weight: bold;
        }
        .header .user-info .logout { 
            color: #e94560; 
            text-decoration: none; 
            font-weight: bold; 
        }
        .header .user-info .logout:hover { text-decoration: underline; }
        .container { max-width: 1200px; margin: 30px auto; padding: 0 20px; }
        .welcome { 
            background: white; 
            padding: 30px; 
            border-radius: 10px; 
            box-shadow: 0 2px 10px rgba(0,0,0,0.1); 
            margin-bottom: 30px;
        }
        .welcome h2 { color: #1a1a2e; margin-bottom: 10px; }
        .welcome p { color: #666; }
        .dashboard-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
        }
        .card {
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            text-align: center;
            transition: transform 0.3s;
        }
        .card:hover { transform: translateY(-5px); }
        .card .icon { font-size: 40px; margin-bottom: 10px; }
        .card h3 { color: #1a1a2e; margin-bottom: 5px; }
        .card p { color: #666; font-size: 14px; }
    </style>
</head>
<body>
    <div class="header">
        <h1>🏇 <span>Horse</span> Racing</h1>
        <div class="user-info">
            <span>Xin chào, <strong><%= user.getFullName() %></strong></span>
            <span class="role-badge"><%= user.getRole() %></span>
            <a href="<%= request.getContextPath() %>/logout" class="logout">Đăng xuất</a>
        </div>
    </div>
    
    <div class="container">
        <div class="welcome">
            <h2>Chào mừng đến với hệ thống quản lý đua ngựa!</h2>
            <p>Bạn đang đăng nhập với vai trò: <strong><%= user.getRole() %></strong></p>
        </div>
        
        <div class="dashboard-grid">
            <div class="card">
                <div class="icon"></div>
                <h3>Ngựa đua</h3>
                <p>Quản lý danh sách ngựa</p>
            </div>
            <div class="card">
                <div class="icon"></div>
                <h3>Cuộc đua</h3>
                <p>Xem và tham gia đua</p>
            </div>
            <div class="card">
                <div class="icon"></div>
                <h3>Kết quả</h3>
                <p>Xem kết quả đua</p>
            </div>
            <div class="card">
                <div class="icon"></div>
                <h3>Xếp hạng</h3>
                <p>Bảng xếp hạng</p>
            </div>
        </div>
    </div>
</body>
</html>