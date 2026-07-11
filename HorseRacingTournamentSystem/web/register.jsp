<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký - Horse Racing Management</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { 
            font-family: Arial, sans-serif; 
            background: linear-gradient(135deg, #1a1a2e, #16213e); 
            min-height: 100vh; 
            display: flex; 
            justify-content: center; 
            align-items: center; 
            padding: 20px;
        }
        .register-container { 
            background: white; 
            padding: 40px; 
            border-radius: 10px; 
            box-shadow: 0 10px 30px rgba(0,0,0,0.3); 
            width: 100%; 
            max-width: 500px; 
        }
        .register-container h1 { 
            text-align: center; 
            color: #1a1a2e; 
            margin-bottom: 30px; 
            font-size: 28px; 
        }
        .register-container h1 span { color: #e94560; }
        .form-group { margin-bottom: 15px; }
        .form-group label { 
            display: block; 
            margin-bottom: 5px; 
            color: #555; 
            font-weight: bold; 
        }
        .form-group input, .form-group select { 
            width: 100%; 
            padding: 10px; 
            border: 1px solid #ddd; 
            border-radius: 5px; 
            font-size: 14px; 
        }
        .form-group input:focus, .form-group select:focus { 
            border-color: #e94560; 
            outline: none; 
        }
        .btn-register { 
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
            margin-top: 10px;
        }
        .btn-register:hover { background: #c0392b; }
        .error { 
            background: #ffe6e6; 
            color: #cc0000; 
            padding: 10px; 
            border-radius: 5px; 
            margin-bottom: 15px; 
            text-align: center; 
        }
        .success { 
            background: #e6ffe6; 
            color: #006600; 
            padding: 10px; 
            border-radius: 5px; 
            margin-bottom: 15px; 
            text-align: center; 
        }
        .login-link { 
            text-align: center; 
            margin-top: 15px; 
            color: #666; 
        }
        .login-link a { 
            color: #e94560; 
            text-decoration: none; 
        }
        .login-link a:hover { text-decoration: underline; }
        .form-row {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 15px;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h1>📝 <span>Đăng ký</span> tài khoản</h1>
        
        <% if (request.getAttribute("error") != null) { %>
            <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>
        <% if (request.getAttribute("success") != null) { %>
            <div class="success"><%= request.getAttribute("success") %></div>
        <% } %>
        
        <form action="<%= request.getContextPath() %>/register" method="post">
            <div class="form-group">
                <label>Tên đăng nhập *</label>
                <input type="text" name="username" required placeholder="Nhập tên đăng nhập...">
            </div>
            
            <div class="form-group">
                <label>Họ và tên *</label>
                <input type="text" name="fullName" required placeholder="Nhập họ và tên...">
            </div>
            
            <div class="form-row">
                <div class="form-group">
                    <label>Email *</label>
                    <input type="email" name="email" required placeholder="example@email.com">
                </div>
                <div class="form-group">
                    <label>Số điện thoại</label>
                    <input type="text" name="phone" placeholder="090xxxxxxx">
                </div>
            </div>
            
            <div class="form-row">
                <div class="form-group">
                    <label>Mật khẩu *</label>
                    <input type="password" name="password" required placeholder="Nhập mật khẩu...">
                </div>
                <div class="form-group">
                    <label>Xác nhận mật khẩu *</label>
                    <input type="password" name="confirmPassword" required placeholder="Nhập lại mật khẩu...">
                </div>
            </div>
            
            <div class="form-group">
                <label>Vai trò</label>
                <select name="role">
                    <option value="OWNER">Chủ ngựa (Owner)</option>
                    <option value="JOCKEY">Kỵ sỹ (Jockey)</option>
                </select>
            </div>
            
            <button type="submit" class="btn-register">Đăng ký</button>
        </form>
        
        <div class="login-link">
            Đã có tài khoản? <a href="<%= request.getContextPath() %>/login">Đăng nhập ngay</a>
        </div>
    </div>
</body>
</html>