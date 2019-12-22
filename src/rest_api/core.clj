(ns rest-api.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [clojure.pprint :as ppr]
            [clojure.string :as str]
            [clojure.data.json :as json]
            [rest-api.simple-body-page :refer [simple-body-page request-example
                                               hello-name people-handler add-person-handler]])
  (:gen-class))

(defroutes app-routes
  (GET "/" [] simple-body-page)
  (GET "/request" [] request-example)
  (GET "/hello" [] hello-name)
  (GET "/people" [] people-handler)
  (POST "/people/add" [] add-person-handler)
  (route/not-found "Error, page not found."))

(defn -main [& args]
;  This sets up local port var, possibly defined on
;  env variable, then runs http server with site-defaults, allowing
;  for sessions, cookies, params, etc.
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    ; run server with ring.defaults middleware
    (server/run-server (wrap-defaults #'app-routes site-defaults) {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))
      
    
