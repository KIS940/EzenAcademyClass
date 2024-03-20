const title = document.querySelector("#title");
const userName = document.querySelector("#desc p");
const userNames = document.querySelectorAll("#desc p");
title.onclick = () => {
  title.classList.toggle("clicked");  
}
userName.onclick = () => {
  // console.log(userNames.length);
  // for(i = 0; i< userNames.length; i++)
  // {
  //   console.log(userNames[i]);
  //   userNames[i].classList.toggle("blue-italic");
  // }

  for(let name of userNames)
    name.classList.toggle("blue-italic");
  // userName.classList.toggle("blue-italic");
}
