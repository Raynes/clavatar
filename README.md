# clavatar

This is a library to generate Gravatar URLs for a given email. It is extremely simple, consisting of only one function. You give it an email and possibly specify some options, and it'll give you the link to the gravatar for that email or a default image.

## Usage

Leiningen, of course.

```clojure
:dependencies [[clavatar "0.2.1"]]
```

Using the library is extremely simple. Just use the `gravatar` function. Here are some examples:

```clojure
clavatar.core> (gravatar "i@raynes.me")
"https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=50&r=pg&d=retro&"
clavatar.core> (gravatar "i@raynes.me" :size 500)
"https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=500&r=pg&d=retro&"
clavatar.core> (gravatar "i@raynes.me" :size 500 :rating :g)
"https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=500&r=g&d=retro&"
clavatar.core> (gravatar "i@raynes.me" :size 500 :rating :r)
"https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=500&r=r&d=retro&"
clavatar.core> (gravatar "i@raynes.me" :default :mm) ;; Sets the default image to mystery man.
"https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=50&r=pg&d=mm&"
clavatar.core> (gravatar "b.ghose@gmail.com" :default :mm :size 128 :https false)
"http://www.gravatar.com/avatar/8aa4490274249db8981283bdadb2ec2b.jpg?s=128&r=pg&d=mm&"
```

## License

Distributed under the Eclipse Public License, the same as Clojure.
