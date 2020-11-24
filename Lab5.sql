--    Zach Weiss
--    09/30/2020
--    Lab 5
--    Prof. Labouseur

--    Query 1
--    This query gives us people data for people who are customers
--        using joins.
select p.* -- The p.* condition gives us solely people data.
from People p inner join Customers c on p.pid = c.pid;

--    Query 2
--    This query gives us the people data for the agents using joins.
select p.* --    This gives us only people data
from People p inner join Agents a on p.pid = a.pid;

--    Query 3
--    This query gives us the People AND Agent data for anyone
--        who is both a customer and an agent.
select p.*, a.* --    This gives us People and Agent data only.
from People p inner join Customers c on p.pid = c.pid
              inner join Agents a on c.pid = a.pid;

--    Query 4
--    This query outputs customer's first names who have never placed an order.
--        This query uses subqueries rather than joins.
select firstName --    The condition gives us only the customers first name.
from People
where pid in (select pid 
              from Customers
              where pid not in (select custId --    Not in gives us only the customers who are not in the orders table.
                                 from Orders));

--    Query 5
--    This gives the same output as query 4, but uses joins
select firstName --    This gives us the first name of the customers.
from People p inner join Customers c on p.pid = c.pid
              left outer join Orders o on c.pid = o.custId
              where c.pid not in (select custId 
                                      from Orders); --    Makes sure we are finding customers who didn't place an order.

--    Query 6
--    This query gives us ID and commission percentage of Agents 
--        who placed orders for customer ID 008, sorted by commission percent
--        from low to high
select distinct pid, commissionPct --    This coniditon gives only one entry for each result.
from Agents a inner join Orders o on a.pid = o.agentId
where o.custId = 8 -- This gives only Customer ID for orders is only 8
order by commissionPct ASC; -- Makes commission percentages ordered low to high

--    Query 7
--    This query gives us the last name, home city, and commission percentages of Agents
--        who booked an order for custId 1 and is sorted by commission percentage high to low.
select distinct lastName, homeCity, commissionPct --    Gives us lastName, homeCity, and commission for the agents selected.
from People p inner join Agents a on p.pid = a.pid -- Gets agents from people data
              inner join Orders o on a.pid = o.agentId -- Gets us agents who put in orders
where o.custId = 1 -- Gives us only agents who bought for customer Id 1
order by commissionPct DESC; -- Sets commission percentages to order from high to low.

--    Query 8
--     This query gives us the lastName and home city of customers who live in the city that makes the fewest different
--        products.
select lastName, homeCity -- Gives us last name and home city from People data
from People
where homeCity in (select city
                  from Products
                      group by city
                      order by count (*)
                    limit 1); --    These lines count the rows in products and limit the amount of products to 1 to find the 
                              --    city with the fewest different products.

--    Query 9
--    This query gives us the name and ID from products ordered through agents who booked one or
--        more orders for a customer from Chicago, sorted by product name from A to Z. (using joins)
select distinct pr.prodId, pr.name --    Gives us distinct product IDs and names that were placed by agents who ordered for a customer at least once from Chicago.
from Products pr inner join Orders o on pr.prodId = o.prodId
                 inner join Agents a on o.agentId = a.pid
                 where o.agentId in (select agentId
                                     from Orders
                                     where custId in (select pid
                                                     from People
                                                     where homeCity = 'Chicago'))
                                                     order by name ASC; --    Finds the agents who ordered for a customer from Chicago and selects 
                                                                        --        all the products they ordered and then orders them by name A to Z.
                                                     
--    Query 9 (using subqueries)
select distinct prodId, name --    Gives us distinct product IDs and names that were placed by agents who ordered for a customer at least once from Chicago.
from Products
where prodId in (select prodId
                    from Orders
                        where agentId in (select agentId
                                             from Orders
                                             where custId in (select pid
                                                                from People
                                                                where homeCity = 'Chicago')))
                                                                order by name ASC; --    Finds the agents who ordered for a customer from Chicago and selects 
                                                                                   --        all the products they ordered and then orders them by name A to Z.
--    Query 10
--    This query gives us the first and last names of customers and agents
--        who live in the same city and the name of the city.
select firstName, lastName, homeCity --    Gets first name, last name, and home city
from People
where homeCity in (select homeCity
                   from People p inner join Customers c on p.pid = c.pid) --    gets customers home cities to compare
                   and 
                   homeCity in (select homeCity 
                                from People p inner join Agents a on p.pid = a.pid) --    gets Agents home cities to compare
                   and
                   pid not in (select a.pid
                               from Customers c inner join Agents a on c.pid = a.pid); --    Makes sure we are only checking for customers and Agents not all people
                                          
              
              
