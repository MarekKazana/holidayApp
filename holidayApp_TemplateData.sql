-- Continents (id, name)
insert into continent values(null, 'Europe');
insert into continent values(null, 'Asia');
insert into continent values(null, 'Africa');

-- Europe (id, name, id_continent)
insert into country values(null, 'Poland', 1);
insert into country values(null, 'England', 1);
insert into country values(null, 'Slovakia', 1);
insert into country values(null, 'Spain', 1);
insert into country values(null, 'Croatia', 1);

-- Asia (id, name, id_continent)
insert into country values(null, 'China', 2);
insert into country values(null, 'Japan', 2);
insert into country values(null, 'Thailand', 2);
insert into country values(null, 'Indonesia', 2);
insert into country values(null, 'Singapur', 2);

-- Africa (id, name, id_continent)
insert into country values(null, 'Tunise', 3);
insert into country values(null, 'Egypt', 3);
insert into country values(null, 'Zanzibar', 3);
insert into country values(null, 'Maroko', 3);
insert into country values(null, 'Kenia', 3);

-- Poland (id, name, id_country)
insert into `city` (`name`, `id_country`) values('Warszawa', 1);
insert into `city` (`name`, `id_country`) values('Kraków', 1);
insert into `city` (`name`, `id_country`) values('Katowice', 1);
insert into `city` (`name`, `id_country`) values('Gdańsk', 1);
insert into `city` (`name`, `id_country`) values('Wrocław', 1);

-- England (id, name, id_country)
insert into `city` (`name`, `id_country`) values('London', 2);
insert into `city` (`name`, `id_country`) values('Manchester', 2);
insert into `city` (`name`, `id_country`) values('Birmingham', 2);
insert into `city` (`name`, `id_country`) values('Glasgow', 2);

-- Slovakia (id, name, id_country)
insert into `city` (`name`, `id_country`) values('Bratyslava', 3);
insert into `city` (`name`, `id_country`) values('Żylina', 3);
insert into `city` (`name`, `id_country`) values('Koszyce', 3);
insert into `city` (`name`, `id_country`) values('Svidnik', 3);

-- Spain (id, name, id_country)
insert into `city` (`name`, `id_country`) values('Barcelona', 4);
insert into `city` (`name`, `id_country`) values('Alicante', 4);
insert into `city` (`name`, `id_country`) values('Santiago', 4);
insert into `city` (`name`, `id_country`) values('Malaga', 4);
insert into `city` (`name`, `id_country`) values('Almeria', 4); -- Airport Malaga
insert into `city` (`name`, `id_country`) values('Murcia', 4); -- Airport Alicante
insert into `city` (`name`, `id_country`) values('Girona', 4); -- Airport Barcelona
insert into `city` (`name`, `id_country`) values('Pontevedra', 4); -- Airport Santiago

-- Croatia (id, name, id_county)
insert into `city` (`name`, `id_country`) values('Zagreb', 5);
insert into `city` (`name`, `id_country`) values('Pula', 5);
insert into `city` (`name`, `id_country`) values('Split', 5);
insert into `city` (`name`, `id_country`) values('Dubrownik', 5);
insert into `city` (`name`, `id_country`) values('Rabac', 5); -- Pula Airport
insert into `city` (`name`, `id_country`) values('Medulin', 5); -- Pula Airport
insert into `city` (`name`, `id_country`) values('Ivanić Grad', 5);  -- Zagreb Airport
insert into `city` (`name`, `id_country`) values('Trogir', 5); -- Split Airport
insert into `city` (`name`, `id_country`) values('Arbanija', 5); -- Split Airport
insert into `city` (`name`, `id_country`) values('Slano', 5); -- Dubrovnik Airport

-- Aitports Poland (id, name, id_city)
insert into `airport` (`name`, `id_city`) values('Chopin', 1); -- Warszawa
insert into `airport` (`name`, `id_city`) values('Babice', 1);  -- Warszawa
insert into `airport` (`name`, `id_city`) values('Jana Pawła II', 2); -- Kraków
insert into `airport` (`name`, `id_city`) values('Pyrzowice', 3); -- Katowice
insert into `airport` (`name`, `id_city`) values('im. Lecha Wałęsy', 4); -- Gdańsk
insert into `airport` (`name`, `id_city`) values('Port lotniczy', 5); -- Wrocław

-- Airports England (id, name, id_city)
insert into `airport` (`name`, `id_city`) values('Port lotniczy', 6); -- London
insert into `airport` (`name`, `id_city`) values('Port lotniczy', 7); -- Manchester
insert into `airport` (`name`, `id_city`) values('Port lotniczy', 8); -- Birmingham
insert into `airport` (`name`, `id_city`) values('Port lotniczy', 9); -- Glasgow

-- Airports Slovakia (id, name, id_city)
insert into `airport` (`name`, `id_city`) values('M. R. Štefánika', 10); -- Bratyslava
insert into `airport` (`name`, `id_city`) values('Airport', 11); -- Żylina
insert into `airport` (`name`, `id_city`) values('Intl Airport', 12); -- Koszyce
insert into `airport` (`name`, `id_city`) values('Airport', 13); -- Svidnik

-- Airports Spain (id, name, id_city)
insert into `airport` (`name`, `id_city`) values('El Prat', 14); -- Barcelona
insert into `airport` (`name`, `id_city`) values('El Altet', 15); -- Alicante
insert into `airport` (`name`, `id_city`) values('Arturo Merino Benitez', 16); -- Santiago
insert into `airport` (`name`, `id_city`) values('Pablo Ruiz Picasso', 17); -- Malaga

-- Aitports Croatia (id, name, id_city)
insert into `airport` (`name`, `id_city`) values('Pleso', 22); -- Zagreb
insert into `airport` (`name`, `id_city`) values('Airport', 23); -- Pula
insert into `airport` (`name`, `id_city`) values('Kastela', 24); -- Split
insert into `airport` (`name`, `id_city`) values('Cilipi', 25); -- Dubrownik

-- Croatia Hotels (id, name, rating, id_city, id_airport, address, img_url)
-- Zagreb / Airport: Zagreb
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) VALUES 
("Esplanade Zagreb Hotel", 5, 18, 19, "ul. Antuna Mihanovića 1", "https://thumbnails.trvl-media.com/8YMfhdGk5jZYkwsdpdJGqW-Xq4Y=/773x530/smart/filters:quality(60)/exp.cdn-hotels.com/hotels/1000000/450000/443100/443036/70554061_z.jpg");
-- Ivanić Grad / Airport: Zagreb
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) VALUES 
("Motel Ivanicanka", 2, 24, 19, "Trg Vladimira Nazora 2", "https://r-ak.bstatic.com/images/hotel/max1280x900/272/2729578.jpg");
 -- Rabac / Airport: Pula
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) 
VALUES ("Miramar Sunny Hotel by Valamar", 3, 22, 20, "Svetog Andrije 1", "https://lh3.googleusercontent.com/p/AF1QipMXyytLymJgYdcwCuqib3dwZFzikLvWJNlD49pb=w592-h404-n-k-no-v1-rj");
 -- Medulin / Airport: Pula
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) VALUES 
("Park Plaza Belvedere Medulin", 4, 23, 20, "Osipovica 33", "https://www.valamar.com/CmsMedia/Objekti/Rabac/Miramar/V3/overview/miramar-sunny-hotel-exterior-overview-XL.jpg");
-- Split / Airport: Split
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) VALUES 
("Hotel Park - Potestas Ltd.", 5, 24, 21, "Hatzeov perivoj 3", "https://www.hotelpark-split.hr/assets/cms_page_image/cms_page_1529391615_details_original.jpg");
-- Arbanija / Airport: Split
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) VALUES 
("Hotel Sv. Kriz", 3, 30, 21, "Cesta Domovinske Zahvalnosti 1", "http://www.putnickaagencijaklek.hr/wp-content/uploads/2018/01/hotel-sveti-kriz2_6229.jpg");
-- Trogir / Airport: Split
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) VALUES 
("Brown Beach House", 4, 29, 21, "Put Gradine 66", "https://brownhotels.com/croatia/sites/default/files/styles/gallery_thumb/public/croatia/the_hotel_brown_beach_house_croatia_80.jpg");
-- Dubrovnik / Airport: Dubrovnik
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) VALUES 
("Hilton Imperial", 5, 25, 22, "Ul. Marijana Blažića 2", "https://croatia.hr/sites/default/files/styles/image_full_width/public/2017-09/deluxim.jpg");
-- Slano / Airport: Dubrovnik
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) VALUES 
("Pavkovic Guesthouse", 2, 31, 22, "Put Grgurica 86", "https://hi-cdn.t-rp.co.uk/images/hotels/3053924/0");

-- Spain Hotels (id, name, rating, id_city, id_airport, address, img_url)
-- Barcelona / Airport: Barcelona
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) 
VALUES ("Hotel Arts", 5, 14, 15, "Carrer de la Marina, 19", "https://cdn.kiwicollection.com/media/property/PR003116/xl/003116-17-Hotel%20Arts%2006.jpg");
-- Girona / Airport: Barcelona
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) 
VALUES ("Hostal de la Gavina", 5, 20, 15, "Pza. Rosaleda", "https://www.jacadatravel.com/wp-content/uploads/2016/09/accommodation_photos__La_Gavina_Beach_StPolWF-1200x675.jpg");
-- Pontevedra / Airport: Santiego
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) 
VALUES ("Eurostars Gran Hotel A Toxa", 5, 21, 17, "Rúa da Condesa 2", "https://vive-media-tpvbooking.netdna-ssl.com/43331/0.jpg");
-- Murcia / Airport: Alicante
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) 
VALUES ("Hotel La Manga Club Príncipe Felipe", 5, 19, 16, "Carretera de Atamaría", "https://lamangaclub.com/sites/default/files/styles/page-header/public/field/image/detalle-piscina.jpg");
-- Malaga / Airport: Malaga
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) 
VALUES ("Gran Hotel Miramar", 5, 17, 18, "Paseo Reding, 22", "https://www.loveholidays.com/images/hotel-only/spain/costa-del-sol/malaga/gran-hotel-miramar.jpg?height=576&width=880");
-- Almeria / Airport: Malaga
INSERT INTO `hotel`(`name`, `rating`, `id_city`, `id_airport`, `address`, `img_url`) 
VALUES ("Hotel Golf Almerimar", 5, 18, 18, "Avda. Almerimar, sn. Urb. Almerimar", "https://media-cdn.tripadvisor.com/media/photo-s/0a/de/7d/e4/hotel-ar-golf-almerimar.jpg");
