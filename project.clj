(defproject fif-lang/fifql-fx "1.3.0-SNAPSHOT"
  :description "re-frame effect handlers for fifql"
  :url "http://github.com/fif-lang/fifql-fx"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.520"]
                 [re-frame "0.10.6"]
                 [cljs-http "0.1.46"]]
  :repl-options {:init-ns fifql-fx.core}

  :repositories [["clojars" {:sign-releases false}]]

  :profiles 
  {:dev 
   {:main fifql-fx.commandline
    :dependencies [[org.clojure/core.async "0.4.490"]
                   [fifql "1.3.0"]
                   [mount "0.1.16"]
                   [ring/ring-defaults "0.3.2"]
                   [compojure "1.6.1"]
                   [http-kit "2.3.0"]]
    :plugins [[lein-cljsbuild "1.1.7"]
              [lein-doo "0.1.8"]
              [lein-ancient "0.6.15"]
              [com.bhauman/figwheel-main "0.2.0"]
              [com.bhauman/rebel-readline-cljs "0.1.4"]]
    :repl-options {:init-ns fifql-fx.dev.user
                   :port 9005}}})
