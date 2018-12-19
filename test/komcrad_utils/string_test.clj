(ns komcrad-utils.string-test
  (:require [clojure.test :refer :all]
            [komcrad-utils.string :refer :all]))

(deftest literal-test
  (testing "literal"
    (is (= "the cow says \\\"hi there\\\""
           (literal "the cow says \"hi there\"")))))

(deftest replace-several-test
  (testing "replace-several"
    (is (= "hello there citizens"
           (replace-several "hello world people" "world" "there" "people" "citizens")))
    (is (= "helm there belmw the cmves"
           (replace-several "hello there bellow the cloves" "lo" "m")))
    (is (= "say 'ahhh'"
           (replace-several "say \"ahhh\"" "\"" "'")))))

(deftest between-test
  (testing "between"
    (is (= "h1" (between "<h1></h1>" "<" ">")))
    (is (= "<h1>hi</h1>" (between "<body><h1>hi</h1></body>" "<body>" "</body>")))
    (is (nil? (between "hello ther" "<" ">")))
    (is (nil? (between "hello< ther" "<" ">")))))

(deftest between-seq-test
  (testing "between-seq-test"
    (is (= (list "h1" "/h1") (between-seq "<h1>hi</h1>" "<" ">")))))
