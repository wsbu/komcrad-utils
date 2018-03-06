(ns komcrad-utils.string)

(defn replace-several [content & replacements]
  (let [replacement-list (partition 2 replacements)]
    (reduce #(apply clojure.string/replace %1 %2) content replacement-list)))
