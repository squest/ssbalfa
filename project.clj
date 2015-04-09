(defproject
  ssbone "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.7.0-alpha6"]
                 [compojure "1.3.3"]
                 [ring/ring-defaults "0.1.4"]
                 [selmer "0.8.2"]
                 [couchbase-clj "0.2.0"]
                 [org.immutant/immutant "2.0.0-beta2"]
                 [lib-noir "0.9.9"]
                 [com.stuartsierra/component "0.2.3"]]
  :plugins [[lein-ring "0.9.3"]]
  :ring {:handler ssbone.handler/app}
  :main ssbone.core
  :aot :all
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
