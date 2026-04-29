# Inventory Management App

Ứng dụng quản lý kho hàng với backend Node.js/Express và frontend Android/Compose.

## 📋 Yêu cầu

### Backend
- Node.js v14 trở lên
- PostgreSQL
- npm hoặc yarn

### Frontend (Android)
- Android Studio
- JDK 11 trở lên
- Android SDK 24+

---

## 🔧 Hướng dẫn cài đặt

### 1. Backend Setup

```bash
cd inventory-backend

# Cài đặt dependencies
npm install

# Copy file .env.example thành .env và cập nhật thông tin database
cp .env.example .env

# Chỉnh sửa .env với thông tin PostgreSQL của bạn
# DB_USER=your_username
# DB_HOST=localhost
# DB_NAME=inventory
# DB_PASSWORD=your_password
# DB_PORT=5432
```

### 2. Database Setup

Tạo database và table trong PostgreSQL:

```sql
-- Tạo database
CREATE DATABASE inventory;

-- Tạo table items
CREATE TABLE items (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 3. Chạy Backend

```bash
cd inventory-backend

# Development mode (với auto-reload)
npm run dev

# Production mode
npm start
```

Backend sẽ chạy tại: `http://localhost:3000`

### 4. Android App Setup

- Mở project trong Android Studio
- Chỉnh sửa file `AppConfig.kt` để đặt URL API phù hợp:
  - **Cho Android Emulator**: Sử dụng `BASE_URL_EMULATOR = "http://10.0.2.2:3000/api/"`
  - **Cho Physical Device**: Cập nhật IP của máy tính (`192.168.x.x`) và sử dụng `BASE_URL_PRODUCTION`

---

## 🚀 API Endpoints

### Items
- `GET /api/items` - Lấy danh sách tất cả items
- `GET /api/items/:id` - Lấy chi tiết 1 item
- `POST /api/items` - Tạo item mới
- `PUT /api/items/:id` - Cập nhật item
- `DELETE /api/items/:id` - Xóa item

### Request Body Example (POST/PUT)
```json
{
  "name": "Laptop",
  "price": 999.99,
  "quantity": 10
}
```

---

## 📁 Cấu trúc Project

```
inventory/
├── inventory-backend/
│   ├── config/
│   │   └── db.js
│   ├── controllers/
│   │   └── itemController.js
│   ├── models/
│   │   └── itemModel.js
│   ├── routes/
│   │   └── itemRoutes.js
│   ├── .env
│   ├── .env.example
│   ├── .gitignore
│   ├── package.json
│   └── server.js
└── app/
    ├── src/
    │   └── main/
    │       ├── java/com/tien/inventory/
    │       │   ├── data/
    │       │   ├── ui/
    │       │   └── utils/
    │       └── res/
    └── build.gradle.kts
```

---

## 🐛 Troubleshooting

### Backend Connection Error
- Kiểm tra PostgreSQL đã chạy
- Kiểm tra thông tin kết nối trong `.env`
- Xem logs ở terminal Node.js

### Android App không kết nối API
- **Emulator**: Đảm bảo `BASE_URL` là `http://10.0.2.2:3000/api/`
- **Physical Device**: 
  - Cập nhật IP address trong `AppConfig.kt`
  - Kiểm tra firewall cho phép port 3000
  - Đảm bảo device và máy tính trên cùng network

---

## 📝 Notes

- File `.env` không được commit vào Git (đã được thêm vào `.gitignore`)
- Sử dụng `.env.example` làm template cho cấu hình mới
- Backend logs hiển thị ở Node.js terminal
