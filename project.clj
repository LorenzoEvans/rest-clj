(defproject rest-api "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [http-kit "2.3.0"]
                 [com.layerware/hugsql "0.5.1"]
                 [com.h2database/h2 "1.4.200"]
                 [ring/ring-defaults "0.3.2"]
                 [org.clojure/data.json "0.2.6"]]
  :main ^:skip-aot rest-api.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
