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
                        'B�n console kim lo?i v�ng',
                        10900000,
                        20,
                        'B�n;B�n Console;Ph�ng kh�ch',
                        'B�n Console hay c�n g?i l� b�n trang tr�, s?n ph?m c� th? d? nh?ng d? v?t nhu khung ?nh gia d�nh, c�c s?n ph?m trang tr�, gi�p cho nh?ng m?ng tu?ng tr?ng c?a nh� b?n tr? n�n sinh d?ng hon.',
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
                        'B�n console Secret 2 ngan',
                        15000000,
                        20,
                        'B�n;B�n console;Ph�ng kh�ch',
                        'B�n Console hay c�n g?i l� b�n trang tr�, s?n ph?m c� th? d? nh?ng d? v?t nhu khung ?nh gia d�nh, c�c s?n ph?m trang tr�, gi�p cho nh?ng m?ng tu?ng tr?ng c?a nh� b?n tr? n�n sinh d?ng hon.

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
                        'B�n trang di?m g? m�y dan',
                        12000000,
                        20,
                        'B�n;B�n trang di?m;Ph�ng ng?',
                        'B�n trang di?m M�y mang ki?u d�ng n? t�nh, trang nh�, c?ng th�m m?t ch�t duy�n d�ng. Ph?n h?c k�o ti?n l?i s? l� noi luu tr? g?n g�ng c�c v?t d?ng c?a nh?ng qu� c�. V?i c�c chi ti?t b?c m�y di?m xuy?t cho s?n ph?m th�m ph?n tinh t?, d?c d�o. ��y s? l� l?a ch?n ho�n h?o cho c�c gia ch? y�u th�ch phong c�ch c? di?n pha l?n m?t ch�t hi?n d?i.  

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
                        'B�n d?u giu?ng Neoclassical 3 ngan b?ng g? tr?ng ng?c trai',
                        11500000,
                        20,
                        'B�n;B�n d?u giu?ng;Neoclassical;Ph�ng ng?',
                        'B�n d?u giu?ng Neoclassical 3 ngan son Lacquer 7 l?p, mang d?n v? qu� ph�i v?i hoa van c? di?n Ph�p. �u?c ngh? nh�n ch?m tr? tinh x?o, m�u son v�ng d?ng n?i b?t tr�n n?n tr?ng ng?c trai, t?o di?m nh?n sang tr?ng, ho�n h?o cho kh�ng gian ph�ng ng?.

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
                        'B�n Twist Tropical g? s?i n�u t? nhi�n',
                        5100000,
                        20,
                        'B�n;B�n an;Ph�ng b?p;Tropical; Ph�ng b?p',
                        'B�n Twist Tropical g? s?i n�u t? nhi�n, k�ch thu?c 80 x 140 x 720 cm. Ch?t li?u khung g? s?i v� m?t g? gh�p, son m�u t? nhi�n ho?c m�u Wanut. Ph?n c?nh m?t b�n du?c l�m v�t me�p, t?o s? nh? nh�ng v� tinh t? trong thi?t k? n?i th?t.',
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
                        'B�n tr� Tropical m�y dan 2 t?ng k�nh',
                        3190000,
                        20,
                        'B�n;B�n c� ph�, tr�; Tropical;Ph�ng kh�ch',
                        'B�n tr� Tropical m�y dan 2 t?ng k�nh, k?t h?p m�y t? nhi�n v� khung g? s?i nguy�n kh?i. K�ch thu?c 86cm x 86cm x 45cm, thi?t k? tinh t?, ti?n �ch cho kh�ng gian hi?n d?i.',
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
                        'Gh?;Sofa;Ph�ng kh�ch;Ph�ng ng?',
                        'Sofa n?m b?c v?i xanh g�y ?n tu?ng b?ng nh?ng du?ng cong b?ng b?nh, theo xu hu?ng Modern Organic � g?n gui v?i thi�n nhi�n m� v?n hi?n d?i, tho?i m�i. C?m gi�c �m �i v� thu th�i s? l� nh?ng t�nh t? d?u ti�n du?c nh?c d?n khi tr?i nghi?m v?i chi?c sofa n�y.

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
                        'Gh?;Sofa;Ph�ng kh�ch',
                        'Sofa n?m b?c v?i xanh g�y ?n tu?ng b?ng nh?ng du?ng cong b?ng b?nh, theo xu hu?ng Modern Organic � g?n gui v?i thi�n nhi�n m� v?n hi?n d?i, tho?i m�i. C?m gi�c �m �i v� thu th�i s? l� nh?ng t�nh t? d?u ti�n du?c nh?c d?n khi tr?i nghi?m v?i chi?c sofa n�y.

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
                        'Sofa 2 ch? v?i b�ng h?ng',
                        11000000,
                        20,
                        'Gh?;Sofa;Ph�ng kh�ch;Ph�ng ng?',
                        'M?t chi?c sofa nh? g?n cho can h? c?a b?n nhung v?n mang v? hi?n d?i. Ph?n t?a lung c?a sofa moon v?i du?ng n�t bo tr�n, nghi�ng h? tr? t?i da cho vi?c ngh? ngoi thu gi�n. Ch?t li?u v?i b�ng m?m t?o s? tho?i m�i khi ng?i k?t h?p v?i m�u s?c pastel nh? nh�ng s? l� gi?i ph�p l?a ch?n t?i uu d�nh cho kh�ng gian n?i th?t can h? c� di?n t�ch khi�m t?n.  

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
                        'Sofa don Indochine g? dan m�y n�u den
',
                        5400000,
                        20,
                        'Gh?;Sofa;Ph�ng kh�ch;Indochine',
                        'Sofa don Indochine g? dan m�y n�u den l� s? k?t h?p ho�n h?o gi?a g? s?i t?n b� v� dan m�y t? nhi�n. Khung g? t?n b� c� th? son m�u Walnut, Brown ho?c Nature. Ch?t li?u b?n b? t? g? t?n b�, n?m Simili Cleo ho?c v?i n? cao c?p. K�ch thu?c gh?: 800x800 x 450 (mm), t?a cao 900mm. Thi?t k? d?c d�o v� ch?t li?u cao c?p d?m b?o s? tho?i m�i v� d?ng c?p cho kh�ng gian ngh? ngoi c?a b?n.

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
                        'Sofa Indochine g? dan m�y n�u den

',
                        8900000,
                        20,
                        'Gh?;Sofa;Ph�ng kh�ch;Indochine',
                        'Sofa Indochine g? s?i t?n b� k?t h?p dan m�y t? nhi�n, v?i k�ch thu?c 2m3 x 0.8m x 0.9m. Ch?t li?u m�y nh?a nh?p kh?u t? Indonesia, nh? nh�ng v� m?m m?i, tang th�m s? tho?i m�i cho kh�ng gian ngh? ngoi. Thi?t k? d?c d�o v� ch?t li?u d?ng c?p t?o n�n m?t s?n ph?m sofa sang tr?ng v� ?n tu?ng.

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
                        'Gh? an Minimalism g? cao su m�u n�u

',
                        1990000,
                        20,
                        'Gh?;Gh? an; Ph�ng b?p;Mimimalism',
                        'Gh? an Minimalism c� m?t khung g?n nh? v� thon g?n v?i k�ch th?c 50cm x 56cm x 47cm/80cm, thu?ng l�m t? ch?t li?u nhu g? ho?c kim lo?i. V?i du?ng n�t don gi?n v� kh�ng c� nh?ng chi ti?t ph?c t?p, gh? an n�y t?o c?m gi�c g?n g�ng v� kh�ng gian trong ph�ng an.

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
                        'Gh? an Neoclassical g? b?c v?i tu�t n�u b?c',
                        1600000,
                        20,
                        'Gh?;Gh? an;Ph�ng b?p; Neoclassical',
                        'Gh? an Neoclassical g? b?c v?i tu�t n�u b?c, k�ch thu?c 4,61W x 68,58D x 107,95H. Ch�n h�nh thanh ki?m c? di?n, khung g? l? ra ngo�i du?c trang tr� b?ng son b?c m?m, t?o di?m nh?n d?c d�o. Gh? n?i b?t v?i ph?n lung h�nh b?u d?c v� ch? ng?i ch?t h?p, b?c b?ng v?i tu�t ch?i b�ng lung linh, mang d?n s? sang tr?ng v� d? ?m �p cho kh�ng gian b�n an. Gh? du?c thi?t k? v?i s? tho?i m�i cao c?p v?i n?m v� lung b?c ngo�i.

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
                        'Gh? Wishbone Tropical g? t?n b� dan c�i n�u s�ng

',
                        2100000,
                        20,
                        'Gh?;Gh? an;Ph�ng b?p;Tropical',
                        'Gh? Wishbone Tropical l� t�c ph?m ngh? thu?t v?i khung g? t?n b� v� dan c�i n�u s�ng. M�u s?c t? nhi�n v� n�u t?o di?m nh?n tinh t?. K�ch thu?c x?p x? 45cm chi?u cao m?t ng?i, cao 75cm v� r?ng 55x50cm, t?o n�n s? tho?i m�i v� phong c�ch cho kh�ng gian. Thi?t k? hi?n d?i v� ch?t li?u t? nhi�n k?t h?p, Gh? Wishbone Tropical l� s? l?a ch?n l� tu?ng d? l�m m?i kh�ng gian n?i th?t c?a b?n.

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
                        'Giu?ng n�ng magenta da 1m8',
                        80000000,
                        20,
                        'Giu?ng;Ph�ng ng?',
                        'Giu?ng n�ng magenta da 1m8 c� thi?t k? ph?n ch�n g?, du?c b?c da Espirit t? nhi�n cao c?p m�u taupe, giu?ng n�ng to�n ph?n c�ng nang ch?a d?ng nhi?u v?t d?ng, d? d�ng c� nh�n m?t c�ch ti?n l?i.  

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
                        'Giu?ng Indochine 1m8x2m g? n�u den

',
                        22900000,
                        20,
                        'Giu?ng; Ph�ng ng?; Indochine',
                        'Giu?ng Indochine 1m8x2m g? n�u den l� di?m nh?n sang tr?ng trong kh�ng gian ngh? ngoi. Ch? t�c t? g? s?i t?n b� t? nhi�n nh?p kh?u, giu?ng mang d?n n�t d?p m?c m?c v� d?ng c?p. V?i k�ch thu?c 1m8x2m, n� t?o ra kh�ng gian tho?i m�i v� sang tr?ng cho gi?c ng?. S? k?t h?p gi?a ch?t li?u cao c?p v� thi?t k? hi?n d?i l�m cho giu?ng Indochine tr? th�nh di?m nh?n quan tr?ng trong trang tr� n?i th?t.',
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
                        'Giu?ng Minimalism 1m8x2m b?c da n�u

',
                        57900000,
                        20,
                        'Giu?ng;Ph�ng ng?;Minimalism',
                        'Giu?ng Minimalism 1m8x2m b?c da n�u l� bi?u tu?ng c?a s? t?i gi?n v� sang tr?ng. Ch�n g? v� khung g? b?c da Esprit cao c?p, t?o n�n kh�ng gian ng? d?ng c?p. B?c da n�u ?m �p v� m?m m?i, k?t h?p v?i k�ch thu?c r?ng r�i 1m8x2m, giu?ng kh�ng ch? l� noi ngh? ngoi m� c�n l� t�c ph?m ngh? thu?t hi?n d?i trong kh�ng gian ph�ng ng? c?a b?n. Th? m�nh v�o s? tho?i m�i v� d?ng c?p v?i Giu?ng Minimalism.

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
                        'Giu?ng Neoclassical 1m8x2m b?c da m�u tr?ng',
                        39900000,
                        20,
                        'Giu?ng;Ph�ng ng?;Neoclassical',
                        'Giu?ng Neoclassical 1m8x2m b?c da m�u tr?ng l� di?m nh?n tinh t? trong ph�ng ng?. Khung g? v� b?c da t?o n�n v? sang tr?ng, k?t h?p s? tho?i m�i v� d?ng c?p. V?i k�ch thu?c 1m8x2m, giu?ng kh�ng ch? l� noi ngh? ngoi m� c�n l� ph?n quan tr?ng c?a thi?t k? n?i th?t. M�u tr?ng tinh kh�i, ch?t li?u b?c da m?m m?i l�m tang th�m s? �m d?u v� ?m �p cho kh�ng gian ng? c?a b?n. Thu gi�n v� d?m ch�m trong s? sang tr?ng v?i Giu?ng Neoclassical n�y.

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
                        'Giu?ng Tropicall 1m8x2m g? c�ng nghi?p m�u t? nhi�n',
                        8900000,
                        20,
                        'Giu?ng;Ph�ng ng?;Tropical',
                        'Giu?ng Tropical 1m8x2m g? c�ng nghi?p m�u t? nhi�n l� l?a ch?n d?p v� ti?n �ch cho ph�ng ng?. Ch? t�c t? G? C�ng Nghi?p, giu?ng mang d?n v? don gi?n v� m?c m?c. Ch?ng m?i m?t, ch?t li?u G? MDF ph? melamine ch?ng tr?y xu?c v� cong v�nh, d?m b?o d? b?n v� d? b?o qu?n. V?i k�ch thu?c 1m8x2m, Giu?ng Tropical l� s? k?t h?p ho�n h?o gi?a thi?t k? hi?n d?i v� t�nh ?ng d?ng.

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
                        'T? qu?n �o Wabrobe g? n�u',
                        75000000,
                        20,
                        'T? k?;T? qu?n �o;Ph�ng ng?',
                        'T? �o Wabrobe l� m?t s?n ph?m n?i th?t ch?t lu?ng cao du?c thi?t k? d? c?i thi?n kh�ng gian luu tr? trong ph�ng ng? ho?c ph�ng thay d?. V?i ch?t li?u ch�nh l� MDF Laminate, t? �o n�y mang l?i s? b?n b? v� d? b?n cao, d?ng th?i d? d�ng v? sinh v� b?o qu?n. K�ch thu?c c?a t? �o l� D3800mm (chi?u d�i) - R670mm (chi?u r?ng) - C2400mm (chi?u cao), t?o ra m?t kh�ng gian l?n v� r?ng r�i d? b?n c� th? s?p x?p v� luu tr? d? d�ng c� nh�n, qu?n �o, gi�y d�p v� c�c v?t d?ng kh�c m?t c�ch d? d�ng

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
                        'T? k?;T? ly;Ph�ng b?p',
                        'N?i b?t v?i c�c du?ng n�t u?n cong h�i h�a c�ng ki?u d�ng m?m m?i, t? ly Lake l� m?t m�n n?i th?t trang tr� kh�ng gian tuy?t v?i. Tr�n ph?n ch�n d? cao, h�nh b?u d?c v� v? d?p c?a n� du?c t�n l�n b?i ph?n m?t b?ng s? du?c d?t hoi l�i so v?i m�p, t?o ra m?t kho?ng tr?ng gi?a c?a v� m?t r?t h?u �ch cho vi?c m? c?a v� ngan k�o. Chi?c t? du?c d�nh b�ng to�n b? gi�p n� tr? n�n l� tu?ng cho nhi?u m?c d�ch s? d?ng kh�c nhau.

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
                        'T? gi�y Caruso 5 ngan x�m',
                        7400000,
                        20,
                        'T? k?;T?, k? gi�y;Ph�ng kh�ch',
                        'T? gi�y Caruso 5 ngan m�u x�m l� m?t l?a ch?n ho�n h?o cho vi?c t? ch?c kh�ng gian luu tr? gi�y d�p m?t c�ch g?n g�ng v� ti?n l?i. V?i ch?t li?u kim lo?i ch?c ch?n, t? gi�y n�y d?m b?o d? b?n cao v� kh? nang ch?u l?c t?t, gi�p b?o v? gi�y d�p c?a b?n m?t c�ch an to�n v� b?n b?. K�ch thu?c c?a t? gi�y l� D500mm (chi?u d�i) - R140mm (chi?u r?ng) - C1700mm (chi?u cao), t?o ra m?t k�ch thu?c ph� h?p cho vi?c d?t trong h?u h?t c�c kh�ng gian nh� ?. V?i 5 ngan ri�ng bi?t, b?n c� d? kh�ng gian d? luu tr? v� t? ch?c c�c d�i gi�y theo t?ng lo?i ho?c m?c d�ch s? d?ng kh�c nhau.

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
                        'T? Minimalism MDF ch?ng ?m m�u tr?ng',
                        5100000,
                        20,
                        'T? k?;T? k�nh;Ph�ng b?p;Minimalism',
                        'T? Minimalism MDF ch?ng ?m m�u tr?ng l� l?a ch?n tinh t? cho kh�ng gian luu tr?. Ch? t�c t? ch?t li?u MDF ch?ng ?m, t?o n�n d? b?n v� kh? nang ch?ng nu?c. V?i m�u tr?ng thanh l?ch, t? kh�ng ch? mang l?i v? tuoi m?i m� c�n t?o di?m nh?n don gi?n v� hi?n d?i. Thi?t k? d?ng nh?t v� ch?t li?u ch?ng ?m l�m cho T? Minimalism tr? th�nh gi?i ph�p luu tr? ho�n h?o cho m?i kh�ng gian.

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
                        'K? tivi Neoclassical 2m g? s?i t? nhi�n m�u tr?ng

',
                        134500000,
                        20,
                        'T? k?;T?, k? tivi;Ph�ng kh�ch;Neoclassical',
                        'K? TV Neoclassical 2m g? s?i t? nhi�n m�u tr?ng l� di?m nh?n tuy?t v?i cho ph�ng kh�ch. Thi?t k? d?c d�o v?i c�c ngan k�o, ch?m kh?c th? c�ng tinh t? mang l?i v? sang tr?ng. Ch?t li?u g? s?i t? nhi�n k?t h?p m�u tr?ng thanh l?ch t?o n�n s? ho�n h?o v� t�nh th?m m? cao. K? TV Neoclassical kh�ng ch? l� noi d?t TV m� c�n l� di?m nh?n ngh? thu?t cho kh�ng gian s?ng c?a b?n.

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
                        'K? tivi Tropical 1m8 g? MDF m�u t? nhi�n

',
                        5800000,
                        20,
                        'T? k?;T?, k? tivi;Ph�ng kh�ch;Tropical',
                        'K? TV Tropical 1m8 g? MDF m�u t? nhi�n l� s? k?t h?p tinh t? c?a thi?t k? v� ch?t li?u. V?i k�ch thu?c 180 x 40 x 55 cm, k? mang l?i kh�ng gian luu tr? l� tu?ng cho TV v� v?t d?ng kh�c. Ch? t�c t? G? MDF L�i Xanh v� son 2K, k? tivi kh�ng ch? d?m b?o d? b?n m� c�n t?o di?m nh?n v? m�u s?c t? nhi�n trong kh�ng gian s?ng c?a b?n.

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
                        '��n tr?n Universe Chrome',
                        14500000,
                        20,
                        '��n;��n tr?n;Ph�ng kh�ch;Ph�ng b?p;Ph�ng ng?',
                        '��n tr?n Universe Chrome l� m?t s?n ph?m chi?u s�ng hi?n d?i v� sang tr?ng, mang l?i kh�ng gian luu tr? sang tr?ng v� d?c bi?t cho b?t k? kh�ng gian n�o trong nh� b?n. V?i vi?c s? d?ng ch?t li?u chrome ch?t lu?ng cao, d�n tr?n n�y kh�ng ch? d?m b?o d? b?n v� d? b�ng b?y m� c�n t?o ra m?t s? sang tr?ng v� d?ng c?p.',
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
                        '��n ch�m �nh s�ng',
                        14500000,
                        20,
                        '��n;��n tr?n;Ph�ng kh�ch;Ph�ng ng?;Ph�ng b?p',
                        '��n ch�m tuy?n t�nh sang tr?ng t?i thu?ng, ho�n h?o cho gian ph�ng, du?c trang tr� trang nh� v?i nhi?u gi?t th?y tinh m�u s�ng b�ng, l?y c?m h?ng t? thi�n nhi�n cho m?t trung t�m n?i th?t d?c d�o vu?t th?i gian.

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
                        '��n d?ng Indochine 1m4 th�n g? v?i ch?p d�n m�u n�u

',
                        3600000,
                        20,
                        '��n;��n d?ng;Ph�ng kh�ch;Ph�ng b?p;Ph�ng ng?;Indochine',
                        '��n d?ng Indochine thu?ng c� m?t khung g?m ho?c kim lo?i ch?c ch?n, v?i c�c chi ti?t trang tr� t? m?. C�c chi ti?t n�y thu?ng du?c l?y c?m h?ng t? c�c y?u t? van h�a v� thi�n nhi�n c?a ��ng Nam �, nhu hoa van tinh t?, du?ng cong m?m m?i v� nh?ng chi ti?t di�u kh?c tinh x?o.
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
                        '��n ng? Indochine 0,6m th�n g? v?i ch?p d�n m�u n�u

',
                        1390000,
                        20,
                        '��n;��n d?ng;Ph�ng kh�ch;Ph�ng b?p;Ph�ng ng?;Indochine',
                        '��n ng? Indochine 0,6m v?i th�n g? v� ch?p d�n v?i m�u n�u, t?o di?m nh?n tinh t? cho kh�ng gian ngh? ngoi. B�ng v?i l�m d?u �nh s�ng, ph�t ra �nh s�ng d?u nh? khu?ch t�n, t?o n�n kh�ng gian ?m �p v� tho?i m�i. ��n s? d?ng c�ng su?t 11-15W, ph� h?p v?i di?n �p 90V - 220V, mang l?i kh�ng gian ng? y�n b�nh v� trang tr� hi?n d?i.',
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
                        '��n d?ng Minimalism kim lo?i m�u den

',
                        3150000,
                        20,
                        '��n;��n d?ng;Ph�ng kh�ch;Ph�ng b?p;Ph�ng ng?;Minimalism',
                        '��n d?ng Minimalism kim lo?i m�u den mang d?n v? d?p d?c d�o v?i c?u tr�c l?ch t�m gi?ng l�, t?o b�ng r�m nh?. Hu?ng �nh s�ng c� th? di?u ch?nh linh ho?t, ph� h?p v?i t?ng kh�ng gian. Ch?t li?u s?t v� nh�m, s? d?ng d�n LED t?i da 12W. M�u th?y tinh d?p m?t Cashmere/�en, tr?ng lu?ng nh? 1 kg.',
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
                        'Kh�c;Th?m;Ph�ng kh�ch;Ph�ng b?p;Ph�ng ng?',
                        'Th?m Ovado du?c l�m t? ch?t li?u v?i ch?t lu?ng cao, d?m b?o d? b?n v� d? d�ng v? sinh. Thi?t k? d?c bi?t v?i c�c du?ng n�t m?m m?i v� h?a ti?t tinh t? t?o ra m?t c?m gi�c ?m �p v� tho?i m�i cho b�n ch�n c?a b?n, d?ng th?i l�m tang th�m v? d?p v� s? sang tr?ng cho kh�ng gian s?ng c?a b?n.',
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
                        'Kh�c;Th?m;Ph�ng kh�ch;Ph�ng b?p;Ph�ng ng?',
                        'V?i m�u x�m trung t�nh v� thi?t k? don gi?n nhung tinh t?, th?m Square Grey d? d�ng ph?i h?p v?i nhi?u phong c�ch trang tr� kh�c nhau. Th?m Square Grey du?c l�m t? ch?t li?u v?i cao c?p, d?m b?o d? b?n v� d? d�ng v? sinh. �? d�y v?a ph?i, th?m n�y cung c?p s? tho?i m�i cho b�n ch�n v� gi? cho kh�ng gian c?a b?n lu�n ?m �p v� tho?i m�i.',
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
                        'Qu? c?u trang tr� Bel Jar',
                        1750000,
                        20,
                        'Kh�c;Ph�ng kh�ch;Ph�ng b?p;Ph�ng ng?',
                        'Qu? c?u Bel Jar kh�ng ch? l� m?t m�n d? trang tr�, m� c�n c� th? du?c s? d?ng d? trung b�y c�c v?t d?ng nhu hoa c?, d�n LED, ho?c c�c m?nh trang tr� kh�c d? t?o ra di?m nh?n d?c d�o cho kh�ng gian c?a b?n. V?i v? d?p l�ng m?n v� s? sang tr?ng, qu? c?u Bel Jar l� m?t l?a ch?n tuy?t v?i d? l�m m?i kh�ng gian n?i th?t c?a b?n v� t?o ra m?t kh�ng gian s?ng d?ng c?p v� tinh t?.',
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
                        'Guong Indochine MDF tr�n m�u b?c vi?n n�u

',
                        1750000,
                        20,
                        'Kh�c;Guong;Ph�ng kh�ch;Ph�ng b?p;Ph�ng ng?;Indochine',
                        'Guong Indochine tr�n MDF m�u b?c, vi?n n�u l� di?m nh?n tinh t? trong trang tr�. Ch? t�c t? ch?t li?u MDF v� guong, c� b�n k�nh 20cm. M�u b?c v� vi?n n�u t?o n�n s? h�i h�a v� sang tr?ng, l�m tang v? d?p c?a kh�ng gian. Guong Indochine kh�ng ch? l� m?t v?t trang tr� m� c�n l�m tang s? r?ng l?n v� s�ng t?o cho can ph�ng c?a b?n.',
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
                        'Guong Neoclassical g? m�u tr?ng ng?c trai

',
                        2390000,
                        20,
                        'Kh�c;Guong;Ph�ng kh�ch;Ph�ng ng?;Neoclassical',
                        'Guong Neoclassical g? m�u tr?ng ng?c trai l� di?m nh?n qu� ph�i trong trang tr� n?i th?t. K�ch thu?c D49cm x CD70cm, tr?ng lu?ng 3.2kg, t?o n�n s? tinh t? v� nh? nh�ng. Ch?t li?u g? m�u tr?ng ng?c trai t?o b?c ph�c th?o thanh l?ch v� sang tr?ng cho kh�ng gian. Guong Neoclassical kh�ng ch? l�m tang v? d?p m� c�n m? r?ng kh�ng gian v� �nh s�ng cho can ph�ng.',
                        'https://i.imgur.com/sFoVf4T.png;https://i.imgur.com/DiUFMak.png;https://i.imgur.com/idNCdME.png',
                        4.0
                    );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
