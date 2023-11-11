USE booking_house;
SET NAMES 'utf8';
INSERT IGNORE INTO role(id, name)
values (1,'ROLE_USER'),
       (2,'ROLE_ADMIN'),
       (3,'ROLE_OWNER');

INSERT IGNORE INTO account (id, username, password, firstname, lastname, address, email, phone, avatar, wallet, status, role_id)
VALUES
    (1, 'admin1', '123456', 'John', 'Doe', '123 Main St', 'john@example.com', '1234567890', 'https://cdn-icons-png.flaticon.com/512/3177/3177440.png', 100.0, 'Đang hoạt động', 2),
    (2, 'admin2', '123456', 'Jane', 'Smith', '456 Elm St', 'jane@example.com', '9876543210', 'https://pcilaocai.vn/wp-content/uploads/2023/02/xam-xi-avatar-cute-1.jpg', 50.0, 'Đang hoạt động', 2),
    (3, 'admin3', '123456', 'Bob', 'Johnson', '789 Oak St', 'bob@example.com', '5555555555', 'https://antimatter.vn/wp-content/uploads/2022/10/hinh-anh-avatar-doi-cute-cho-nam.jpg', 200.0, 'Đang hoạt động', 2),
    (4, 'admin4', '123456', 'Bob', 'Johnson', '789 Oak St', 'admin@example.com', '5555555555', 'https://i0.wp.com/thatnhucuocsong.com.vn/wp-content/uploads/2023/06/Hinh-anh-avatar-doi-tinh-yeu-online-cute-cho-nam.jpg', 200.0, 'Đang hoạt động', 2),
    (5, 'owner1', '123456', 'B', 'Nguyễn Văn', '789 Oak St', 'owner1@example.com', '5555555555', 'https://antimatter.vn/wp-content/uploads/2023/02/hinh-anh-avatar-nu-cute-ngau.jpg', 200.0, 'Đang hoạt động', 3),
    (6, 'user1', '123456', 'AA', 'Nguyễn Văn', '789 Oak St', 'user1@example.com', '5555555555', 'https://antimatter.vn/wp-content/uploads/2022/10/hinh-anh-avatar-doi-cute-cho-nam.jpg', 200.0, 'Đang hoạt động', 1);


INSERT IGNORE INTO house(id, name, address, bedroom, bathroom, area, price, sale, thumbnail, status, create_at, update_at, owner_id, description, facility)
values
    (1, 'Nha Dep 1', 'HN', 2, 2, 80, 1234567, 10, 'https://static.vinwonders.com/production/homestay-la-gi-1.jpg', 'Đang trống', '2023-10-03', null, 5, '<p><strong>Vị tr&iacute;</strong><br>Lưu tr&uacute; tại Gold Plaza Hotel Da Nang l&agrave; một lựa chọn đ&uacute;ng đắn khi qu&yacute; kh&aacute;ch đến thăm Quận Hải Ch&acirc;u.</p>
                            <p>kh&aacute;ch sạn sở hữu vị tr&iacute; đắc địa c&aacute;ch s&acirc;n bay S&acirc;n bay quốc tế Đ&agrave; Nẵng (DAD) 2,51 km.</p>
                            <p>kh&aacute;ch sạn nằm c&aacute;ch Da Nang Railway Station 2,82 km.</p>
                            <p>kh&aacute;ch sạn n&agrave;y rất dễ t&igrave;m bởi vị tr&iacute; đắc địa, nằm gần với nhiều tiện &iacute;ch c&ocirc;ng cộng.</p>
                            <p><strong>Th&ocirc;ng tin về Gold Plaza Hotel Da Nang</strong></p>
                            <p>Kh&ocirc;ng chỉ sở hữu vị tr&iacute; gi&uacute;p qu&yacute; kh&aacute;ch dễ d&agrave;ng gh&eacute; thăm những địa điểm l&yacute; th&uacute; trong chuyến h&agrave;nh tr&igrave;nh, Gold Plaza Hotel Da Nang cũng sẽ mang đến cho qu&yacute; kh&aacute;ch trải nghiệm lưu tr&uacute; mỹ m&atilde;n.</p>
                            <p>Tọa lạc gần s&acirc;n bay, Gold Plaza Hotel Da Nang l&agrave; nơi nghỉ ngơi l&yacute; tưởng trong l&uacute;c qu&yacute; kh&aacute;ch đang chờ chuyến bay kế tiếp. Qu&yacute; kh&aacute;ch c&oacute; thể tận hưởng kh&ocirc;ng gian nghỉ dưỡng vừa &yacute; nơi đ&acirc;y trong qu&aacute; tr&igrave;nh qu&aacute; cảnh.</p>
                            <p>Khi lưu tr&uacute; tại kh&aacute;ch sạn th&igrave; nội thất v&agrave; kiến tr&uacute;c hẳn l&agrave; hai yếu tố quan trọng khiến qu&yacute; kh&aacute;ch m&atilde;n nh&atilde;n. Với thiết kế độc đ&aacute;o, Gold Plaza Hotel Da Nang mang đến kh&ocirc;ng gian lưu tr&uacute; l&agrave;m h&agrave;i l&ograve;ng qu&yacute; kh&aacute;ch.</p>', '<div class="css-1dbjc4n r-1awozwy r-18u37iz r-1h0z5md"><img src="https://s3-ap-southeast-1.amazonaws.com/cntres-assets-ap-southeast-1-250226768838-cf675839782fd369/imageResource/2016/12/23/1482486531890-cbaee7be1e0c71e690dba61a3ea68ae0.png" width="20" height="20" loading="lazy"> <span style="font-size: 14pt;"><strong>Tiện nghi chung</strong></span></div>
<ul>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">M&aacute;y lạnh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Tiệc chi&ecirc;u đ&atilde;i</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giữ đồ</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng gia đ&igrave;nh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng kh&ocirc;ng h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Hồ bơi</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giải tr&iacute;</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Khu vực h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Kh&ocirc;ng kh&oacute;i thuốc</div>
</li>
</ul>
<div class="ddict_btn" style="top: 23px; left: 780px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png"></div>'),
        (2, 'Nha Dep 2', 'HN', 2, 2, 90, 1234567, 10, 'https://static.vinwonders.com/production/homestay-la-gi-1.jpg', 'Đang trống', '2023-10-03', null, 5, '<p><strong>Vị tr&iacute;</strong><br>Lưu tr&uacute; tại Gold Plaza Hotel Da Nang l&agrave; một lựa chọn đ&uacute;ng đắn khi qu&yacute; kh&aacute;ch đến thăm Quận Hải Ch&acirc;u.</p>
                            <p>kh&aacute;ch sạn sở hữu vị tr&iacute; đắc địa c&aacute;ch s&acirc;n bay S&acirc;n bay quốc tế Đ&agrave; Nẵng (DAD) 2,51 km.</p>
                            <p>kh&aacute;ch sạn nằm c&aacute;ch Da Nang Railway Station 2,82 km.</p>
                            <p>kh&aacute;ch sạn n&agrave;y rất dễ t&igrave;m bởi vị tr&iacute; đắc địa, nằm gần với nhiều tiện &iacute;ch c&ocirc;ng cộng.</p>
                            <p><strong>Th&ocirc;ng tin về Gold Plaza Hotel Da Nang</strong></p>
                            <p>Kh&ocirc;ng chỉ sở hữu vị tr&iacute; gi&uacute;p qu&yacute; kh&aacute;ch dễ d&agrave;ng gh&eacute; thăm những địa điểm l&yacute; th&uacute; trong chuyến h&agrave;nh tr&igrave;nh, Gold Plaza Hotel Da Nang cũng sẽ mang đến cho qu&yacute; kh&aacute;ch trải nghiệm lưu tr&uacute; mỹ m&atilde;n.</p>
                            <p>Tọa lạc gần s&acirc;n bay, Gold Plaza Hotel Da Nang l&agrave; nơi nghỉ ngơi l&yacute; tưởng trong l&uacute;c qu&yacute; kh&aacute;ch đang chờ chuyến bay kế tiếp. Qu&yacute; kh&aacute;ch c&oacute; thể tận hưởng kh&ocirc;ng gian nghỉ dưỡng vừa &yacute; nơi đ&acirc;y trong qu&aacute; tr&igrave;nh qu&aacute; cảnh.</p>
                            <p>Khi lưu tr&uacute; tại kh&aacute;ch sạn th&igrave; nội thất v&agrave; kiến tr&uacute;c hẳn l&agrave; hai yếu tố quan trọng khiến qu&yacute; kh&aacute;ch m&atilde;n nh&atilde;n. Với thiết kế độc đ&aacute;o, Gold Plaza Hotel Da Nang mang đến kh&ocirc;ng gian lưu tr&uacute; l&agrave;m h&agrave;i l&ograve;ng qu&yacute; kh&aacute;ch.</p>', '<div class="css-1dbjc4n r-1awozwy r-18u37iz r-1h0z5md"><img src="https://s3-ap-southeast-1.amazonaws.com/cntres-assets-ap-southeast-1-250226768838-cf675839782fd369/imageResource/2016/12/23/1482486531890-cbaee7be1e0c71e690dba61a3ea68ae0.png" width="20" height="20" loading="lazy"> <span style="font-size: 14pt;"><strong>Tiện nghi chung</strong></span></div>
<ul>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">M&aacute;y lạnh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Tiệc chi&ecirc;u đ&atilde;i</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giữ đồ</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng gia đ&igrave;nh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng kh&ocirc;ng h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Hồ bơi</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giải tr&iacute;</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Khu vực h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Kh&ocirc;ng kh&oacute;i thuốc</div>
</li>
</ul>
<div class="ddict_btn" style="top: 23px; left: 780px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png"></div>'),
    (3, 'Nha Dep 3', 'HN', 2, 2, 70, 1234567, 10, 'https://static.vinwonders.com/production/homestay-la-gi-1.jpg', 'Đang trống', '2023-10-03', null, 5, '<p><strong>Vị tr&iacute;</strong><br>Lưu tr&uacute; tại Gold Plaza Hotel Da Nang l&agrave; một lựa chọn đ&uacute;ng đắn khi qu&yacute; kh&aacute;ch đến thăm Quận Hải Ch&acirc;u.</p>
                            <p>kh&aacute;ch sạn sở hữu vị tr&iacute; đắc địa c&aacute;ch s&acirc;n bay S&acirc;n bay quốc tế Đ&agrave; Nẵng (DAD) 2,51 km.</p>
                            <p>kh&aacute;ch sạn nằm c&aacute;ch Da Nang Railway Station 2,82 km.</p>
                            <p>kh&aacute;ch sạn n&agrave;y rất dễ t&igrave;m bởi vị tr&iacute; đắc địa, nằm gần với nhiều tiện &iacute;ch c&ocirc;ng cộng.</p>
                            <p><strong>Th&ocirc;ng tin về Gold Plaza Hotel Da Nang</strong></p>
                            <p>Kh&ocirc;ng chỉ sở hữu vị tr&iacute; gi&uacute;p qu&yacute; kh&aacute;ch dễ d&agrave;ng gh&eacute; thăm những địa điểm l&yacute; th&uacute; trong chuyến h&agrave;nh tr&igrave;nh, Gold Plaza Hotel Da Nang cũng sẽ mang đến cho qu&yacute; kh&aacute;ch trải nghiệm lưu tr&uacute; mỹ m&atilde;n.</p>
                            <p>Tọa lạc gần s&acirc;n bay, Gold Plaza Hotel Da Nang l&agrave; nơi nghỉ ngơi l&yacute; tưởng trong l&uacute;c qu&yacute; kh&aacute;ch đang chờ chuyến bay kế tiếp. Qu&yacute; kh&aacute;ch c&oacute; thể tận hưởng kh&ocirc;ng gian nghỉ dưỡng vừa &yacute; nơi đ&acirc;y trong qu&aacute; tr&igrave;nh qu&aacute; cảnh.</p>
                            <p>Khi lưu tr&uacute; tại kh&aacute;ch sạn th&igrave; nội thất v&agrave; kiến tr&uacute;c hẳn l&agrave; hai yếu tố quan trọng khiến qu&yacute; kh&aacute;ch m&atilde;n nh&atilde;n. Với thiết kế độc đ&aacute;o, Gold Plaza Hotel Da Nang mang đến kh&ocirc;ng gian lưu tr&uacute; l&agrave;m h&agrave;i l&ograve;ng qu&yacute; kh&aacute;ch.</p>', '<div class="css-1dbjc4n r-1awozwy r-18u37iz r-1h0z5md"><img src="https://s3-ap-southeast-1.amazonaws.com/cntres-assets-ap-southeast-1-250226768838-cf675839782fd369/imageResource/2016/12/23/1482486531890-cbaee7be1e0c71e690dba61a3ea68ae0.png" width="20" height="20" loading="lazy"> <span style="font-size: 14pt;"><strong>Tiện nghi chung</strong></span></div>
<ul>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">M&aacute;y lạnh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Tiệc chi&ecirc;u đ&atilde;i</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giữ đồ</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng gia đ&igrave;nh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng kh&ocirc;ng h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Hồ bơi</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giải tr&iacute;</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Khu vực h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Kh&ocirc;ng kh&oacute;i thuốc</div>
</li>
</ul>
<div class="ddict_btn" style="top: 23px; left: 780px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png"></div>'),
    (4, 'Nha Dep 4', 'HN', 2, 2, 80, 1234567, 10, 'https://static.vinwonders.com/production/homestay-la-gi-1.jpg', 'Đang trống', '2023-10-03', null, 5, '<p><strong>Vị tr&iacute;</strong><br>Lưu tr&uacute; tại Gold Plaza Hotel Da Nang l&agrave; một lựa chọn đ&uacute;ng đắn khi qu&yacute; kh&aacute;ch đến thăm Quận Hải Ch&acirc;u.</p>
                            <p>kh&aacute;ch sạn sở hữu vị tr&iacute; đắc địa c&aacute;ch s&acirc;n bay S&acirc;n bay quốc tế Đ&agrave; Nẵng (DAD) 2,51 km.</p>
                            <p>kh&aacute;ch sạn nằm c&aacute;ch Da Nang Railway Station 2,82 km.</p>
                            <p>kh&aacute;ch sạn n&agrave;y rất dễ t&igrave;m bởi vị tr&iacute; đắc địa, nằm gần với nhiều tiện &iacute;ch c&ocirc;ng cộng.</p>
                            <p><strong>Th&ocirc;ng tin về Gold Plaza Hotel Da Nang</strong></p>
                            <p>Kh&ocirc;ng chỉ sở hữu vị tr&iacute; gi&uacute;p qu&yacute; kh&aacute;ch dễ d&agrave;ng gh&eacute; thăm những địa điểm l&yacute; th&uacute; trong chuyến h&agrave;nh tr&igrave;nh, Gold Plaza Hotel Da Nang cũng sẽ mang đến cho qu&yacute; kh&aacute;ch trải nghiệm lưu tr&uacute; mỹ m&atilde;n.</p>
                            <p>Tọa lạc gần s&acirc;n bay, Gold Plaza Hotel Da Nang l&agrave; nơi nghỉ ngơi l&yacute; tưởng trong l&uacute;c qu&yacute; kh&aacute;ch đang chờ chuyến bay kế tiếp. Qu&yacute; kh&aacute;ch c&oacute; thể tận hưởng kh&ocirc;ng gian nghỉ dưỡng vừa &yacute; nơi đ&acirc;y trong qu&aacute; tr&igrave;nh qu&aacute; cảnh.</p>
                            <p>Khi lưu tr&uacute; tại kh&aacute;ch sạn th&igrave; nội thất v&agrave; kiến tr&uacute;c hẳn l&agrave; hai yếu tố quan trọng khiến qu&yacute; kh&aacute;ch m&atilde;n nh&atilde;n. Với thiết kế độc đ&aacute;o, Gold Plaza Hotel Da Nang mang đến kh&ocirc;ng gian lưu tr&uacute; l&agrave;m h&agrave;i l&ograve;ng qu&yacute; kh&aacute;ch.</p>', '<div class="css-1dbjc4n r-1awozwy r-18u37iz r-1h0z5md"><img src="https://s3-ap-southeast-1.amazonaws.com/cntres-assets-ap-southeast-1-250226768838-cf675839782fd369/imageResource/2016/12/23/1482486531890-cbaee7be1e0c71e690dba61a3ea68ae0.png" width="20" height="20" loading="lazy"> <span style="font-size: 14pt;"><strong>Tiện nghi chung</strong></span></div>
<ul>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">M&aacute;y lạnh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Tiệc chi&ecirc;u đ&atilde;i</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giữ đồ</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng gia đ&igrave;nh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng kh&ocirc;ng h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Hồ bơi</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giải tr&iacute;</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Khu vực h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Kh&ocirc;ng kh&oacute;i thuốc</div>
</li>
</ul>
<div class="ddict_btn" style="top: 23px; left: 780px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png"></div>'),
    (5, 'Nha Dep 5', 'HN', 2, 2, 80, 1234567, 10, 'https://static.vinwonders.com/production/homestay-la-gi-1.jpg', 'Đang trống', '2023-10-03', null, 5, '<p><strong>Vị tr&iacute;</strong><br>Lưu tr&uacute; tại Gold Plaza Hotel Da Nang l&agrave; một lựa chọn đ&uacute;ng đắn khi qu&yacute; kh&aacute;ch đến thăm Quận Hải Ch&acirc;u.</p>
                            <p>kh&aacute;ch sạn sở hữu vị tr&iacute; đắc địa c&aacute;ch s&acirc;n bay S&acirc;n bay quốc tế Đ&agrave; Nẵng (DAD) 2,51 km.</p>
                            <p>kh&aacute;ch sạn nằm c&aacute;ch Da Nang Railway Station 2,82 km.</p>
                            <p>kh&aacute;ch sạn n&agrave;y rất dễ t&igrave;m bởi vị tr&iacute; đắc địa, nằm gần với nhiều tiện &iacute;ch c&ocirc;ng cộng.</p>
                            <p><strong>Th&ocirc;ng tin về Gold Plaza Hotel Da Nang</strong></p>
                            <p>Kh&ocirc;ng chỉ sở hữu vị tr&iacute; gi&uacute;p qu&yacute; kh&aacute;ch dễ d&agrave;ng gh&eacute; thăm những địa điểm l&yacute; th&uacute; trong chuyến h&agrave;nh tr&igrave;nh, Gold Plaza Hotel Da Nang cũng sẽ mang đến cho qu&yacute; kh&aacute;ch trải nghiệm lưu tr&uacute; mỹ m&atilde;n.</p>
                            <p>Tọa lạc gần s&acirc;n bay, Gold Plaza Hotel Da Nang l&agrave; nơi nghỉ ngơi l&yacute; tưởng trong l&uacute;c qu&yacute; kh&aacute;ch đang chờ chuyến bay kế tiếp. Qu&yacute; kh&aacute;ch c&oacute; thể tận hưởng kh&ocirc;ng gian nghỉ dưỡng vừa &yacute; nơi đ&acirc;y trong qu&aacute; tr&igrave;nh qu&aacute; cảnh.</p>
                            <p>Khi lưu tr&uacute; tại kh&aacute;ch sạn th&igrave; nội thất v&agrave; kiến tr&uacute;c hẳn l&agrave; hai yếu tố quan trọng khiến qu&yacute; kh&aacute;ch m&atilde;n nh&atilde;n. Với thiết kế độc đ&aacute;o, Gold Plaza Hotel Da Nang mang đến kh&ocirc;ng gian lưu tr&uacute; l&agrave;m h&agrave;i l&ograve;ng qu&yacute; kh&aacute;ch.</p>', '<div class="css-1dbjc4n r-1awozwy r-18u37iz r-1h0z5md"><img src="https://s3-ap-southeast-1.amazonaws.com/cntres-assets-ap-southeast-1-250226768838-cf675839782fd369/imageResource/2016/12/23/1482486531890-cbaee7be1e0c71e690dba61a3ea68ae0.png" width="20" height="20" loading="lazy"> <span style="font-size: 14pt;"><strong>Tiện nghi chung</strong></span></div>
<ul>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">M&aacute;y lạnh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Tiệc chi&ecirc;u đ&atilde;i</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giữ đồ</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng gia đ&igrave;nh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng kh&ocirc;ng h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Hồ bơi</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giải tr&iacute;</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Khu vực h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Kh&ocirc;ng kh&oacute;i thuốc</div>
</li>
</ul>
<div class="ddict_btn" style="top: 23px; left: 780px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png"></div>'),
    (6, 'Nha Dep 6', 'HN', 2, 2, 100, 1234567, 10, 'https://static.vinwonders.com/production/homestay-la-gi-1.jpg', 'Đang trống', '2023-10-03', null, 5, '<p><strong>Vị tr&iacute;</strong><br>Lưu tr&uacute; tại Gold Plaza Hotel Da Nang l&agrave; một lựa chọn đ&uacute;ng đắn khi qu&yacute; kh&aacute;ch đến thăm Quận Hải Ch&acirc;u.</p>
                            <p>kh&aacute;ch sạn sở hữu vị tr&iacute; đắc địa c&aacute;ch s&acirc;n bay S&acirc;n bay quốc tế Đ&agrave; Nẵng (DAD) 2,51 km.</p>
                            <p>kh&aacute;ch sạn nằm c&aacute;ch Da Nang Railway Station 2,82 km.</p>
                            <p>kh&aacute;ch sạn n&agrave;y rất dễ t&igrave;m bởi vị tr&iacute; đắc địa, nằm gần với nhiều tiện &iacute;ch c&ocirc;ng cộng.</p>
                            <p><strong>Th&ocirc;ng tin về Gold Plaza Hotel Da Nang</strong></p>
                            <p>Kh&ocirc;ng chỉ sở hữu vị tr&iacute; gi&uacute;p qu&yacute; kh&aacute;ch dễ d&agrave;ng gh&eacute; thăm những địa điểm l&yacute; th&uacute; trong chuyến h&agrave;nh tr&igrave;nh, Gold Plaza Hotel Da Nang cũng sẽ mang đến cho qu&yacute; kh&aacute;ch trải nghiệm lưu tr&uacute; mỹ m&atilde;n.</p>
                            <p>Tọa lạc gần s&acirc;n bay, Gold Plaza Hotel Da Nang l&agrave; nơi nghỉ ngơi l&yacute; tưởng trong l&uacute;c qu&yacute; kh&aacute;ch đang chờ chuyến bay kế tiếp. Qu&yacute; kh&aacute;ch c&oacute; thể tận hưởng kh&ocirc;ng gian nghỉ dưỡng vừa &yacute; nơi đ&acirc;y trong qu&aacute; tr&igrave;nh qu&aacute; cảnh.</p>
                            <p>Khi lưu tr&uacute; tại kh&aacute;ch sạn th&igrave; nội thất v&agrave; kiến tr&uacute;c hẳn l&agrave; hai yếu tố quan trọng khiến qu&yacute; kh&aacute;ch m&atilde;n nh&atilde;n. Với thiết kế độc đ&aacute;o, Gold Plaza Hotel Da Nang mang đến kh&ocirc;ng gian lưu tr&uacute; l&agrave;m h&agrave;i l&ograve;ng qu&yacute; kh&aacute;ch.</p>', '<div class="css-1dbjc4n r-1awozwy r-18u37iz r-1h0z5md"><img src="https://s3-ap-southeast-1.amazonaws.com/cntres-assets-ap-southeast-1-250226768838-cf675839782fd369/imageResource/2016/12/23/1482486531890-cbaee7be1e0c71e690dba61a3ea68ae0.png" width="20" height="20" loading="lazy"> <span style="font-size: 14pt;"><strong>Tiện nghi chung</strong></span></div>
<ul>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">M&aacute;y lạnh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Tiệc chi&ecirc;u đ&atilde;i</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giữ đồ</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng gia đ&igrave;nh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng kh&ocirc;ng h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Hồ bơi</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giải tr&iacute;</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Khu vực h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Kh&ocirc;ng kh&oacute;i thuốc</div>
</li>
</ul>
<div class="ddict_btn" style="top: 23px; left: 780px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png"></div>'),
    (7, 'Nha Dep 7', 'HN', 2, 2, 80, 1234567, 10, 'https://static.vinwonders.com/production/homestay-la-gi-1.jpg', 'Đang trống', '2023-10-03', null, 5, '<p><strong>Vị tr&iacute;</strong><br>Lưu tr&uacute; tại Gold Plaza Hotel Da Nang l&agrave; một lựa chọn đ&uacute;ng đắn khi qu&yacute; kh&aacute;ch đến thăm Quận Hải Ch&acirc;u.</p>
                            <p>kh&aacute;ch sạn sở hữu vị tr&iacute; đắc địa c&aacute;ch s&acirc;n bay S&acirc;n bay quốc tế Đ&agrave; Nẵng (DAD) 2,51 km.</p>
                            <p>kh&aacute;ch sạn nằm c&aacute;ch Da Nang Railway Station 2,82 km.</p>
                            <p>kh&aacute;ch sạn n&agrave;y rất dễ t&igrave;m bởi vị tr&iacute; đắc địa, nằm gần với nhiều tiện &iacute;ch c&ocirc;ng cộng.</p>
                            <p><strong>Th&ocirc;ng tin về Gold Plaza Hotel Da Nang</strong></p>
                            <p>Kh&ocirc;ng chỉ sở hữu vị tr&iacute; gi&uacute;p qu&yacute; kh&aacute;ch dễ d&agrave;ng gh&eacute; thăm những địa điểm l&yacute; th&uacute; trong chuyến h&agrave;nh tr&igrave;nh, Gold Plaza Hotel Da Nang cũng sẽ mang đến cho qu&yacute; kh&aacute;ch trải nghiệm lưu tr&uacute; mỹ m&atilde;n.</p>
                            <p>Tọa lạc gần s&acirc;n bay, Gold Plaza Hotel Da Nang l&agrave; nơi nghỉ ngơi l&yacute; tưởng trong l&uacute;c qu&yacute; kh&aacute;ch đang chờ chuyến bay kế tiếp. Qu&yacute; kh&aacute;ch c&oacute; thể tận hưởng kh&ocirc;ng gian nghỉ dưỡng vừa &yacute; nơi đ&acirc;y trong qu&aacute; tr&igrave;nh qu&aacute; cảnh.</p>
                            <p>Khi lưu tr&uacute; tại kh&aacute;ch sạn th&igrave; nội thất v&agrave; kiến tr&uacute;c hẳn l&agrave; hai yếu tố quan trọng khiến qu&yacute; kh&aacute;ch m&atilde;n nh&atilde;n. Với thiết kế độc đ&aacute;o, Gold Plaza Hotel Da Nang mang đến kh&ocirc;ng gian lưu tr&uacute; l&agrave;m h&agrave;i l&ograve;ng qu&yacute; kh&aacute;ch.</p>', '<div class="css-1dbjc4n r-1awozwy r-18u37iz r-1h0z5md"><img src="https://s3-ap-southeast-1.amazonaws.com/cntres-assets-ap-southeast-1-250226768838-cf675839782fd369/imageResource/2016/12/23/1482486531890-cbaee7be1e0c71e690dba61a3ea68ae0.png" width="20" height="20" loading="lazy"> <span style="font-size: 14pt;"><strong>Tiện nghi chung</strong></span></div>
<ul>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">M&aacute;y lạnh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Tiệc chi&ecirc;u đ&atilde;i</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giữ đồ</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng gia đ&igrave;nh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng kh&ocirc;ng h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Hồ bơi</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giải tr&iacute;</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Khu vực h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Kh&ocirc;ng kh&oacute;i thuốc</div>
</li>
</ul>
<div class="ddict_btn" style="top: 23px; left: 780px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png"></div>'),
    (8, 'Nha Dep 8', 'HN', 2, 2, 100, 1234567, 10, 'https://static.vinwonders.com/production/homestay-la-gi-1.jpg', 'Đang trống', '2023-10-03', null, 5, '<p><strong>Vị tr&iacute;</strong><br>Lưu tr&uacute; tại Gold Plaza Hotel Da Nang l&agrave; một lựa chọn đ&uacute;ng đắn khi qu&yacute; kh&aacute;ch đến thăm Quận Hải Ch&acirc;u.</p>
                            <p>kh&aacute;ch sạn sở hữu vị tr&iacute; đắc địa c&aacute;ch s&acirc;n bay S&acirc;n bay quốc tế Đ&agrave; Nẵng (DAD) 2,51 km.</p>
                            <p>kh&aacute;ch sạn nằm c&aacute;ch Da Nang Railway Station 2,82 km.</p>
                            <p>kh&aacute;ch sạn n&agrave;y rất dễ t&igrave;m bởi vị tr&iacute; đắc địa, nằm gần với nhiều tiện &iacute;ch c&ocirc;ng cộng.</p>
                            <p><strong>Th&ocirc;ng tin về Gold Plaza Hotel Da Nang</strong></p>
                            <p>Kh&ocirc;ng chỉ sở hữu vị tr&iacute; gi&uacute;p qu&yacute; kh&aacute;ch dễ d&agrave;ng gh&eacute; thăm những địa điểm l&yacute; th&uacute; trong chuyến h&agrave;nh tr&igrave;nh, Gold Plaza Hotel Da Nang cũng sẽ mang đến cho qu&yacute; kh&aacute;ch trải nghiệm lưu tr&uacute; mỹ m&atilde;n.</p>
                            <p>Tọa lạc gần s&acirc;n bay, Gold Plaza Hotel Da Nang l&agrave; nơi nghỉ ngơi l&yacute; tưởng trong l&uacute;c qu&yacute; kh&aacute;ch đang chờ chuyến bay kế tiếp. Qu&yacute; kh&aacute;ch c&oacute; thể tận hưởng kh&ocirc;ng gian nghỉ dưỡng vừa &yacute; nơi đ&acirc;y trong qu&aacute; tr&igrave;nh qu&aacute; cảnh.</p>
                            <p>Khi lưu tr&uacute; tại kh&aacute;ch sạn th&igrave; nội thất v&agrave; kiến tr&uacute;c hẳn l&agrave; hai yếu tố quan trọng khiến qu&yacute; kh&aacute;ch m&atilde;n nh&atilde;n. Với thiết kế độc đ&aacute;o, Gold Plaza Hotel Da Nang mang đến kh&ocirc;ng gian lưu tr&uacute; l&agrave;m h&agrave;i l&ograve;ng qu&yacute; kh&aacute;ch.</p>', '<div class="css-1dbjc4n r-1awozwy r-18u37iz r-1h0z5md"><img src="https://s3-ap-southeast-1.amazonaws.com/cntres-assets-ap-southeast-1-250226768838-cf675839782fd369/imageResource/2016/12/23/1482486531890-cbaee7be1e0c71e690dba61a3ea68ae0.png" width="20" height="20" loading="lazy"> <span style="font-size: 14pt;"><strong>Tiện nghi chung</strong></span></div>
<ul>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">M&aacute;y lạnh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Tiệc chi&ecirc;u đ&atilde;i</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giữ đồ</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng gia đ&igrave;nh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng kh&ocirc;ng h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Hồ bơi</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giải tr&iacute;</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Khu vực h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Kh&ocirc;ng kh&oacute;i thuốc</div>
</li>
</ul>
<div class="ddict_btn" style="top: 23px; left: 780px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png"></div>'),
    (9, 'Nha Dep 9', 'HN', 2, 2, 80, 1234567, 10, 'https://static.vinwonders.com/production/homestay-la-gi-1.jpg', 'Đang trống', '2023-10-03', null, 5, '<p><strong>Vị tr&iacute;</strong><br>Lưu tr&uacute; tại Gold Plaza Hotel Da Nang l&agrave; một lựa chọn đ&uacute;ng đắn khi qu&yacute; kh&aacute;ch đến thăm Quận Hải Ch&acirc;u.</p>
                            <p>kh&aacute;ch sạn sở hữu vị tr&iacute; đắc địa c&aacute;ch s&acirc;n bay S&acirc;n bay quốc tế Đ&agrave; Nẵng (DAD) 2,51 km.</p>
                            <p>kh&aacute;ch sạn nằm c&aacute;ch Da Nang Railway Station 2,82 km.</p>
                            <p>kh&aacute;ch sạn n&agrave;y rất dễ t&igrave;m bởi vị tr&iacute; đắc địa, nằm gần với nhiều tiện &iacute;ch c&ocirc;ng cộng.</p>
                            <p><strong>Th&ocirc;ng tin về Gold Plaza Hotel Da Nang</strong></p>
                            <p>Kh&ocirc;ng chỉ sở hữu vị tr&iacute; gi&uacute;p qu&yacute; kh&aacute;ch dễ d&agrave;ng gh&eacute; thăm những địa điểm l&yacute; th&uacute; trong chuyến h&agrave;nh tr&igrave;nh, Gold Plaza Hotel Da Nang cũng sẽ mang đến cho qu&yacute; kh&aacute;ch trải nghiệm lưu tr&uacute; mỹ m&atilde;n.</p>
                            <p>Tọa lạc gần s&acirc;n bay, Gold Plaza Hotel Da Nang l&agrave; nơi nghỉ ngơi l&yacute; tưởng trong l&uacute;c qu&yacute; kh&aacute;ch đang chờ chuyến bay kế tiếp. Qu&yacute; kh&aacute;ch c&oacute; thể tận hưởng kh&ocirc;ng gian nghỉ dưỡng vừa &yacute; nơi đ&acirc;y trong qu&aacute; tr&igrave;nh qu&aacute; cảnh.</p>
                            <p>Khi lưu tr&uacute; tại kh&aacute;ch sạn th&igrave; nội thất v&agrave; kiến tr&uacute;c hẳn l&agrave; hai yếu tố quan trọng khiến qu&yacute; kh&aacute;ch m&atilde;n nh&atilde;n. Với thiết kế độc đ&aacute;o, Gold Plaza Hotel Da Nang mang đến kh&ocirc;ng gian lưu tr&uacute; l&agrave;m h&agrave;i l&ograve;ng qu&yacute; kh&aacute;ch.</p>', '<div class="css-1dbjc4n r-1awozwy r-18u37iz r-1h0z5md"><img src="https://s3-ap-southeast-1.amazonaws.com/cntres-assets-ap-southeast-1-250226768838-cf675839782fd369/imageResource/2016/12/23/1482486531890-cbaee7be1e0c71e690dba61a3ea68ae0.png" width="20" height="20" loading="lazy"> <span style="font-size: 14pt;"><strong>Tiện nghi chung</strong></span></div>
<ul>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">M&aacute;y lạnh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Tiệc chi&ecirc;u đ&atilde;i</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giữ đồ</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng gia đ&igrave;nh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng kh&ocirc;ng h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Hồ bơi</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giải tr&iacute;</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Khu vực h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Kh&ocirc;ng kh&oacute;i thuốc</div>
</li>
</ul>
<div class="ddict_btn" style="top: 23px; left: 780px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png"></div>'),
    (10, 'Nha Dep 10', 'HN', 2, 2, 80, 1234567, 10, 'https://static.vinwonders.com/production/homestay-la-gi-1.jpg', 'Đang trống', '2023-10-03', null, 5, '<p><strong>Vị tr&iacute;</strong><br>Lưu tr&uacute; tại Gold Plaza Hotel Da Nang l&agrave; một lựa chọn đ&uacute;ng đắn khi qu&yacute; kh&aacute;ch đến thăm Quận Hải Ch&acirc;u.</p>
                            <p>kh&aacute;ch sạn sở hữu vị tr&iacute; đắc địa c&aacute;ch s&acirc;n bay S&acirc;n bay quốc tế Đ&agrave; Nẵng (DAD) 2,51 km.</p>
                            <p>kh&aacute;ch sạn nằm c&aacute;ch Da Nang Railway Station 2,82 km.</p>
                            <p>kh&aacute;ch sạn n&agrave;y rất dễ t&igrave;m bởi vị tr&iacute; đắc địa, nằm gần với nhiều tiện &iacute;ch c&ocirc;ng cộng.</p>
                            <p><strong>Th&ocirc;ng tin về Gold Plaza Hotel Da Nang</strong></p>
                            <p>Kh&ocirc;ng chỉ sở hữu vị tr&iacute; gi&uacute;p qu&yacute; kh&aacute;ch dễ d&agrave;ng gh&eacute; thăm những địa điểm l&yacute; th&uacute; trong chuyến h&agrave;nh tr&igrave;nh, Gold Plaza Hotel Da Nang cũng sẽ mang đến cho qu&yacute; kh&aacute;ch trải nghiệm lưu tr&uacute; mỹ m&atilde;n.</p>
                            <p>Tọa lạc gần s&acirc;n bay, Gold Plaza Hotel Da Nang l&agrave; nơi nghỉ ngơi l&yacute; tưởng trong l&uacute;c qu&yacute; kh&aacute;ch đang chờ chuyến bay kế tiếp. Qu&yacute; kh&aacute;ch c&oacute; thể tận hưởng kh&ocirc;ng gian nghỉ dưỡng vừa &yacute; nơi đ&acirc;y trong qu&aacute; tr&igrave;nh qu&aacute; cảnh.</p>
                            <p>Khi lưu tr&uacute; tại kh&aacute;ch sạn th&igrave; nội thất v&agrave; kiến tr&uacute;c hẳn l&agrave; hai yếu tố quan trọng khiến qu&yacute; kh&aacute;ch m&atilde;n nh&atilde;n. Với thiết kế độc đ&aacute;o, Gold Plaza Hotel Da Nang mang đến kh&ocirc;ng gian lưu tr&uacute; l&agrave;m h&agrave;i l&ograve;ng qu&yacute; kh&aacute;ch.</p>', '<div class="css-1dbjc4n r-1awozwy r-18u37iz r-1h0z5md"><img src="https://s3-ap-southeast-1.amazonaws.com/cntres-assets-ap-southeast-1-250226768838-cf675839782fd369/imageResource/2016/12/23/1482486531890-cbaee7be1e0c71e690dba61a3ea68ae0.png" width="20" height="20" loading="lazy"> <span style="font-size: 14pt;"><strong>Tiện nghi chung</strong></span></div>
<ul>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">M&aacute;y lạnh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Tiệc chi&ecirc;u đ&atilde;i</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giữ đồ</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng gia đ&igrave;nh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng kh&ocirc;ng h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Hồ bơi</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giải tr&iacute;</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Khu vực h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Kh&ocirc;ng kh&oacute;i thuốc</div>
</li>
</ul>
<div class="ddict_btn" style="top: 23px; left: 780px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png"></div>'),
    (11, 'Nha Dep 11', 'HN', 2, 2, 100, 1234567, 10, 'https://static.vinwonders.com/production/homestay-la-gi-1.jpg', 'Đang trống', '2023-10-03', null, 5, '<p><strong>Vị tr&iacute;</strong><br>Lưu tr&uacute; tại Gold Plaza Hotel Da Nang l&agrave; một lựa chọn đ&uacute;ng đắn khi qu&yacute; kh&aacute;ch đến thăm Quận Hải Ch&acirc;u.</p>
                            <p>kh&aacute;ch sạn sở hữu vị tr&iacute; đắc địa c&aacute;ch s&acirc;n bay S&acirc;n bay quốc tế Đ&agrave; Nẵng (DAD) 2,51 km.</p>
                            <p>kh&aacute;ch sạn nằm c&aacute;ch Da Nang Railway Station 2,82 km.</p>
                            <p>kh&aacute;ch sạn n&agrave;y rất dễ t&igrave;m bởi vị tr&iacute; đắc địa, nằm gần với nhiều tiện &iacute;ch c&ocirc;ng cộng.</p>
                            <p><strong>Th&ocirc;ng tin về Gold Plaza Hotel Da Nang</strong></p>
                            <p>Kh&ocirc;ng chỉ sở hữu vị tr&iacute; gi&uacute;p qu&yacute; kh&aacute;ch dễ d&agrave;ng gh&eacute; thăm những địa điểm l&yacute; th&uacute; trong chuyến h&agrave;nh tr&igrave;nh, Gold Plaza Hotel Da Nang cũng sẽ mang đến cho qu&yacute; kh&aacute;ch trải nghiệm lưu tr&uacute; mỹ m&atilde;n.</p>
                            <p>Tọa lạc gần s&acirc;n bay, Gold Plaza Hotel Da Nang l&agrave; nơi nghỉ ngơi l&yacute; tưởng trong l&uacute;c qu&yacute; kh&aacute;ch đang chờ chuyến bay kế tiếp. Qu&yacute; kh&aacute;ch c&oacute; thể tận hưởng kh&ocirc;ng gian nghỉ dưỡng vừa &yacute; nơi đ&acirc;y trong qu&aacute; tr&igrave;nh qu&aacute; cảnh.</p>
                            <p>Khi lưu tr&uacute; tại kh&aacute;ch sạn th&igrave; nội thất v&agrave; kiến tr&uacute;c hẳn l&agrave; hai yếu tố quan trọng khiến qu&yacute; kh&aacute;ch m&atilde;n nh&atilde;n. Với thiết kế độc đ&aacute;o, Gold Plaza Hotel Da Nang mang đến kh&ocirc;ng gian lưu tr&uacute; l&agrave;m h&agrave;i l&ograve;ng qu&yacute; kh&aacute;ch.</p>', '<div class="css-1dbjc4n r-1awozwy r-18u37iz r-1h0z5md"><img src="https://s3-ap-southeast-1.amazonaws.com/cntres-assets-ap-southeast-1-250226768838-cf675839782fd369/imageResource/2016/12/23/1482486531890-cbaee7be1e0c71e690dba61a3ea68ae0.png" width="20" height="20" loading="lazy"> <span style="font-size: 14pt;"><strong>Tiện nghi chung</strong></span></div>
<ul>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">M&aacute;y lạnh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Tiệc chi&ecirc;u đ&atilde;i</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giữ đồ</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng gia đ&igrave;nh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng kh&ocirc;ng h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Hồ bơi</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giải tr&iacute;</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Khu vực h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Kh&ocirc;ng kh&oacute;i thuốc</div>
</li>
</ul>
<div class="ddict_btn" style="top: 23px; left: 780px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png"></div>'),
    (12, 'Nha Dep 12', 'HN', 2, 2, 90, 1234567, 10, 'https://static.vinwonders.com/production/homestay-la-gi-1.jpg', 'Đang trống', '2023-10-03', null, 5, '<p><strong>Vị tr&iacute;</strong><br>Lưu tr&uacute; tại Gold Plaza Hotel Da Nang l&agrave; một lựa chọn đ&uacute;ng đắn khi qu&yacute; kh&aacute;ch đến thăm Quận Hải Ch&acirc;u.</p>
                            <p>kh&aacute;ch sạn sở hữu vị tr&iacute; đắc địa c&aacute;ch s&acirc;n bay S&acirc;n bay quốc tế Đ&agrave; Nẵng (DAD) 2,51 km.</p>
                            <p>kh&aacute;ch sạn nằm c&aacute;ch Da Nang Railway Station 2,82 km.</p>
                            <p>kh&aacute;ch sạn n&agrave;y rất dễ t&igrave;m bởi vị tr&iacute; đắc địa, nằm gần với nhiều tiện &iacute;ch c&ocirc;ng cộng.</p>
                            <p><strong>Th&ocirc;ng tin về Gold Plaza Hotel Da Nang</strong></p>
                            <p>Kh&ocirc;ng chỉ sở hữu vị tr&iacute; gi&uacute;p qu&yacute; kh&aacute;ch dễ d&agrave;ng gh&eacute; thăm những địa điểm l&yacute; th&uacute; trong chuyến h&agrave;nh tr&igrave;nh, Gold Plaza Hotel Da Nang cũng sẽ mang đến cho qu&yacute; kh&aacute;ch trải nghiệm lưu tr&uacute; mỹ m&atilde;n.</p>
                            <p>Tọa lạc gần s&acirc;n bay, Gold Plaza Hotel Da Nang l&agrave; nơi nghỉ ngơi l&yacute; tưởng trong l&uacute;c qu&yacute; kh&aacute;ch đang chờ chuyến bay kế tiếp. Qu&yacute; kh&aacute;ch c&oacute; thể tận hưởng kh&ocirc;ng gian nghỉ dưỡng vừa &yacute; nơi đ&acirc;y trong qu&aacute; tr&igrave;nh qu&aacute; cảnh.</p>
                            <p>Khi lưu tr&uacute; tại kh&aacute;ch sạn th&igrave; nội thất v&agrave; kiến tr&uacute;c hẳn l&agrave; hai yếu tố quan trọng khiến qu&yacute; kh&aacute;ch m&atilde;n nh&atilde;n. Với thiết kế độc đ&aacute;o, Gold Plaza Hotel Da Nang mang đến kh&ocirc;ng gian lưu tr&uacute; l&agrave;m h&agrave;i l&ograve;ng qu&yacute; kh&aacute;ch.</p>', '<div class="css-1dbjc4n r-1awozwy r-18u37iz r-1h0z5md"><img src="https://s3-ap-southeast-1.amazonaws.com/cntres-assets-ap-southeast-1-250226768838-cf675839782fd369/imageResource/2016/12/23/1482486531890-cbaee7be1e0c71e690dba61a3ea68ae0.png" width="20" height="20" loading="lazy"> <span style="font-size: 14pt;"><strong>Tiện nghi chung</strong></span></div>
<ul>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">M&aacute;y lạnh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Tiệc chi&ecirc;u đ&atilde;i</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giữ đồ</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng gia đ&igrave;nh</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng kh&ocirc;ng h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Hồ bơi</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Ph&ograve;ng giải tr&iacute;</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Khu vực h&uacute;t thuốc</div>
</li>
<li>
<div class="css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-fdjqy7" dir="auto">Kh&ocirc;ng kh&oacute;i thuốc</div>
</li>
</ul>
<div class="ddict_btn" style="top: 23px; left: 780px;"><img src="chrome-extension://bpggmmljdiliancllaapiggllnkbjocb/logo/48.png"></div>');

INSERT IGNORE INTO booking(id, start_time, end_time, create_at, total, status, house_id, account_id) values
    (1, '2023-10-10', '2023-10-15', '2023-10-08', 20000000, 'Đã trả phòng', 1, 6),
    (2, '2023-10-16', '2023-10-18', '2023-10-08', 10000000, 'Đã trả phòng', 2, 6),
    (3, '2023-10-19', '2023-10-21', '2023-10-08', 10000000, 'Đã trả phòng', 3, 6),
    (4, '2023-10-22', '2023-10-24', '2023-10-08', 10000000, 'Đã trả phòng', 4, 6),
    (5, '2023-10-25', '2023-10-27', '2023-10-08', 10000000, 'Đã trả phòng', 5, 6),
    (6, '2023-10-28', '2023-10-30', '2023-10-08', 10000000, 'Đã trả phòng', 6, 6);

INSERT IGNORE INTO review(id, comment, status, rating, create_at, booking_id) values
    (1, 'Qua dep', 'Hiện', 4.4, '2023-10-05', 1);

