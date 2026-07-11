<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập - Horse Racing Management</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { 
            font-family: Arial, sans-serif; 
            background: linear-gradient(135deg, #1a1a2e, #16213e); 
            min-height: 100vh; 
            display: flex; 
            justify-content: center; 
            align-items: center; 
        }
        .login-container { 
            background: white; 
            padding: 40px; 
            border-radius: 10px; 
            box-shadow: 0 10px 30px rgba(0,0,0,0.3); 
            width: 100%; 
            max-width: 400px; 
        }
        .login-container h1 { 
            text-align: center; 
            color: #1a1a2e; 
            margin-bottom: 30px; 
            font-size: 28px; 
        }
        .login-container h1 span { color: #e94560; }
        .form-group { margin-bottom: 20px; }
        .form-group label { 
            display: block; 
            margin-bottom: 5px; 
            color: #555; 
            font-weight: bold; 
        }
        .form-group input { 
            width: 100%; 
            padding: 12px; 
            border: 1px solid #ddd; 
            border-radius: 5px; 
            font-size: 16px; 
            transition: border 0.3s; 
        }
        .form-group input:focus { 
            border-color: #e94560; 
            outline: none; 
        }
        .btn-login { 
            width: 100%; 
            padding: 12px; 
            background: #e94560; 
            color: white; 
            border: none; 
            border-radius: 5px; 
            font-size: 18px; 
            font-weight: bold; 
            cursor: pointer; 
            transition: background 0.3s; 
        }
        .btn-login:hover { background: #c0392b; }
        .error { 
            background: #ffe6e6; 
            color: #cc0000; 
            padding: 10px; 
            border-radius: 5px; 
            margin-bottom: 15px; 
            text-align: center; 
        }
        .register-link { 
            text-align: center; 
            margin-top: 15px; 
            color: #666; 
        }
        .register-link a { 
            color: #e94560; 
            text-decoration: none; 
        }
        .register-link a:hover { text-decoration: underline; }
        .info { 
            margin-top: 15px; 
            text-align: center; 
            font-size: 12px; 
            color: #999; 
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>🏇 <span>Đua Ngựa</span></h1>
        
        <% if (request.getAttribute("error") != null) { %>
            <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>
        
        <form action="<%= request.getContextPath() %>/login" method="post">
            <div class="form-group">
                <label>Tên đăng nhập</label>
                <input type="text" name="username" required placeholder="Nhập tên đăng nhập...">
            </div>
            <div class="form-group">
                <label>Mật khẩu</label>
                <input type="password" name="password" required placeholder="Nhập mật khẩu...">
            </div>
            <button type="submit" class="btn-login">Đăng nhập</button>
        </form>
        
        <div class="register-link">
            Chưa có tài khoản? <a href="<%= request.getContextPath() %>/register">Đăng ký ngay</a>
        </div>
        
        <div class="info">
            <p>Tài khoản mẫu: <strong>admin</strong> / <strong>admin123</strong></p>
        </div>
    </div>
</body>
</html>