# postgres playground
Learning and collecting information about Postgres, Spring-data and Hibernate!

## Setup
I started a local cluster of Postgres, and use that to interact with while running this app. The role 'rob' with password 'xxx' 
is used here. I also included docker-compose functionality, but did not create any helpful commands to get that 
"dockerized" setup going, it is just there to play with!

To start a local postgres server: `pg_ctl start`. Check the status with `pg_ctl status`

Now we can use the command line tool, psql, to interact with our database! The database may have to be created, which can be done with `CREATE DATABSE postgres-playground`. The tables and practice
data are inserted by the .sql files I have created, located in the resources file. Here I created a role "rob" with 
the password "xxx", this looks something like `CREATE ROLE rob WITH LOGIN PASSWORD 'xxx'`, after logging in under the admin
role. Now we can login and explore the database with `psql -d postgres_playground -U rob`.

Now, we can run our app, as we have configured our application.yml file to include the specifics about the database,
including the login and password.

I have compiled a list of insomnia requests within postgres_playground_insomnia.json. I also experimented with Spring
Data and the embedded Hibernate framework here, so that works that into this project as well.

More about postgres can be found [here](https://github.com/roschwartz79/my-notes/blob/main/postgres-notes.md), but we can
mess around inside the DB, see what tables are there (`\d`), or even what databases are currently on the server (`\l`), 
and whenever we screw something up just restart the app and all will be good! Happy hacking!
