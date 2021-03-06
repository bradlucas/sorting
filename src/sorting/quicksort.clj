(ns sorting.quicksort)

;; ----------------------------------------------------------------------------------------------------
;;
;; Divide by choosing a pivot element and rearranging the vector into two
;; vectors where all items in the left vector are less than the pivot and
;; all items in the right vector are greater. 
;;
;; As a matter of practice some choose the rightmost element in the subarray
;; as the pivot.
;;
;; Recurse by sorting each sub array in the same fashion.
;;
;;
;; @see https://www.khanacademy.org/computing/computer-science/algorithms/quick-sort/a/overview-of-quicksort
;; ----------------------------------------------------------------------------------------------------


(defn quicksort
  [xs]
  ;; take the last element as the pivot
  ;; return [..items less than pivot...] pivot [... items greater than pivot ...]
  ;; (println xs)
  (if (seq xs)
    (cond
      (< (count xs) 2) xs
      (= (count xs) 2) (let [a (first xs) b (second xs)] (if (< a b) [a b] [b a]))
      :else (let [pivot (last xs)
                  lst (drop-last xs)
                  left (filter #(< % pivot) lst)
                  right (filter #(> % pivot) lst)]
              (flatten (filter identity (list* (quicksort left) pivot (quicksort right))))))))


;; |------------+-----------------+---------------+-------------|
;; | Algorithm  | Time complexity |               |             |
;; |            | Best cases      | Average cases | Worst cases |
;; |------------+-----------------+---------------+-------------|
;; | Quick Sort | O(n log(n))     | O(n log(n))   | O(n2)       |
;; |------------+-----------------+---------------+-------------|

