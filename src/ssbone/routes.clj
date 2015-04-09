(ns ssbone.routes
	(:require
		[compojure.route :as route]
		[compojure.core :refer :all]
		[ssbone.pages :as page]))

(def main
	(routes (GET "/" []
							 (page/home))))

(def backoffice
	(context "/backoffice" req
					 (GET "/" req "This is the backoffice")))

(def resta
	(route/not-found "Not Found"))

(def app-routes
	(routes main backoffice resta))
