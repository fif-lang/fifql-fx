(ns fifql-fx.effects
  (:require
   [reframe.core :as reframe :refer [reg-fx dispatch]]
   [fifql.client :refer [query]]
   [fif.stack-machine.error-handling :refer [error-object?]]))


(reg-fx
  :fifql/query
  (fn [{:keys [url form on-success on-failure]}]
    (query url form
           (fn [result]
             (if (and on-failure (-> result :stack first error-object?))
               (dispatch [on-failure result])
               (dispatch [on-success result]))))))
    
