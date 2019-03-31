(ns fifql-fx.effects
  (:require
   [reframe.core :as reframe :refer [reg-fx dispatch]]
   [fifql.client :refer [query]]
   [fif.stack-machine.error-handling :refer [error-object?]]))


;; Perform a fifql query on the fifql endpoint at `url` with the given
;; `sform` stack form. The successful result is then sent to the event
;; defined on `on-success`, with failures being dispatched to the
;; event defined on `on-failure`. 
;;
;; The result object sent to each event consists of
;; {:input-string <original input to the stack machine>
;;  :stack  <stack-list after evaluating the input-string>
;;  :stdout <vector of stdout strings>
;;  :stderr <vector of stderr strings>}


(reg-fx
  :fifql/query
  (fn [{:keys [url sform on-success on-failure]
        :or {url "/fifql"}}]
    (query url sform
           (fn [result]
             (if (and on-failure (-> result :stack first error-object?))
               (dispatch [on-failure result])
               (dispatch [on-success result]))))))
    
