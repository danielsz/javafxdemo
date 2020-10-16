(ns javafxdemo.core
    (:require [javafxdemo.scenegraph :refer [root]])
    (:import [javafx.application Application]
             [javafx.stage Stage])
    (:gen-class))

(gen-class
 :name javafxdemo.core.App
 :extends javafx.application.Application
 :methods [[launch [Class] void]]
 :prefix "app-")

(defn app-start [this ^Stage stage]
  (.setScene stage (root))
  (.show stage))

(defn app-launch [this klass]
  (Application/launch klass (into-array String [])))

(defn -main [& args]
  (let [instance (javafxdemo.core.App.)]
    (.launch instance (.getClass instance))))


