(ns sample-dirac-re-frame.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
  :name
  (fn [db]
    (get db :name)))

(re-frame/reg-sub
  :counter
  (fn [db]
    (get db :counter)))

(re-frame/reg-sub
  :background-color
  (fn [db]
    (get db :background-color)))
