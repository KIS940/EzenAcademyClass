// 아이디 찾기
const findIdBtn = document.getElementById("findIdBtn");
if(findIdBtn){
    findIdBtn.addEventListener("click", event=>{
        const userId = document.getElementById("userId").value;
        console.log(userId);
        if (userId !== "사용자를 찾을 수 없음") {

            alert("찾은 아이디: " + userId);// 아이디를 찾았을 때
        } else {
            alert("사용자를 찾을 수 없습니다." + userId); // 아이디를 찾지 못했을 때
        }

    });

}


// 비밀번호 찾기