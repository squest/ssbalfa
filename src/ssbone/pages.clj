(ns ssbone.pages
	(:require
		[selmer.parser :as selmer]))

(defn- render
	"Render a file in folder templates"
	[fname page-map]
	(selmer/render-file (str "templates/" fname ".html")
											page-map))

(defn home
	[]
	(render "index"
					{:page {:title    "This is fun"
									:headline "This is a clojure web development"}}))



