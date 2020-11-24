--	Zach Weiss
--	09/17/2020
--	Lab 3
--	Prof. Labouseur

--	Query 1
--	Lists the order number and the 
--		total dollars for all orders.
select orderNum, totalUSD
from Orders;

--	Query 2
--	Lists the last name and hometown
--		of all the Doctors in the 
--		people table.
select lastName, homeCity
from People
where prefix = 'Dr.';

--	Query 3
--	Lists the ID, name, and 
--		price of all products
--		with quantity greater
--		than 1007.
select prodId, name, priceUSD
from Products
where qtyOnHand > 1007;

--	Query 4
--	Lists first name and home city
--		of people born between 
--		1/1/1950 and 12/31/1959.
select firstName, homeCity
from People
	where DOB between '1950-01-01'
		and '1959-12-31';
		
--	Query 5
--	Lists prefixes and last names for
--		everyone BUT those with the 
--		prefix Mr.
select prefix, lastName
from People
where prefix != 'Mr.';

--	Query 6
--	Lists all fields for products
--		outside of Dallas and Duluth
--		that are more than 3 dollars.
select *
from Products
where city != 'Dallas' and city != 'Duluth'
	and priceUSD > 3.00;
	
--	Query 7
--	Lists all details for orders
--		in March
select *
from Orders
where date_part('month', dateOrdered) = 3;
	
--	Query 8
--	Lists all fields for orders 
--		in February that were
--		more than 20,000 dollars.
--		Includes leap day for 2020.
select *
from Orders
where date_part('month', dateOrdered) = 2 
	and totalUSD >= 20000.00;
	
--	Query 9
--	Lists all orders from
--		customer ID 007.
select *
from Orders
where custID = '007';

--	Query 10
--	Lists orders from customer ID 005.
select *
from Orders
where custID = '005';
