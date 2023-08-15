select ts.name_type_seat as nameTypeSeat, count(*) as countSeatEmpty
from seat s join type_seat ts on s.id_type_seat = ts.id_type_seat
where s.id_route = 3
and s.flag_seat = false
group by s.id_type_seat;

select price_extra from type_seat
where id_type_seat = 1;

select rt.id_route as idRoute ,rt.date_arrival as dateArrival, rt.date_departure as dateDeparture, rt.name_route as nameRoute, rt.price_route as priceRoute, rt.time_arrival as timeArrival, rt.time_departure as timeDeparture, ac.name_air_craft as nameAirCraft, dt.name_destination as nameDestination,
 dp.name_departure as nameDeparture, (
 select count(*) as countSeatEmpty
from seat s join type_seat ts on s.id_type_seat = ts.id_type_seat
where s.id_route = rt.id_route
and ts.name_type_seat = "BUSSINESS"
and s.flag_seat = false
group by s.id_type_seat
 ) as seatsBussinessRemaining,
 (
  select count(*) as countSeatEmpty
from seat s join type_seat ts on s.id_type_seat = ts.id_type_seat
where s.id_route = rt.id_route
and ts.name_type_seat = "skyBOSS"
and s.flag_seat = false
group by s.id_type_seat
 ) as seatsSkybossRemaining,
 (
   select count(*) as countSeatEmpty
from seat s join type_seat ts on s.id_type_seat = ts.id_type_seat
where s.id_route = rt.id_route
and ts.name_type_seat = "VELUXE"
and s.flag_seat = false
group by s.id_type_seat
 ) as seatsVeluxeRemaining,
 (
    select count(*) as countSeatEmpty
from seat s join type_seat ts on s.id_type_seat = ts.id_type_seat
where s.id_route = rt.id_route
and ts.name_type_seat = "ECO"
and s.flag_seat = false
group by s.id_type_seat
 ) as seatsEcoRemaining,
 (
 select price_extra from type_seat
where id_type_seat = 1
) as priceExtraBussiness,
 (
 select price_extra from type_seat
where id_type_seat = 2
) as priceExtraSkyboss,
 (
 select price_extra from type_seat
where id_type_seat = 3
) as priceExtraVeluxe,
 (
 select price_extra from type_seat
where id_type_seat = 4
) as priceExtraEco
from route rt 
join air_craft ac on rt.id_air_craft = ac.id_air_craft
join departure dp on rt.id_departure = dp.id_departure
join destination dt on rt.id_destination = dt.id_destination
where dp.name_departure = "Hà Nội (HAN)"
and dt.name_destination = "Tp. Hồ Chí Minh (SGN)"
and rt.date_departure = "2023-08-20"
and rt.date_departure >= now();