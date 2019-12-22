(ns rest-api.simple-body-page
    (:require [clojure.pprint :as ppr]
              [clojure.string :as str]
              [clojure.data.json :as json]))

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
; :name works because we used ?name= as a query string, and our params are turned into a map
; in the request object
(def people-collection (atom []))

; (defn add-person [f-name l-name]
;     (swap! people-collection conj {:firstname (str/capitalize f-name)
;                                    :lastname (str/capitalize l-name)}))
; (add-person "Lore" "Silver")
; (add-person "Klassic" "Kloudhead")

(defn people-handler [req]
    {:status 20
     :headers {"Content-Type" "text/json"}
     :body (str (json/write-str @people-collection))})

(defn get-parameter [req p-name]
    (get (:param req) p-name))

(defn add-person [req & args]
 {:status 200
    :headers {"Content-Type" "text/json"}
    :body (-> (let [p (partial get-parameter req)]
                (str (json/write-str (add-person (p :firstname) (p :lastname))))))})
