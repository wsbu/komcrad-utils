(ns komcrad-utils.wait)

(defn wait-for
  "wait for a max of timeout in milliseconds for f to return true. Sleeping for retry-delay between each attempt of f"
  [f timeout retry-delay]
  (let [start (. System currentTimeMillis)]
    (loop [now (. System currentTimeMillis)]
      (if (< (- now start) timeout)
        (let [result (f)]
          (if result result (do (Thread/sleep retry-delay)
                              (recur (. System currentTimeMillis)))))
        nil))))
