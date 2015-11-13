(ns sorting.selection)

;; ----------------------------------------------------------------------------------------------------
;;
;; Find the smallest element and swap it with the first element
;; Find the second-smallest and swap it with the second card
;; Repeat finding the next smallest card and swapping it into the correct next position
;;
;; @see https://www.khanacademy.org/computing/computer-science/algorithms/sorting-algorithms/a/sorting
;; ----------------------------------------------------------------------------------------------------


(defn smallest 
  [xs]
  (loop [elm (first xs)
         xs (rest xs)]
    (if (not (seq xs))
      elm
      (let [next (first xs)]
        (if (< next elm)
          (recur next (rest xs))
          (recur elm (rest xs)))))))

(defn remove-element
  [num xs]
  (loop [acc []
         xs xs]
    (if (not (seq xs))
      acc
      (let [elm (first xs)]
        (if (= elm num)
          (recur acc (rest xs))
          (recur (conj acc elm) (rest xs)))))))

(defn selection-sort
  [xs]
  (loop [acc []
         xs xs]
    (if (not (seq xs))
      acc
      (let [elm (smallest xs)
            next (remove-element elm xs)
            ]
        (recur (conj acc elm) next)))))


;; |----------------+-----------------+---------------+-------------|
;; | Algorithm      | Time complexity |               |             |
;; |                | Best cases      | Average cases | Worst cases |
;; |----------------+-----------------+---------------+-------------|
;; | Selection Sort | O(n2)           | O(n2)         | O(n2)       |
;; |----------------+-----------------+---------------+-------------|
