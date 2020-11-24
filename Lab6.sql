--  Zach Weiss
--  10/12/2020
--  Lab 6
--  Prof. Labouseur

--  Query 1
--  This Query gives us the cities that make the most different products
select city
from Products
group by city
having count(*) in (select max(cities.countProds) --  We need a new table and alias to count cities to find the max
                      from (select count(*) as countProds
                              from Products
                              group by city) as cities);
					  
--  Query 2
--  This query will give us products with price >= average price
--    in reverse alphabetical order.
select name
from Products --  gives us name of the products in the products table
where priceUSD >= (select avg(priceUSD)
                     from Products)  --  finds average priceUSD and selects 
					                --    products above that price
order by name desc; --  orders by name of products Z - A, also, I love the $42134.04 average

--  Query 3
--  This query displays last names, prodId ordered, and total priceUSD for customers
--    who made orders in March, sorted high to low by totalUSD
select p.lastName, o.prodId, o.totalUSD  --  selects the proper attributes from their respective tables
from People p inner join Customers c on p.pid = c.pid  --  selects customers only
              inner join Orders o on c.pid = o.custId  --  finds customers who placed orders
where date_part('month', o.dateOrdered) = 3  --  takes only orders from March
order by totalUSD desc;  -- orders by the order price high to low

--  Query 4
--  This query displays customers' last names and their total ordered
select p.lastName, (coalesce(sum(o.totalUSD), 0))  --  select last name and total price of orders, sets nulls to 0
from People p inner join Customers c on p.pid = c.pid  --  selects customers
              left outer join Orders o on c.pid = o.custId  --  finds customers' orders in the orders table
group by p.lastName  -- makes sure their total cost is grouped by their lastName
order by p.lastName desc;  --  orders by lastName Z - A

--  Query 5
--  Displays names of customers who bought products from Teaneck based agents
--    along with the product names and agent names
select p.firstName, p.lastName, pr.name  --  Selects the proper attributes to display
from People p inner join Customers c on p.pid = c.pid  --  Finds people who are customers		  
              inner join Orders o on c.pid = o.custId  --  Finds customers who made an order
              inner join Products pr on o.prodId = pr.prodId  --  Finds the products that were ordered for their name
              inner join Agents a on o.agentId = a.pid  --  Finds which agents placed the order
              inner join People pe on a.pid = pe.pid  -- Gets the agents' people data
where pe.homeCity = 'Teaneck';  -- Only uses agents from Teaneck

--  Query 6
--  This checks the accuracy of the totalUSD column.
select *
from Orders o inner join Products pr on o.prodId = pr.prodId  --  finds products that were ordered
              inner join Customers c on o.custId = c.pid  --  Finds customers who placed an order so we know their discount
where o.totalUSD != ((o.quantityOrdered * pr.priceUSD * (1- (c.discountPct)/100)));  --  Calculates the order total and finds those not equal to the one in Orders

--  Query 7
--  This query displays the first and last names of customers who are also agents
select *
from People
where pid in (select pid
                from Customers
                where pid in (select pid
                                from Agents));
							 
--  Query 8
--  This query creates a view of all customer and people data.
--    It also creates a view of all agent and people data.
create view PeopleCustomers as
select * 
from People
where pid in (select pid
                from Customers);  -- Finds people who are customers

select *
from PeopleCustomers;  --  Displays all data from PeopleCustomers view

create view PeopleAgents as
select *
from People
where pid in (select pid
                from Agents);  --  Finds people who are agents
			   
select *
from PeopleAgents;  -- Displays all data from PeopleAgents view

--  Query 9
--  This query displays the first and last name of all customers who are also agents
--    but instead using the views we now have.
select *
from PeopleCustomers
where pid in (select pid
                from PeopleAgents);  -- Same as query 7 but using views
			   
--  Query 10
--  When using views rather than subqueries, the database server is using the view,
--    which is a virtual table stored as a query, to then find the base table from the
--    query stored and display the proper information from the base tables.

--  Query 11
--  A left outer join first takes data from the table referenced on the left, 
--    matches it with data from the right hand table, and nulls those that don't match.
--    A right outer join performs the same process but first referencing the right hand 
--    referenced table, matching to the left hand table, and nulling those that don't match.
select *
from People p left outer join Customers c on p.pid = c.pid;

select *
from Orders o right outer join Products pr on o.prodId = pr.prodId;
