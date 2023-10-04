USE booking_house;

INSERT INTO role(id, name)
values (1,'ROLE_USER'),
       (2,'ROLE_ADMIN'),
       (3,'ROLE_OWNER');

INSERT INTO account(id, username, password, firstname, lastname, address, email, phone, avatar, wallet, status)
values (1, 'abc', '1', 'A', 'B', 'ABC', 'abc@gmail.com', '099999999', 'https://cdn-icons-png.flaticon.com/512/3177/3177440.png', 10000, 'ok');


INSERT INTO house(id, name, address, bedroom, bathroom, old_price, new_price, thumbnail, status, create_at, update_at, owner_id, category_id, description, facility)
values (1, 'Nha Dep', 'HN', 2, 2, 1234567, 1000000, 'https://static.vinwonders.com/production/homestay-la-gi-1.jpg', 'Dang Trong', '2023-10-03', null, 1, null, '<p><strong>Vị tr&iacute;</strong><br>Lưu tr&uacute; tại Gold Plaza Hotel Da Nang l&agrave; một lựa chọn đ&uacute;ng đắn khi qu&yacute; kh&aacute;ch đến thăm Quận Hải Ch&acirc;u.</p>
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

INSERT INTO image(id, url, house_id) values
                                         (1, 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/406023161.jpg?k=31be8fcb8f7feb6cc33b055eeb9abd7f65b8659ce70c55083a2b89dfda797fa3&o=&hp=1', 1),
                                         (2, 'https://tecwoodoutdoorfloor.com/upload/images/Blog/homestay-dep5.jpg', 1),
                                         (3, 'https://sakos.vn/wp-content/uploads/2023/05/momo-upload-api-220510091852-637877711328579007.jpeg', 1),
                                         (4, 'https://dulich9.com/wp-content/uploads/2021/05/The-muse-homestay-01.png', 1);

INSERT INTO booking(id, start_time, end_time, total, status, house_id, account_id) values
    (1, '2023-10-01', '2023-10-05', 20000000, 'ok', 1, 1);

INSERT INTO review(id, comment, status, rating, create_at, booking_id) values
    (1, 'Qua dep', 'ok', 4.4, '2023-10-02', 1);

