--	Zach Weiss
--	09/23/2020
--	Lab 4
--	Prof. Labouseur

--	Query 1
--	This query gives us all the data on people who are customers.
select * 
from People
where pid in (select pid
			 	from Customers);
					
--	Query 2
--	This query will give us all the data on people who are agents.
select *
from People
where pid in (select pid
				 from Agents);
				 
--	Query 3
--	This query will give us all the data on people who are both
--		customers and agents, but not one or the other.
select *
from People
where pid in (select pid 
			 	from Customers
			  	where pid in
			  		(select pid
			  			from Agents));
						
--	Query 4
--	This query will give us all the data on the people who aren't
--		customers or agents.
select *
from People
where pid not in (select pid
				 	from Customers)
			and pid not in (select pid
						   	from Agents);
							
--	Query 5
--	This query will give us the IDs of customers who ordered
--	prodID p01, p07, or both.
select custId
from Orders 
where prodId = 'p01' 
	or prodId = 'p07';
	
--  Query 6
--	This query will give us the ID of customers who ordered
--		both products (p01 and p07), ordered highest to lowest.
select distinct custId
from Orders
where prodId  = 'p01'
	and custId in (select custId
			       from Orders
			   			where prodId = 'p07')
order by custId desc;

--	Query 7
--	This query will give us the first and last names of agents
--		who sold products p05 or p07, ordered by last name Z - A.
select firstName, lastName
from People
where pid in ((select pid
			 from Agents
			  where pid in (select agentId
						   from Orders
							where prodId = 'p05'
								or prodId = 'p07')))
								order by lastName desc;
								
--	Query 8
--	This query will give us the hometown and birthday of agents
--		who worked with the customer pid 001, sorted by the 
--		hometowns from A to Z.
select homeCity, dob
from People
where pid in (select pid
			 from Agents
			 where pid in (select agentId
						   from Orders
						  	where custId = 001))
							order by homeCity asc;

--	Query 9
--	This query will give us distinct IDs of products ordered
--		through any agent who took one or more orders
--		from a customer in Toronto, ordered by id high to low.
select distinct prodId
from Orders
where agentId in (select agentId
				  from Orders
				  where custId in (select pid
								  	from People
								    where homeCity = 'Toronto'))
									order by prodId desc;
									
--	Query 10
--	This query will give us the last names and home cities 
--		of customers who place orders through agents based in
--		Teaneck or Santa Monica.
select lastName, homeCity
from People
where pid in (select custId
			  from Orders
			  where agentId in (select pid
			      			   from People
							  where homeCity = 'Teaneck'
					          or homeCity = 'Santa Monica'));