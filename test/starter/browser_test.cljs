(ns starter.browser-test
  (:require [clojure.test :refer [deftest testing is]]))

(deftest simple-test
  (testing "simple test"
    (is (= 1 1))))

(deftest simple-test2
  (testing "simple test"
    (is (= 1 1))))

(deftest simple-test3
  (testing "simple test"
    (is (not= 2 1))))
