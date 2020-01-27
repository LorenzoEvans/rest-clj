-- :name create-articles-table
-- :command :execute
-- :result :raw
-- :doc Create articles table

create table articles (
  id    integer auto_increment primary key,
  title   varchar(40),
  body text,
  created_at timestamp not null default current_timestamp     
)