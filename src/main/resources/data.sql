INSERT INTO company(name,catch_phrase,bs)
VALUES ('Hoeger LLC','Centralized empowering task-force', 'target end-to-end models'),
('Yost and Sons','Switchable contextually-based project','aggregate real-time technologies'),
('Abernathy Group','Implemented secondary concept','e-enable extensible e-tailers');

INSERT INTO geographical_coordinates (lat,lng)
VALUES ('-38.2386','57.2232'),
('24.6463','-168.8889'),
('-14.3990','-120.7677'),
('24.8918','21.8984');


INSERT INTO address (street, suite, city, zipcode,geo_id)
VALUES ('Kattie Turnpike','Suite 198','Lebsackbury','314282',1),
('Dayna Park','Suite 449','Bartholomebury','764959',2),
('Ellsworth Summit','Suite 729','Aliyaview','451690',3),
('Rex Trail','Suite 280','Howemouth','588049',4);

INSERT INTO user (email,name,phone,username,website,address_id,company_id)
VALUES ('Rey.Padberg@karina.biz', 'Clementina DuBuque', '+919845761200','Moriah.Stanton','www.ambrose.net',1,3),
('Chaim_McDermott@dana.io', 'Glenna Reichert', '+917853679012','Delphine','www.conrad.com',2,1),
('Sherwood@rosamond.me', 'Nicholas Runolfsdottir V', '+917623544565','Maxime_Nienow','www.jacynthe.com',3,2),
('Telly.Hoeger@billy.biz', 'Kurtis Weissnat', '+918790090535','Elwyn.Skiles','www.elvis.io',4,3);
