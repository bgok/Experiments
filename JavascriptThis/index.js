var foo = {
    a: 'happy',
    b: this.a, // 'this' is not defined yet
    c: function() {
        console.log(this.b); // now you can use 'this'
    },
    d: foo.a, // 'foo' is defined, though
    e: function() {
        console.log(this.d);
    },
    f: foo.g, // hoisting works, too
    g: 'wow',
    h: function() {
        console.log(this.f);
    }

};

foo.c(); // undefined
foo.e(); // happy
foo.h(); // wow