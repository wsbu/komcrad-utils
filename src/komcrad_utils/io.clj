(ns komcrad-utils.io)

(defn tmp-file
  "returns a tmp file File object"
  []
  (. java.io.File createTempFile "komcrad-utils-" ".tmp"))

(defn tmp-folder
  "returns a tmp folder File object"
  []
  (let [file (tmp-file)]
    (.delete file)
    (.mkdir file)
    file))

(defn resource-as-file
  "returns a temp file containing resource"
  [resource]
  (let [res (clojure.java.io/resource resource)
        tmp (tmp-file)]
    (with-open [in (clojure.java.io/input-stream res)]
      (clojure.java.io/copy in tmp) tmp)))

(defn delete-file
  "deletes file recursively"
  [file]
  (loop [files (vec [(clojure.java.io/file file)])]
    (when (not (empty? files))
      (let [f (first files)]
        (if (and (.isDirectory f) (> (count (.listFiles f)) 0))
            (recur (concat (vec (.listFiles f)) files))
            (do (.delete f)
                (recur (rest files))))))))

(defmacro with-tmp-file
  "executes body and insures the file is deleted"
  [file & body]
  `(let [file# ~file]
     (try
       ~@body
       (finally (delete-file file#)))))

(defn available-port? [n]
  (try
    (let [socket (java.net.ServerSocket. n)]
      (.close socket) true)
    (catch Exception e false)))

(defn available-port []
  (let [socket (java.net.ServerSocket. 0)]
    (.close socket)
    (.getLocalPort socket)))
