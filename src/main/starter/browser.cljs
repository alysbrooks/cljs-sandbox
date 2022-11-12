(ns starter.browser
  (:require [lambdaisland.fetch :as fetch]))


(def controller (new js/AbortController))

;; start is called by init and after code reloading finishes
(defn ^:dev/after-load start []
  (js/console.log "start"))

(defonce counter (atom 0))

(defn set-color []
  (swap! counter inc)
  (let [el (js/document.getElementById "rectangle")
        style (.-style el)
        ;; previous-color (.-backgroundColor style)
        ]
    (set! (.-backgroundColor style) (str "hsl(" @counter " 50% 50%)") )
    ))

(defn init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (js/console.log "init")
  (js/console.log "fetch")
  (fetch/get "www.example.com" {:signal (.-signal controller)})

  (let [el (js/document.getElementById "app")]
    (set! (.-innerHTML el) "Hi from ClojureScript!"))

  (js/window.setInterval set-color 50)
   
  ;; (js/console.log (.abort controller))
  (start))

;; this is called before any code is reloaded
(defn ^:dev/before-load stop []
  (js/console.log "stop"))
