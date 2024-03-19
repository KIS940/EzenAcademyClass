// function greeting(){
//   console.log("안녕하세요?");
// }

// setInterval(greeting, 2000);

let counter = 0;
let isCheck = false;
let timer = setInterval(() => {
  console.log("안녕하세요?");
  counter++;
  if(counter === 3){
    clearInterval(timer);
    isCheck = true;
  }
  check(isCheck);
}, 2000);

function check(isCheck){
  if(isCheck){
    setTimeout(() => {
      console.log("네")
    }, 1000);
  }
}