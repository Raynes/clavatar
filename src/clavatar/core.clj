(ns clavatar.core
  (:import java.security.MessageDigest))

(def ^:private gravatar-base-url ".gravatar.com/avatar/")

(defn- md5sum
  "Calculate the MD5 checksum of a string and return the hex-digest string."
  [^String s]
  (let [digest ^MessageDigest (MessageDigest/getInstance "MD5")]
    (.reset digest)
    (.toString (BigInteger. 1 (.digest digest (.getBytes s "UTF-8"))) 16)))

(defn- genhash
  "Generate the hash needed for Gravatar.
   The hash is generated by trimming, lowercasing & md5-summing the email."
  [^String email]
  (-> email .trim .toLowerCase md5sum))

(defn- genparams
  "Generate the parameters needed for Gravatar."
  [& {size :size default :default rating :rating}]
  (format "?s=%s&r=%s&d=%s&" size (name rating) (name default)))

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
  (let [base-url (str gravatar-base-url
                      (genhash email)
                      ".jpg"
                      (genparams :size size :default default :rating rating))]
    (str (if https "https://secure" "http://www") base-url)))
