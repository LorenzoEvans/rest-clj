(ns rest-api.sforc.db.articles
  (:require [hugsql.core :as sql]))

(def gen-db-fns
  "Init here means original state, not initialize,"
  (sql/def-db-fns "rest_api/sforc/db/sql/articles.sql"))
