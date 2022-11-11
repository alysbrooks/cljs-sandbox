(ns test
  (:require [clojure.test :refer [deftest testing is]]))


(deftest simple-test
  (testing "simple test"
    (is (= 1 1))))
