str1 = "Good mornig, everyone. Beautiful morning."
console.log(str1.indexOf("morning"));
console.log(str1.indexOf("evening"));

str2 = "Good mornig, everyone. Beautiful morning."
first = str2.indexOf("morning")
console.log(str2.indexOf("morning", first+1));

str3 = "Hello, everyone."
console.log(str3.startsWith("Hello"));
console.log(str3.startsWith("hello"));
console.log(str3.startsWith("He"));
console.log(str3.startsWith("Hello, ev"));

console.log(str3.endsWith("everyone."));
console.log(str3.endsWith("Everyone."));
console.log(str3.endsWith("one."));
console.log(str3.endsWith("lo, everyone"));

console.log(str3.endsWith("one", 15));
console.log(str3.endsWith("lo", 5));

console.log(str3.includes("every"));

str5 = "Hello everyone"
array1 = str5.split(" ")
array2 = str.split("")