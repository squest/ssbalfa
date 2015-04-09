(ns ssbone.dbase
	(:require
		[couchbase-clj.client-builder :as cbb]
		[couchbase-clj.client :as cb]
		[com.stuartsierra.component :as com]))


(defrecord CouchbaseDB [bucket vector-of-url]
	com/Lifecycle
	(start [this]
		(assoc this
			:couchbase-db
			(cb/create-client {:bucket bucket
												 :uris vector-of-url})))
	(stop [this]
		(cb/shutdown (:couchbase-db this))
		(assoc this
			:couchbase-db nil)))

(defn add-user
	[{:keys [couchbase-db]} user-data]
	(cb/set-json (:couchbase-db couchbase-db)
							 :proj
							 user-data))

(defn make-couchbase
	[conf]
	(let [{:keys [bucket uris]} (:couchbase-db conf)]
		(map->CouchbaseDB {:bucket bucket :uris uris})))

(defn my-system
	[conf]
	(com/system-map
		:couchbase-db (make-couchbase conf)))