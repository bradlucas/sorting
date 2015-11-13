(ns sorting.core
  (:refer-clojure :exclude [merge])
  (:use [sorting.bubble]
        [sorting.selection]
        [sorting.quicksort]
        [sorting.merge])
)

        ;; [sorting.insertion]


;; |----------------+-----------------+---------------+-------------|
;; | Algorithm      | Time complexity |               |             |
;; |                | Best cases      | Average cases | Worst cases |
;; |----------------+-----------------+---------------+-------------|
;; | Bubble Sort    | O(n)            | O(n2)         | O(n2)       |
;; | Selection Sort | O(n2)           | O(n2)         | O(n2)       |
;; | Insertion Sort | O(n)            | O(n2)         | O(n2)       |
;; | Quick Sort     | O(n log(n))     | O(n log(n))   | O(n2)       |
;; | Merge Sort     | O(n log(n))     | O(n log(n))   | O(n log(n)) |
;; |----------------+-----------------+---------------+-------------|


;; @see 6.4.1 Joy of Clojure
(defn rand-ints [n]
  (take n (repeatedly #(rand-int n))))


(defn time-run-with-results 
  [fn param]
   ;; use with-out-str to get the time results as well as the print of (fn num
   ;; print the results of the fnc
   ;; return both as a string
  (with-out-str (time (println (fn param)))))


(defn -main
  [& args]
  

  (let [convert (fn [x] (if (string? x) (Long/parseLong x) x))
        num (if args (convert (first args)) 10)
        nums (rand-ints num)]
    (println "Running sorts with " num " random ints")
    (println "----------------------------------------------------------------------------------------------------\n")
    (println "Bubble     :" (time-run-with-results bubble-sort nums))
    (println "Selection  :" (time-run-with-results selection-sort nums))
    (println "Quicksort  :" (time-run-with-results quicksort nums))
    (println "Merge      :" (time-run-with-results merge-sort nums))
    ))
