(defproject sample-dirac-re-frame "0.1.0-SNAPSHOT"
  :license {:name "GNU GPL v3+"
            :url "http://www.gnu.org/licenses/gpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.495"]
                 [reagent "0.6.1"]
                 [re-frame "0.9.2"]]
  :plugins [[lein-cljsbuild "1.1.6-SNAPSHOT"]
            [lein-ancient "0.6.10"]]
  :min-lein-version "2.5.3"
  :source-paths ["src/clj"]
  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]
  :figwheel {:css-dirs ["resources/public/css"]
             :server-port 3456
             :repl false}
  :profiles {:dev
             {:dependencies [[binaryage/dirac "1.2.1"]
                             [binaryage/devtools "0.9.2"]
                             [re-frisk "0.4.4"]]
              :plugins [[lein-figwheel "0.5.9"]]
              :repl-options {:port 8230
                             :nrepl-middleware [dirac.nrepl/middleware]
                             :init (do
                                     (require 'dirac.agent)
                                     (dirac.agent/boot!))}}}
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs"]
                        :figwheel {:on-jsload "sample-dirac-re-frame.core/mount-root"}
                        :compiler {:main sample-dirac-re-frame.core
                                   :output-to "resources/public/js/compiled/app.js"
                                   :output-dir "resources/public/js/compiled/out"
                                   :asset-path "js/compiled/out"
                                   :source-map-timestamp true
                                   :preloads [devtools.preload dirac.runtime.preload]
                                   :external-config {:devtools/config {:features-to-install :all}}}}
                       {:id "min"
                        :source-paths ["src/cljs"]
                        :compiler {:main sample-dirac-re-frame.core
                                   :output-to "resources/public/js/compiled/app.js"
                                   :optimizations :advanced
                                   :closure-defines {goog.DEBUG false}
                                   :pretty-print false}}]})
