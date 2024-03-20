const openn = document.querySelector("#open");
const modalBox = document.querySelector("#modal-box");
const closee = document.querySelector("#close");

openn.addEventListener("click", ()=>{
  modalBox.classList.add("active");
})
closee.addEventListener("click", ()=>{
  modalBox.classList.remove("active");
})