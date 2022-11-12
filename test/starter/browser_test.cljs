(ns starter.browser-test
  (:require [clojure.test :refer [deftest testing is]]))

(deftest simple-test
  (testing "a simple test"
    (is (= 1 1))))

(deftest simple-test2
  (testing "another simple test"
    (is (= 1 1))))

(deftest simple-test3
  (testing "yet another simple test"
    (is (not= 2 1))))
