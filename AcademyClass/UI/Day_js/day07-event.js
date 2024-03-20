// const button = document.querySelector("#btn");

// function changeBackGround(){
//   document.body.style.backgroundColor = "green";
// }
// //button.onclick = changeBackGround;

// button.addEventListener("click", changeBackGround);

const button = document.querySelector("#bttn");

button.addEventListener("click", () =>{
  const word = document.querySelector("#word").value;
  const result = document.querySelector("#result");
  let count = word.length;

  result.innerText = `${count}`;
})
