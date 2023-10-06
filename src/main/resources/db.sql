
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

INSERT INTO House (name, address, bedroom, bathroom, description, new_price,old_price, thumbnail, status, create_at, update_at, owner_id, category_id,area)
VALUES
    ('Beach House', '123 Beachfront Ave', 3, 2, 'Beautiful beachfront house', 200.0,210.0, 'http://localhost:63342/real-estate-html-template/real-estate-html-template/img/property-1.jpg', 'available', '2023-09-15', '2023-09-15', 2, 1,200),
    ('City Apartment', '456 Downtown St', 2, 1, 'Modern apartment in the city center', 150.0, 170.0,'http://localhost:63342/real-estate-html-template/real-estate-html-template/img/property-2.jpg', 'available', '2023-09-15', '2023-09-15', 2, 3,120),
    ('Mountain Cabin', '789 Forest Rd', 2, 1, 'Cozy cabin in the mountains', 120.0,130.0, 'http://localhost:63342/real-estate-html-template/real-estate-html-template/img/property-3.jpg', 'booked', '2023-09-15', '2023-09-15', 3, 4,150),
    ('Riverside Villa', '321 Riverside Rd', 4, 3, 'Spacious villa by the river', 250.0,270.0, 'riverside_villa.jpg', 'available', '2023-09-16', '2023-09-16', 2, 1,90),
    ('Downtown Loft', '789 Main St', 1, 1, 'Cozy loft in the heart of downtown', 100.0,110.0, 'downtown_loft.jpg', 'available', '2023-09-16', '2023-09-16', 3, 2,110),
    ('Hillside Retreat', '456 Hilltop Ave', 3, 2, 'Peaceful retreat in the hills', 180.0, 200.0,'hillside_retreat.jpg', 'booked', '2023-09-16', '2023-09-16', 1, 4.250),
    ('Beachfront Bungalow', '101 Ocean Blvd', 2, 1, 'Quaint bungalow on the beach', 150.0, 170.0,'beachfront_bungalow.jpg', 'available', '2023-09-16', '2023-09-16', 2, 1,200),
('Lakefront Resort', '101 Lakeview Dr', 5, 3, 'Luxurious lakefront resort', 300.0, 320.0,'http://localhost:63342/real-estate-html-template/real-estate-html-template/img/property-4.jpg', 'available', '2023-09-15', '2023-09-15', 2, 4,90.0);


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
    ('Căn nhà 1', 'Số 123 Đường A, Quận B, TP Hà Nội', 'Hà Nội', 'Quận B', 'Phường C', '123A', 3, 2, 'Mô tả căn nhà 1', 'Tiện ích: Bể bơi, sân vườn', 2000000000, 1800000000, 200.0, 'link_thumbnail_1.jpg', 'ok', '2023-10-05', '2023-10-05', 1),
    ('Căn nhà 2', 'Số 456 Đường X, Quận Y, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận Y', 'Phường Z', '456B', 4, 3, 'Mô tả căn nhà 2', 'Tiện ích: Phòng tập thể dục, bãi đỗ xe', 2500000000, 2200000000, 250.0, 'link_thumbnail_2.jpg', 'ok', '2023-10-05', '2023-10-05', 2),
('Căn nhà 3', 'Số 789 Đường X, Quận Y, TP Hà Nội', 'Hà Nội', 'Quận Y', 'Phường Z', '789C', 2, 1, 'Mô tả căn nhà 3', 'Tiện ích: Bãi đỗ xe', 1500000000, 1300000000, 150.0, 'link_thumbnail_3.jpg', 'ok', '2023-10-05', '2023-10-05', 3),
('Căn nhà 4', 'Số 101 Đường M, Quận N, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận N', 'Phường P', '101D', 3, 2, 'Mô tả căn nhà 4', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'link_thumbnail_4.jpg', 'ok', '2023-10-05', '2023-10-05', 4),

('Căn nhà 5', 'Số 111 Đường Q, Quận R, TP Hà Nội', 'Hà Nội', 'Quận R', 'Phường S', '111E', 4, 3, 'Mô tả căn nhà 5', 'Tiện ích: Phòng tập thể dục, bể bơi', 2200000000, 2000000000, 220.0, 'link_thumbnail_5.jpg', 'ok', '2023-10-05', '2023-10-05', 2),
('Căn nhà 6', 'Số 222 Đường T, Quận U, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận U', 'Phường V', '222F', 2, 1, 'Mô tả căn nhà 6', 'Tiện ích: Bãi đỗ xe', 1300000000, 1100000000, 130.0, 'link_thumbnail_6.jpg', 'ok', '2023-10-05', '2023-10-05', 3),
('Căn nhà 7', 'Số 333 Đường W, Quận X, TP Hà Nội', 'Hà Nội', 'Quận X', 'Phường Y', '333G', 3, 2, 'Mô tả căn nhà 7', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'link_thumbnail_7.jpg', 'ok', '2023-10-05', '2023-10-05', 2),
('Căn nhà 8', 'Số 444 Đường Z, Quận A1, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận A1', 'Phường B1', '444H', 4, 3, 'Mô tả căn nhà 8', 'Tiện ích: Phòng tập thể dục, bể bơi', 2200000000, 2000000000, 220.0, 'link_thumbnail_8.jpg', 'ok', '2023-10-05', '2023-10-05', 4),
('Căn nhà 9', 'Số 555 Đường C1, Quận D1, TP Hà Nội', 'Hà Nội', 'Quận D1', 'Phường E1', '555I', 2, 1, 'Mô tả căn nhà 9', 'Tiện ích: Bãi đỗ xe', 1300000000, 1100000000, 130.0, 'link_thumbnail_9.jpg', 'ok', '2023-10-05', '2023-10-05', 1),
('Căn nhà 10', 'Số 666 Đường F1, Quận G1, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận G1', 'Phường H1', '666J', 3, 2, 'Mô tả căn nhà 10', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'link_thumbnail_10.jpg', 'ok', '2023-10-05', '2023-10-05', 3),


    ('Căn nhà 11', 'Số 777 Đường K1, Quận L1, TP Hà Nội', 'Hà Nội', 'Quận L1', 'Phường M1', '777K', 3, 2, 'Mô tả căn nhà 11', 'Tiện ích: Bãi đỗ xe', 1500000000, 1300000000, 150.0, 'link_thumbnail_11.jpg', 'ok', '2023-10-05', '2023-10-05', 2),
     ('Căn nhà 12', 'Số 888 Đường N1, Quận O1, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận O1', 'Phường P1', '888L', 4, 3, 'Mô tả căn nhà 12', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'link_thumbnail_12.jpg', 'ok', '2023-10-05', '2023-10-05', 1),
     ('Căn nhà 13', 'Số 999 Đường Q1, Quận R1, TP Hà Nội', 'Hà Nội', 'Quận R1', 'Phường S1', '999M', 2, 1, 'Mô tả căn nhà 13', 'Tiện ích: Phòng tập thể dục, bể bơi', 2200000000, 2000000000, 220.0, 'link_thumbnail_13.jpg', 'ok', '2023-10-05', '2023-10-05', 2),
     ('Căn nhà 14', 'Số 1111 Đường T1, Quận U1, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận U1', 'Phường V1', '1111N', 3, 2, 'Mô tả căn nhà 14', 'Tiện ích: Bãi đỗ xe', 1300000000, 1100000000, 130.0, 'link_thumbnail_14.jpg', 'ok', '2023-10-05', '2023-10-05', 3),
     ('Căn nhà 15', 'Số 2222 Đường V1, Quận X1, TP Hà Nội', 'Hà Nội', 'Quận X1', 'Phường Y1', '2222O', 4, 3, 'Mô tả căn nhà 15', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'link_thumbnail_15.jpg', 'ok', '2023-10-05', '2023-10-05', 2),
     ('Căn nhà 16', 'Số 3333 Đường W1, Quận A2, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận A2', 'Phường B2', '3333P', 2, 1, 'Mô tả căn nhà 16', 'Tiện ích: Phòng tập thể dục, bể bơi', 2200000000, 2000000000, 220.0, 'link_thumbnail_16.jpg', 'ok', '2023-10-05', '2023-10-05', 1),
     ('Căn nhà 17', 'Số 4444 Đường C2, Quận D2, TP Hà Nội', 'Hà Nội', 'Quận D2', 'Phường E2', '4444Q', 3, 2, 'Mô tả căn nhà 17', 'Tiện ích: Bãi đỗ xe', 1300000000, 1100000000, 130.0, 'link_thumbnail_17.jpg', 'ok', '2023-10-05', '2023-10-05', 3),
     ('Căn nhà 18', 'Số 5555 Đường F2, Quận G2, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận G2', 'Phường H2', '5555R', 4, 3, 'Mô tả căn nhà 18', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'link_thumbnail_18.jpg', 'ok', '2023-10-05', '2023-10-05', 4),
     ('Căn nhà 19', 'Số 6666 Đường K2, Quận L2, TP Hà Nội', 'Hà Nội', 'Quận L2', 'Phường M2', '6666S', 2, 1, 'Mô tả căn nhà 19', 'Tiện ích: Bãi đỗ xe', 1500000000, 1300000000, 150.0, 'link_thumbnail_19.jpg', 'ok', '2023-10-05', '2023-10-05', 4),
     ('Căn nhà 20', 'Số 7777 Đường N2, Quận O2, TP Hồ Chí Minh', 'Hồ Chí Minh', 'Quận O2', 'Phường P2', '7777T', 3, 2, 'Mô tả căn nhà 20', 'Tiện ích: Sân vườn', 1800000000, 1600000000, 180.0, 'link_thumbnail_20.jpg', 'ok', '2023-10-05', '2023-10-05', 1);
