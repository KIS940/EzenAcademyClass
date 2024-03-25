// function displayA(){
//   console.log("A");
// }
// function displayB(){
//   setTimeout(() => console.log("B"), 2000);
// }
// function displayC(){
//   console.log("C");
// }
// displayA();
// displayB();
// displayC();

function displayA(){
  console.log("A");
}
function displayB(callback){
  setTimeout(() => {
    console.log("B");
    callback();
  }, 2000);
}
function displayC(){
  console.log("C");
}
displayA();
displayB(displayC);

function order(coffee, callback) {
  console.log(`${coffee} 주문 접수`);
  setTimeout(() =>{
    callback(coffee);
  }, 3000);
}

function display(result) {
  console.log(`${result} 준비 완료`);
}
order("아메리카노", display);