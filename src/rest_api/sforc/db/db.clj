(ns rest-api.db
  (:require [hugsql.core :as sql]))

(def db
  {:subprotocol "h2"})
