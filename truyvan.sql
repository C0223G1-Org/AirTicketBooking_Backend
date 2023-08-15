select rt.id_route as idRoute ,rt.date_arrival as dateArrival, rt.date_departure as dateDeparture, rt.name_route as nameRoute, rt.price_route as priceRoute, rt.time_arrival as timeArrival, rt.time_departure as timeDeparture, ac.name_air_craft as nameAirCraft, dt.name_destination as nameDestination, dp.name_departure as nameDeparture
from route rt 
join air_craft ac on rt.id_air_craft = ac.id_air_craft
join departure dp on rt.id_departure = dp.id_departure
join destination dt on rt.id_destination = dt.id_destination
where dp.name_departure = "Tp. Hồ Chí Minh (SGN)"
and dt.name_destination = "Hà Nội (HAN)"
and rt.date_departure = "2023-08-20"
and rt.date_departure >= now();


UPDATE account SET password = 'NgocSang1236' 
WHERE password = 'NgocSang1238'
and id_account = (
select account_id_account 
from customer
where id_customer = 1);	

UPDATE account SET password = 'Sanglong98' 
WHERE password = 'Ngocsang123'
and id_account = (
select account_id_account 
from employee
where id_employee = 1);




select * from type_seat;

select ts.id_type_seat as idTypeSeat,ts.name_type_seat as nameTypeSeat, count(*) as countSeatEmpty
from seat s join type_seat ts on s.id_type_seat = ts.id_type_seat
where s.id_route = 7
and s.flag_seat = false
group by s.id_type_seat;

select rt.id_route ,rt.date_arrival, rt.date_departure, rt.name_route, rt.price_route, rt.time_arrival, rt.time_departure, ac.name_air_craft, dt.name_destination, dp.name_departure
from route rt 
join air_craft ac on rt.id_air_craft = ac.id_air_craft
join departure dp on rt.id_departure = dp.id_departure
join destination dt on rt.id_destination = dt.id_destination
where rt.id_route = 1;
