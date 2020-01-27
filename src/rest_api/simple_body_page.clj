(ns rest-api.simple-body-page
    (:require [clojure.pprint :as ppr]
              [clojure.string :as str]
              [clojure.data.json :as json]))

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
; :name works because we used ?name= as a query string, and our params are turned into a map
; in the request object
; (def people-collection (atom []))
(def article-collection (atom []))

(defn add-person [f-name l-name]
    (swap! people-collection conj {:firstname f-name
                                   :surname l-name}))
(defn add-article [title body]
  (swap! article-collection conj {:title title :body body}))                              

(defn people-handler [req]
    {:status 20
     :headers {"Content-Type" "text/json"}
     :body (str (json/write-str @people-collection))})

(defn get-parameter [req p-name]
    (get (:param req) p-name))

; (defn add-person [req & args]
;  {:status 200
;     :headers {"Content-Type" "text/json"}
;     :body (-> (let [p (partial get-parameter req)]
;                 (str (json/write-str (add-person (p :firstname) (p :lastname))))))})
(defn add-person-handler [req]
    {:status  200
     :headers {"Content-Type" "text/json"}
     :body    (-> (let [p (partial get-parameter req)]
                    (str (json/write-str (add-person (p :firstname) (p :surname))))))})

(defn article-handler [req]
  {:status 200
   :headers {"Content-Type" "text/json"}
   :body })
  
