--
-- File generated with SQLiteStudio v3.4.4 on Wed Apr 17 21:43:53 2024
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Product
CREATE TABLE IF NOT EXISTS Product (
    ProductId          TEXT    PRIMARY KEY
                               NOT NULL
                               UNIQUE,
    ProductName        TEXT    NOT NULL,
    ProductPrice       NUMERIC,
    ProductQuantity    NUMERIC,
    ProductCategory    NUMERIC,
    ProductDescribtion NUMERIC,
    ProductImg         TEXT,
    ProductRating      REAL
);

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOBA0001',
                        'Bàn console kim lo?i vàng',
                        10900000,
                        20,
                        'Bàn;Bàn Console;Phòng khách',
                        'Bàn Console hay còn g?i là bàn trang trí, s?n ph?m có th? d? nh?ng d? v?t nhu khung ?nh gia dình, các s?n ph?m trang trí, giúp cho nh?ng m?ng tu?ng tr?ng c?a nhà b?n tr? nên sinh d?ng hon.',
                        'https://i.imgur.com/C5TSIhD.png;https://i.imgur.com/dlEmxEx.png;https://i.imgur.com/rmMsp4u.png
',
                        4.5
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOBA0002

',
                        'Bàn console Secret 2 ngan',
                        15000000,
                        20,
                        'Bàn;Bàn console;Phòng khách',
                        'Bàn Console hay còn g?i là bàn trang trí, s?n ph?m có th? d? nh?ng d? v?t nhu khung ?nh gia dình, các s?n ph?m trang trí, giúp cho nh?ng m?ng tu?ng tr?ng c?a nhà b?n tr? nên sinh d?ng hon.

',
                        'https://i.imgur.com/l1xNFpQ.png;https://i.imgur.com/KNIv33C.png;https://i.imgur.com/fodd4Sd.png',
                        5.0
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOBA0003',
                        'Bàn trang di?m g? mây dan',
                        12000000,
                        20,
                        'Bàn;Bàn trang di?m;Phòng ng?',
                        'Bàn trang di?m Mây mang ki?u dáng n? tính, trang nhã, c?ng thêm m?t chút duyên dáng. Ph?n h?c kéo ti?n l?i s? là noi luu tr? g?n gàng các v?t d?ng c?a nh?ng quý cô. V?i các chi ti?t b?c mây di?m xuy?t cho s?n ph?m thêm ph?n tinh t?, d?c dáo. Ðây s? là l?a ch?n hoàn h?o cho các gia ch? yêu thích phong cách c? di?n pha l?n m?t chút hi?n d?i.  

',
                        'https://i.imgur.com/wOEkl5o.png;https://i.imgur.com/BIgb3Uz.png;https://i.imgur.com/oRmrrGM.png',
                        4.3
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOBA3004

',
                        'Bàn d?u giu?ng Neoclassical 3 ngan b?ng g? tr?ng ng?c trai',
                        11500000,
                        20,
                        'Bàn;Bàn d?u giu?ng;Neoclassical;Phòng ng?',
                        'Bàn d?u giu?ng Neoclassical 3 ngan son Lacquer 7 l?p, mang d?n v? quý phái v?i hoa van c? di?n Pháp. Ðu?c ngh? nhân ch?m tr? tinh x?o, màu son vàng d?ng n?i b?t trên n?n tr?ng ng?c trai, t?o di?m nh?n sang tr?ng, hoàn h?o cho không gian phòng ng?.

',
                        'https://i.imgur.com/SxCmWac.png;https://i.imgur.com/EskqKvA.png;https://i.imgur.com/JYVbE9S.png',
                        4.5
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOBA4005

',
                        'Bàn Twist Tropical g? s?i nâu t? nhiên',
                        5100000,
                        20,
                        'Bàn;Bàn an;Phòng b?p;Tropical; Phòng b?p',
                        'Bàn Twist Tropical g? s?i nâu t? nhiên, kích thu?c 80 x 140 x 720 cm. Ch?t li?u khung g? s?i và m?t g? ghép, son màu t? nhiên ho?c màu Wanut. Ph?n c?nh m?t bàn du?c làm vát me´p, t?o s? nh? nhàng và tinh t? trong thi?t k? n?i th?t.',
                        'https://i.imgur.com/8RkLjaj.png;https://i.imgur.com/It0JMF7.png;https://i.imgur.com/mG2Ud8J.png',
                        4.5
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOBA4006

',
                        'Bàn trà Tropical mây dan 2 t?ng kính',
                        3190000,
                        20,
                        'Bàn;Bàn cà phê, trà; Tropical;Phòng khách',
                        'Bàn trà Tropical mây dan 2 t?ng kính, k?t h?p mây t? nhiên và khung g? s?i nguyên kh?i. Kích thu?c 86cm x 86cm x 45cm, thi?t k? tinh t?, ti?n ích cho không gian hi?n d?i.',
                        'https://i.imgur.com/POrcWEz.png;https://i.imgur.com/R3Ow8BZ.png;https://i.imgur.com/ElWLDbT.png',
                        5.0
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOGH0001',
                        'Sofa 2 ch? n?m b?c v?i xanh',
                        17900000,
                        20,
                        'Gh?;Sofa;Phòng khách;Phòng ng?',
                        'Sofa n?m b?c v?i xanh gây ?n tu?ng b?ng nh?ng du?ng cong b?ng b?nh, theo xu hu?ng Modern Organic – g?n gui v?i thiên nhiên mà v?n hi?n d?i, tho?i mái. C?m giác êm ái và thu thái s? là nh?ng tính t? d?u tiên du?c nh?c d?n khi tr?i nghi?m v?i chi?c sofa này.

',
                        'https://i.imgur.com/2B8nGWl.png;https://i.imgur.com/Em0jBTP.png;https://i.imgur.com/WBwkvzn.png',
                        4.6
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOGH0002',
                        'Sofa don n?m b?c v?i xanh',
                        9800000,
                        20,
                        'Gh?;Sofa;Phòng khách',
                        'Sofa n?m b?c v?i xanh gây ?n tu?ng b?ng nh?ng du?ng cong b?ng b?nh, theo xu hu?ng Modern Organic – g?n gui v?i thiên nhiên mà v?n hi?n d?i, tho?i mái. C?m giác êm ái và thu thái s? là nh?ng tính t? d?u tiên du?c nh?c d?n khi tr?i nghi?m v?i chi?c sofa này.

',
                        'https://i.imgur.com/lAMFOXu.png;https://i.imgur.com/x3Y7T14.png;https://i.imgur.com/BYaB0xj.png',
                        4.0
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOGH0003',
                        'Sofa 2 ch? v?i bông h?ng',
                        11000000,
                        20,
                        'Gh?;Sofa;Phòng khách;Phòng ng?',
                        'M?t chi?c sofa nh? g?n cho can h? c?a b?n nhung v?n mang v? hi?n d?i. Ph?n t?a lung c?a sofa moon v?i du?ng nét bo tròn, nghiêng h? tr? t?i da cho vi?c ngh? ngoi thu giãn. Ch?t li?u v?i bông m?m t?o s? tho?i mái khi ng?i k?t h?p v?i màu s?c pastel nh? nhàng s? là gi?i pháp l?a ch?n t?i uu dành cho không gian n?i th?t can h? có di?n tích khiêm t?n.  

',
                        'https://i.imgur.com/cA7H4hv.png;https://i.imgur.com/aKH7Pij.png;https://i.imgur.com/KqzFTxT.png',
                        5.0
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOGH1004',
                        'Sofa don Indochine g? dan mây nâu den
',
                        5400000,
                        20,
                        'Gh?;Sofa;Phòng khách;Indochine',
                        'Sofa don Indochine g? dan mây nâu den là s? k?t h?p hoàn h?o gi?a g? s?i t?n bì và dan mây t? nhiên. Khung g? t?n bì có th? son màu Walnut, Brown ho?c Nature. Ch?t li?u b?n b? t? g? t?n bì, n?m Simili Cleo ho?c v?i n? cao c?p. Kích thu?c gh?: 800x800 x 450 (mm), t?a cao 900mm. Thi?t k? d?c dáo và ch?t li?u cao c?p d?m b?o s? tho?i mái và d?ng c?p cho không gian ngh? ngoi c?a b?n.

',
                        'https://i.imgur.com/yIzqScf.png;https://i.imgur.com/MWT5iVF.png;https://i.imgur.com/CmRsXWz.png',
                        4.0
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOGH1005',
                        'Sofa Indochine g? dan mây nâu den

',
                        8900000,
                        20,
                        'Gh?;Sofa;Phòng khách;Indochine',
                        'Sofa Indochine g? s?i t?n bì k?t h?p dan mây t? nhiên, v?i kích thu?c 2m3 x 0.8m x 0.9m. Ch?t li?u mây nh?a nh?p kh?u t? Indonesia, nh? nhàng và m?m m?i, tang thêm s? tho?i mái cho không gian ngh? ngoi. Thi?t k? d?c dáo và ch?t li?u d?ng c?p t?o nên m?t s?n ph?m sofa sang tr?ng và ?n tu?ng.

',
                        'https://i.imgur.com/UaZ1i4e.png;https://i.imgur.com/9G4Bj9W.png;https://i.imgur.com/wzJ8aJ2.png',
                        4.2
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOGH2006',
                        'Gh? an Minimalism g? cao su màu nâu

',
                        1990000,
                        20,
                        'Gh?;Gh? an; Phòng b?p;Mimimalism',
                        'Gh? an Minimalism có m?t khung g?n nh? và thon g?n v?i kích th?c 50cm x 56cm x 47cm/80cm, thu?ng làm t? ch?t li?u nhu g? ho?c kim lo?i. V?i du?ng nét don gi?n và không có nh?ng chi ti?t ph?c t?p, gh? an này t?o c?m giác g?n gàng và không gian trong phòng an.

',
                        'https://i.imgur.com/ukIBNho.png;https://i.imgur.com/ZsSNLfV.png;https://i.imgur.com/pAn2xh0.png',
                        4.5
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOGH3007

',
                        'Gh? an Neoclassical g? b?c v?i tuýt nâu b?c',
                        1600000,
                        20,
                        'Gh?;Gh? an;Phòng b?p; Neoclassical',
                        'Gh? an Neoclassical g? b?c v?i tuýt nâu b?c, kích thu?c 4,61W x 68,58D x 107,95H. Chân hình thanh ki?m c? di?n, khung g? l? ra ngoài du?c trang trí b?ng son b?c m?m, t?o di?m nh?n d?c dáo. Gh? n?i b?t v?i ph?n lung hình b?u d?c và ch? ng?i ch?t h?p, b?c b?ng v?i tuýt ch?i bóng lung linh, mang d?n s? sang tr?ng và d? ?m áp cho không gian bàn an. Gh? du?c thi?t k? v?i s? tho?i mái cao c?p v?i n?m và lung b?c ngoài.

',
                        'https://i.imgur.com/hc4aRxz.png;https://i.imgur.com/AAXNwsh.png;https://i.imgur.com/xsPxcc0.png',
                        4.5
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOGH4008',
                        'Gh? Wishbone Tropical g? t?n bì dan cói nâu sáng

',
                        2100000,
                        20,
                        'Gh?;Gh? an;Phòng b?p;Tropical',
                        'Gh? Wishbone Tropical là tác ph?m ngh? thu?t v?i khung g? t?n bì và dan cói nâu sáng. Màu s?c t? nhiên và nâu t?o di?m nh?n tinh t?. Kích thu?c x?p x? 45cm chi?u cao m?t ng?i, cao 75cm và r?ng 55x50cm, t?o nên s? tho?i mái và phong cách cho không gian. Thi?t k? hi?n d?i và ch?t li?u t? nhiên k?t h?p, Gh? Wishbone Tropical là s? l?a ch?n lý tu?ng d? làm m?i không gian n?i th?t c?a b?n.

',
                        'https://i.imgur.com/RSOWRFp.png;https://i.imgur.com/0Wa08pa.png;https://i.imgur.com/or7P5LR.png',
                        4.4
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOGI0001

',
                        'Giu?ng nâng magenta da 1m8',
                        80000000,
                        20,
                        'Giu?ng;Phòng ng?',
                        'Giu?ng nâng magenta da 1m8 có thi?t k? ph?n chân g?, du?c b?c da Espirit t? nhiên cao c?p màu taupe, giu?ng nâng toàn ph?n công nang ch?a d?ng nhi?u v?t d?ng, d? dùng cá nhân m?t cách ti?n l?i.  

',
                        'https://i.imgur.com/W5xK44u.png;https://i.imgur.com/R0pN3gr.png;https://i.imgur.com/7rhJ6bJ.png',
                        4.2
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOGI1002',
                        'Giu?ng Indochine 1m8x2m g? nâu den

',
                        22900000,
                        20,
                        'Giu?ng; Phòng ng?; Indochine',
                        'Giu?ng Indochine 1m8x2m g? nâu den là di?m nh?n sang tr?ng trong không gian ngh? ngoi. Ch? tác t? g? s?i t?n bì t? nhiên nh?p kh?u, giu?ng mang d?n nét d?p m?c m?c và d?ng c?p. V?i kích thu?c 1m8x2m, nó t?o ra không gian tho?i mái và sang tr?ng cho gi?c ng?. S? k?t h?p gi?a ch?t li?u cao c?p và thi?t k? hi?n d?i làm cho giu?ng Indochine tr? thành di?m nh?n quan tr?ng trong trang trí n?i th?t.',
                        'https://i.imgur.com/prmQUH2.png;https://i.imgur.com/yWKJddq.png;https://i.imgur.com/NfzpFAB.png',
                        4.1
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOGI2003',
                        'Giu?ng Minimalism 1m8x2m b?c da nâu

',
                        57900000,
                        20,
                        'Giu?ng;Phòng ng?;Minimalism',
                        'Giu?ng Minimalism 1m8x2m b?c da nâu là bi?u tu?ng c?a s? t?i gi?n và sang tr?ng. Chân g? và khung g? b?c da Esprit cao c?p, t?o nên không gian ng? d?ng c?p. B?c da nâu ?m áp và m?m m?i, k?t h?p v?i kích thu?c r?ng rãi 1m8x2m, giu?ng không ch? là noi ngh? ngoi mà còn là tác ph?m ngh? thu?t hi?n d?i trong không gian phòng ng? c?a b?n. Th? mình vào s? tho?i mái và d?ng c?p v?i Giu?ng Minimalism.

',
                        'https://i.imgur.com/4XYDs34.png;https://i.imgur.com/gKFmNxf.png;https://i.imgur.com/giQj7pP.png',
                        4.3
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOGI3004',
                        'Giu?ng Neoclassical 1m8x2m b?c da màu tr?ng',
                        39900000,
                        20,
                        'Giu?ng;Phòng ng?;Neoclassical',
                        'Giu?ng Neoclassical 1m8x2m b?c da màu tr?ng là di?m nh?n tinh t? trong phòng ng?. Khung g? và b?c da t?o nên v? sang tr?ng, k?t h?p s? tho?i mái và d?ng c?p. V?i kích thu?c 1m8x2m, giu?ng không ch? là noi ngh? ngoi mà còn là ph?n quan tr?ng c?a thi?t k? n?i th?t. Màu tr?ng tinh khôi, ch?t li?u b?c da m?m m?i làm tang thêm s? êm d?u và ?m áp cho không gian ng? c?a b?n. Thu giãn và d?m chìm trong s? sang tr?ng v?i Giu?ng Neoclassical này.

',
                        'https://i.imgur.com/EE40tNk.png;https://i.imgur.com/piMpnpC.png;https://i.imgur.com/mowtOtg.png',
                        4.6
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOGI4005',
                        'Giu?ng Tropicall 1m8x2m g? công nghi?p màu t? nhiên',
                        8900000,
                        20,
                        'Giu?ng;Phòng ng?;Tropical',
                        'Giu?ng Tropical 1m8x2m g? công nghi?p màu t? nhiên là l?a ch?n d?p và ti?n ích cho phòng ng?. Ch? tác t? G? Công Nghi?p, giu?ng mang d?n v? don gi?n và m?c m?c. Ch?ng m?i m?t, ch?t li?u G? MDF ph? melamine ch?ng tr?y xu?c và cong vênh, d?m b?o d? b?n và d? b?o qu?n. V?i kích thu?c 1m8x2m, Giu?ng Tropical là s? k?t h?p hoàn h?o gi?a thi?t k? hi?n d?i và tính ?ng d?ng.

',
                        'https://i.imgur.com/vMiL4Ux.png;https://i.imgur.com/q161RWm.png;https://i.imgur.com/h1tBhHp.png',
                        4.5
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOTK0001',
                        'T? qu?n áo Wabrobe g? nâu',
                        75000000,
                        20,
                        'T? k?;T? qu?n áo;Phòng ng?',
                        'T? áo Wabrobe là m?t s?n ph?m n?i th?t ch?t lu?ng cao du?c thi?t k? d? c?i thi?n không gian luu tr? trong phòng ng? ho?c phòng thay d?. V?i ch?t li?u chính là MDF Laminate, t? áo này mang l?i s? b?n b? và d? b?n cao, d?ng th?i d? dàng v? sinh và b?o qu?n. Kích thu?c c?a t? áo là D3800mm (chi?u dài) - R670mm (chi?u r?ng) - C2400mm (chi?u cao), t?o ra m?t không gian l?n và r?ng rãi d? b?n có th? s?p x?p và luu tr? d? dùng cá nhân, qu?n áo, giày dép và các v?t d?ng khác m?t cách d? dàng

',
                        'https://i.imgur.com/fdmYXm6.png;https://i.imgur.com/PPb24KM.png;https://i.imgur.com/1mbjWbg.png',
                        4.8
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOTK0002',
                        'T? ly Lake Walnut',
                        84000000,
                        20,
                        'T? k?;T? ly;Phòng b?p',
                        'N?i b?t v?i các du?ng nét u?n cong hài hòa cùng ki?u dáng m?m m?i, t? ly Lake là m?t món n?i th?t trang trí không gian tuy?t v?i. Trên ph?n chân d? cao, hình b?u d?c và v? d?p c?a nó du?c tôn lên b?i ph?n m?t b?ng s? du?c d?t hoi lùi so v?i mép, t?o ra m?t kho?ng tr?ng gi?a c?a và m?t r?t h?u ích cho vi?c m? c?a và ngan kéo. Chi?c t? du?c dánh bóng toàn b? giúp nó tr? nên lý tu?ng cho nhi?u m?c dích s? d?ng khác nhau.

',
                        'https://i.imgur.com/WPXRmy4.png;https://i.imgur.com/qmbVQkv.png;https://i.imgur.com/PE436z0.png',
                        5.0
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOTK0003',
                        'T? giày Caruso 5 ngan xám',
                        7400000,
                        20,
                        'T? k?;T?, k? giày;Phòng khách',
                        'T? giày Caruso 5 ngan màu xám là m?t l?a ch?n hoàn h?o cho vi?c t? ch?c không gian luu tr? giày dép m?t cách g?n gàng và ti?n l?i. V?i ch?t li?u kim lo?i ch?c ch?n, t? giày này d?m b?o d? b?n cao và kh? nang ch?u l?c t?t, giúp b?o v? giày dép c?a b?n m?t cách an toàn và b?n b?. Kích thu?c c?a t? giày là D500mm (chi?u dài) - R140mm (chi?u r?ng) - C1700mm (chi?u cao), t?o ra m?t kích thu?c phù h?p cho vi?c d?t trong h?u h?t các không gian nhà ?. V?i 5 ngan riêng bi?t, b?n có d? không gian d? luu tr? và t? ch?c các dôi giày theo t?ng lo?i ho?c m?c dích s? d?ng khác nhau.

',
                        'https://i.imgur.com/MWqPzkE.png;https://i.imgur.com/BB82qkr.png;https://i.imgur.com/ZaCDzMA.png',
                        4.7
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOTK2004',
                        'T? Minimalism MDF ch?ng ?m màu tr?ng',
                        5100000,
                        20,
                        'T? k?;T? kính;Phòng b?p;Minimalism',
                        'T? Minimalism MDF ch?ng ?m màu tr?ng là l?a ch?n tinh t? cho không gian luu tr?. Ch? tác t? ch?t li?u MDF ch?ng ?m, t?o nên d? b?n và kh? nang ch?ng nu?c. V?i màu tr?ng thanh l?ch, t? không ch? mang l?i v? tuoi m?i mà còn t?o di?m nh?n don gi?n và hi?n d?i. Thi?t k? d?ng nh?t và ch?t li?u ch?ng ?m làm cho T? Minimalism tr? thành gi?i pháp luu tr? hoàn h?o cho m?i không gian.

',
                        'https://i.imgur.com/ArRxy6r.png;https://i.imgur.com/7rIHWze.png;https://i.imgur.com/U8zZYh2.png',
                        4.8
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOTK3005',
                        'K? tivi Neoclassical 2m g? s?i t? nhiên màu tr?ng

',
                        134500000,
                        20,
                        'T? k?;T?, k? tivi;Phòng khách;Neoclassical',
                        'K? TV Neoclassical 2m g? s?i t? nhiên màu tr?ng là di?m nh?n tuy?t v?i cho phòng khách. Thi?t k? d?c dáo v?i các ngan kéo, ch?m kh?c th? công tinh t? mang l?i v? sang tr?ng. Ch?t li?u g? s?i t? nhiên k?t h?p màu tr?ng thanh l?ch t?o nên s? hoàn h?o và tính th?m m? cao. K? TV Neoclassical không ch? là noi d?t TV mà còn là di?m nh?n ngh? thu?t cho không gian s?ng c?a b?n.

',
                        'https://i.imgur.com/iDswaAN.png;https://i.imgur.com/tRgDaNM.png;https://i.imgur.com/jxu5OGP.png',
                        5.0
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOTK4006',
                        'K? tivi Tropical 1m8 g? MDF màu t? nhiên

',
                        5800000,
                        20,
                        'T? k?;T?, k? tivi;Phòng khách;Tropical',
                        'K? TV Tropical 1m8 g? MDF màu t? nhiên là s? k?t h?p tinh t? c?a thi?t k? và ch?t li?u. V?i kích thu?c 180 x 40 x 55 cm, k? mang l?i không gian luu tr? lý tu?ng cho TV và v?t d?ng khác. Ch? tác t? G? MDF Lõi Xanh và son 2K, k? tivi không ch? d?m b?o d? b?n mà còn t?o di?m nh?n v? màu s?c t? nhiên trong không gian s?ng c?a b?n.

',
                        'https://i.imgur.com/Yd4D8rd.png;https://i.imgur.com/QED8fiY.png;https://i.imgur.com/W7MwN0T.png',
                        4.3
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DODE0001',
                        'Ðèn tr?n Universe Chrome',
                        14500000,
                        20,
                        'Ðèn;Ðèn tr?n;Phòng khách;Phòng b?p;Phòng ng?',
                        'Ðèn tr?n Universe Chrome là m?t s?n ph?m chi?u sáng hi?n d?i và sang tr?ng, mang l?i không gian luu tr? sang tr?ng và d?c bi?t cho b?t k? không gian nào trong nhà b?n. V?i vi?c s? d?ng ch?t li?u chrome ch?t lu?ng cao, dèn tr?n này không ch? d?m b?o d? b?n và d? bóng b?y mà còn t?o ra m?t s? sang tr?ng và d?ng c?p.',
                        'https://i.imgur.com/EScNsyG.png;https://i.imgur.com/sGj3tZ7.png;https://i.imgur.com/EjyNGZs.png',
                        4.5
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DODE0002',
                        'Ðèn chùm ánh sáng',
                        14500000,
                        20,
                        'Ðèn;Ðèn tr?n;Phòng khách;Phòng ng?;Phòng b?p',
                        'Ðèn chùm tuy?n tính sang tr?ng t?i thu?ng, hoàn h?o cho gian phòng, du?c trang trí trang nhã v?i nhi?u gi?t th?y tinh màu sáng bóng, l?y c?m h?ng t? thiên nhiên cho m?t trung tâm n?i th?t d?c dáo vu?t th?i gian.

',
                        'https://i.imgur.com/yjNcX4H.png;https://i.imgur.com/cYXs2pG.png;https://i.imgur.com/0EYsZHz.png',
                        4.0
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DODE1003',
                        'Ðèn d?ng Indochine 1m4 thân g? v?i ch?p dèn màu nâu

',
                        3600000,
                        20,
                        'Ðèn;Ðèn d?ng;Phòng khách;Phòng b?p;Phòng ng?;Indochine',
                        'Ðèn d?ng Indochine thu?ng có m?t khung g?m ho?c kim lo?i ch?c ch?n, v?i các chi ti?t trang trí t? m?. Các chi ti?t này thu?ng du?c l?y c?m h?ng t? các y?u t? van hóa và thiên nhiên c?a Ðông Nam Á, nhu hoa van tinh t?, du?ng cong m?m m?i và nh?ng chi ti?t diêu kh?c tinh x?o.
',
                        'https://i.imgur.com/LH7d57X.png;https://i.imgur.com/SNDOVP7.png;https://i.imgur.com/jSnZmR9.png',
                        4.0
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DODE1004',
                        'Ðèn ng? Indochine 0,6m thân g? v?i ch?p dèn màu nâu

',
                        1390000,
                        20,
                        'Ðèn;Ðèn d?ng;Phòng khách;Phòng b?p;Phòng ng?;Indochine',
                        'Ðèn ng? Indochine 0,6m v?i thân g? và ch?p dèn v?i màu nâu, t?o di?m nh?n tinh t? cho không gian ngh? ngoi. Bóng v?i làm d?u ánh sáng, phát ra ánh sáng d?u nh? khu?ch tán, t?o nên không gian ?m áp và tho?i mái. Ðèn s? d?ng công su?t 11-15W, phù h?p v?i di?n áp 90V - 220V, mang l?i không gian ng? yên bình và trang trí hi?n d?i.',
                        'https://i.imgur.com/yvLl3j9.png;https://i.imgur.com/XN7Vosl.png;https://i.imgur.com/FQKbU8A.png',
                        4.0
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DODE2005',
                        'Ðèn d?ng Minimalism kim lo?i màu den

',
                        3150000,
                        20,
                        'Ðèn;Ðèn d?ng;Phòng khách;Phòng b?p;Phòng ng?;Minimalism',
                        'Ðèn d?ng Minimalism kim lo?i màu den mang d?n v? d?p d?c dáo v?i c?u trúc l?ch tâm gi?ng lá, t?o bóng râm nh?. Hu?ng ánh sáng có th? di?u ch?nh linh ho?t, phù h?p v?i t?ng không gian. Ch?t li?u s?t và nhôm, s? d?ng dèn LED t?i da 12W. Màu th?y tinh d?p m?t Cashmere/Ðen, tr?ng lu?ng nh? 1 kg.',
                        'https://i.imgur.com/SPsHpik.png;https://i.imgur.com/DVF736T.png;https://i.imgur.com/0EAe5FT.png',
                        5.0
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOKH0001

',
                        'Th?m Ovado',
                        18000000,
                        20,
                        'Khác;Th?m;Phòng khách;Phòng b?p;Phòng ng?',
                        'Th?m Ovado du?c làm t? ch?t li?u v?i ch?t lu?ng cao, d?m b?o d? b?n và d? dàng v? sinh. Thi?t k? d?c bi?t v?i các du?ng nét m?m m?i và h?a ti?t tinh t? t?o ra m?t c?m giác ?m áp và tho?i mái cho bàn chân c?a b?n, d?ng th?i làm tang thêm v? d?p và s? sang tr?ng cho không gian s?ng c?a b?n.',
                        'https://i.imgur.com/x5CeWLb.png;https://i.imgur.com/nNP0bcf.png;https://i.imgur.com/XjVSDli.png',
                        4.5
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOKH0002',
                        'Th?m Square grey',
                        17500000,
                        20,
                        'Khác;Th?m;Phòng khách;Phòng b?p;Phòng ng?',
                        'V?i màu xám trung tính và thi?t k? don gi?n nhung tinh t?, th?m Square Grey d? dàng ph?i h?p v?i nhi?u phong cách trang trí khác nhau. Th?m Square Grey du?c làm t? ch?t li?u v?i cao c?p, d?m b?o d? b?n và d? dàng v? sinh. Ð? dày v?a ph?i, th?m này cung c?p s? tho?i mái cho bàn chân và gi? cho không gian c?a b?n luôn ?m áp và tho?i mái.',
                        'https://i.imgur.com/wb5DspF.png;https://i.imgur.com/2pQcqQh.png;https://i.imgur.com/uZIwsC9.png',
                        4.5
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOKH0003',
                        'Qu? c?u trang trí Bel Jar',
                        1750000,
                        20,
                        'Khác;Phòng khách;Phòng b?p;Phòng ng?',
                        'Qu? c?u Bel Jar không ch? là m?t món d? trang trí, mà còn có th? du?c s? d?ng d? trung bày các v?t d?ng nhu hoa c?, dèn LED, ho?c các m?nh trang trí khác d? t?o ra di?m nh?n d?c dáo cho không gian c?a b?n. V?i v? d?p lãng m?n và s? sang tr?ng, qu? c?u Bel Jar là m?t l?a ch?n tuy?t v?i d? làm m?i không gian n?i th?t c?a b?n và t?o ra m?t không gian s?ng d?ng c?p và tinh t?.',
                        'https://i.imgur.com/x7FORhC.png;https://i.imgur.com/70Sac0o.png;https://i.imgur.com/UvSmao8.png',
                        4.5
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOKH1004',
                        'Guong Indochine MDF tròn màu b?c vi?n nâu

',
                        1750000,
                        20,
                        'Khác;Guong;Phòng khách;Phòng b?p;Phòng ng?;Indochine',
                        'Guong Indochine tròn MDF màu b?c, vi?n nâu là di?m nh?n tinh t? trong trang trí. Ch? tác t? ch?t li?u MDF và guong, có bán kính 20cm. Màu b?c và vi?n nâu t?o nên s? hài hòa và sang tr?ng, làm tang v? d?p c?a không gian. Guong Indochine không ch? là m?t v?t trang trí mà còn làm tang s? r?ng l?n và sáng t?o cho can phòng c?a b?n.',
                        'https://i.imgur.com/gOoHr1L.png;https://i.imgur.com/qEj3awG.png;https://i.imgur.com/DBGTlOv.png',
                        4.5
                    );

INSERT INTO Product (
                        ProductId,
                        ProductName,
                        ProductPrice,
                        ProductQuantity,
                        ProductCategory,
                        ProductDescribtion,
                        ProductImg,
                        ProductRating
                    )
                    VALUES (
                        'DOKH3005',
                        'Guong Neoclassical g? màu tr?ng ng?c trai

',
                        2390000,
                        20,
                        'Khác;Guong;Phòng khách;Phòng ng?;Neoclassical',
                        'Guong Neoclassical g? màu tr?ng ng?c trai là di?m nh?n quý phái trong trang trí n?i th?t. Kích thu?c D49cm x CD70cm, tr?ng lu?ng 3.2kg, t?o nên s? tinh t? và nh? nhàng. Ch?t li?u g? màu tr?ng ng?c trai t?o b?c phác th?o thanh l?ch và sang tr?ng cho không gian. Guong Neoclassical không ch? làm tang v? d?p mà còn m? r?ng không gian và ánh sáng cho can phòng.',
                        'https://i.imgur.com/sFoVf4T.png;https://i.imgur.com/DiUFMak.png;https://i.imgur.com/idNCdME.png',
                        4.0
                    );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
