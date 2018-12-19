(ns komcrad-utils.string
  (:gen-class))

(defn literal [s]
  (.replace s "\"" "\\\""))

(defn replace-several [content & replacements]
  (let [replacement-list (partition 2 replacements)]
    (reduce #(apply clojure.string/replace %1 %2) content replacement-list)))

(defn between-pattern [prefix suffix]
  (re-pattern (str (literal prefix) "([\\s\\S]*?)" (literal suffix))))

(defn between [s prefix suffix]
  (second (re-find (between-pattern prefix suffix) s)))

(defn between-seq [s prefix suffix]
  (map #(second %) (re-seq (between-pattern prefix suffix) s)))
