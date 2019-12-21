(ns rest-api.simple-body-page
    (:require [clojure.pprint :as ppr]))

(defn simple-body-page [req]
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body "Hello World"})

(defn request-example [req]
    {:status 200
     :headers {"Content-Type" "text-html"}
     :body (->> (ppr/pprint req)
                (str "Request Object: " req))})
     
; Event handlers get a single request parameter, and return maps.
(defn hello-name [req]
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body (-> (ppr/pprint req)
               (str "Hello " (:name (:params req))))})
