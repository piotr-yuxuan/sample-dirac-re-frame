(ns sample-dirac-re-frame.events
  (:require [re-frame.core :as re-frame]
            [sample-dirac-re-frame.db :as db]))

(re-frame/reg-event-db
  :initialize-db
  (fn [_ _]
    db/default-db))

(re-frame/reg-event-fx
  :increment-counter
  (fn [{:keys [db]} [sub-kw new-value]]
    {:db (assoc db :counter new-value)
     :dispatch [:change-background-color]}))

(re-frame/reg-event-fx
  :change-background-color
  (fn [{:keys [db]} _]
    {:db (assoc db :background-color (rand-nth [:red :green :blue :coral :cyan :brown]))
     :println "Background color changed"}))
