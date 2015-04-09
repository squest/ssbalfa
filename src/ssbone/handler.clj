(ns ssbone.handler
  (:require
    [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
    [compojure.core :refer [routes]]
    [ssbone.routes :refer :all]))

(def app
  (-> (routes app-routes)
      (wrap-defaults site-defaults)))




