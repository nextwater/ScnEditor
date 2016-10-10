create table a_agent1 (fqid text primary key, label text, x float, y float);
create table o_plat (fqid text primary key, label text, x float, y float);
create table t_move (fqid text primary key, label text, to_x float, to_y float, t int);
create table r_rel (rid text primary key, value text);
create table x_event (eid serial primary key, fqid text, rid text, scenarioid int, stepid int);
create table register (id serial primary key, type text, lookup text);
insert into register (type,lookup) values ('agent1', 'java:module/Agent1Bean');
