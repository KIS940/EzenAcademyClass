const email = document.querySelector("#userEmail");
const button = document.querySelector("button");
const result = document.querySelector("#result");
// button.addEventListener("click", function(){
//   let username, domain;
//   if(email.value !== ""){
//     username = email.value.split("@")[0];
//     username = username.substring(0, 3);
//     domain = email.value.split("@")[1];
//     result.innerText = `${username}...@${domain}`;
//     email.value = "";
//   }
// });

button.addEventListener("click", function(){
  let username, domain, half;

  if(email.value !== ""){
    username = email.value.split("@")[0];
    half = username.length/2;
    username = username.substring(0, half);
    domain = email.value.split("@")[1];
    result.innerText = `${username}...@${domain}`;
    email.value = "";
  }
});
console.log("=============================")