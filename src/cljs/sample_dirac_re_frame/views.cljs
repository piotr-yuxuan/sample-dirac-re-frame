(ns sample-dirac-re-frame.views
    (:require [re-frame.core :as re-frame]))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])
        background-color (re-frame/subscribe [:background-color])
        counter (re-frame/subscribe [:counter])]
    (fn []
      [:div#custom-id.first-class.second-class {:style {:background-color @background-color}}
       [:button {:on-click (fn [] (re-frame/dispatch [:increment-counter (inc @counter)]))}
        (str "Click (" @counter ")")]
       [:div "Hello from " @name]])))
