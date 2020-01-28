-- :name create-articles-table
-- :command :execute
-- :result :raw
-- :doc Create articles table

create table articles (
  id    integer auto_increment primary key,
  title   varchar(40),
  body text,
  tags array,
  created_at timestamp not null default current_timestamp     
)

-- :name drop-articles-table
-- :doc Drop articles table iff it exists

drop table if exists articles

-- :name insert-article :! :n
-- :doc Insert a single article

insert into articles (title, body)
values (:title, :body)

-- :name insert-articles :! :n
-- :doc Insert multiple articles

insert into articles (title, body)
values :tuple* :articles

-- :name insert-tag :! :n
-- :doc Insert single tag into article
insert into articles (tag)
values (:id, tag)
where id = :id

