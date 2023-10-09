
INSERT INTO Role (name)
VALUES
    ('ROLE_ADMIN'),
    ('ROLE_OWNER'),
    ('ROLE_USER');



INSERT INTO Account (username, password, firstname, lastname, address, email, phone, avatar, wallet, status, role_id)
VALUES
    ('admin', '123', 'John', 'Doe', '123 Main St', 'john@example.com', '1234567890', 'avatar1.jpg', 100.0, 'active', 1),
    ('user1', '123', 'Jane', 'Smith', '456 Elm St', 'jane@example.com', '9876543210', 'avatar2.jpg', 50.0, 'active', 2),
    ('user2', '123', 'Bob', 'Johnson', '789 Oak St', 'bob@example.com', '5555555555', 'avatar3.jpg', 200.0, 'inactive', 2);


INSERT INTO Category (name)
VALUES
    ('Boarding House'),
    ('Room for Rent'),
    ('Mini Apartment'),
    ('Resort');




INSERT INTO Booking (start_time, end_time, total, status, house_id, account_id)
VALUES
    ('2023-09-25 14:00:00', '2023-09-27 12:00:00', 300.0, 'confirmed', 12, 1),
    ('2023-09-26 15:00:00', '2023-09-29 10:00:00', 250.0, 'confirmed', 16, 2),
    ('2023-09-28 12:00:00', '2023-09-30 11:00:00', 180.0, 'canceled', 10, 3),
    ('2023-09-30 16:00:00', '2023-10-03 14:00:00', 400.0, 'confirmed', 11, 2);



INSERT INTO Review (comment, status, rating, create_at, booking_id)
VALUES
    ('Great place to stay!', 'approved', 5, '2023-09-20', 17),
    ('Clean and comfortable.', 'approved', 4, '2023-09-21', 20),
    ('Nice view from the balcony.', 'pending', 3, '2023-09-22', 18),
    ('Excellent service.', 'approved', 5, '2023-09-23', 19);
-- Thêm dữ liệu giả lập cho căn nhà với giá và địa chỉ ở Việt Nam
INSERT INTO House (name, address, province, district, ward, house_number, bedroom, bathroom, description, facility, old_price, new_price, area, thumbnail, status, create_at, update_at, owner_id)
VALUES
    ('Căn hộ Quận 1', 'Số 123 Đường A, Quận B, TP Hà Nội', 'Hà Nội', 'Quận B', 'Phường C', '123A', 3, 2, 'Mô tả căn nhà 1', 'Tiện ích: Bể bơi, sân vườn', 2000000000, 1800000000, 200.0, 'https://dulichbavi.com/wp-content/uploads/2022/06/ST-Homestay-4-800x530.png', 'ok', '2023-10-05', '2023-10-05', 1),
    ('Căn hộ Vạn Phát', 'Số 456 Đường X, Quận Y, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận Y', 'Phường Z', '456B', 4, 3, 'Mô tả căn nhà 2', 'Tiện ích: Phòng tập thể dục, bãi đỗ xe', 2500000000, 2200000000, 250.0, 'https://khanhanlaw.com/Uploads/kinh-doanh-dich-vu-homestay.jpg', 'ok', '2023-10-05', '2023-10-05', 2),
('Nhà phố Cổ Điển', 'Số 789 Đường X, Quận Y, TP Hà Nội', 'Hà Nội', 'Quận Y', 'Phường Z', '789C', 2, 1, 'Mô tả căn nhà 3', 'Tiện ích: Bãi đỗ xe', 1500000000, 1300000000, 150.0, 'https://cdn.luatminhkhue.vn/lmk/articles/12/60847/lam-homestay-tren-dat-nong-nghiep-co-phu-hop-ve-mat-phap-ly-khong-a--neu-khong-toi-phai-dang-ky-lam-sao-va-thu-tuc-nhu-the-nao-a--60847.jpg', 'ok', '2023-10-05', '2023-10-05', 3),
('Biệt thự Hòa Nhạc', 'Số 101 Đường M, Quận N, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận N', 'Phường P', '101D', 3, 2, 'Mô tả căn nhà 4', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'https://vietsovpetrohotel.vn/wp-content/uploads/2020/07/homestay-da-lat-moi-xay-dung.jpg', 'ok', '2023-10-05', '2023-10-05', 4),

('Nhà Phố Hạ Long', 'Số 111 Đường Q, Quận R, TP Hà Nội', 'Hà Nội', 'Quận R', 'Phường S', '111E', 4, 3, 'Mô tả căn nhà 5', 'Tiện ích: Phòng tập thể dục, bể bơi', 2200000000, 2000000000, 220.0, 'https://tecwoodoutdoorfloor.com/upload/images/Blog/homestay-dep5.jpg', 'ok', '2023-10-05', '2023-10-05', 2),
('Biệt thự Xanh', 'Số 222 Đường T, Quận U, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận U', 'Phường V', '222F', 2, 1, 'Mô tả căn nhà 6', 'Tiện ích: Bãi đỗ xe', 1300000000, 1100000000, 130.0, 'https://kientrucsuvietnam.vn/wp-content/uploads/2021/12/mau-nha-homestay-dep.jpeg', 'ok', '2023-10-05', '2023-10-05', 3),
('Căn hộ Thành Phố Lớn', 'Số 333 Đường W, Quận X, TP Hà Nội', 'Hà Nội', 'Quận X', 'Phường Y', '333G', 3, 2, 'Mô tả căn nhà 7', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/2a/14/c3/a6/a-little-leaf-homestay.jpg?w=700&h=-1&s=1', 'ok', '2023-10-05', '2023-10-05', 2),
('Biệt thự Sân Golf', 'Số 444 Đường Z, Quận A1, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận A1', 'Phường B1', '444H', 4, 3, 'Mô tả căn nhà 8', 'Tiện ích: Phòng tập thể dục, bể bơi', 2200000000, 2000000000, 220.0, 'https://bcdhouse.vn/wp-content/uploads/2022/07/Thiet-ke-chua-co-ten-52.png', 'ok', '2023-10-05', '2023-10-05', 4),
('Căn hộ Sài Gòn View', 'Số 555 Đường C1, Quận D1, TP Hà Nội', 'Hà Nội', 'Quận D1', 'Phường E1', '555I', 2, 1, 'Mô tả căn nhà 9', 'Tiện ích: Bãi đỗ xe', 1300000000, 1100000000, 130.0, 'https://static.kinhtedothi.vn/images/upload/2023/06/12/fb-img-1686476434534.jpg', 'ok', '2023-10-05', '2023-10-05', 1),
('Căn hộ Sơn Trà', 'Số 666 Đường F1, Quận G1, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận G1', 'Phường H1', '666J', 3, 2, 'Mô tả căn nhà 10', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'https://static.kinhtedothi.vn/images/upload/2023/06/12/fb-img-1686476434534.jpg', 'ok', '2023-10-05', '2023-10-05', 3),


    ('Căn hộ Mới Trùng Khơi', 'Số 777 Đường K1, Quận L1, TP Hà Nội', 'Hà Nội', 'Quận L1', 'Phường M1', '777K', 3, 2, 'Mô tả căn nhà 11', 'Tiện ích: Bãi đỗ xe', 1500000000, 1300000000, 150.0, 'https://bloghomestay.vn/wp-content/uploads/2022/07/homestay-soc-son-co-be-boi-8.jpg', 'ok', '2023-10-05', '2023-10-05', 2),
     ('Biệt thự Biển Xanh', 'Số 888 Đường N1, Quận O1, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận O1', 'Phường P1', '888L', 4, 3, 'Mô tả căn nhà 12', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'https://bloghomestay.vn/wp-content/uploads/2022/07/homestay-soc-son-co-be-boi-8.jpg', 'ok', '2023-10-05', '2023-10-05', 1),
     ('Căn hộ Ngọc Lan', 'Số 999 Đường Q1, Quận R1, TP Hà Nội', 'Hà Nội', 'Quận R1', 'Phường S1', '999M', 2, 1, 'Mô tả căn nhà 13', 'Tiện ích: Phòng tập thể dục, bể bơi', 2200000000, 2000000000, 220.0, 'https://phanthietvn.com/wp-content/uploads/2021/11/moonbeam-homestay-mui-ne-5.jpeg', 'ok', '2023-10-05', '2023-10-05', 2),
     ('Nhà phố Hoa Hồng', 'Số 1111 Đường T1, Quận U1, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận U1', 'Phường V1', '1111N', 3, 2, 'Mô tả căn nhà 14', 'Tiện ích: Bãi đỗ xe', 1300000000, 1100000000, 130.0, 'https://phanthietvn.com/wp-content/uploads/2021/11/moonbeam-homestay-mui-ne-5.jpeg', 'ok', '2023-10-05', '2023-10-05', 3),
     ('Nhà phố Mặt Tiền', 'Số 2222 Đường V1, Quận X1, TP Hà Nội', 'Hà Nội', 'Quận X1', 'Phường Y1', '2222O', 4, 3, 'Mô tả căn nhà 15', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'https://phanthietvn.com/wp-content/uploads/2021/11/moonbeam-homestay-mui-ne-7.jpeg', 'ok', '2023-10-05', '2023-10-05', 2),
     ('Nhà phố Đô Thị', 'Số 3333 Đường W1, Quận A2, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận A2', 'Phường B2', '3333P', 2, 1, 'Mô tả căn nhà 16', 'Tiện ích: Phòng tập thể dục, bể bơi', 2200000000, 2000000000, 220.0, 'https://phanthietvn.com/wp-content/uploads/2021/11/moonbeam-homestay-mui-ne-7.jpeg', 'ok', '2023-10-05', '2023-10-05', 1),
     ('Căn hộ Làng Quê', 'Số 4444 Đường C2, Quận D2, TP Hà Nội', 'Hà Nội', 'Quận D2', 'Phường E2', '4444Q', 3, 2, 'Mô tả căn nhà 17', 'Tiện ích: Bãi đỗ xe', 1300000000, 1100000000, 130.0, 'https://datnendep.vn/wp-content/uploads/2019/11/174379346.jpg', 'ok', '2023-10-05', '2023-10-05', 3),
     ('Căn hộ Phong Cách Hiện Đại', 'Số 5555 Đường F2, Quận G2, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận G2', 'Phường H2', '5555R', 4, 3, 'Mô tả căn nhà 18', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'https://dulichtoday.vn/wp-content/uploads/2018/04/Hygge-homestay.jpg', 'ok', '2023-10-05', '2023-10-05', 4),
     ('Nhà Phố Phương Đông', 'Số 6666 Đường K2, Quận L2, TP Hà Nội', 'Hà Nội', 'Quận L2', 'Phường M2', '6666S', 2, 1, 'Mô tả căn nhà 19', 'Tiện ích: Bãi đỗ xe', 1500000000, 1300000000, 150.0, 'https://dulichtoday.vn/wp-content/uploads/2018/04/Hygge-homestay.jpg', 'ok', '2023-10-05', '2023-10-05', 4),
     ('Biệt thự Cổ Điển', 'Số 7777 Đường N2, Quận O2, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận O2', 'Phường P2', '7777T', 3, 2, 'Mô tả căn nhà 20', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'https://dulichtoday.vn/wp-content/uploads/2018/04/Hygge-homestay.jpg', 'ok', '2023-10-05', '2023-10-05', 1);
