(ns komcrad-utils.io-test
  (:require [clojure.test :refer :all]
            [komcrad-utils.io :refer :all]))

(deftest available-port?-test
  (testing "available-port?"
    (with-open [socket (java.net.ServerSocket. (available-port))]
      (is (not (available-port? (.getLocalPort socket)))))
    (is (available-port? (available-port)))))

(deftest available-port-test
  (testing "available-port"
    (is (available-port? (available-port)))))
