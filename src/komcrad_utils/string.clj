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

(defn swap-char [s i1 i2]
  (as-> (vec s) v
    (clojure.string/join "" (assoc v i2 (v i1) i1 (v i2)))))

(defn permute [s start end]
  (map #(swap-char s start %) (range start (inc end))))

(defn permutations [s]
  (loop [perms (permute s 0 (dec (count s))) start 0 end (dec (count s))]
    (if (= start end)
      perms
      (recur (flatten (map #(permute % (inc start) end) perms))
             (inc start) end))))
