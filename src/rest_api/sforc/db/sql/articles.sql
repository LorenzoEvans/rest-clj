-- :name create-articles-table
-- :command :execute
-- :result :raw
-- :doc Create articles table

create table articles (
  id    integer auto_increment primary key,
  title   varchar(40) unique,
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

-- :name update-article-title :! :n
-- :doc Update the title of an article
update articles
set title = :title
where id = :id

update articles
set body = :body
where id = :id


-- :name insert-tag :! :n
-- :doc Insert single tag into article
insert into articles (tag)
values (:id, tag)
where id = :id

-- :name delete-article-by-id :! :n
-- :doc Delete an article by id
delete from characters where id = :id

-- :name all-articles :? :*
-- :doc Retrieve all articles
select * from articles
order by id -- maybe change this to timestamp at some point

-- :name get-article-by-id :? :1
-- :doc Get article by id.
select * from articles
where id = :id

-- :name get-articles-by tag
-- :doc Get articles by tag
-- select * from articles
-- where tag = :tag