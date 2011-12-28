(ns clavatar.core
  (:import (de.bripkens.gravatar Gravatar Rating DefaultImage)))

(def ratings
  {:g Rating/GENERAL_AUDIENCE
   :pg Rating/PARENTAL_GUIDANCE_SUGGESTED
   :r Rating/RESTRICTED
   :x Rating/ADULT_ONLY})

(def default-images
  {:404 DefaultImage/HTTP_404
   :mm DefaultImage/MYSTERY_MAN
   :identicon DefaultImage/IDENTICON
   :monster DefaultImage/MONSTER
   :wavatar DefaultImage/WAVATAR
   :retro DefaultImage/RETRO})

(defn gravatar
  "Returns the URL to a gravatar image for an email.
   Options are:
      size    -- size of image
      https   -- whether or not to use https
      rating  -- one of :pg, :g, :x,: r which are Parental Guidance,
                 General Audience, Explicit, and Restricted respectively.
      default -- default image if the one choosen doesn't exist. One of
                 :404       -- a 404 error,
                 :mm        -- cartoon-style silhouetted outline of a person,
                 :identicon -- geometric pattern based on an email hash,
                 :monsterid -- generated 'monster' with different colors, faces, etc,
                 :wavatar   -- generated faces with differing features and background,
                 :retro     --generated 8-bit arcade-style pixelated faces"
  [email & {:keys [size https rating default]
            :or {size 50
                 https true
                 rating :pg
                 default :retro}}]
  (let [g (Gravatar.)]
    (doto g
      (.setSize size)
      (.setHttps https)
      (.setRating (ratings rating))
      (.setStandardDefaultImage (default-images default)))
    (.getUrl g email)))