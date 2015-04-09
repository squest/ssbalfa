(ns ssbone.core
	(:require
		[immutant.web :as web]
		[ssbone.handler :as handler]
		[com.stuartsierra.component :as component])
	(:gen-class))

(defonce server (atom nil))

(defn run-site
	[]
	(reset! server (web/run-dmc handler/app {:port 3000})))

(defn stop-site
	[]
	(reset! server (web/stop @server)))



(defn -main [& args]
	(web/run handler/app {:port 3000}))
