document.getElementById("joinMembership").addEventListener("click", function() {
  window.location.href = "http://localhost:8080/joinMembership.html";
});

document.getElementById("find_Id").addEventListener("click", findInfo());
document.getElementById("find_Password").addEventListener("click", findInfo());

function findInfo(){
  window.location.href = "http://localhost:8080/findInfo.html";
}