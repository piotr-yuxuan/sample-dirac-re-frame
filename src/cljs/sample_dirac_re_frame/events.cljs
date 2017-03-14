(ns sample-dirac-re-frame.events
    (:require [re-frame.core :as re-frame]
              [sample-dirac-re-frame.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
