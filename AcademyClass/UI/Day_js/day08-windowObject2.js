const bttn = document.querySelector("button");
const popWidth = 600;
const popHeight = 500;

bttn.addEventListener("click", function(){
  let left = (screen.availWidth - popWidth) / 2;
  let top = (screen.availHeight - popHeight) / 2;
  window.open("day08-notice.html", "event", `width = ${popWidth} height = ${popHeight} left = ${left} top = ${top}`);
});