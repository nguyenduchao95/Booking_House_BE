
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

INSERT INTO House (name, address, bedroom, bathroom, description, price, thumbnail, status, create_at, update_at, owner_id, category_id)
VALUES
    ('Beach House', '123 Beachfront Ave', 3, 2, 'Beautiful beachfront house', 200.0, 'http://localhost:63342/real-estate-html-template/real-estate-html-template/img/property-1.jpg', 'available', '2023-09-15', '2023-09-15', 2, 1),
    ('City Apartment', '456 Downtown St', 2, 1, 'Modern apartment in the city center', 150.0, 'http://localhost:63342/real-estate-html-template/real-estate-html-template/img/property-2.jpg', 'available', '2023-09-15', '2023-09-15', 2, 3),
    ('Mountain Cabin', '789 Forest Rd', 2, 1, 'Cozy cabin in the mountains', 120.0, 'http://localhost:63342/real-estate-html-template/real-estate-html-template/img/property-3.jpg', 'booked', '2023-09-15', '2023-09-15', 3, 4),
    ('Riverside Villa', '321 Riverside Rd', 4, 3, 'Spacious villa by the river', 250.0, 'riverside_villa.jpg', 'available', '2023-09-16', '2023-09-16', 2, 1),
    ('Downtown Loft', '789 Main St', 1, 1, 'Cozy loft in the heart of downtown', 100.0, 'downtown_loft.jpg', 'available', '2023-09-16', '2023-09-16', 3, 2),
    ('Hillside Retreat', '456 Hilltop Ave', 3, 2, 'Peaceful retreat in the hills', 180.0, 'hillside_retreat.jpg', 'booked', '2023-09-16', '2023-09-16', 1, 4),
    ('Beachfront Bungalow', '101 Ocean Blvd', 2, 1, 'Quaint bungalow on the beach', 150.0, 'beachfront_bungalow.jpg', 'available', '2023-09-16', '2023-09-16', 2, 1),
('Lakefront Resort', '101 Lakeview Dr', 5, 3, 'Luxurious lakefront resort', 300.0, 'http://localhost:63342/real-estate-html-template/real-estate-html-template/img/property-4.jpg', 'available', '2023-09-15', '2023-09-15', 2, 4);


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
