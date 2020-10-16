(ns javafxdemo.scenegraph
    (:require [javafxdemo.utils :refer [event-handler]]
              [clojure.java.io :as io])
    (:import [javafx.scene Scene Node]
             [javafx.scene.control Label]
             [javafx.scene.layout VBox]
             [javafx.scene.image Image ImageView]
             [javafx.geometry Pos]
             [javafx.scene.control Button]))

(defn root []
  (let [label (Label. (str "javafx " (System/getProperty "javafx.version") " running on java " (System/getProperty "java.version"))) 
        button (Button. "Click me")
        imageview (-> "chimp.png"
                     io/resource
                     io/input-stream
                     (Image.)
                     (ImageView.))
        vbox (VBox. 30 (into-array Node [imageview label button]))
        scene (Scene. vbox 640 480)]
    (.setAlignment vbox Pos/CENTER)
    (doto imageview (.setFitHeight 100) (.setPreserveRatio true))
    (.setOnAction button (event-handler [_] (.setText label "You clicked me")))
    scene))
