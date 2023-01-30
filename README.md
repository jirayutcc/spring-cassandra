# spring-cassandra


#### Install cassandra with docker
```
$ docker run --name cassandra-node -p 9042:9042 -d cassandra
```

#### Run cassandra with docker
```
$ docker run --name cassandra-node -p 9042:9042 -d cassandra
```

#### Execute CQL shell
```
$ docker exec -it cassandra-node bash
root@9c1ad817715a:/# cqlsh
Connected to Test Cluster at 127.0.0.1:9042
[cqlsh 6.0.0 | Cassandra 4.0.7 | CQL spec 3.4.5 | Native protocol v5]
Use HELP for help.
```

#### CREATE KEYSPACE
```
cqlsh> CREATE KEYSPACE mycassandrakeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
```

#### CREATE TABLE
```
cqlsh> CREATE TABLE mycassandrakeyspace.employee (id UUID PRIMARY KEY, firstname text, lastname text, age int, email text);
```