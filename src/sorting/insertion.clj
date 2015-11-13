(ns sorting.insertion)

;; ----------------------------------------------------------------------------------------------------
;;
;; Insertion sort iterates, consuming one input element each
;; repetition, and growing a sorted output list. Each iteration,
;; insertion sort removes one element from the input data, finds the
;; location it belongs within the sorted list, and inserts it
;; there. It repeats until no input elements remain.
;;
;; Sorting is typically done in-place, by iterating up the array, growing
;; the sorted list behind it. At each array-position, it checks the value
;; there against the largest value in the sorted list (which happens to
;; be next to it, in the previous array-position checked). If larger, it
;; leaves the element in place and moves to the next. If smaller, it
;; finds the correct position within the sorted list, shifts all the
;; larger values up to make a space, and inserts into that correct
;; position.
;;
;;
;; @see https://en.wikipedia.org/wiki/Insertion_sort
;; @see https://www.khanacademy.org/computing/computer-science/algorithms/insertion-sort/a/insertion-sort
;; ----------------------------------------------------------------------------------------------------


(defn insert
  [xs value]
  ;; put value in xs in sorted 
  (concat (filter #(< % value) xs) [value] (filter #(> % value) xs)))

(defn insertion-sort
  [xs]
  (loop [result []
         xs xs]
    (if (not (seq xs))
      result
      (recur (insert result (first xs)) (rest xs)))))


;; |----------------+-----------------+---------------+-------------|
;; | Algorithm      | Time complexity |               |             |
;; |                | Best cases      | Average cases | Worst cases |
;; |----------------+-----------------+---------------+-------------|
;; | Insertion Sort | O(n)            | O(n2)         | O(n2)       |
;; |----------------+-----------------+---------------+-------------|


