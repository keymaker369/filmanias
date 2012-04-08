
    alter table COMMENT 
        drop constraint FK_COMMENT_USER;

    alter table COMMENT 
        drop constraint FK_COMMENT_MOVIE;

    alter table GENRE_MOVY 
        drop constraint FK_GENRE_MOVY_GENRE;

    alter table GENRE_MOVY 
        drop constraint FK_GENRE_MOVY_MOVY;

    alter table MOVIE 
        drop constraint FK_MOVIE_USER;

    alter table RATING 
        drop constraint FK_RATING_USER;

    alter table RATING 
        drop constraint FK_MOVIE_RATING_MOVIE;

    alter table ROLE_USER 
        drop constraint FK_ROLE_USER_ROLE;

    alter table ROLE_USER 
        drop constraint FK_ROLE_USER_USER;

    drop table COMMENT if exists;

    drop table GENRE if exists;

    drop table GENRE_MOVY if exists;

    drop table MOVIE if exists;

    drop table RATING if exists;

    drop table ROLE if exists;

    drop table ROLE_USER if exists;

    drop table USER if exists;

    create table COMMENT (
        ID bigint ,
        CONTENT varchar(100) not null,
        INPUTDATE date not null,
        VERSION bigint not null,
        MOVIE bigint not null,
        USER bigint not null,
        primary key (ID),
        unique (ID, USER, MOVIE)
    );

    create table GENRE (
        ID bigint ,
        NAME varchar(100) not null,
        VERSION bigint not null,
        primary key (ID),
        unique (NAME)
    );

    create table GENRE_MOVY (
        GENRE bigint not null,
        MOVY bigint not null,
        primary key (GENRE, MOVY)
    );

    create table MOVIE (
        ID bigint ,
        INPUTDATE date not null,
        NAME varchar(100) not null,
        RANK double not null,
        VERSION bigint not null,
        USER bigint,
        primary key (ID)
    );

    create table RATING (
        ID bigint ,
        INPUTDATE date not null,
        MARK integer not null,
        VERSION bigint not null,
        MOVIE bigint not null,
        USER bigint not null,
        primary key (ID),
        unique (ID, USER, MOVIE)
    );

    create table ROLE (
        ID bigint ,
        NAME varchar(100) not null,
        VERSION bigint not null,
        primary key (ID),
        unique (NAME)
    );

    create table ROLE_USER (
        ROLE bigint not null,
        USER bigint not null,
        primary key (ROLE, USER)
    );

    create table USER (
        ID bigint ,
        ACCOUNTNONEXPIRED bit not null,
        ACCOUNTNONLOCKED bit not null,
        CREDENTIALSNONEXPIRED bit not null,
        EMAILADRESS varchar(100) not null,
        ENABLED bit not null,
        PASSWORD varchar(100) not null,
        USERNAME varchar(100) not null,
        VERSION bigint not null,
        primary key (ID)
    );

    alter table COMMENT 
        add constraint FK_COMMENT_USER 
        foreign key (USER) 
        references USER;

    alter table COMMENT 
        add constraint FK_COMMENT_MOVIE 
        foreign key (MOVIE) 
        references MOVIE;

    alter table GENRE_MOVY 
        add constraint FK_GENRE_MOVY_GENRE 
        foreign key (GENRE) 
        references GENRE (ID);

    alter table GENRE_MOVY 
        add constraint FK_GENRE_MOVY_MOVY 
        foreign key (MOVY) 
        references MOVIE (ID);

    alter table MOVIE 
        add constraint FK_MOVIE_USER 
        foreign key (USER) 
        references USER (ID);

    alter table RATING 
        add constraint FK_RATING_USER 
        foreign key (USER) 
        references USER (ID);

    alter table RATING 
        add constraint FK_MOVIE_RATING_MOVIE 
        foreign key (MOVIE) 
        references MOVIE (ID);

    alter table ROLE_USER 
        add constraint FK_ROLE_USER_ROLE 
        foreign key (ROLE) 
        references ROLE (ID);

    alter table ROLE_USER 
        add constraint FK_ROLE_USER_USER 
        foreign key (USER) 
        references USER (ID);

