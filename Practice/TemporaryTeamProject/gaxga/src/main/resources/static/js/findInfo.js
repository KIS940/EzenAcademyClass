// 아이디 찾기
// const findIdBtn = document.getElementById("findIdBtn");
const findId = () =>{
    const userNick = document.getElementById("user_Name").value;
    const userPhone = document.getElementById("userId_PhoneNumber").value;
    const info = {
        "userNick" : userNick,
        "userPhone" : userPhone,
    };

    $.ajax({
        type: "post",
        url: "/findInfo/ID",
        data:JSON.stringify(info),
        contentType: "application/json",
        success: function (res){
            console.log("성공", res);
            alert(res);
        },
        error: function(){
            console.log("실패")
            alert("실패");
        }
    })
}
//
// if(findIdBtn){
//     findIdBtn.addEventListener("click", event=>{
//         const userId = document.getElementById("userId").value;
//         console.log(userId);
//         if (userId !== "사용자를 찾을 수 없음") {
//
//             alert("찾은 아이디: " + userId);// 아이디를 찾았을 때
//         } else {
//             alert("사용자를 찾을 수 없습니다." + userId); // 아이디를 찾지 못했을 때
//         }
//
//     });
//
// }


// 비밀번호 찾기