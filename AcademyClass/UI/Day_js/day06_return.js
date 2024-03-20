// (function(){
//   let username = prompt('이름을 입력하세요.');
//   alert(`${username}님, 안녕하세요?`);
// })();

// (function(a,b){
//   let sum = a+b;
//   console.log(`함수 실행 결과 : ${sum}`)
// })(100,200);

// let hi = function(user){
//   document.write(`${user}님, 안녕하세요?`);
// }
// hi("홍길동");

// let hi = () => {let user = prompt("이름을 입력하세요 ");alert(`${user}님 안녕하세요?`)};
// hi();

fruits = ["apple", "banana", "grape"]
// document.write(fruits);

// function addNum(...numbers){
//   let sum = 0;

//   for(let number of numbers)
//     sum += number;

//     return sum;
// }
// document.write(addNum(1, 3));
// document.write(addNum(1, 3, 5, 7));
fruits.forEach(fruit => document.write(`${fruit}<br>`));
for(let fruit of fruits){
  document.write(`${fruit}<br>`);
}