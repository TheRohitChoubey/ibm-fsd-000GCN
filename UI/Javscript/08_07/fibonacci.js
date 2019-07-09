let a = 1;
let b = 1;
console.log(a);
console.log(b);
for (i = 0; i < 10; i++) {
    c = a + b;
    a = b;
    b = c;
    console.log(c);
}