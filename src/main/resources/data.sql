insert into location(id,name) values(1,'Canada');
insert into location(id,name) values(2,'USA');
insert into location(id,name) values(3,'Mexico');
commit;

insert into user(id,firstname,lastname,email,location_id) values(1,'andy','wang','andy@andy.com',1);
insert into user(id,firstname,lastname,email,location_id) values(2,'tom','wang','tom@tom.com',1);
insert into user(id,firstname,lastname,email,location_id) values(3,'jack','wang','jack@jack.com',2);
commit;

insert into post(id,postdate,details,user_id) values(1,'2020-2-12','good things',1);
insert into post(id,postdate,details,user_id) values(2,'2020-2-12','good things',2);
insert into post(id,postdate,details,user_id) values(3,'2020-2-12','good things',3);
