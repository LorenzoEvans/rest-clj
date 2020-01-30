(ns rest-api.core
  (:require [org.httpkit.server :as server]
            [clojure.pprint :as ppr]
            [clojure.java.jdbc]
            [rest-api.sforc.articles :as articles]
            [sforc.db :refer [db]]
            [clojure.string :as str]
            [clojure.data.json :as json])
  (:gen-class))

; (defroutes app-routes
;   (GET "/" [] simple-body-page)
;   (GET "/request" [] request-example)
;   (GET "/hello" [] hello-name)
;   (GET "/people" [] people-handler)
;   (POST "/people/add" [] add-person-handler)
;   (route/not-found "Error, page not found."))

; (defn -main [& args]
; ;  This sets up local port var, possibly defined on
; ;  env variable, then runs http server with site-defaults, allowing
; ;  for sessions, cookies, params, etc.
;   (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
;     ; run server with ring.defaults middleware
;     (server/run-server (wrap-defaults #'app-routes site-defaults) {:port port})
;     (println (str "Running webserver at http:/127.0.0.1:" port "/"))))
      
    
(def pp ppr/pprint)

(defn ppl [value]
  (pp x) (println))

(defn gen-tables []
  (articles/create-articles-table))

(defn drop-tables []
  (articles/drop-articles-table))

(defn inserts []
  (articles/insert-article {:title "Title" :body "Body"})
  (articles/insert-articles {:articles [["Title 2" "Body 2"]
                                        ["Title 3" "Body 3"]]})
  (articles/insert-tag {:tag "Lisp" :id 1}))
  
(defn updates []
  (let [article-1 (articles/get-article-by-id 1)]
    (articles/update-article-title {:id (:id article-1)
                                    :title "I'm Updated!"})))

(defn -main []
  (drop-tables)
  (create-tables)
  (inserts)
  (updates))
