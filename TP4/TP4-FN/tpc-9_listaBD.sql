
select * from Professors;

-- inserindo padroes valores na base de dados
insert into Professors(Firstname, Lastname,Code, Username,Day,Month,Year, Password) values ("Fredy","Brito",6162114,"Froyd",10,11,2003,"Fredboy17$");
insert into Professors(Firstname, Lastname,Code, Username,Day,Month,Year, Password) values ("Paulo","Silva",123,"Isecmar-Paulo",12,12,1970,"cisco2023");
insert into Professors(Firstname, Lastname,Code, Username,Day,Month,Year, Password) values ("Nelson","Sousa",6161612,"Rei_da_Passada",12,11,2003,"12345");
insert into Professors(Firstname, Lastname,Code, Username,Day,Month,Year, Password) values ("Ericles","Fonseca",6161613,"emossOK",10,11,2001,"eck");

SELECT Firstname FROM UserAcounts WHERE Username = "Froyd";
SELECT count(1) from UserAcounts where Username = "emossOK" AND Password = "eck";


create table fotos (
    id int auto_increment primary key,
    nome varchar(100),
    fotoperfil varchar(100)
);

insert into fotos (nome, fotoperfil) values
  ("Ericles", "file:src/main/resources/com/example/tpc9/Images/ericles.jpeg"),
  ("Fredy",   "file:src/main/resources/com/example/tpc9/Images/marko.jpegg"),
  ("Paulo",   "file:src/main/resources/com/example/tpc9/Images/gemstone.png"),
  ("Lenice",  "file:src/main/resources/com/example/tpc9/Images/rosa.jpeg"),
  ("Nelson",  "file:src/main/resources/com/example/tpc9/Images/gemstone.png");

select * from fotos;

drop table fotos;












