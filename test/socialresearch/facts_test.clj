(ns socialresearch.facts-test
  (:require [clojure.test :refer [deftest is]]
            [socialresearch.facts :as facts]))

(deftest jpn-has-a-spec-basis
  (is (some? (facts/spec-basis "JPN")))
  (is (string? (:provenance (facts/spec-basis "JPN"))))
  (is (string? (:ethics-provenance (facts/spec-basis "JPN")))))

(deftest unknown-jurisdiction-has-no-fabricated-spec-basis
  (is (nil? (facts/spec-basis "ATL"))))

(deftest coverage-never-reports-a-missing-jurisdiction-as-covered
  (let [report (facts/coverage ["JPN" "ATL" "GBR"])]
    (is (= 2 (:covered report)))
    (is (= ["ATL"] (:missing-jurisdictions report)))
    (is (= ["GBR" "JPN"] (:covered-jurisdictions report)))))

(deftest required-evidence-satisfied-needs-every-item
  (let [all (facts/evidence-checklist "JPN")]
    (is (facts/required-evidence-satisfied? "JPN" all))
    (is (not (facts/required-evidence-satisfied? "JPN" (rest all))))
    (is (not (facts/required-evidence-satisfied? "ATL" all)) "no spec-basis -> never satisfied")))

(deftest every-catalog-entry-has-a-distinct-ethics-review-citation
  (doseq [[iso3 entry] facts/catalog]
    (is (string? (:ethics-owner-authority entry)) (str iso3 " ethics-owner-authority"))
    (is (string? (:ethics-legal-basis entry)) (str iso3 " ethics-legal-basis"))
    (is (string? (:ethics-provenance entry)) (str iso3 " ethics-provenance"))))
