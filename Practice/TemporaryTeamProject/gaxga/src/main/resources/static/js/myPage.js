const contents = ["modifyProfile","myWrited","saved","receiveLike"];
const profileInfos = ["showNickname", "showPhoneNumber","showAddress","showEmail"];
const modifyType = ["nickname", "phoneNumber","address","email"];
const modifyBtn =["modifyNickname","modifyPhoneNumber","modifyAddress","modifyEmail"];
const saveBtn =["nicknameBtn","phoneNumberBtn","addressBtn","emailBtn"];

function SelectedContent(selectNum){
  for(let i = 0; i < contents.length; i++){
    const element = document.getElementById(contents[i]);
    element.classList.remove("active");
  }
  const selectedElement = document.getElementById(contents[selectNum]);
  selectedElement.classList.add("active");
}

function ModifyProfileBtn(btnType) {
  for (let i = 0; i < profileInfos.length; i++) {
    const spanElement = document.getElementById(profileInfos[i]);
    const inputElement = document.getElementById(modifyType[i]);
    const saveElement = document.getElementById(saveBtn[i]);
    const modifyElement = document.getElementById(modifyBtn[i]);
    if (btnType === i) {
      if (spanElement.classList.contains("hidden")) {
        spanElement.classList.remove("hidden");
        inputElement.classList.add("hidden");
        saveElement.classList.add("hidden");
        modifyElement.classList.remove("hidden");
      } else {
        spanElement.classList.add("hidden");
        inputElement.classList.remove("hidden");
        saveElement.classList.remove("hidden");
        modifyElement.classList.add("hidden");
      }
    }
  }
}

function modifySaveBtn(btnType) {
  const inputElement = document.getElementById(modifyType[btnType]);
  const newText = inputElement.value;
  console.log(newText);
  fetch("/api/myPage",{
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      type: modifyType[btnType],
      text: newText
    })
  })
      .then(response => {
        if(!response.ok){
          throw new Error("수정에 실패 햇습니다.");
        }
        return response.json();
      })
      .then(data => {
        const spanElement = document.getElementById(profileInfos[btnType]);
        spanElement.textContent = newValue; // 화면에 수정된 값 업데이트
        spanElement.classList.remove("hidden");
        inputElement.classList.add("hidden");
        document.getElementById(saveBtn[btnType]).classList.add("hidden");
        document.getElementById(modifyBtn[btnType]).classList.remove("hidden");
        console.log("프로필이 성공적으로 수정되었습니다.");
      })
      .catch(error => {
        console.error("프로필 수정에 실패했습니다.", error);
      });
}