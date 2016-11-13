(ns grid-problem.core)
(use 'clojure.pprint)

(defn create-grid [x y]
    (into [] (repeat y (into [] (repeat x 1))))
    )

(defn neighbors [m coords]
  (let [[x y] coords, s #{}]
    (into s
      (for [row (range (- x 1) (+ x 2)),
            column (range (- y 1) (+ y 2))]
        (if (and (= x row) (= y column))
          nil
          (get-in m [row column])
        )
      )
    )
  )
  )

(defn is-valid-coord [m coord]
  (and (every? #(contains? (neighbors m coord) %) (range 1 (get-in m coord)))
       (not= (get-in m coord) 10)
       )
  )

(defn is-valid-grid [m]
  (let [rows (count m)
        columns (count (first m))
        all-coords (for [row (range rows)
                         column (range columns)
                         ]
                     [row column]
                     )
        ]
    (every? #(is-valid-coord m %) all-coords)
    )

  )

(defn inc-grid
  ([m] (inc-grid m [0 0]))
  ([m coords]
    (if (= coords [-1 -1])
      m
      (recur
        (let [val (get-in m coords)]
          (if (is-valid-grid (update-in m coords inc))
            (update-in m coords inc)
            m
            )
          )
        (let [[x y] coords]
           (if (< x (dec (count m)))
            [(inc x) y]
            (if (< y (dec (count (first m))))
              [0 (inc y)]
              [-1 -1]
             )
            )
          )
        )
      )
    )
  )

(defn find-best-grid [m]
  (let [new-grid (inc-grid m)]
    (if (not= new-grid m)
      (recur new-grid)
      m
      )
    )
  )

(defn -main [& args]
  (let [solution (find-best-grid (create-grid 5 5))]
    (pprint (for [row solution] (into-array row)))
    )
)
