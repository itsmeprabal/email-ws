# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table drafts (
  id                            bigint auto_increment not null,
  from_email                    varchar(256),
  to_emails                     varchar(255),
  subject                       varchar(255),
  body                          longtext,
  updated_at                    datetime(6),
  created_at                    datetime(6),
  constraint pk_drafts primary key (id)
);

create table emails (
  id                            bigint auto_increment not null,
  from_email                    varchar(256),
  subject                       varchar(255),
  body                          longtext,
  updated_at                    datetime(6),
  created_at                    datetime(6),
  constraint pk_emails primary key (id)
);

create table emails_users (
  emails_id                     bigint not null,
  users_email                   varchar(256) not null,
  constraint pk_emails_users primary key (emails_id,users_email)
);

create table users (
  email                         varchar(256) not null,
  auth_token                    varchar(255),
  name                          varchar(256) not null,
  sha_password                  varbinary(64) not null,
  updated_at                    datetime(6) not null,
  created_at                    datetime(6) not null,
  constraint pk_users primary key (email)
);

create table user_emails (
  id                            bigint auto_increment not null,
  user_email                    varchar(256),
  email_id                      bigint,
  read_state                    varchar(6),
  deleted                       tinyint(1) default 0,
  updated_at                    datetime(6),
  created_at                    datetime(6),
  constraint ck_user_emails_read_state check ( read_state in ('READ','UNREAD')),
  constraint pk_user_emails primary key (id)
);

alter table drafts add constraint fk_drafts_from_email foreign key (from_email) references users (email) on delete restrict on update restrict;
create index ix_drafts_from_email on drafts (from_email);

alter table emails add constraint fk_emails_from_email foreign key (from_email) references users (email) on delete restrict on update restrict;
create index ix_emails_from_email on emails (from_email);

alter table emails_users add constraint fk_emails_users_emails foreign key (emails_id) references emails (id) on delete restrict on update restrict;
create index ix_emails_users_emails on emails_users (emails_id);

alter table emails_users add constraint fk_emails_users_users foreign key (users_email) references users (email) on delete restrict on update restrict;
create index ix_emails_users_users on emails_users (users_email);

alter table user_emails add constraint fk_user_emails_user_email foreign key (user_email) references users (email) on delete restrict on update restrict;
create index ix_user_emails_user_email on user_emails (user_email);

alter table user_emails add constraint fk_user_emails_email_id foreign key (email_id) references emails (id) on delete restrict on update restrict;
create index ix_user_emails_email_id on user_emails (email_id);


# --- !Downs

alter table drafts drop foreign key fk_drafts_from_email;
drop index ix_drafts_from_email on drafts;

alter table emails drop foreign key fk_emails_from_email;
drop index ix_emails_from_email on emails;

alter table emails_users drop foreign key fk_emails_users_emails;
drop index ix_emails_users_emails on emails_users;

alter table emails_users drop foreign key fk_emails_users_users;
drop index ix_emails_users_users on emails_users;

alter table user_emails drop foreign key fk_user_emails_user_email;
drop index ix_user_emails_user_email on user_emails;

alter table user_emails drop foreign key fk_user_emails_email_id;
drop index ix_user_emails_email_id on user_emails;

drop table if exists drafts;

drop table if exists emails;

drop table if exists emails_users;

drop table if exists users;

drop table if exists user_emails;

