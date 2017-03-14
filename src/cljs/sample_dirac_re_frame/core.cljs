(ns sample-dirac-re-frame.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [re-frisk.core :refer [enable-re-frisk!]]
              [sample-dirac-re-frame.events]
              [sample-dirac-re-frame.subs]
              [sample-dirac-re-frame.views :as views]
              [sample-dirac-re-frame.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (enable-re-frisk!)))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (dev-setup)
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
