=================
Redis Cache :
=================
-> In our application we will have 2 types of tables.

		1. Transactional Tables		(App will have Crud operations)
		2. Non-Transactional Tables 	(App will have only retrive operation only).

=> Cache : 
	-> It is memory to store data in key value format.
	-> Cache is used to reduce no. of db calls in our application.
	-> DB calls is costly operation in term of execution time and no. of DB calls reduces application performance. 
	-> cache is used to improve performance of the application.

=> Redis :
	-> The open source, in-memory data store used by millions of developers as a database, cache, streaming engine and message broker.

	1. Redis download Link => https://download.redis.io/redis-stable.tar.gz
	2. Extract
	3. cmd -> redis-server.exe
	4. cmd -> redis-cli.exe -> ping  (connecting local redis server)
		
			if redis server running different machine
	   
	   cmd -> redis-cli -h <ip> -p <pwd>
	
	
