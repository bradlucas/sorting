(ns sorting.merge
  (:refer-clojure :exclude [merge]))

;; ----------------------------------------------------------------------------------------------------
;;
;; Recursively divide the vector until you have a pair of numbers or a single number.
;; - If you have a single number return it.
;; - If you have two numbers return them sorted.
;; Combine by merging the 
;;
;; Divide
;; For a vector of one or more elements return two vectors such that the original
;; vector has been divided at the midpoint. If you have an odd number of elements
;; split at the middle rounding down.
;;
;; Merge
;; Give two sorted vectors or one or more elements return a vector with the elements
;; combined into a sorted vector. Iterate over each map at the same time and add the 
;; two elements to the result vector in sorted order
;;
;;
;; @see https://www.khanacademy.org/computing/computer-science/algorithms/merge-sort/a/overview-of-merge-sort
;; @see http://blog2samus.tumblr.com/post/20763915302/playing-with-merge-sort-in-clojure
;; ----------------------------------------------------------------------------------------------------


(defn divide
  "Divide a sequence by finding the midway positon and retun the two
  halves."
  [xs]
  (let [cnt (count xs)
        idx (quot cnt 2)]
    (map vec (split-at idx xs))))

(defn merge
  "Assuming a and b are sorted vectors merge them so that the result
  are the contents of the two are combined into a single sorted array"
  [xs1 xs2]
  ;; (println xs1 xs2)
  (let [a (first xs1)
        b (first xs2)]
    (cond
      (nil? a) xs2
      (nil? b) xs1
      :else (if (< a b)
              (cons a (merge (rest xs1) xs2))
              (cons b (merge xs1 (rest xs2)))))))

(defn merge-sort
  "Merge sort by recursively dividing the sequence until you have a
  pair to return sorted. Merge the returned results by combining two
  sequences so the two sorted sequences are merged into a single
  sorted sequence."
  [xs]
  (if (seq xs)
    (cond
      (< (count xs) 2) xs
      (= (count xs) 2) (merge [(first xs)] [(second xs)])
      :else (let [[lh rh] (divide xs)] 
              (merge (merge-sort lh) (merge-sort rh))))))


;; |------------+-----------------+---------------+-------------|
;; | Algorithm  | Time complexity |               |             |
;; |            | Best cases      | Average cases | Worst cases |
;; |------------+-----------------+---------------+-------------|
;; | Merge Sort | O(n log(n))     | O(n log(n))   | O(n log(n)) |
;; |------------+-----------------+---------------+-------------|


