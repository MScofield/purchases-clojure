(ns purchases-clojure.core
  (:require [clojure.string :as g])
  (:gen-class))

(defn -main []
  (println "Type a category:")
    
 (let [
       purchases(slurp "purchases.csv")
       purchases(g/split-lines purchases)
       purchases (map (fn [line] (g/split line #",")) purchases)
       header (first purchases)
       purchases (rest purchases)
       purchases (map (fn [line] (zipmap header line)) purchases)
       category-name (read-line)
       purchases (filter (fn [line] (= (get line "category") category-name)) purchases)
       file-text (pr-str purchases)]
       
   (spit "filtered_purchases.edn" file-text)))
  
