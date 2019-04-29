(ns komcrad-utils.user
  (:gen-class))

(defmacro sandbox! []
  `(do
     (use '[clojure.tools.namespace.repl :only ~'(refresh)])
     (clojure.tools.namespace.repl/refresh)
     (use 'clojure.repl)
     (require '[komcrad-utils.string :as ~'ks]
              '[komcrad-utils.io :as ~'kio]
              '[komcrad-utils.wait :as ~'kw])))

