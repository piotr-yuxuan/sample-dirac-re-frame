(defproject sample-dirac-re-frame "0.1.0-SNAPSHOT"
  :license {:name "GNU GPL v3+"
            :url "http://www.gnu.org/licenses/gpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.10.0-alpha4"]
                 [org.clojure/clojurescript "1.10.238"]
                 [reagent "0.8.0-rc1"]
                 [re-frame "0.10.5"]]
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-ancient "0.6.10"]]
  :min-lein-version "2.5.3"
  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"
                                    "docs/css"
                                    "docs/img"
                                    "docs/js"
                                    "docs/favicon.ico"
                                    "docs/index.html"]
  :source-paths ["src"]
  :figwheel {:css-dirs ["resources/public/css"]}
  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.10"]]
                   :plugins [[lein-figwheel "0.5.16-SNAPSHOT"]]}
             :emacs [:dev {:repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
                           :dependencies [[binaryage/dirac "LATEST"] ;; only for the preload
                                          [com.cemerick/piggieback "0.2.2"]
                                          [org.clojure/tools.nrepl "0.2.13"]
                                          [figwheel-sidecar "0.5.16-SNAPSHOT"]]}]
             :intelli-j-dirac [:dev {:dependencies [ ;; for the server and agent
                                                    [binaryage/dirac "LATEST"]]
                                     :repl-options {:port 8230
                                                    :nrepl-middleware [dirac.nrepl/middleware]
                                                    :init (do (require 'dirac.agent)
                                                              (dirac.agent/boot!))}}]}
  :cljsbuild {:builds {:dev {:source-paths ["src/cljs"]
                             :figwheel {:on-jsload "sample-dirac-re-frame.core/mount-root"}
                             :compiler {:main sample-dirac-re-frame.core
                                        :output-to "resources/public/js/compiled/app.js"
                                        :output-dir "resources/public/js/compiled/out"
                                        :asset-path "js/compiled/out"
                                        :source-map-timestamp true
                                        :preloads [dirac.runtime.preload devtools.preload]
                                        :external-config {:devtools/config {:features-to-install :all}}}}
                       :min {:source-paths ["src/cljs"]
                             :compiler {:main sample-dirac-re-frame.core
                                        :output-to "resources/public/js/compiled/app.js"
                                        :optimizations :advanced
                                        :closure-defines {goog.DEBUG false}
                                        :pretty-print false}}}}
  :aliases {"dist" ["do"
                    "clean,"
                    "cljsbuild" "once" "min,"
                    "shell" "./release.sh"]})
