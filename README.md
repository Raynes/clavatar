# clavatar

This is a library wrapping [gravatar4j](https://github.com/bripkens/Gravatar4Java). It is extremely simple, consisting of only one function. You give it an email and possibly specify some options, and it'll give you the link to the gravatar for that email or a default image.

## Usage

Leiningen, of course.

```clojure
:dependencies [[clavatar "0.1.0"]]
```

Using the library is extremely simple. Just use the `gravatar` function. Here are some examples:

```clojure
clavatar.core> (gravatar "i@raynes.me")
"https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=50&r=pg&d=retro&"
clavatar.core> (gravatar "i@raynes.me" :size 500)
"https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=500&r=pg&d=retro&"
clavatar.core> (gravatar "i@raynes.me" :size 500 :rating :g)
"https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=500&d=retro&"
clavatar.core> (gravatar "i@raynes.me" :size 500 :rating :r)
"https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=500&r=r&d=retro&"
clavatar.core> (gravatar "i@raynes.me" :default :mm) ;; Sets the default image to mystery man.
"https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=50&r=pg&d=mm&"
```

## License

Distributed under the Eclipse Public License, the same as Clojure.
