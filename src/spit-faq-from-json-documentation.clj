#!/usr/bin/env bb

;; Copyright (c) DINUM, Bastien Guerry
;; SPDX-License-Identifier: EPL-2.0
;; License-Filename: LICENSES/LICENSE.EPL-2.0.txt

(def faq
  (->> (json/parse-string (slurp "https://code.gouv.fr/documentation/index.json") true)
       :contents
       (filter #(= "Foire aux questions" (:raw-value (:properties %))))
       first
       :contents))

(spit "faq.json" (json/generate-string faq))
