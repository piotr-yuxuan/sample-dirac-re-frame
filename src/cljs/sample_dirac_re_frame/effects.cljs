(ns sample-dirac-re-frame.effects
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-fx
  :println
  (fn [& params]
    (apply println params)))
