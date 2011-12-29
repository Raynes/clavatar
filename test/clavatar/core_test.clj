(ns clavatar.core-test
  (:use clojure.test
        clavatar.core))

(deftest basics
  (testing "Clavatar core functionality"
    (is (= (gravatar "i@raynes.me")
           "https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=50&r=pg&d=retro&"))
    (is (= (gravatar "i@raynes.me" :size 500)
           "https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=500&r=pg&d=retro&"))
    (is (= (gravatar "i@raynes.me" :size 500 :rating :g)
           "https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=500&r=g&d=retro&"))
    (is (= (gravatar "i@raynes.me" :size 500 :rating :r)
           "https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=500&r=r&d=retro&"))
    (is (= (gravatar "i@raynes.me" :default :mm)
           "https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=50&r=pg&d=mm&"))
    (is (= (gravatar "b.ghose@gmail.com" :default :mm :size 128 :https false)
           "http://www.gravatar.com/avatar/8aa4490274249db8981283bdadb2ec2b.jpg?s=128&r=pg&d=mm&"))))
