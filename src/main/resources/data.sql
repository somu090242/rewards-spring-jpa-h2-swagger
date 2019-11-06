INSERT INTO "USER"("USER_ID","CREATED_TIMESTAMP","UPDATED_TIMESTAMP","USER_NAME")VALUES(1,sysdate,sysdate,'somasekhar'),(2,sysdate,sysdate,'pinjala');
insert into transaction (created_timestamp, item_cost, item_name, reward_points, transaction_date, updated_timestamp, user_id, id) values 
(sysdate, 192,'Item1' ,234, parsedatetime('17-09-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 59,'Item2' ,9, parsedatetime('18-09-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 93,'Item3' ,43, parsedatetime('19-09-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 112,'Item4' ,74, parsedatetime('17-10-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 156,'Item5' ,162, parsedatetime('20-10-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 62,'Item6' ,15, parsedatetime('21-10-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 95,'Item7' ,45, parsedatetime('22-11-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 172,'Item8' ,194, parsedatetime('23-11-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence)),
(sysdate, 12,'Item9' ,0, parsedatetime('15-11-2019 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), sysdate, 1,  (SELECT NEXT VALUE FOR hibernate_sequence));