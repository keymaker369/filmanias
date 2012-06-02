
    alter table COMMENT 
        drop 
        foreign key FK_COMMENT_USER;

    alter table COMMENT 
        drop 
        foreign key FK_COMMENT_MOVIE;

    alter table GENRE_MOVY 
        drop 
        foreign key FK_GENRE_MOVY_GENRE;

    alter table GENRE_MOVY 
        drop 
        foreign key FK_GENRE_MOVY_MOVY;

    alter table MOVIE 
        drop 
        foreign key FK_MOVIE_USER;

    alter table RATING 
        drop 
        foreign key FK_RATING_USER;

    alter table RATING 
        drop 
        foreign key FK_MOVIE_RATING_MOVIE;

    drop table if exists COMMENT;

    drop table if exists GENRE;

    drop table if exists GENRE_MOVY;

    drop table if exists MOVIE;

    drop table if exists RATING;

    drop table if exists USER;

    create table COMMENT (
        ID bigint not null auto_increment,
        CONTENT varchar(100) not null,
        INPUTDATE date not null,
        VERSION bigint not null,
        MOVIE bigint not null,
        USER bigint not null,
        primary key (ID),
        unique (ID, USER, MOVIE)
    );

    create table GENRE (
        ID bigint not null auto_increment,
        NAME varchar(100) not null unique,
        VERSION bigint not null,
        primary key (ID)
    );

    create table GENRE_MOVY (
        GENRE bigint not null,
        MOVY bigint not null,
        primary key (GENRE, MOVY)
    );

    create table MOVIE (
        ID bigint not null auto_increment,
        INPUTDATE date not null,
        NAME varchar(100) not null,
        RANK double precision not null,
        VERSION bigint not null,
        USER bigint,
        primary key (ID)
    );

    create table RATING (
        ID bigint not null auto_increment,
        INPUTDATE date not null,
        MARK integer not null,
        VERSION bigint not null,
        MOVIE bigint not null,
        USER bigint not null,
        primary key (ID),
        unique (ID, USER, MOVIE)
    );

    create table USER (
        ID bigint not null auto_increment,
        ACCOUNTNONEXPIRED bit not null,
        ACCOUNTNONLOCKED bit not null,
        CREDENTIALSNONEXPIRED bit not null,
        EMAILADRESS varchar(100) not null,
        ENABLED bit not null,
        PASSWORD varchar(100) not null,
        ROLE varchar(6),
        USERNAME varchar(100) not null,
        VERSION bigint not null,
        primary key (ID)
    );

    alter table COMMENT 
        add index FK_COMMENT_USER (USER), 
        add constraint FK_COMMENT_USER 
        foreign key (USER) 
        references USER (ID);

    alter table COMMENT 
        add index FK_COMMENT_MOVIE (MOVIE), 
        add constraint FK_COMMENT_MOVIE 
        foreign key (MOVIE) 
        references MOVIE (ID);

    alter table GENRE_MOVY 
        add index FK_GENRE_MOVY_GENRE (GENRE), 
        add constraint FK_GENRE_MOVY_GENRE 
        foreign key (GENRE) 
        references GENRE (ID);

    alter table GENRE_MOVY 
        add index FK_GENRE_MOVY_MOVY (MOVY), 
        add constraint FK_GENRE_MOVY_MOVY 
        foreign key (MOVY) 
        references MOVIE (ID);

    alter table MOVIE 
        add index FK_MOVIE_USER (USER), 
        add constraint FK_MOVIE_USER 
        foreign key (USER) 
        references USER (ID);

    alter table RATING 
        add index FK_RATING_USER (USER), 
        add constraint FK_RATING_USER 
        foreign key (USER) 
        references USER (ID);

    alter table RATING 
        add index FK_MOVIE_RATING_MOVIE (MOVIE), 
        add constraint FK_MOVIE_RATING_MOVIE 
        foreign key (MOVIE) 
        references MOVIE (ID);
