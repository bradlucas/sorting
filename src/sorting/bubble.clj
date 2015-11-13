(ns sorting.bubble)

;; ----------------------------------------------------------------------------------------------------
;;
;; @see https://en.wikipedia.org/wiki/Bubble_sort
;; @see http://www.fatvat.co.uk/2008/12/bubbling-clojure.html
;; ----------------------------------------------------------------------------------------------------


(defn bubble
  [xs]
  ;; if don't have two to compare return xs
  (if (< (count xs) 2)
    xs
    (let [a (first xs)
          b (second xs)]
      ;; (println ".")
      (if (> a b)
        (cons b (cons a (bubble (drop 2 xs))))
        (cons a (bubble (rest xs)))))))

(defn bubble-sort
  [xs]
  (if (= (bubble xs) xs)
    xs
    (recur (bubble xs))))


;; |-------------+-----------------+---------------+-------------|
;; | Algorithm   | Time complexity |               |             |
;; |             | Best cases      | Average cases | Worst cases |
;; |-------------+-----------------+---------------+-------------|
;; | Bubble Sort | O(n)            | O(n2)         | O(n2)       |
;; |-------------+-----------------+---------------+-------------|

