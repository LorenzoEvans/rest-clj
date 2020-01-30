(ns rest-api.sforc.db.articles
  (:require [hugsql.core :as sql]))

; "Init here means original state, not initialize,"
(sql/def-db-fns "rest_api/sforc/db/sql/articles.sql")

(sql/def-sqlvec-fns "rest_api/sforc/db/sql/articles.sql")