(ns javafxdemo.utils
    (:import [javafx.event EventHandler]
             [javafx.application Platform]))

(defmacro with-javafx
  "Runs a body inside the JavaFX thread."
  [& body]
  `(let [*result# (promise)]
     (Platform/runLater (fn [] (let [result# (do ~@body)]
                                (deliver *result# result#))))
     @*result#))

(defn event-handler*
  [f]
  (reify EventHandler
    (handle [this e] (f e))))

(defmacro event-handler [arg & body]
  `(event-handler* (fn ~arg ~@body)))

